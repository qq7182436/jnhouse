package com.jnhouse.app.dao;

import java.util.List;

import com.jnhouse.app.bean.Answer_header;

public interface AnswerDao extends BaseDao<Answer_header>{
	List<Answer_header> selectAnswer();

}
