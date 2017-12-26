package com.jnhouse.app.dao;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.dto.TemAnswer;

public interface SupAnswerDao extends BaseDao<SupAnswerHeader>{
	//查询答案主表数据
	List<SupAnswerHeader> selectAnswer(Map<String,Object> map);
	//获取模板下节点
	List<TemAnswer> temAnswer(Map<String,Object> map);
	void insertheader_dept(Map<String,Object> map);
	void insertline_dept(Map<String,Object> map);
	//判断是否共享
	int getHeader_dept(Map<String,Object> map);
	void deleteHeader(String id);
	void deleteLine(String id);
	
	//查询答案主表数据
	List<SupAnswerHeader> selectDeptShareAnswer(Map<String,Object> map);
	void deleteDeptHeader(Map<String,Object> map);
	void deleteDeptLine(Map<String,Object> map);
	
}