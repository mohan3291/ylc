package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.Customer;
import com.ylc.model.CustomerLine;
import com.ylc.model.CustomerLinePaymentDetail;
import com.ylc.model.InMate;
import com.ylc.model.PaymentCardType;
import com.ylc.model.PrepaidPricing;
import com.ylc.service.CustomerLinePaymentDetailService;

public class TestCustomerLinePaymentDetail extends BaseTest{
	
	@Autowired
    public CustomerLinePaymentDetailService customerLinePaymentDetailService;
	
	@Ignore("Only one time insert")	
	@Test
	public void testAddCustomerLinePaymentDetail(){
		
		CustomerLinePaymentDetail customerLinePaymentDetail=new CustomerLinePaymentDetail();
		Customer customer=new Customer();
		customer.setCustomerID(1);
		customerLinePaymentDetail.setCustomer(customer);
		CustomerLine customerlIne=new CustomerLine();
		customerlIne.setCustomerLineID(1);
		customerLinePaymentDetail.setCustomerLine(customerlIne);
		InMate inMate=new InMate();
		inMate.setInmateID(1);
		customerLinePaymentDetail.setInMate(inMate);
		customerLinePaymentDetail.setInvoiceGeneratedDate(new Timestamp(new Date().getTime()));
		customerLinePaymentDetail.setIsInitiatedByInmate(new Byte("1"));
		customerLinePaymentDetail.setIsInitiatedByInmate(new Byte("1"));
		customerLinePaymentDetail.setIsInvoiceGenerated(new Byte("1"));
		customerLinePaymentDetail.setIsPaidByQuickPay(new Byte("1"));
		customerLinePaymentDetail.setIsRecurringPayemnt(new Byte("1"));
		customerLinePaymentDetail.setLast4DigitsOfCard("9999");		
		customerLinePaymentDetail.setNameOnCard("XXXX");
		customerLinePaymentDetail.setNumberOfMinutes(222);
		customerLinePaymentDetail.setPaidFor("2333");
		customerLinePaymentDetail.setPaymentAmount(new BigDecimal(23.2));
		PaymentCardType paymentCardType=new PaymentCardType();
		paymentCardType.setPaymentCardTypeID(1);
		customerLinePaymentDetail.setPaymentCardType(paymentCardType);
		customerLinePaymentDetail.setPaymentConformationCode("12345");
		customerLinePaymentDetail.setPaymentDate(new Timestamp(new Date().getTime()));
		customerLinePaymentDetail.setPaymentType("online");
		PrepaidPricing prepaidPricing=new PrepaidPricing();
		prepaidPricing.setPrepaidPricingID(1);
		customerLinePaymentDetail.setPrepaidPricing(prepaidPricing);
		try {
			customerLinePaymentDetailService
					.saveCustomerLinePaymentDetail(customerLinePaymentDetail);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
