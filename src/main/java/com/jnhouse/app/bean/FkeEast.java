package com.jnhouse.app.bean;

import java.io.Serializable;
import java.util.List;

public class FkeEast implements Serializable{

	private static final long serialVersionUID = 1L;  
	
	private Integer id;
	
	private Integer company_id;
	
	private Integer area_id;
	
	
	private Integer is_business;
	
	
	
	private String name;
	
	private List<SupAnswerHeader> supAnswerHeaders;
	
	
	/**
	 * @return the company_id
	 */
	public Integer getCompany_id() {
		return company_id;
	}

	/**
	 * @param company_id the company_id to set
	 */
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	/**
	 * @return the is_business
	 */
	public Integer getIs_business() {
		return is_business;
	}

	/**
	 * @param is_business the is_business to set
	 */
	public void setIs_business(Integer is_business) {
		this.is_business = is_business;
	}


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
	 * @return the area_id
	 */
	public Integer getArea_id() {
		return area_id;
	}

	/**
	 * @param area_id the area_id to set
	 */
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<SupAnswerHeader> getSupAnswerHeaders() {
		return supAnswerHeaders;
	}

	public void setSupAnswerHeaders(List<SupAnswerHeader> supAnswerHeaders) {
		this.supAnswerHeaders = supAnswerHeaders;
	}

	
}
