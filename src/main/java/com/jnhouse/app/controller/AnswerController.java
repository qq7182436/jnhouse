package com.jnhouse.app.controller;


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
import com.jnhouse.app.bean.TemAnswer;
import com.jnhouse.app.service.AnswerService;
import com.jnhouse.app.service.SupTemplateService;


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
	
	
    @RequestMapping(value="/selectAnswer")
    @ResponseBody
    @SuppressWarnings("all")
    public List selectAnswer(HttpServletRequest request,HttpServletResponse response) {
    	Map<String,Object> map = new HashMap<>();
        List<SupAnswerHeader> answer = answerService.selectAnswer(map);
        return answer;
    }
    
    @RequestMapping(value="/temAnswer")
    @ResponseBody
    public List temAnswer(HttpServletRequest request,HttpServletResponse response) {
    	String id = request.getParameter("template_id");
    	Map<String,Object> map = new HashMap<>();
    	map.put("parent_id", id);
        List<SupTemplate> temp = templateService.fke_template(map);
        return temp;
    }
    
    @RequestMapping(value="/title_answer")
    @ResponseBody
    public List title_answer(HttpServletRequest request,HttpServletResponse response) {
    	String id = request.getParameter("template_id");
    	String store_id = request.getParameter("store_id");
    	String check_date = request.getParameter("check_date");
    	String docking_man = request.getParameter("docking_man");
    	Map<String,Object> map = new HashMap<>();
    	map.put("parent_id", id);
    	map.put("store_id",store_id);
    	map.put("check_date", check_date);
    	map.put("docking_man", docking_man);
        List<TemAnswer> tem = answerService.temAnswer(map);
        return tem;
    }
}
