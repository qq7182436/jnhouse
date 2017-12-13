package com.jnhouse.app.dao;

import java.util.List;

import com.jnhouse.app.bean.SupAnswerHeader;

public interface SupAnswerHeaderDao extends BaseDao<SupAnswerHeader>{
	List<SupAnswerHeader> selectAnswer();
}