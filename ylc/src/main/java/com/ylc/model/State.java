package com.ylc.model;

import java.io.Serializable;

public class State implements Serializable {
	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public String getStateAbbr() {
		return stateAbbr;
	}

	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	private static final long serialVersionUID = 1L;
	
	private Integer stateID;

	private String stateAbbr;

	private String stateName;
	
	

}