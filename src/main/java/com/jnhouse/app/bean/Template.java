package com.jnhouse.app.bean;

import java.io.Serializable;
import java.util.Date;

public class Template implements Serializable{

	private Integer id;
	private Integer parentid;
	private String menutitle;
	private Integer menulevel;
	private Integer sort;
	private Integer isdelete;
	private Date updatedtime;
	private Date createdtime;
	private String score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getMenutitle() {
		return menutitle;
	}
	public void setMenutitle(String menutitle) {
		this.menutitle = menutitle;
	}
	public Integer getMenulevel() {
		return menulevel;
	}
	public void setMenulevel(Integer menulevel) {
		this.menulevel = menulevel;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	public Date getUpdatedtime() {
		return updatedtime;
	}
	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}
	public Date getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	

	
	
}
