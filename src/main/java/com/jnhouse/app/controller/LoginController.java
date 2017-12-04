package com.jnhouse.app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jnhouse.app.bean.Dept;
import com.jnhouse.app.bean.DeptAuthority;
import com.jnhouse.app.bean.Menu;
import com.jnhouse.app.bean.User;
import com.jnhouse.app.utils.MD5Util;

import net.sf.json.JSONArray;
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
		DeptAuthority deptAuthority = new DeptAuthority();
		deptAuthority.setDept_id(1);
		deptAuthority.setMenu_id(1);
		deptAuthority.setIs_delete(1);
		deptAuthority.setCreated_by(1);
		deptAuthority.setUpdated_by(1);
		deptAuthority.setUpdated_time(new Date());
		deptAuthority.setCreated_time(new Date());
		/*deptAuthorityService.save(deptAuthority);*/
		System.err.println("--------");
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/dept_views")
	public ModelAndView dept_views(HttpServletRequest request) {
		Menu menu = new Menu();
		menu.setFather_id(0);
		menu.setMenu_level(1);
		menu.setMenu_name("系统管理");
		menu.setUrl("");
		menu.setSort(1);
		menu.setIs_delete(1);;
		menu.setCreated_by(1);
		menu.setUpdated_by(1);;
		menu.setSort(1);
		ModelAndView modelAndView = new ModelAndView();
		/*System.err.println(dept.getId() + "--------2");*/
		modelAndView.setViewName("sys/dept");
		return modelAndView;
	}
	
	@RequestMapping(value="/role")
	public ModelAndView role(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		System.err.println("--------3");
		modelAndView.setViewName("sys/dept");
		return modelAndView;
	}
	
	@RequestMapping(value="/aJsonObject",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject aJsonObject(HttpServletRequest request) {
		/*ModelAndView modelAndView = new ModelAndView();*/
		List<Dept> depts = deptService.findAll();
		System.err.println("---w-----" + depts.size());
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonobj = new JSONObject(); 
		Map<String,Object> map = new HashMap<String,Object>();  
		for (int i = 0; i < depts.size(); i++) {
			
			jsonobj.put("id",depts.get(i).getId());
			jsonobj.put("pId", depts.get(i).getFather_id());
			jsonobj.put("name", depts.get(i).getDept_name());
			jsonobj.put("sort", depts.get(i).getSort());
			jsonobj.put("dept_level", depts.get(i).getDept_level());
			if (depts.get(i).getDept_level() == 1) {
				jsonobj.put("open", true);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (depts.get(i).getDept_level() == 2) {
				jsonobj.put("iconSkin", "icon03");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			
			jsonArray.add(jsonobj);
		}
		map.put("zNodes", jsonArray);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.err.println(jsonObject.toString());
		return jsonObject;
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
			modelAndView.setViewName("home");
			modelAndView.addObject(user);
		}else{
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
}
