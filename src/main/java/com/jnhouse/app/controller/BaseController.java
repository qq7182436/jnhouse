package com.jnhouse.app.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.jnhouse.app.service.DeptAuthorityService;
import com.jnhouse.app.service.DeptService;


@Controller
public class BaseController {

	
	@Resource
	public DeptAuthorityService deptAuthorityService;
	
	@Resource
	public DeptService deptService;

}
