package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Login_Details")
public class Login_Details {

	
	private String username;
	private String password;
	private String status;
	private int times;
	
	
	
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	public int gettimes() {
		return times;
	}
	public void settimes(int times) {
		this.times = times;
	}
	@Override
	public String toString() {
		return "Login_Details [username=" + username + ", password=" + password + ", status=" + status + ", times="
				+ times + "]";
	}

	
}
