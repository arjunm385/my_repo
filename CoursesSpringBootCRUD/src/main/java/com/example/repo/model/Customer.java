package com.example.repo.model;

import java.io.Serializable;

public class Customer implements Serializable {


	private int cId;
	private String cName;
	private String mobile;
	private String password;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int cId, String cName, String mobile, String password) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.mobile = mobile;
		this.password = password;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", mobile=" + mobile + ", password=" + password + "]";
	}
	
	
}
