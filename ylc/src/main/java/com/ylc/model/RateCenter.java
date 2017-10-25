package com.ylc.model;

import java.sql.Timestamp;

public class RateCenter {
	
	private Integer rateCenterID;
	private String rateCenterName;
	private Integer npanxx;
	private Timestamp effective;
	private Integer lata;
	private String ocn;
	private Integer createdBy;
	private Timestamp createdDate;
	private Integer updatedBy;
	private Timestamp updatedDate;
	private String localExchanges;
	public Integer getRateCenterID() {
		return rateCenterID;
	}
	public void setRateCenterID(Integer rateCenterID) {
		this.rateCenterID = rateCenterID;
	}
	public String getRateCenterName() {
		return rateCenterName;
	}
	public void setRateCenterName(String rateCenterName) {
		this.rateCenterName = rateCenterName;
	}
	public Integer getNpanxx() {
		return npanxx;
	}
	public void setNpanxx(Integer npanxx) {
		this.npanxx = npanxx;
	}
	public Timestamp getEffective() {
		return effective;
	}
	public void setEffective(Timestamp effective) {
		this.effective = effective;
	}
	public Integer getLata() {
		return lata;
	}
	public void setLata(Integer lata) {
		this.lata = lata;
	}
	public String getOcn() {
		return ocn;
	}
	public void setOcn(String ocn) {
		this.ocn = ocn;
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
	public String getLocalExchanges() {
		return localExchanges;
	}
	public void setLocalExchanges(String localExchanges) {
		this.localExchanges = localExchanges;
	}

}
