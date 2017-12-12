package com.jnhouse.app.service;

import java.util.List;

import com.jnhouse.app.bean.Answer_header;

public interface AnswerService extends BaseService<Answer_header>{
	
	List<Answer_header> selectAnswer();

}
