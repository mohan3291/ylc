package com.ylc.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



public class InmateStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer inmateStatusID;
	private String inmateStatusName;
	private String inmateStatusDescription;
	public Integer getInmateStatusID() {
		return inmateStatusID;
	}
	public void setInmateStatusID(Integer inmateStatusID) {
		this.inmateStatusID = inmateStatusID;
	}
	public String getInmateStatusName() {
		return inmateStatusName;
	}
	public void setInmateStatusName(String inmateStatusName) {
		this.inmateStatusName = inmateStatusName;
	}
	public String getInmateStatusDescription() {
		return inmateStatusDescription;
	}
	public void setInmateStatusDescription(String inmateStatusDescription) {
		this.inmateStatusDescription = inmateStatusDescription;
	}
	

}