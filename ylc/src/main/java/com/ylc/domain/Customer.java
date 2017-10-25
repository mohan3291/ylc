package com.ylc.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Customer {
	
	private Integer customerID;	
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNumber;
	private String address1;
	private String address2;
	private String  city;
	private State state;
	private Country country;	
	private String zipCode;
	private byte active;
	private Integer createdBy;
	private Timestamp createdDate;
	private Integer updatedBy;
	private User user;
	private String paymentGatewayId;
	private BigDecimal prePaidAmount;
	private byte recurringPayment;
	private String recurringPaymentDate;
	private BigDecimal recurringPaymentAmount;
	
	public BigDecimal getPrePaidAmount() {
		return prePaidAmount;
	}
	public void setPrePaidAmount(BigDecimal prePaidAmount) {
		this.prePaidAmount = prePaidAmount;
	}
	public byte getRecurringPayment() {
		return recurringPayment;
	}
	public void setRecurringPayment(byte recurringPayment) {
		this.recurringPayment = recurringPayment;
	}
	public String getRecurringPaymentDate() {
		return recurringPaymentDate;
	}
	public void setRecurringPaymentDate(String recurringPaymentDate) {
		this.recurringPaymentDate = recurringPaymentDate;
	}
	public BigDecimal getRecurringPaymentAmount() {
		return recurringPaymentAmount;
	}
	public void setRecurringPaymentAmount(BigDecimal recurringPaymentAmount) {
		this.recurringPaymentAmount = recurringPaymentAmount;
	}

	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	private Timestamp updatedDate;

	public String getPaymentGatewayId() {
		return paymentGatewayId;
	}
	public void setPaymentGatewayId(String paymentGatewayId) {
		this.paymentGatewayId = paymentGatewayId;
	}

}
