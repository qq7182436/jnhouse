package com.jnhouse.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jnhouse.app.bean.Dept;

import net.sf.json.JSONObject;

@Controller
public class DeptController extends BaseController{

	@RequestMapping(value="/dept/delete_dept",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject delete_dept(HttpServletRequest request) {
		System.err.println("---s-----" + request.getParameter("dept_id"));
		JSONObject jsonObject = null;
		try {
			Integer id = Integer.valueOf(request.getParameter("dept_id"));
			deptService.delete(id);
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("msg", "删除成功");
			jsonObject = JSONObject.fromObject(map);
			System.err.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}
