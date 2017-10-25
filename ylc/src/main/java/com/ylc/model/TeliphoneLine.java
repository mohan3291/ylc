package com.ylc.model;

import java.sql.Date;

public class TeliphoneLine {
	private String inmateName;
	private String bop;
	private String destCountry;
	private Integer lineID;
	public Integer getLineID() {
		return lineID;
	}
	public void setLineID(Integer lineID) {
		this.lineID = lineID;
	}
	private String service;
	private String number;
	private String status;
	public String getInmateName() {
		return inmateName;
	}
	public void setInmateName(String inmateName) {
		this.inmateName = inmateName;
	}
	public String getBop() {
		return bop;
	}
	public void setBop(String bop) {
		this.bop = bop;
	}
	public String getDestCountry() {
		return destCountry;
	}
	public void setDestCountry(String destCountry) {
		this.destCountry = destCountry;
	}
	private String routingNumber;
	private String facility;
	private String activation;
	private int minutesRemaining;
	public int getMinutesRemaining() {
		return minutesRemaining;
	}
	public void setMinutesRemaining(int minutesRemaining) {
		this.minutesRemaining = minutesRemaining;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	} 
	

}
