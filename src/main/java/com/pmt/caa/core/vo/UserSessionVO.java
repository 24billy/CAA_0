package com.pmt.caa.core.vo;

import java.util.Date;

public class UserSessionVO {

	private String userid;
	
	private boolean isAdmin;

	private String remoteAddr;
	
	private Date loginDateTime;

	public UserSessionVO() {
		;
	}

	public UserSessionVO(String userid) {
		this.userid = userid;
	}
	
	public UserSessionVO(String userid, boolean isAdmin) {
		this.userid = userid;
		this.isAdmin = isAdmin;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public Date getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(Date loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
