package com.ylc.model;

import java.io.Serializable;


public class PaymentCardType implements Serializable {
	private static final long serialVersionUID = 1L;
    
	private Integer paymentCardTypeID;
	private String paymentCardName;
	private byte active;

	public Integer getPaymentCardTypeID() {
		return paymentCardTypeID;
	}

	public void setPaymentCardTypeID(Integer paymentCardTypeID) {
		this.paymentCardTypeID = paymentCardTypeID;
	}

	public String getPaymentCardName() {
		return paymentCardName;
	}

	public void setPaymentCardName(String paymentCardName) {
		this.paymentCardName = paymentCardName;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
}