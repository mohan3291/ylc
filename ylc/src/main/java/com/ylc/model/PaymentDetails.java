package com.ylc.model;

public class PaymentDetails {
	private String blockOfMins;
	private String pricePerBlock;
	private String totalPrice;
	private int blockId;
	private String fname;
	private String lname;
	private String bop;
	private String amount;
	private String address;
	private String city;
	private String state;
	private String userName;
	private String email;
	private  Integer stateID;
	private Integer countryID;
	private Integer inmateFacility;
	private String paymentProfileID;
	private String paymentType;
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentGatewayProfileID() {
		return paymentGatewayProfileID;
	}
	public void setPaymentGatewayProfileID(String paymentGatewayProfileID) {
		this.paymentGatewayProfileID = paymentGatewayProfileID;
	}
	private String paymentGatewayProfileID;
	
	public Integer getInmateFacility() {
		return inmateFacility;
	}
	public void setInmateFacility(Integer inmateFacility) {
		this.inmateFacility = inmateFacility;
	}
	public Integer getStateID() {
		return stateID;
	}
	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}
	public Integer getCountryID() {
		return countryID;
	}
	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}
	public String getPaymentProfileID() {
		return paymentProfileID;
	}
	public void setPaymentProfileID(String paymentProfileID) {
		this.paymentProfileID = paymentProfileID;
	}
	private String country ;
	private String zip;
	private String phone;
	private String cardHolderName;
	private String cardNumber;
	private String cvc;
	private String expiration;


	private String location;
	private String lineNumber;
	private String destination;
	private String fwdLineNumber;
	private Integer lineID;
	private String selectedPayProfile;
	
	
	public String getSelectedPayProfile() {
		return selectedPayProfile;
	}
	public void setSelectedPayProfile(String selectedPayProfile) {
		this.selectedPayProfile = selectedPayProfile;
	}
	public Integer getLineID() {
		return lineID;
	}
	public void setLineID(Integer lineID) {
		this.lineID = lineID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFwdLineNumber() {
		return fwdLineNumber;
	}
	public void setFwdLineNumber(String fwdLineNumber) {
		this.fwdLineNumber = fwdLineNumber;
	}
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	public String getBlockOfMins() {
		return blockOfMins;
	}
	public void setBlockOfMins(String blockOfMins) {
		this.blockOfMins = blockOfMins;
	}
	public String getPricePerBlock() {
		return pricePerBlock;
	}
	public void setPricePerBlock(String pricePerBlock) {
		this.pricePerBlock = pricePerBlock;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getBop() {
		return bop;
	}
	public void setBop(String bop) {
		this.bop = bop;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	

}
