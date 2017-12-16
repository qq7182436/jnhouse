package com.jnhouse.app.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.jnhouse.app.service.DeptAuthorityService;
import com.jnhouse.app.service.DeptService;
import com.jnhouse.app.service.DeptUserService;
import com.jnhouse.app.service.MenuService;
import com.jnhouse.app.service.RoleMenuService;
import com.jnhouse.app.service.RoleService;
import com.jnhouse.app.service.UserService;


@Controller
public class BaseController {

	
	@Resource
	public DeptAuthorityService deptAuthorityService;
	
	@Resource
	public DeptService deptService;
	
	@Resource
	public MenuService menuService;
	
	@Resource
	public UserService userService;
	
	@Resource
	public RoleService roleService;
	
	@Resource
	public RoleMenuService roleMenuService;
	
	@Resource
	public DeptUserService deptUserService;

}
