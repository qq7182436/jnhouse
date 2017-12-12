package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.Answer_header;
import com.jnhouse.app.dao.AnswerDao;
import com.jnhouse.app.service.AnswerService;
@Service
public class AnswerServiceImpl implements AnswerService {

	@Resource
	AnswerDao answerdao;
	@Override
	public int save(Answer_header entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Answer_header entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Answer_header getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer_header> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer_header> selectAnswer() {
		// TODO Auto-generated method stub
		return answerdao.selectAnswer();
	}

}
