package com.jnhouse.app.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jnhouse.app.bean.FkeFile;
import com.jnhouse.app.service.DeptAuthorityService;
import com.jnhouse.app.service.DeptService;
import com.jnhouse.app.service.FileService;
import com.jnhouse.app.service.MenuService;
import com.jnhouse.app.service.RoleService;
import com.jnhouse.app.service.SupAnswerHeaderService;
import com.jnhouse.app.service.SupAnswerLineService;
import com.jnhouse.app.service.SupTemplateService;
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
	SupTemplateService supTemplateService;
	
	@Resource
	SupAnswerHeaderService supAnswerHeaderService;
	
	@Resource
	FileService fileService;
	
	@Resource
	SupAnswerLineService supAnswerLineService;
	
	
	
	
	
	
	
	
}
