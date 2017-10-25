package com.ylc.model;

import java.io.Serializable;



public class FacilityLocation implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer facilityID; 
	private String facilityName;
	private String phone;
	private float inmates;
	private String address;
	private String citystatezip;
	private String f7;
	private String timezone;
	private RateCenter rateCenter;
	
	public Integer getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(Integer facilityID) {
		this.facilityID = facilityID;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getInmates() {
		return inmates;
	}
	public void setInmates(float inmates) {
		this.inmates = inmates;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCitystatezip() {
		return citystatezip;
	}
	public void setCitystatezip(String citystatezip) {
		this.citystatezip = citystatezip;
	}
	public String getF7() {
		return f7;
	}
	public void setF7(String f7) {
		this.f7 = f7;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public RateCenter getRateCenter() {
		return rateCenter;
	}
	public void setRateCenter(RateCenter rateCenter) {
		this.rateCenter = rateCenter;
	}
}