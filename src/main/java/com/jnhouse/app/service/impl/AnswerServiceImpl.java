package com.jnhouse.app.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.dto.TemAnswer;
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


	@Override
	public void shareByheaderId(Map<String,Object> map) {
		// TODO Auto-generated method stub
		answerdao.insertheader_dept(map);
		answerdao.insertline_dept(map);
	}


	@Override
	public int getHeader_dept(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return answerdao.getHeader_dept(map);
	}


	@Override
	public void deleteHeader(String id) {
		// TODO Auto-generated method stub
		answerdao.deleteHeader(id);
		answerdao.deleteLine(id);
	}


	@Override
	public List<SupAnswerHeader> selectDeptShareAnswer(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return answerdao.selectDeptShareAnswer(map);
	}


	@Override
	public void deleteDeptHeader(String id) {
		// TODO Auto-generated method stub
		answerdao.deleteDeptHeader(id);
		answerdao.deleteDeptLine(id);
	}


}
