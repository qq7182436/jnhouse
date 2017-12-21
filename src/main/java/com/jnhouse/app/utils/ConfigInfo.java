package com.jnhouse.app.utils;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("configInfo")
public class ConfigInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Value("${img.url}")
	private String imgUrl;

	@Value("${sftp.ip}")
	private String sftpIp;
	
	@Value("${sftp.port}")
	private Integer sftPort;

	@Value("${sftp.user}")
	private String sftpUser;
	
	@Value("${sftp.password}")
	private String sftpPassword;
	
	/**
	 * @return the sftpIp
	 */
	public String getSftpIp() {
		return sftpIp;
	}

	/**
	 * @param sftpIp the sftpIp to set
	 */
	public void setSftpIp(String sftpIp) {
		this.sftpIp = sftpIp;
	}

	

	/**
	 * @return the sftpUser
	 */
	public String getSftpUser() {
		return sftpUser;
	}

	/**
	 * @param sftpUser the sftpUser to set
	 */
	public void setSftpUser(String sftpUser) {
		this.sftpUser = sftpUser;
	}

	/**
	 * @return the sftpPassword
	 */
	public String getSftpPassword() {
		return sftpPassword;
	}

	/**
	 * @param sftpPassword the sftpPassword to set
	 */
	public void setSftpPassword(String sftpPassword) {
		this.sftpPassword = sftpPassword;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	/**
	 * @return the sftPort
	 */
	public Integer getSftPort() {
		return sftPort;
	}

	/**
	 * @param sftPort the sftPort to set
	 */
	public void setSftPort(Integer sftPort) {
		this.sftPort = sftPort;
	}
	
	
}
