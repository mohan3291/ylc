package com.ylc.domain;

import java.io.Serializable;



public class BillingAddress implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer billingAddressID;

	private String address1;
	
	private String address2;

	private String city;

	private String zipCode;
	
	private Country country;
	
	private State state;
	
	private User user;

	public Integer getBillingAddressID() {
		return billingAddressID;
	}

	public void setBillingAddressID(Integer billingAddressID) {
		this.billingAddressID = billingAddressID;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}	

}