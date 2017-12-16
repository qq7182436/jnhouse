package com.jnhouse.app.dto;


public class DeptUserDto {

	private Integer id;

    private Integer dept_id;

    private Integer broker_id;
    
    private String realname;
    
    private String mobile;
    
    private String photo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public Integer getBroker_id() {
		return broker_id;
	}

	public void setBroker_id(Integer broker_id) {
		this.broker_id = broker_id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
}
