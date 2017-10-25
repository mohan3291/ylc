package com.ylc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class CustomerPaymentDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer linePaymentDetailID;
	private String paidFor;
	private String paymentType;
	private BigDecimal paymentAmount;
	private String nameOnCard;
	private String last4DigitsOfCard;
	private String paymentConformationCode;
	private Timestamp paymentDate;
	private Integer numberOfMinutes;
	private byte isPaidByQuickPay;
	private byte isInitiatedByInmate;
	private byte isRecurringPayemnt;
	private byte isInvoiceGenerated;
	private Timestamp invoiceGeneratedDate;
	private Integer createdBy;
	private Timestamp createdDate;
	private Integer updatedBy;
	private Timestamp updatedDate;	
	private User user;
	private PrepaidPricing prepaidPricing;
	public PaymentCardType getPaymentCardType() {
		return paymentCardType;
	}
	public void setPaymentCardType(PaymentCardType paymentCardType) {
		this.paymentCardType = paymentCardType;
	}
	private PaymentCardType paymentCardType;
	
	public Integer getLinePaymentDetailID() {
		return linePaymentDetailID;
	}
	public void setLinePaymentDetailID(Integer linePaymentDetailID) {
		this.linePaymentDetailID = linePaymentDetailID;
	}
	public String getPaidFor() {
		return paidFor;
	}
	public void setPaidFor(String paidFor) {
		this.paidFor = paidFor;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getLast4DigitsOfCard() {
		return last4DigitsOfCard;
	}
	public void setLast4DigitsOfCard(String last4DigitsOfCard) {
		this.last4DigitsOfCard = last4DigitsOfCard;
	}
	public String getPaymentConformationCode() {
		return paymentConformationCode;
	}
	public void setPaymentConformationCode(String paymentConformationCode) {
		this.paymentConformationCode = paymentConformationCode;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Integer getNumberOfMinutes() {
		return numberOfMinutes;
	}
	public void setNumberOfMinutes(Integer numberOfMinutes) {
		this.numberOfMinutes = numberOfMinutes;
	}
	public byte getIsPaidByQuickPay() {
		return isPaidByQuickPay;
	}
	public void setIsPaidByQuickPay(byte isPaidByQuickPay) {
		this.isPaidByQuickPay = isPaidByQuickPay;
	}
	public byte getIsInitiatedByInmate() {
		return isInitiatedByInmate;
	}
	public void setIsInitiatedByInmate(byte isInitiatedByInmate) {
		this.isInitiatedByInmate = isInitiatedByInmate;
	}
	public byte getIsRecurringPayemnt() {
		return isRecurringPayemnt;
	}
	public void setIsRecurringPayemnt(byte isRecurringPayemnt) {
		this.isRecurringPayemnt = isRecurringPayemnt;
	}
	public byte getIsInvoiceGenerated() {
		return isInvoiceGenerated;
	}
	public void setIsInvoiceGenerated(byte isInvoiceGenerated) {
		this.isInvoiceGenerated = isInvoiceGenerated;
	}
	public Timestamp getInvoiceGeneratedDate() {
		return invoiceGeneratedDate;
	}
	public void setInvoiceGeneratedDate(Timestamp invoiceGeneratedDate) {
		this.invoiceGeneratedDate = invoiceGeneratedDate;
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


	public PrepaidPricing getPrepaidPricing() {
		return prepaidPricing;
	}
	public void setPrepaidPricing(PrepaidPricing prepaidPricing) {
		this.prepaidPricing = prepaidPricing;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
