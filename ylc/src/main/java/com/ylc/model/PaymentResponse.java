package com.ylc.model;

public class PaymentResponse {
String statusCode;
String statusMessage;
String transID;
public String getStatusCode() {
	return statusCode;
}
public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}
public String getStatusMessage() {
	return statusMessage;
}
public void setStatusMessage(String statusMessage) {
	this.statusMessage = statusMessage;
}
public String getTransID() {
	return transID;
}
public void setTransID(String transID) {
	this.transID = transID;
}

}
