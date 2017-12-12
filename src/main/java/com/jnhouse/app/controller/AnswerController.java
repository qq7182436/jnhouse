package com.jnhouse.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jnhouse.app.bean.Answer_header;
import com.jnhouse.app.service.AnswerService;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	AnswerService answerService;
	
	@RequestMapping(value="/answer")
	public ModelAndView to_answer(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("sys/answer");
	}
	
	
    @RequestMapping(value="/selectAnswer")
    @ResponseBody
    public Object selectAnswer(HttpServletRequest request,HttpServletResponse response) {
        List<Answer_header> answer = answerService.selectAnswer();
        return answer;
    }

}
