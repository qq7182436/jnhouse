package com.jnhouse.app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jnhouse.app.bean.Dept;
import com.jnhouse.app.bean.DeptAuthority;
import com.jnhouse.app.service.DeptAuthorityService;
import com.jnhouse.app.service.DeptService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
 * 登录
 * @author Administrator
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
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value="/dept")
	public ModelAndView dept(HttpServletRequest request) {
		Dept dept = new Dept();
		dept.setDept_name("西北战区");
		dept.setFather_id(0);
		dept.setSort(40);
		dept.setDept_level(1);
		dept.setUpdated_by(1);
		dept.setCreated_by(1);
		dept.setUpdated_time(new Date());
		dept.setCreated_time(new Date());
		dept.setIs_delete(1);
		/*int id = deptService.save(dept);*/
		ModelAndView modelAndView = new ModelAndView();
		/*System.err.println(dept.getId() + "--------2");*/
		modelAndView.setViewName("dept/test2");
		return modelAndView;
	}
	
	@RequestMapping(value="/role")
	public ModelAndView role(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		System.err.println("--------3");
		modelAndView.setViewName("dept/test");
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
	/*	modelAndView.addObject(jsonObject);
		modelAndView.setViewName("dept/test2");*/
		return jsonObject;
	}
}
