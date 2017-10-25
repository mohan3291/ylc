package com.ylc.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;
import java.util.List;


public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer roleID;

	private byte active;

	private String createdBy;

	private Date createdDate;

	private String roleName;

	private String updatedBy;

	private Timestamp updatedDate;


	public Integer getRoleID() {
		return this.roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}	
}