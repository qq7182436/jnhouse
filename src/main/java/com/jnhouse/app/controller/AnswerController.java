package com.jnhouse.app.controller;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.dto.TemAnswer;
import com.jnhouse.app.service.AnswerService;
import com.jnhouse.app.service.SupTemplateService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	AnswerService answerService;
	
	@Autowired
	SupTemplateService templateService;
	
	@RequestMapping(value="/answer")
	public ModelAndView to_answer(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("sys/answer");
	}
	
	//获取答案主表数据
    @RequestMapping(value="/selectAnswer")
    @ResponseBody
    public List<SupAnswerHeader> selectAnswer(HttpServletRequest request,HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<>();
        List<SupAnswerHeader> answer = answerService.selectAnswer(map);
        return answer;
    }
    //获取模板下的子节点
    @RequestMapping(value="/answerList")
    @ResponseBody
    public List<SupTemplate> answerList(HttpServletRequest request,HttpServletResponse response) {
    	String id = request.getParameter("template_id");
    	Map<String,Object> map = new HashMap<>();
    	map.put("parent_id", id);
        List<SupTemplate> temp = templateService.fke_template(map);
        return temp;
    }
    //获取答案明细
    @RequestMapping(value="/temAnswer")
    @ResponseBody   
    public List<TemAnswer> temAnswer(HttpServletRequest request,HttpServletResponse response) {
    	String id = request.getParameter("template_id");
    	String header_id = request.getParameter("header_id");
    	Map<String,Object> map = new HashMap<>();
    	map.put("parent_id", id);
    	map.put("header_id", header_id);
        List<TemAnswer> tem = answerService.temAnswer(map);
        return tem;
    }
    //共享
    @RequestMapping(value="/share")
    @ResponseBody
    public void share(HttpServletRequest request,HttpServletResponse response) {
    	String header_id = request.getParameter("header_id");
    	String dept_id = request.getParameter("dept_id");
    	Map<String,Object> par = new HashMap<>();
    	JSONObject json = new JSONObject();
    	par.put("header_id", header_id);
    	par.put("dept_id", dept_id);
    	try {
    		PrintWriter out = response.getWriter();
    		//判断有没有共享过，0为没有共享
    		int isHave = answerService.getHeader_dept(par);
    	   	if(isHave == 0) {
    	   		answerService.shareByheaderId(par); 
        		json.put("success","共享成功");
    	   	}else {
    	   		json.put("success","您已共享");
    	   	}
    	   	out.println(json);
    		out.flush();
    		out.close();		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    @RequestMapping(value="/isHave")
    @ResponseBody
    public List isHave(HttpServletRequest request,HttpServletResponse response) {
    	String id = request.getParameter("id");
    	
    	//判断模板下是否还有子项，0位没有
    	List<SupTemplate> levelCount = templateService.isHaveLevelCount(id);
    	
    	return levelCount;
    }
    
    @RequestMapping(value="/deleteHeader")
    @ResponseBody
    public void deleteHeader(HttpServletRequest request,HttpServletResponse response) {
    	String header_id = request.getParameter("id");
    	JSONObject json = new JSONObject();
    	try {
    		PrintWriter out = response.getWriter();
    		answerService.deleteHeader(header_id);
    		json.put("success", true);
    		out.println(json);
    		out.flush();
    		out.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
}
