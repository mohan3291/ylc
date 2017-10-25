package com.ylc.domain;

import java.io.Serializable;


public class LineType implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer lineTypeID;
	private String lineTypeName;
	public Integer getLineTypeID() {
		return lineTypeID;
	}
	public void setLineTypeID(Integer lineTypeID) {
		this.lineTypeID = lineTypeID;
	}
	public String getLineTypeName() {
		return lineTypeName;
	}
	public void setLineTypeName(String lineTypeName) {
		this.lineTypeName = lineTypeName;
	}
}