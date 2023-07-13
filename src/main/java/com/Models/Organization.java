package com.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organization {
	
	@Id
	private String organizationName;
	private String address;
	private String phoneNumber;
	private String email;
	private String password;
	
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organization( String organizationName, String address, String phoneNumber, String email,
			String password) {
		super();
		this.organizationName = organizationName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Organization [id="  + ", organizationName=" + organizationName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + "]";
	}
	
}
