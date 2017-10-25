package com.ylc.model;

public class CreditCard {
	String last4Digits;
	public String getLast4Digits() {
		return last4Digits;
	}
	public void setLast4Digits(String last4Digits) {
		this.last4Digits = last4Digits;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	String cardType;
	String cardNumber;
	String exp;

}
