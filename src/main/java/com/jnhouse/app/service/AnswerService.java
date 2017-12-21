package com.jnhouse.app.service;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.TemAnswer;

public interface AnswerService{
	
	List<SupAnswerHeader> selectAnswer(Map<String,Object> map);
	List<TemAnswer> temAnswer(Map<String,Object> map);
}
