package com.ylc.util;

import java.math.BigDecimal;

import javax.xml.bind.JAXBException;

import com.ylc.authorize.model.ArrayOfLineItem;
import com.ylc.authorize.model.CreateTransactionRequest;
import com.ylc.authorize.model.CreateTransactionResponse;
import com.ylc.authorize.model.CreditCardType;
import com.ylc.authorize.model.CustomerAddressType;
import com.ylc.authorize.model.CustomerDataType;
import com.ylc.authorize.model.CustomerProfilePaymentType;
import com.ylc.authorize.model.ExtendedAmountType;
import com.ylc.authorize.model.LineItemType;
import com.ylc.authorize.model.MerchantAuthenticationType;
import com.ylc.authorize.model.ObjectFactory;
import com.ylc.authorize.model.OrderType;
import com.ylc.authorize.model.PaymentProfile;
import com.ylc.authorize.model.PaymentType;
import com.ylc.authorize.model.TransactionRequestType;
import com.ylc.authorize.service.AuthorizeNetService;
import com.ylc.model.PaymentDetails;
import com.ylc.model.PaymentResponse;

public class ProcessPayment {
	
	public  PaymentResponse processPayment(PaymentDetails pd,AuthorizeNetService authorizeNetService){
		CreateTransactionResponse paymentRes=null;
		ObjectFactory objectFactory=new ObjectFactory();
		CreditCardType creditCardType=objectFactory.createCreditCardType();
		creditCardType.setCardCode(pd.getCvc());
		//creditCardType.setCardNumber("5424000000000015");
		creditCardType.setCardNumber(pd.getCardNumber());
		creditCardType.setExpirationDate(pd.getExpiration().replace("/", ""));
		
		if(pd.getAmount()==null)
			pd.setAmount("10");
		if(pd.getTotalPrice()==null)
			pd.setTotalPrice("10");
		PaymentType paymentType=objectFactory.createPaymentType();		
		paymentType.setCreditCard(creditCardType);
		
		OrderType orderType=objectFactory.createOrderType();
		
		orderType.setInvoiceNumber(YlcUtils.getInvoiceNum());
		orderType.setDescription("New Number");
		
		LineItemType lineItemType=objectFactory.createLineItemType();
		lineItemType.setItemId("1");
		lineItemType.setName("Number");
		lineItemType.setDescription("Inmate Number");
		lineItemType.setQuantity(new BigDecimal(1));
		lineItemType.setUnitPrice(new BigDecimal(pd.getTotalPrice()));		
		
		ArrayOfLineItem arrayOfLineItem=objectFactory.createArrayOfLineItem();
		arrayOfLineItem.getLineItem().add(lineItemType);
		
		ExtendedAmountType tax=objectFactory.createExtendedAmountType();
		tax.setAmount(new BigDecimal("0.00"));
		tax.setDescription("tax");
		tax.setName("Tax");
		
		
		
		CustomerDataType customerDataType=objectFactory.createCustomerDataType();
		customerDataType.setId(pd.getEmail());
		
		
		CustomerAddressType customerAddressType=objectFactory.createCustomerAddressType();
		customerAddressType.setFirstName(pd.getFname());
		customerAddressType.setLastName(pd.getLname());
		customerAddressType.setCompany("");
		customerAddressType.setCountry(pd.getCountry());
		customerAddressType.setEmail(pd.getEmail());
		customerAddressType.setFaxNumber("");
		customerAddressType.setAddress(pd.getAddress());
		customerAddressType.setPhoneNumber(pd.getPhone());
		customerAddressType.setState(pd.getState());
		customerAddressType.setZip(pd.getZip());
		
		
		
		TransactionRequestType transactionRequest=objectFactory.createTransactionRequestType();
		transactionRequest.setTransactionType("authCaptureTransaction");
		transactionRequest.setAmount(new BigDecimal(pd.getAmount()));
		transactionRequest.setPayment(paymentType);
		transactionRequest.setOrder(orderType);
		transactionRequest.setLineItems(arrayOfLineItem);
		transactionRequest.setTax(tax);
		transactionRequest.setPoNumber(""+YlcUtils.getPONumber());
		transactionRequest.setCustomer(customerDataType);
		transactionRequest.setBillTo(customerAddressType);
		transactionRequest.setCustomerIP("192.168.1.1");
		
		
		MerchantAuthenticationType merchantAuthenticationType=objectFactory.createMerchantAuthenticationType();		
		CreateTransactionRequest createTransactionRequest=objectFactory.createCreateTransactionRequest();
		createTransactionRequest.setMerchantAuthentication(merchantAuthenticationType);
		createTransactionRequest.setRefId(""+YlcUtils.getPONumber());
		createTransactionRequest.setTransactionRequest(transactionRequest);
		
		
		try {
			 paymentRes = authorizeNetService.chargeCreditCard(createTransactionRequest);
			 createResponse(paymentRes);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PaymentResponse rsponse=new PaymentResponse();
			rsponse.setStatusCode("-1");
			rsponse.setStatusMessage("Error while processing payment Contact helpdesk");
			return rsponse;
			//paymentRes.set
		}
		System.out.println();
		return  createResponse(paymentRes);
	}
	
	
	public  PaymentResponse processPaymentWithProfileId(PaymentDetails pd,AuthorizeNetService authorizeNetService){
		PaymentResponse response=null;
		
		ObjectFactory objectFactory=new ObjectFactory();
		PaymentProfile paymentProfile=objectFactory.createPaymentProfile();
		paymentProfile.setPaymentProfileId(pd.getPaymentProfileID());
		CustomerProfilePaymentType customerPaymentProfileType=objectFactory.createCustomerProfilePaymentType();
		customerPaymentProfileType.setCustomerProfileId(pd.getPaymentGatewayProfileID());
		customerPaymentProfileType.setPaymentProfile(paymentProfile);
		
		
		TransactionRequestType transactionRequest=objectFactory.createTransactionRequestType();
		transactionRequest.setTransactionType("authCaptureTransaction");
		transactionRequest.setAmount(new BigDecimal(pd.getTotalPrice()));
		transactionRequest.setProfile(customerPaymentProfileType);
		transactionRequest.setRefTransId(YlcUtils.getInvoiceNum());
		
		MerchantAuthenticationType merchantAuthenticationType=objectFactory.createMerchantAuthenticationType();		
		CreateTransactionRequest createTransactionRequest=objectFactory.createCreateTransactionRequest();
		createTransactionRequest.setTransactionRequest(transactionRequest);	
		createTransactionRequest.setMerchantAuthentication(merchantAuthenticationType);		
		
		try {
			CreateTransactionResponse createTransactionResponse=(CreateTransactionResponse)authorizeNetService.callPaymentService(createTransactionRequest,CreateTransactionRequest.class,CreateTransactionResponse.class);
			response=createResponse(createTransactionResponse);
			if(createTransactionResponse!=null){
				System.err.println("customer payment  profile id>>>>>>>>"+createTransactionResponse.getRefId());
				//customer profile id>>>>>>>>36978033
				//paymentProfile id>>>>33453727
			}
			
		} catch (JAXBException e) {
			response=new PaymentResponse();
			response.setStatusCode("-1");
			response.setStatusMessage("Error while processing payment Contact helpdesk");
			//return rsponse;
		}
		
		
		System.out.println();
		return  response;
	}
	
	
	
	private PaymentResponse createResponse(CreateTransactionResponse paymentRes){
		PaymentResponse rsponse=new PaymentResponse();
    	
		 if(YlcConstents.TRANS_SUCESS.equalsIgnoreCase(paymentRes.getMessages().getMessage().get(0).getCode())){
			 rsponse.setStatusCode("0");
				rsponse.setStatusMessage("your order is completed and transaction refrance number is : "+paymentRes.getTransactionResponse().getTransId());
				rsponse.setTransID(paymentRes.getTransactionResponse().getTransId());
		 }
		 else{
		    	rsponse.setStatusCode(paymentRes.getMessages().getMessage().get(0).getCode());
				rsponse.setStatusMessage(paymentRes.getMessages().getMessage().get(0).getText());
				rsponse.setTransID(null);
		    	
		    }
		 return rsponse;
	}
	
	
    
   
}
