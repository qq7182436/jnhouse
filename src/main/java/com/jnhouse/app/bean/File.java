package com.jnhouse.app.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class File implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String file_name;
	
	private Integer file_type;
	
	private String file_url;
	
	private Integer is_delete;
	
	private Timestamp created_by;
	
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
	 * @return the file_name
	 */
	public String getFile_name() {
		return file_name;
	}

	/**
	 * @param file_name the file_name to set
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	/**
	 * @return the file_type
	 */
	public Integer getFile_type() {
		return file_type;
	}

	/**
	 * @param file_type the file_type to set
	 */
	public void setFile_type(Integer file_type) {
		this.file_type = file_type;
	}

	/**
	 * @return the file_url
	 */
	public String getFile_url() {
		return file_url;
	}

	/**
	 * @param file_url the file_url to set
	 */
	public void setFile_url(String file_url) {
		this.file_url = file_url;
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
	 * @return the created_by
	 */
	public Timestamp getCreated_by() {
		return created_by;
	}

	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(Timestamp created_by) {
		this.created_by = created_by;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Timestamp created_time;
}
