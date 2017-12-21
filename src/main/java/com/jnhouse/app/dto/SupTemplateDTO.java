package com.jnhouse.app.dto;

import java.util.List;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.bean.SupTemplate;

public class SupTemplateDTO {

	
	private Integer id;
	private String menu_title;
	private Integer answer_num;
	private Integer answer;
	
	private Integer parent_id;
	private String menu_title1;
	private String menu_title3;
	
	private SupTemplateDTO supTemplateDto;

	private SupAnswerHeader supAnswerHeader;
	
	private List<SupAnswerLine> supAnswerLines;
	
	private List<SupTemplate> supTemplates;
	
	

	public List<SupAnswerLine> getSupAnswerLines() {
		return supAnswerLines;
	}

	public void setSupAnswerLines(List<SupAnswerLine> supAnswerLines) {
		this.supAnswerLines = supAnswerLines;
	}

	public Integer getAnswer_num() {
		return answer_num;
	}

	public void setAnswer_num(Integer answer_num) {
		this.answer_num = answer_num;
	}

	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

	public String getMenu_title() {
		return menu_title;
	}

	public void setMenu_title(String menu_title) {
		this.menu_title = menu_title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<SupTemplate> getSupTemplates() {
		return supTemplates;
	}

	public void setSupTemplates(List<SupTemplate> supTemplates) {
		this.supTemplates = supTemplates;
	}

	public SupAnswerHeader getSupAnswerHeader() {
		return supAnswerHeader;
	}

	public void setSupAnswerHeader(SupAnswerHeader supAnswerHeader) {
		this.supAnswerHeader = supAnswerHeader;
	}

	public String getMenu_title3() {
		return menu_title3;
	}

	public void setMenu_title3(String menu_title3) {
		this.menu_title3 = menu_title3;
	}

	public String getMenu_title1() {
		return menu_title1;
	}

	public void setMenu_title1(String menu_title1) {
		this.menu_title1 = menu_title1;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public SupTemplateDTO getSupTemplateDto() {
		return supTemplateDto;
	}

	public void setSupTemplateDto(SupTemplateDTO supTemplateDto) {
		this.supTemplateDto = supTemplateDto;
	}

	
}
