package com.ylc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class InMate implements Serializable {
		private static final long serialVersionUID = 1L;

	
		private Integer inmateID;		
		private String inmateCode;		
		private InmateStatus inmateStatus;
		private FacilityLocation facilityLocation;
		private String bopNumber;
		private String inmateFirstName;
		private String inmateLastName;
		private String referralCode;
		private BigDecimal prePaidAmount;
		private Integer allowedCallLines;
		private byte active;
		private BigDecimal maxAmtLimit;
		private BigDecimal chargePerLine;
		private boolean isCreditAllowed;
		private Integer createdBy;
		private Timestamp createdDate;
		private Integer updatedBy;
		private Timestamp updatedDate;
		public Integer getInmateID() {
			return inmateID;
		}
		public void setInmateID(Integer inmateID) {
			this.inmateID = inmateID;
		}
		public String getInmateCode() {
			return inmateCode;
		}
		public void setInmateCode(String inmateCode) {
			this.inmateCode = inmateCode;
		}
		public InmateStatus getInmateStatus() {
			return inmateStatus;
		}
		public void setInmateStatus(InmateStatus inmateStatus) {
			this.inmateStatus = inmateStatus;
		}
		public FacilityLocation getFacilityLocation() {
			return facilityLocation;
		}
		public void setFacilityLocation(FacilityLocation facilityLocation) {
			this.facilityLocation = facilityLocation;
		}
		public String getBopNumber() {
			return bopNumber;
		}
		public void setBopNumber(String bopNumber) {
			this.bopNumber = bopNumber;
		}
		public String getInmateFirstName() {
			return inmateFirstName;
		}
		public void setInmateFirstName(String inmateFirstName) {
			this.inmateFirstName = inmateFirstName;
		}
		public String getInmateLastName() {
			return inmateLastName;
		}
		public void setInmateLastName(String inmateLastName) {
			this.inmateLastName = inmateLastName;
		}
		public String getReferralCode() {
			return referralCode;
		}
		public void setReferralCode(String referralCode) {
			this.referralCode = referralCode;
		}
		public BigDecimal getPrePaidAmount() {
			return prePaidAmount;
		}
		public void setPrePaidAmount(BigDecimal prePaidAmount) {
			this.prePaidAmount = prePaidAmount;
		}
		public Integer getAllowedCallLines() {
			return allowedCallLines;
		}
		public void setAllowedCallLines(Integer allowedCallLines) {
			this.allowedCallLines = allowedCallLines;
		}
		public byte getActive() {
			return active;
		}
		public void setActive(byte active) {
			this.active = active;
		}
		public BigDecimal getMaxAmtLimit() {
			return maxAmtLimit;
		}
		public void setMaxAmtLimit(BigDecimal maxAmtLimit) {
			this.maxAmtLimit = maxAmtLimit;
		}
		public BigDecimal getChargePerLine() {
			return chargePerLine;
		}
		public void setChargePerLine(BigDecimal chargePerLine) {
			this.chargePerLine = chargePerLine;
		}
		public boolean getIsCreditAllowed() {
			return isCreditAllowed;
		}
		public void setIsCreditAllowed(boolean isCreditAllowed) {
			this.isCreditAllowed = isCreditAllowed;
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