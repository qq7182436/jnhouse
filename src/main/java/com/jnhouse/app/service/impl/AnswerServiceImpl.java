package com.jnhouse.app.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.TemAnswer;
import com.jnhouse.app.dao.SupAnswerDao;
import com.jnhouse.app.service.AnswerService;
@Service
public class AnswerServiceImpl implements AnswerService {

	@Resource
	SupAnswerDao answerdao;
	

	@Override
	public List<SupAnswerHeader> selectAnswer(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return answerdao.selectAnswer(map);
	}


	@Override
	public List<TemAnswer> temAnswer(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return answerdao.temAnswer(map);
	}


}
