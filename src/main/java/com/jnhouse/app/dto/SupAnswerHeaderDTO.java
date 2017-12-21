package com.jnhouse.app.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.jnhouse.app.bean.FkeEast;
import com.jnhouse.app.bean.FkeFile;
import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.bean.SupTemplate;

public class SupAnswerHeaderDTO {

	private Integer id;

	private String answer;
	private Integer answer_num;
	private Integer  parent_id;
    private Integer template_id;
    
    private Integer header_id;
    private  String menu_title;
    
    private Integer get_score;
    
    private String name;
    
    private Integer firstMenuId;//一级问题的id
    
    private Date check_date;

    private Integer store_id;

    private String store_around;

    private String start_time;

    private String end_time;

    private Integer broker_num;

    private Integer customer_num;

    private String docking_man;

    private String recording;

    private Integer is_delete;

    private Timestamp updated_time;

    private Timestamp created_time;   
    private FkeEast fkeEast;   
    private SupTemplate supTemplate;
    private FkeFile fkeFile;
    private SupAnswerHeader supAnswerHeader;
    
    private SupTemplateDTO supTemplateDTO;

    private SupAnswerLine supAnswerLine;
    private List<SupTemplateDTO> supTemplateDtos;
    
    private List<SupAnswerLine> supTemplateLines;
    
    private List<SupTemplate> supTemplates;
    
    private List<SupAnswerHeaderDTO> supAnswerHeaderDTOss;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the template_id
	 */
	public Integer getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id the template_id to set
	 */
	public void setTemplate_id(Integer template_id) {
		this.template_id = template_id;
	}

	/**
	 * @return the menu_title
	 */
	public String getMenu_title() {
		return menu_title;
	}

	/**
	 * @param menu_title the menu_title to set
	 */
	public void setMenu_title(String menu_title) {
		this.menu_title = menu_title;
	}

	/**
	 * @return the firstMenuId
	 */
	public Integer getFirstMenuId() {
		return firstMenuId;
	}

	/**
	 * @param firstMenuId the firstMenuId to set
	 */
	public void setFirstMenuId(Integer firstMenuId) {
		this.firstMenuId = firstMenuId;
	}

	/**
	 * @return the check_date
	 */
	public Date getCheck_date() {
		return check_date;
	}

	/**
	 * @param check_date the check_date to set
	 */
	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}

	/**
	 * @return the store_id
	 */
	public Integer getStore_id() {
		return store_id;
	}

	/**
	 * @param store_id the store_id to set
	 */
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	/**
	 * @return the store_around
	 */
	public String getStore_around() {
		return store_around;
	}

	/**
	 * @param store_around the store_around to set
	 */
	public void setStore_around(String store_around) {
		this.store_around = store_around;
	}

	/**
	 * @return the start_time
	 */
	public String getStart_time() {
		return start_time;
	}

	/**
	 * @param start_time the start_time to set
	 */
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	/**
	 * @return the end_time
	 */
	public String getEnd_time() {
		return end_time;
	}

	/**
	 * @param end_time the end_time to set
	 */
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	/**
	 * @return the broker_num
	 */
	public Integer getBroker_num() {
		return broker_num;
	}

	/**
	 * @param broker_num the broker_num to set
	 */
	public void setBroker_num(Integer broker_num) {
		this.broker_num = broker_num;
	}

	/**
	 * @return the customer_num
	 */
	public Integer getCustomer_num() {
		return customer_num;
	}

	/**
	 * @param customer_num the customer_num to set
	 */
	public void setCustomer_num(Integer customer_num) {
		this.customer_num = customer_num;
	}

	/**
	 * @return the docking_man
	 */
	public String getDocking_man() {
		return docking_man;
	}

	/**
	 * @param docking_man the docking_man to set
	 */
	public void setDocking_man(String docking_man) {
		this.docking_man = docking_man;
	}

	/**
	 * @return the recording
	 */
	public String getRecording() {
		return recording;
	}

	/**
	 * @param recording the recording to set
	 */
	public void setRecording(String recording) {
		this.recording = recording;
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

	public SupAnswerHeader getSupAnswerHeader() {
		return supAnswerHeader;
	}

	public void setSupAnswerHeader(SupAnswerHeader supAnswerHeader) {
		this.supAnswerHeader = supAnswerHeader;
	}

	public FkeEast getFkeEast() {
		return fkeEast;
	}

	public void setFkeEast(FkeEast fkeEast) {
		this.fkeEast = fkeEast;
	}


	public List<SupTemplateDTO> getSupTemplateDtos() {
		return supTemplateDtos;
	}

	public void setSupTemplateDtos(List<SupTemplateDTO> supTemplateDtos) {
		this.supTemplateDtos = supTemplateDtos;
	}

	public List<SupTemplate> getSupTemplates() {
		return supTemplates;
	}

	public void setSupTemplates(List<SupTemplate> supTemplates) {
		this.supTemplates = supTemplates;
	}

	public List<SupAnswerLine> getSupTemplateLines() {
		return supTemplateLines;
	}

	public void setSupTemplateLines(List<SupAnswerLine> supTemplateLines) {
		this.supTemplateLines = supTemplateLines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Integer getHeader_id() {
		return header_id;
	}

	public void setHeader_id(Integer header_id) {
		this.header_id = header_id;
	}

	public SupTemplate getSupTemplate() {
		return supTemplate;
	}

	public void setSupTemplate(SupTemplate supTemplate) {
		this.supTemplate = supTemplate;
	}

	public SupAnswerLine getSupAnswerLine() {
		return supAnswerLine;
	}

	public void setSupAnswerLine(SupAnswerLine supAnswerLine) {
		this.supAnswerLine = supAnswerLine;
	}

	public FkeFile getFkeFile() {
		return fkeFile;
	}

	public void setFkeFile(FkeFile fkeFile) {
		this.fkeFile = fkeFile;
	}

	public List<SupAnswerHeaderDTO> getSupAnswerHeaderDTOss() {
		return supAnswerHeaderDTOss;
	}

	public void setSupAnswerHeaderDTOss(List<SupAnswerHeaderDTO> supAnswerHeaderDTOss) {
		this.supAnswerHeaderDTOss = supAnswerHeaderDTOss;
	}

	public Integer getAnswer_num() {
		return answer_num;
	}

	public void setAnswer_num(Integer answer_num) {
		this.answer_num = answer_num;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public SupTemplateDTO getSupTemplateDTO() {
		return supTemplateDTO;
	}

	public void setSupTemplateDTO(SupTemplateDTO supTemplateDTO) {
		this.supTemplateDTO = supTemplateDTO;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getGet_score() {
		return get_score;
	}

	public void setGet_score(Integer get_score) {
		this.get_score = get_score;
	}






	

	
    
}
