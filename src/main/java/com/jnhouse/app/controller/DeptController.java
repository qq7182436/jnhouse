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
	
	@RequestMapping(value="/dept/add_same_level",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject add_same_level(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			Integer dept_level = Integer.valueOf(request.getParameter("dept_level"));
			Integer father_id = Integer.valueOf(request.getParameter("father_id"));
			Dept dept = new Dept();
			dept.setDept_level(dept_level);
			dept.setFather_id(father_id);
			Integer maxSort = deptService.findMaxValue(dept);
			if (maxSort == null) {
				maxSort = 0;
			}
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("maxSort", maxSort);
			jsonObject = JSONObject.fromObject(map);
			System.err.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	@RequestMapping(value="/dept/save_dept",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject save_dept(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			Integer dept_level = Integer.valueOf(request.getParameter("dept_level"));
			Integer father_id = Integer.valueOf(request.getParameter("father_id"));
			String name = request.getParameter("name");
			Integer sort = Integer.valueOf(request.getParameter("sort"));
			Dept dept = new Dept();
			dept.setFather_id(father_id);
			dept.setDept_name(name);
			dept.setSort(sort);
			dept.setDept_level(dept_level);
			dept.setIs_delete(1);
			dept.setCreated_by(1);
			/*dept.setCreated_time(new Date());*/
			dept.setUpdated_by(1);
			/*dept.setUpdated_time(new Date());*/
			int id = deptService.save(dept);
			System.err.println(dept.getId() + "###########");
			Dept dept2 = deptService.getById(dept.getId());
			JSONObject jsonobj = new JSONObject(); 
			jsonobj.put("id",dept2.getId());
			jsonobj.put("pId", dept2.getFather_id());
			jsonobj.put("name", dept2.getDept_name());
			jsonobj.put("sort", dept2.getSort());
			jsonobj.put("dept_level", dept2.getDept_level());
			if (dept2.getDept_level() == 1) {
				jsonobj.put("open", true);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (dept2.getDept_level() == 2) {
				jsonobj.put("iconSkin", "icon03");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("treeNode", jsonobj);
			jsonObject = JSONObject.fromObject(map);
			System.err.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}
