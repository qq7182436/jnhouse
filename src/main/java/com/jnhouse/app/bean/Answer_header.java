package com.jnhouse.app.bean;

import java.util.Date;

public class Answer_header {

	private Integer id;
	private Integer templateid;
	private Date checkdate;
	private Integer storeid;
	private String storearound;
	private String starttime;
	private String endtime;
	private Integer brokernum;
	private Integer customernum;
	private String dockingman;
	private String recording;
	private Integer isdelete;
	private Date updatetime;
	private Date createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTemplateid() {
		return templateid;
	}
	public void setTemplateid(Integer templateid) {
		this.templateid = templateid;
	}
	public Date getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}
	public Integer getStoreid() {
		return storeid;
	}
	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}
	public String getStorearound() {
		return storearound;
	}
	public void setStorearound(String storearound) {
		this.storearound = storearound;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public Integer getBrokernum() {
		return brokernum;
	}
	public void setBrokernum(Integer brokernum) {
		this.brokernum = brokernum;
	}
	public Integer getCustomernum() {
		return customernum;
	}
	public void setCustomernum(Integer customernum) {
		this.customernum = customernum;
	}
	public String getDockingman() {
		return dockingman;
	}
	public void setDockingman(String dockingman) {
		this.dockingman = dockingman;
	}
	public String getRecording() {
		return recording;
	}
	public void setRecording(String recording) {
		this.recording = recording;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}
