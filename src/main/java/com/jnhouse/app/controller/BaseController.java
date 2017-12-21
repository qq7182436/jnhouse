package com.jnhouse.app.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.jnhouse.app.service.DeptAuthorityService;
import com.jnhouse.app.service.DeptService;
import com.jnhouse.app.service.DeptUserService;
import com.jnhouse.app.service.FileService;
import com.jnhouse.app.service.MenuService;
import com.jnhouse.app.service.RoleMenuService;
import com.jnhouse.app.service.RoleService;
import com.jnhouse.app.service.SupAnswerHeaderService;
import com.jnhouse.app.service.SupAnswerLineService;
import com.jnhouse.app.service.SupTemplateService;
import com.jnhouse.app.service.UserService;
import com.jnhouse.app.utils.ConfigInfo;



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
	
	@Resource
	public ConfigInfo configInfo;

	@Resource
	SupTemplateService supTemplateService;
	
	@Resource
	SupAnswerHeaderService supAnswerHeaderService;
	
	@Resource
	FileService fileService;
	
	@Resource
	SupAnswerLineService supAnswerLineService;
	
	
	
	
	
	
	
	
}
