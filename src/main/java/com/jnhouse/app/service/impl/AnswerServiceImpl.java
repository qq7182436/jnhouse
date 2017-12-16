package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.dao.SupAnswerHeaderDao;
import com.jnhouse.app.service.AnswerService;
@Service
public class AnswerServiceImpl implements AnswerService {

	@Resource
	SupAnswerHeaderDao answerdao;
	

	@Override
	public List<SupAnswerHeader> selectAnswer() {
		// TODO Auto-generated method stub
		return answerdao.selectAnswer();
	}


}
