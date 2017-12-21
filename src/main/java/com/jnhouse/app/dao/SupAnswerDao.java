package com.jnhouse.app.dao;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.TemAnswer;

public interface SupAnswerDao extends BaseDao<SupAnswerHeader>{
	List<SupAnswerHeader> selectAnswer(Map<String,Object> map);
	List<TemAnswer> temAnswer(Map<String,Object> map);
}