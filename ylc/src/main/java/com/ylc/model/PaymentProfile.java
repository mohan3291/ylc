package com.ylc.model;

public class PaymentProfile {
	private String paymentProfileID;
	private CreditCard creditCard;
	public String getPaymentProfileID() {
		return paymentProfileID;
	}
	public void setPaymentProfileID(String paymentProfileID) {
		this.paymentProfileID = paymentProfileID;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
