package com.jnhouse.app.service;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.dto.TemAnswer;

public interface AnswerService{
	//查询答案主表数据
	List<SupAnswerHeader> selectAnswer(Map<String,Object> map);
	//查询模板下节点
	List<TemAnswer> temAnswer(Map<String,Object> map);
	void shareByheaderId(Map<String,Object> map);
	//判断是否共享过
	int getHeader_dept(Map<String,Object> map);
	void deleteHeader(String id);
	
	//查询分享后答案主表数据
	List<SupAnswerHeader> selectDeptShareAnswer(Map<String,Object> map);
	void deleteDeptHeader(String id);
}
