package com.richie.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class LoginEntity implements Serializable{

	private static final long serialVersionUID = -3418888896581676318L;
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
