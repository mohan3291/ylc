package com.ylc.domain;

import java.io.Serializable;
import java.sql.Timestamp;


public class CallLog implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer lineCallLogID;
	private String localLineNumber;
	private String destinationLineNumber;
	private Timestamp callStartDateTime;
	private Timestamp  callEndDateTime;
	private String callDuration;
	private Integer minutesLeft;	
	private CustomerLinePaymentDetail customerLinePaymentDetail;
	
	public CustomerLinePaymentDetail getCustomerLinePaymentDetail() {
		return customerLinePaymentDetail;
	}
	public void setCustomerLinePaymentDetail(
			CustomerLinePaymentDetail customerLinePaymentDetail) {
		this.customerLinePaymentDetail = customerLinePaymentDetail;
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
	private Integer createdBy;
	private Timestamp createdDate;
	private Integer updatedBy;
	private Timestamp updatedDate;
	public Integer getLineCallLogID() {
		return lineCallLogID;
	}
	public void setLineCallLogID(Integer lineCallLogID) {
		this.lineCallLogID = lineCallLogID;
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
	public Timestamp getCallStartDateTime() {
		return callStartDateTime;
	}
	public void setCallStartDateTime(Timestamp callStartDateTime) {
		this.callStartDateTime = callStartDateTime;
	}
	public Timestamp getCallEndDateTime() {
		return callEndDateTime;
	}
	public void setCallEndDateTime(Timestamp callEndDateTime) {
		this.callEndDateTime = callEndDateTime;
	}
	public String getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(String callDuration) {
		this.callDuration = callDuration;
	}
	public Integer getMinutesLeft() {
		return minutesLeft;
	}
	public void setMinutesLeft(Integer minutesLeft) {
		this.minutesLeft = minutesLeft;
	}
	
}