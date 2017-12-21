package com.jnhouse.app.dto;

import java.sql.Timestamp;
import java.util.List;

import com.jnhouse.app.bean.SupTemplate;

public class SupAnswerHeaderLineDTO {

	private Integer id;
	private Integer answerLineId;
	private Integer problem_id;
	
	private Integer header_id;
	
	private Integer answer_num;
	
	private String answer;
	
	private Float score;
	
	private Integer is_delete;
	
	private Timestamp updated_time;
	
	private Timestamp created_time;
	
	private List<SupTemplate> supTemplates;

	/**
	 * @return the header_id
	 */
	public Integer getHeader_id() {
		return header_id;
	}

	/**
	 * @param header_id the header_id to set
	 */
	public void setHeader_id(Integer header_id) {
		this.header_id = header_id;
	}

	/**
	 * @return the answer_num
	 */
	public Integer getAnswer_num() {
		return answer_num;
	}

	/**
	 * @param answer_num the answer_num to set
	 */
	public void setAnswer_num(Integer answer_num) {
		this.answer_num = answer_num;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the score
	 */
	public Float getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Float score) {
		this.score = score;
	}

	/**
	 * @return the is_delete
	 */
	public Integer getIs_delete() {
		return is_delete;
	}

	/**
	 * @param is_delete the is_delete to set
	 */
	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	/**
	 * @return the updated_time
	 */
	public Timestamp getUpdated_time() {
		return updated_time;
	}

	/**
	 * @param updated_time the updated_time to set
	 */
	public void setUpdated_time(Timestamp updated_time) {
		this.updated_time = updated_time;
	}

	/**
	 * @return the created_time
	 */
	public Timestamp getCreated_time() {
		return created_time;
	}

	/**
	 * @param created_time the created_time to set
	 */
	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

	

	


	public Integer getAnswerLineId() {
		return answerLineId;
	}

	public void setAnswerLineId(Integer answerLineId) {
		this.answerLineId = answerLineId;
	}

	public Integer getProblem_id() {
		return problem_id;
	}

	public void setProblem_id(Integer problem_id) {
		this.problem_id = problem_id;
	}

	public List<SupTemplate> getSupTemplates() {
		return supTemplates;
	}

	public void setSupTemplates(List<SupTemplate> supTemplates) {
		this.supTemplates = supTemplates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
