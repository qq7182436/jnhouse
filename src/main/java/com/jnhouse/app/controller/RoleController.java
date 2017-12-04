package com.jnhouse.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController extends BaseController {

	/**
	 * 角色管理页面
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="role/role_views")
	public ModelAndView menu_views(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sys/role3");
		return modelAndView;
	}
}
