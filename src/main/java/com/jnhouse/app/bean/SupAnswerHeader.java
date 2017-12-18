package com.jnhouse.app.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;




/**
 * 模版答案表
 * @author lou
 *
 */
public class SupAnswerHeader implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;

    private Integer template_id;
   

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
    
    
 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(Integer template_id) {
        this.template_id = template_id;
    }

    public Date getCheck_date() {
        return check_date;
    }

    public void setCheck_date(Date check_date) {
        this.check_date = check_date;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public String getStore_around() {
        return store_around;
    }

    public void setStore_around(String store_around) {
        this.store_around = store_around == null ? null : store_around.trim();
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time == null ? null : start_time.trim();
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time == null ? null : end_time.trim();
    }

    public Integer getBroker_num() {
        return broker_num;
    }

    public void setBroker_num(Integer broker_num) {
        this.broker_num = broker_num;
    }

    public Integer getCustomer_num() {
        return customer_num;
    }

    public void setCustomer_num(Integer customer_num) {
        this.customer_num = customer_num;
    }

    public String getDocking_man() {
        return docking_man;
    }

    public void setDocking_man(String docking_man) {
        this.docking_man = docking_man == null ? null : docking_man.trim();
    }

    public String getRecording() {
        return recording;
    }

    public void setRecording(String recording) {
        this.recording = recording == null ? null : recording.trim();
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

	public Timestamp getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Timestamp updated_time) {
		this.updated_time = updated_time;
	}

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}
/*
	public SupAnswerHeaderDTO getSupAnswerHeaderDTO() {
		return supAnswerHeaderDTO;
	}

	public void setSupAnswerHeaderDTO(SupAnswerHeaderDTO supAnswerHeaderDTO) {
		this.supAnswerHeaderDTO = supAnswerHeaderDTO;
	}*/





	


	

	

	

	


  
}