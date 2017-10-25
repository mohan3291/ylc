package com.ylc.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


public class CustomerLine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer customerLineID;	
	private Integer inmateLocationID;
	private String  localLineNumber;
	private String destinationLineNumber;
	private Integer prepaidMinutes;
	private byte isInitiatedByInmate;
	private byte isPaidByQuickPay;
	private Timestamp startDate;
	private Timestamp endDate;
	private byte active;
	private Integer createdBy;
	private Timestamp createdDate;
	private Integer updatedBy;
	private Timestamp updatedDate;	
	private InMate inMate;
	private LineType lineType;	
	private User user;
	private Set<CustomerLinePaymentDetail> customerLinePaymentDetails = 
			new HashSet<CustomerLinePaymentDetail>(0);

	public Set<CustomerLinePaymentDetail> getCustomerLinePaymentDetails() {
		return customerLinePaymentDetails;
	}

	public void setCustomerLinePaymentDetails(
			Set<CustomerLinePaymentDetail> customerLinePaymentDetails) {
		this.customerLinePaymentDetails = customerLinePaymentDetails;
	}

	public Integer getCustomerLineID() {
		return customerLineID;
	}

	public void setCustomerLineID(Integer customerLineID) {
		this.customerLineID = customerLineID;
	}

	public Integer getInmateLocationID() {
		return inmateLocationID;
	}

	public void setInmateLocationID(Integer inmateLocationID) {
		this.inmateLocationID = inmateLocationID;
	}

	public String getLocalLineNumber() {
		return localLineNumber;
	}

	public void setLocalLineNumber(String localLineNumber) {
		this.localLineNumber = localLineNumber;
	}

	public String getDestinationLineNumber() {
		return destinationLineNumber;
	}

	public void setDestinationLineNumber(String destinationLineNumber) {
		this.destinationLineNumber = destinationLineNumber;
	}

	public Integer getPrepaidMinutes() {
		return prepaidMinutes;
	}

	public void setPrepaidMinutes(Integer prepaidMinutes) {
		this.prepaidMinutes = prepaidMinutes;
	}

	public byte getIsInitiatedByInmate() {
		return isInitiatedByInmate;
	}

	public void setIsInitiatedByInmate(byte isInitiatedByInmate) {
		this.isInitiatedByInmate = isInitiatedByInmate;
	}

	public byte getIsPaidByQuickPay() {
		return isPaidByQuickPay;
	}

	public void setIsPaidByQuickPay(byte isPaidByQuickPay) {
		this.isPaidByQuickPay = isPaidByQuickPay;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
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

	public InMate getInMate() {
		return inMate;
	}

	public void setInMate(InMate inMate) {
		this.inMate = inMate;
	}

	public LineType getLineType() {
		return lineType;
	}

	public void setLineType(LineType lineType) {
		this.lineType = lineType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}