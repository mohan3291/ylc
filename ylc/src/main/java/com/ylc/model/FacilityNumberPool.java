package com.ylc.model;

import java.sql.Timestamp;

public class FacilityNumberPool {
	
	private Integer facilityNumberPoolID;
	private Integer rateCenterID;
	private String pNumber;
	private byte status;
	private FacilityLocation facilityLocation;
	private Integer createdBy;
	private Timestamp createdDate;
	private Integer updatedBy;
	private Timestamp updatedDate;
	public Integer getFacilityNumberPoolID() {
		return facilityNumberPoolID;
	}
	public void setFacilityNumberPoolID(Integer facilityNumberPoolID) {
		this.facilityNumberPoolID = facilityNumberPoolID;
	}
	public Integer getRateCenterID() {
		return rateCenterID;
	}
	public void setRateCenterID(Integer rateCenterID) {
		this.rateCenterID = rateCenterID;
	}
	public String getpNumber() {
		return pNumber;
	}
	public void setpNumber(String string) {
		this.pNumber = string;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public FacilityLocation getFacilityLocation() {
		return facilityLocation;
	}
	public void setFacilityLocation(FacilityLocation facilityLocation) {
		this.facilityLocation = facilityLocation;
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
	

}
