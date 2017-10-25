package com.ylc.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PrepaidPricing {
	private Integer prepaidPricingID;
	private String nameOfBlock;
	private Integer noOfMinutes;
	private String  description;
	private BigDecimal blockPrice;
	private byte active;
	private Integer createdBy; 
	private Timestamp createdDate;
	private Integer updatedBy;
	private Timestamp updatedDate;

	public Integer getPrepaidPricingID() {
		return prepaidPricingID;
	}

	public void setPrepaidPricingID(Integer prepaidPricingID) {
		this.prepaidPricingID = prepaidPricingID;
	}

	public String getNameOfBlock() {
		return nameOfBlock;
	}

	public void setNameOfBlock(String nameOfBlock) {
		this.nameOfBlock = nameOfBlock;
	}

	public Integer getNoOfMinutes() {
		return noOfMinutes;
	}

	public void setNoOfMinutes(Integer noOfMinutes) {
		this.noOfMinutes = noOfMinutes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getBlockPrice() {
		return blockPrice;
	}

	public void setBlockPrice(BigDecimal blockPrice) {
		this.blockPrice = blockPrice;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
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
