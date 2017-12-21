package com.jnhouse.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnhouse.app.bean.Menu;
import com.jnhouse.app.bean.Role;
import com.jnhouse.app.bean.User;

@Controller
public class RoleController extends BaseController {

	/**
	 * 角色管理页面
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="role/role_views")
	public ModelAndView menu_views(HttpServletRequest request,@RequestParam(value="role_name",required=false)String role_name
			,@RequestParam(value="pageNum",defaultValue="1",required=false)String pageNum) {
		System.err.println("role_name----------" + role_name);
		Integer page_num = 1;
		if (pageNum == null || "".equals(pageNum)) {
			page_num = 1;
		}else {
			page_num = Integer.valueOf(pageNum);
		}
		PageHelper.startPage(page_num, 5);
		List<Role> list = null;
		if (null != role_name && !"".equals(role_name)) {
			list = roleService.findByRoleName(role_name);
		}else {
			list = roleService.findAll();
		}
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		List<Menu> menus = menuService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("role_name",role_name);
		modelAndView.addObject("menusList",menus);
		modelAndView.setViewName("sys/role3");
		return modelAndView;
	}
	
	/**
	 * 添加、更新角色
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="role/add_role",method=RequestMethod.POST)
	public ModelAndView add_role(HttpServletRequest request,Role role) {
		User user = (User)request.getSession().getAttribute("user");

		System.err.println(role.getId() + "----##");
		role.setUpdated_by(user.getId());
		role.setCreated_by(user.getId());
		//id为空时 添加角色
		if (null == role.getId()) {
			roleService.save(role);
		}else{
			//id不为空时 更新角色
			roleService.update(role);
		}
		Integer pageNum = 1;
		if (request.getAttribute("pageNum") != null) {
			pageNum = Integer.valueOf((String) request.getAttribute("pageNum"));
		}
		
		PageHelper.startPage(pageNum, 5);
		List<Role> list = roleService.findAll();
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.setViewName("sys/role3");
		return modelAndView;
	}
	
	/**
	 * 删除角色
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="role/role_delete")
	public ModelAndView role_delete(HttpServletRequest request,@RequestParam(value="ids",required=false)String ids
			,@RequestParam(value="pageNum",defaultValue="1",required=false)String pageNum) {
		if (null != ids && !"".equals(ids)) {
			String id[] = ids.split(",");
			roleService.deleteByids(id);
		}
		Integer page_num = 1;
		if (pageNum == null) {
			page_num = 1;
		}else {
			page_num = Integer.valueOf(pageNum);
		}
		System.err.println(page_num + "----!!!!");
		PageHelper.startPage(page_num, 5);
		List<Role> list = roleService.findAll();
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.setViewName("sys/role3");
		return modelAndView;
	}
	
}
