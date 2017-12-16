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

import com.jnhouse.app.bean.Menu;
import com.jnhouse.app.bean.User;
import com.jnhouse.app.utils.MD5Util;

import net.sf.json.JSONObject;



/**
 * 登录
 * @author lou
 *
 */
@Controller
public class LoginController extends BaseController{
	
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		/*deptAuthorityService.save(deptAuthority);*/
		System.err.println("--------");
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/role")
	public ModelAndView role(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		System.err.println("--------3");
		modelAndView.setViewName("sys/dept");
		return modelAndView;
	}
	
	/**
	 * 登录验证用户
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="login/login_in",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject login_in(HttpServletRequest request) {
		String userName = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setUsername(userName);
		pwd = MD5Util.getMD5(pwd);
		user.setPasswd(pwd);
		User user2 = userService.findUser(user);
		int userId = 0;
		if (null != user2) {
			request.getSession().setAttribute("user", user2);
			userId = user2.getId();
		}
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("userId", userId);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.err.println(jsonObject.toString());
		return jsonObject;
	}
	/**
	 * 登录成功跳转主页
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="login/home")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User)request.getSession().getAttribute("user"); //取得session中的user
		if (null != user && null != user.getId()) {
			List<Integer> menu_ids = new ArrayList<>();
			List<Menu> menuList = new ArrayList<>();
			List<Menu> menus = menuService.getMenuByUserId(user.getId());
			for (Menu menu : menus) {
				if (!menu_ids.contains(menu.getId())) {
					menuList.add(menu);
					menu_ids.add(menu.getId());
					System.err.println(menu.getMenu_name() + "****************" + menu.getId());
				}
			}
			request.getSession().setAttribute("menuList", menuList);
			modelAndView.setViewName("home");
			modelAndView.addObject(user);
			modelAndView.addObject(menuList);
		}else{
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
}
