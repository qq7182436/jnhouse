package com.jnhouse.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnhouse.app.bean.DeptUser;
import com.jnhouse.app.bean.User;
import com.jnhouse.app.dto.DeptUserDto;
import com.jnhouse.app.dto.UserInfoDto;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * 用户管理
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/user_views")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sys/user");
		return modelAndView;
	}
	
	/**
	 * 通过部门id查询该部门或职位下的所有用户
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/find_deptUser",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject find_deptUser(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			Integer dept_id = Integer.valueOf(request.getParameter("dept_id"));
			Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
			String username = request.getParameter("username");
			PageHelper.startPage(pageNum, 5);
			DeptUserDto deptUser = new DeptUserDto();
			deptUser.setDept_id(dept_id);
			deptUser.setRealname(username);
			List<DeptUserDto> deptUserDtos = deptUserService.selectUserByDeptId(deptUser);
			PageInfo<DeptUserDto> pageInfo = new PageInfo<>(deptUserDtos);
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("msg", pageInfo);
			jsonObject = JSONObject.fromObject(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * 通过部门id查询该部门或职位下的所有用户
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/find_allUsers",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject find_allUsers(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			String username = request.getParameter("username");
			Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
			PageHelper.startPage(pageNum, 5);
			List<UserInfoDto> userInfos = userService.findUserByName(username);
			PageInfo<UserInfoDto> pageInfo = new PageInfo<>(userInfos);
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("userInfo", pageInfo);
			jsonObject = JSONObject.fromObject(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	/**
	 * 建立部门用户关系
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/save_user",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject save_user(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			String users = request.getParameter("users");
			Integer dept_id = Integer.valueOf(request.getParameter("dept_id"));
			String []user_id = users.split(",");
			List<Integer> userIds = deptUserService.selectByDeptId(dept_id);
			List<DeptUser> deptUserList = new ArrayList<>();
			User user = (User)request.getSession().getAttribute("user");
			DeptUser deptUser = null;
			if (user_id.length >0 ) {
				for (int i = 0; i < user_id.length; i++) {
					if (!userIds.contains(Integer.valueOf(user_id[i]))) {
						deptUser = new DeptUser();
						if (null != user) {
							deptUser.setUpdated_by(user.getId());
							deptUser.setCreated_by(user.getId());
						}else {
							deptUser.setCreated_by(1);
							deptUser.setCreated_by(1);
						}
						deptUser.setDept_id(dept_id);
						deptUser.setBroker_id(Integer.valueOf(user_id[i]));
						deptUserList.add(deptUser);
					}
				}	
			}
			if (deptUserList.size() > 0) {
				deptUserService.insertBatchUsers(deptUserList);
			}
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("msg", "成功");
			jsonObject = JSONObject.fromObject(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * 删除部门下的用户
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/delete_user",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject delete_user(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			String users = request.getParameter("users");
			String []ids = users.split(",");
			deptUserService.deleteByPrimaryKeys(ids);
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("msg", "成功");
			jsonObject = JSONObject.fromObject(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}
