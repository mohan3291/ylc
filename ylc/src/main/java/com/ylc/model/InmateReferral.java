package com.ylc.model;

import java.io.Serializable;


public class InmateReferral implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer inmateReferralID;
	private InMate inMate;
	private InMate inMateReferredBy;
	public Integer getInmateReferralID() {
		return inmateReferralID;
	}
	public void setInmateReferralID(Integer inmateReferralID) {
		this.inmateReferralID = inmateReferralID;
	}
	public InMate getInMate() {
		return inMate;
	}
	public void setInMate(InMate inMate) {
		this.inMate = inMate;
	}
	public InMate getInMateReferredBy() {
		return inMateReferredBy;
	}
	public void setInMateReferredBy(InMate inMateReferredBy) {
		this.inMateReferredBy = inMateReferredBy;
	}
	


}