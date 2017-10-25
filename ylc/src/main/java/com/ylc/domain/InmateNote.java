package com.ylc.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class InmateNote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer inmateNaotesID;
	private String inmateNotes;
	private InMate inMate;
	private Integer createdBy;
	private Timestamp createdDate;
	public Integer getInmateNaotesID() {
		return inmateNaotesID;
	}
	public void setInmateNaotesID(Integer inmateNaotesID) {
		this.inmateNaotesID = inmateNaotesID;
	}
	public String getInmateNotes() {
		return inmateNotes;
	}
	public void setInmateNotes(String inmateNotes) {
		this.inmateNotes = inmateNotes;
	}
	public InMate getInMate() {
		return inMate;
	}
	public void setInMate(InMate inMate) {
		this.inMate = inMate;
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
	


}