package com.pmt.caa.core.vo;

public class SubjectVo {

	private String medical_no;

	private String gender;

	private String name;

	private String birthday;

	private String status;

	public String getMedical_no() {
		return medical_no;
	}

	public void setMedical_no(String medical_no) {
		this.medical_no = medical_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SubjectVo [medical_no=" + medical_no
				+ ", gender=" + gender + ", name=" + name + ", birthday="
				+ birthday + ", status=" + status + "]";
	}

}
