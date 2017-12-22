package com.jnhouse.app.bean;

import java.io.Serializable;
import java.util.Date;
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

    private String check_date;

    private Integer store_id;

    private String store_around;

    private String start_time;

    private String end_time;

    private Integer broker_num;

    private Integer customer_num;

    private String docking_man;

    private String recording;

    private Integer is_delete;

    private String updated_time;

    private String created_time;
    
    private String store_name;
    
    private String menu_title;
    
    private Integer header_id;
    
    private Integer dept_id;
    

    
	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public Integer getHeader_id() {
		return header_id;
	}

	public void setHeader_id(Integer header_id) {
		this.header_id = header_id;
	}

	public String getMenu_title() {
		return menu_title;
	}

	public void setMenu_title(String menu_title) {
		this.menu_title = menu_title;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

    public String getCheck_date() {
        return check_date;
    }

    public void setCheck_date(String check_date) {
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

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }
}