package com.jnhouse.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jnhouse.app.bean.Dept;
import com.jnhouse.app.bean.Role;
import com.jnhouse.app.bean.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class DeptController extends BaseController{
	
	/**
	 * 进入部门页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dept/dept_views")
	public ModelAndView dept_views(HttpServletRequest request) {
		List<Role> roleList = roleService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("roleList", roleList);
		modelAndView.setViewName("sys/dept");
		return modelAndView;
	}
	
	/**
	 * 删除部门
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/dept/delete_dept",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject delete_dept(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			Integer id = Integer.valueOf(request.getParameter("dept_id"));
			deptService.delete(id);
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("msg", "删除成功");
			jsonObject = JSONObject.fromObject(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * 添加部门
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/dept/add_same_level",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject add_same_level(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			Integer dept_level = Integer.valueOf(request.getParameter("dept_level"));
			Integer father_id = Integer.valueOf(request.getParameter("father_id"));
			Dept dept = new Dept();
			dept.setDept_level(dept_level);
			dept.setFather_id(father_id);
			Integer maxSort = deptService.findMaxValue(dept);
			if (maxSort == null) {
				maxSort = 0;
			}
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("maxSort", maxSort);
			jsonObject = JSONObject.fromObject(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * 保存或者修改部门
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dept/save_dept",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject save_dept(HttpServletRequest request,@RequestParam(value="role_ids",required=false) String role_ids) {
		JSONObject jsonObject = null;
		try {
			Integer dept_level = Integer.valueOf(request.getParameter("dept_level")); //部门等级
			Integer father_id = Integer.valueOf(request.getParameter("father_id"));  //父部门
			String name = request.getParameter("name");

			Integer sort = Integer.valueOf(request.getParameter("sort"));
			String id = request.getParameter("id");
			User user = (User)request.getAttribute("user");
			Dept dept = new Dept();
			dept.setFather_id(father_id);
			dept.setDept_name(name);
			dept.setSort(sort);
			dept.setDept_level(dept_level);
			if (null != user) {
				dept.setCreated_by(user.getId());
				dept.setUpdated_by(user.getId());	
			}else{
				dept.setCreated_by(1);
				dept.setUpdated_by(1);
			}
			if (null != id && !"".equals(id)) {
				dept.setId(Integer.valueOf(id));
				deptService.update(dept);
			}else{
				deptService.save(dept);
			}
			
			//判断部门角色是否为空
			if (null != role_ids && !"".equals(role_ids)) {
				deptAuthorityService.deleteAll(dept.getId());
				List<Role> list = new ArrayList<>();
				Role role = null;
				String role_id[] = role_ids.split(",");
				for (int i = 0; i < role_id.length; i++) {
					role = new Role();
					role.setId(Integer.valueOf(role_id[i]));
					if (null != user) {
						role.setCreated_by(user.getId());
						role.setUpdated_by(user.getId());	
					}else{
						role.setCreated_by(1);
						role.setUpdated_by(1);
					}
					list.add(role);
				}
				if (list.size() > 0) {
					deptAuthorityService.insertBatchRole(dept.getId().toString(), list);
				}
				
			}
			Dept dept2 = deptService.getById(dept.getId());
			JSONObject jsonobj = new JSONObject(); 
			jsonobj.put("id",dept2.getId());
			jsonobj.put("pId", dept2.getFather_id());
			jsonobj.put("name", dept2.getDept_name());
			jsonobj.put("sort", dept2.getSort());
			jsonobj.put("dept_level", dept2.getDept_level());
			jsonobj.put("role_ids", role_ids);
			if (dept2.getDept_level() == 1) {
				jsonobj.put("open", true);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (dept2.getDept_level() == 2) {
				jsonobj.put("iconSkin", "icon02");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("treeNode", jsonobj);
			jsonObject = JSONObject.fromObject(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * 查询所有部门
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dept/aJsonObject",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject aJsonObject(HttpServletRequest request) {
		/*ModelAndView modelAndView = new ModelAndView();*/
		List<Dept> depts = deptService.findAll();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonobj = new JSONObject(); 
		List<Integer> deptAuthorList = null;
		Map<String,Object> map = new HashMap<String,Object>();
		for (int i = 0; i < depts.size(); i++) {
			jsonobj.put("id",depts.get(i).getId());
			jsonobj.put("pId", depts.get(i).getFather_id());
			jsonobj.put("name", depts.get(i).getDept_name());
			jsonobj.put("sort", depts.get(i).getSort());
			jsonobj.put("dept_level", depts.get(i).getDept_level());
			deptAuthorList = deptAuthorityService.findByDeptId(depts.get(i).getId());
			jsonobj.put("role_ids", deptAuthorList);
			if (depts.get(i).getDept_level() == 1) {
				jsonobj.put("open", true);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (depts.get(i).getDept_level() == 2) {
				jsonobj.put("iconSkin", "icon02");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			jsonArray.add(jsonobj);
		}
		map.put("zNodes", jsonArray);
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject;
	}
}
