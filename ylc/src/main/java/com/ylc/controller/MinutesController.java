package com.ylc.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylc.authorize.service.AuthorizeNetService;
import com.ylc.domain.CustomerLine;
import com.ylc.model.Customer;
import com.ylc.model.CustomerLinePaymentDetail;
import com.ylc.model.Email;
import com.ylc.model.InMate;
import com.ylc.model.PaymentCardType;
import com.ylc.model.PaymentDetails;
import com.ylc.model.PaymentResponse;
import com.ylc.model.PrepaidPricing;
import com.ylc.model.User;
import com.ylc.service.BillingService;
import com.ylc.service.CustermerService;
import com.ylc.service.CustomerLineService;
import com.ylc.service.PrepaidPricingService;
import com.ylc.service.UserService;
import com.ylc.util.ProcessPayment;
import com.ylc.util.SendEmail;
import com.ylc.util.YlcConstents;
import com.ylc.util.YlcEmailTemplet;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/minutes")
public class MinutesController {
   
	@Autowired
	private PrepaidPricingService prepaidPricingService;
	@Autowired
	SendEmail sendEmail;
	@Autowired
	AuthorizeNetService authorizeNetService;
	@Autowired
    private BillingService billlingService;
    @Autowired
    private CustermerService customerService;
	
	@Autowired
    private UserService userService;

	@Autowired
	private CustomerLineService customerLineService;
	@RequestMapping("/layout")
    public String getLinesPartialPage() {
        return "minutes/layout";
    }
   
    
    @RequestMapping("/minutesDetails")
    public @ResponseBody List<PrepaidPricing> getMinutesDetails(HttpServletRequest  request) {
    	
    	PaymentDetails pd=new PaymentDetails();
    	List<PrepaidPricing> prepaidPricingList=null; 
    	try {
			prepaidPricingList = prepaidPricingService.getPrepaidPricings();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return prepaidPricingList;
        }
    @RequestMapping(value="/saveMinutesDetails", method= RequestMethod.POST)
    public @ResponseBody PaymentDetails saveAddMin(@RequestBody PaymentDetails paymentDetails,HttpServletRequest  request) {
    	
    	PaymentDetails pd=new PaymentDetails();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	pd.setUserName(auth.getName());
    	return pd;
        }
    
    
    @RequestMapping(value="/submitPayment" ,method = RequestMethod.POST)
    public @ResponseBody PaymentResponse submitPayment(@RequestBody PaymentDetails paymentDetails,HttpServletRequest  request) {
    	ProcessPayment pp =new ProcessPayment();
    	PaymentResponse paymentRes=new PaymentResponse();
    	paymentRes=pp.processPaymentWithProfileId(paymentDetails,authorizeNetService);
	    if(YlcConstents.PAYMENT_SUCCESS.equalsIgnoreCase(paymentRes.getStatusCode()))
	    {
			
	    	Customer customer=getCustomer();
	    	BigDecimal price =new BigDecimal(paymentDetails.getTotalPrice());
	    	BigDecimal balance=customer.getPrePaidAmount();
	    	if(balance==null)
	    		balance=price;
	    	else
	    		balance=balance.add(price);
	    	customer.setPrePaidAmount(balance);
	    	try {
				customerService.saveCustomer(customer);
				//e.printStackTrace();
				paymentRes.setStatusCode("0");
	    		paymentRes.setStatusMessage("Transaction Completed succesfully");
				paymentRes.setTransID("Add Minutes");;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				paymentRes.setStatusCode("-1");
	    		paymentRes.setStatusMessage("Errror while processing request");
				paymentRes.setTransID("Add Minutes Number");;
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				paymentRes.setStatusCode("-1");
	    		paymentRes.setStatusMessage("Errror while processing request");
				paymentRes.setTransID("Add Minutes Number");;
				e.printStackTrace();
			} 
	    	sendorderConfemail(paymentDetails);
	    }
	    
    //	saveBillingAdd(paymentDetails);
	    return paymentRes;
        }
    private void sendorderConfemail(PaymentDetails paymentDetails){
    	Email emailObj=new Email();
    	emailObj.setTo(getUser().getEmailID());
    	emailObj.setMessage(YlcEmailTemplet.PREPAY_TEMP);
    	emailObj.setSubject("Order Conformation");
    	sendEmail.sendOrderEMail(emailObj);
	    
    }
    
    private Customer getCustomer(){
    	String userID=SecurityContextHolder.getContext().getAuthentication().getName();
    	Customer customer=new Customer();
    	customer.setCustomerID(Integer.parseInt(userID));    	
    	try {
			customer=customerService.getCustomerById(customer);
		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
    	return customer;
    }

    private User getUser(){
    	String userID=SecurityContextHolder.getContext().getAuthentication().getName();
    	User customer=new User();
    	customer.setCustomerID(Integer.parseInt(userID));    	
    	try {
			customer=userService.findByUserById(customer);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	return customer;
    }
    
}
