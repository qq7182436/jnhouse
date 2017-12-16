package com.jnhouse.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jnhouse.app.bean.User;

public class CommonInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.err.println("----------------------");
		System.err.println(request.getRequestURI()+ "-------------request.getRequestURI()");
		if (request.getRequestURI().contains(".action")) {
			User user = (User)request.getSession().getAttribute("user");
			System.err.println(user);
			if (null == user) {
				 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
		}
		
		return true;
	}

	

}
