package com.bookcart.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RegisteredUser {
	@Id
	private int id;
	@Column(length = 50)
	private String name;
	
	@Column(length = 100)
	private String address;
	
	@Column(length = 50)
	private String phoneNumber;
	
	@Column(length = 50)
	private String password;
	
	@Column(length = 50)
	private String userEmail;
	
	@Column(length = 7)
	private String pinCode;
	
	public RegisteredUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public RegisteredUser(int id) {
		super();
		
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
	
	

}
