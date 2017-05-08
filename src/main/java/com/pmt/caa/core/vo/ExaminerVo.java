package com.pmt.caa.core.vo;

public class ExaminerVo {

	private String id;

	private String userid;

	private String password;

	private String name;

	private String companyid;

	private String title;

	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ExaminerVo [id=" + id + ", userid=" + userid + ", password="
				+ password + ", name=" + name + ", companyid=" + companyid
				+ ", title=" + title + ", status=" + status + "]";
	}

}
