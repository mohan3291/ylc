package com.ylc.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylc.authorize.model.ArrayOfLineItem;
import com.ylc.authorize.model.ArrayOfSetting;
import com.ylc.authorize.model.CreateTransactionRequest;
import com.ylc.authorize.model.CreateTransactionResponse;
import com.ylc.authorize.model.CreditCardType;
import com.ylc.authorize.model.CustomerAddressType;
import com.ylc.authorize.model.CustomerDataType;
import com.ylc.authorize.model.ExtendedAmountType;
import com.ylc.authorize.model.LineItemType;
import com.ylc.authorize.model.MerchantAuthenticationType;
import com.ylc.authorize.model.NameAndAddressType;
import com.ylc.authorize.model.ObjectFactory;
import com.ylc.authorize.model.OrderType;
import com.ylc.authorize.model.PaymentType;
import com.ylc.authorize.model.SettingType;
import com.ylc.authorize.model.TransRetailInfoType;
import com.ylc.authorize.model.TransactionRequestType;
import com.ylc.authorize.model.UserField;
import com.ylc.authorize.service.AuthorizeNetService;
import com.ylc.model.BillingAddress;
import com.ylc.model.Country;
import com.ylc.model.CreditCard;
import com.ylc.model.Customer;
import com.ylc.model.FacilityLocation;
import com.ylc.model.InMate;
import com.ylc.model.InmateStatus;
import com.ylc.model.PaymentDetails;
import com.ylc.model.PaymentProfile;
import com.ylc.model.PaymentResponse;
import com.ylc.model.State;
import com.ylc.model.User;
import com.ylc.service.BillingService;
import com.ylc.service.CustermerService;
import com.ylc.service.InMateService;
import com.ylc.service.UserService;
import com.ylc.util.ProcessPayment;
import com.ylc.util.YlcConstents;
import com.ylc.util.YlcUtils;


/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/quickpay")
public class QuickPayController {
    @RequestMapping("/layout")
    public String getCarPartialPage() {
        return "quickpay/layout";
    }
    @Autowired
    private BillingService billlingService;
    @Autowired
    private CustermerService customerService;
	
    @Autowired
	AuthorizeNetService authorizeNetService;
    @Autowired
    private UserService userService;
    
	@Autowired
    private InMateService inMateService;
	
    @RequestMapping("/paymetDetails")
    public @ResponseBody PaymentDetails getCustomer(HttpServletRequest  request) {
    	
    	PaymentDetails pd=new PaymentDetails();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	pd.setUserName(auth.getName());
    	 Customer customer=getCustomer();
    	 pd.setAddress(customer.getAddress1());
    	 pd.setCity(customer.getCity());
    	 if(customer.getCountry()!=null){
    		 pd.setCountry(customer.getCountry().getCountryName());
    		 pd.setCountryID(customer.getCountry().getCountryID());
    	 }
    	 User user=getUser();
    	 if(user!=null)
    		 pd.setEmail(user.getEmailID());
    	 if(customer.getState()!=null){
	    	 pd.setState(customer.getState().getStateName());
	    	 pd.setStateID(customer.getState().getStateID());
    	 }
    	 pd.setZip(customer.getZipCode());
    	 pd.setPhone(customer.getMobileNumber());
    		

    	 if(customer.getPaymentGatewayId()!=null){
    		 	
    		 	pd.setPaymentGatewayProfileID(customer.getPaymentGatewayId());
    		 	PaymentProfile cc=authorizeNetService.getdetailsForProfile(customer.getPaymentGatewayId());
    		 	pd.setPaymentProfileID(cc.getPaymentProfileID());
    		 	pd.setCardNumber(cc.getCreditCard().getCardNumber());
 	}
    	// pd.setCardHolderName();
    	return pd;
        }
    
    @RequestMapping(value="/savePaymetDetails" ,method = RequestMethod.POST)
    public @ResponseBody PaymentResponse savePaymetDetails(@RequestBody PaymentDetails paymentDetails,HttpServletRequest  request) {
        	
    	InMate inmate=new InMate();
    	ProcessPayment pp =new ProcessPayment();
    	PaymentResponse paymentRes=new PaymentResponse(); 
    	paymentRes.setStatusCode("0");
    	/*PaymentResponse paymentRes=pp.processPayment(paymentDetails,authorizeNetService);
    	 if(YlcConstents.PAYMENT_SUCCESS.equalsIgnoreCase(paymentRes.getStatusCode()))*/
    	 {
	    	try{
	    	if(paymentDetails.getBop()!=null){
	    		inmate.setBopNumber(paymentDetails.getBop());
	    		List<InMate> inmates= inMateService.getInmateByBOP(inmate);	
	    		if(inmates.size()>0)
	    			inmate=inmates.get(0);
	    		if(inmate.getPrePaidAmount()==null)
	    			inmate.setPrePaidAmount(new BigDecimal(paymentDetails.getAmount()));
	    		else
	    			inmate.setPrePaidAmount(inmate.getPrePaidAmount().add(new BigDecimal(paymentDetails.getAmount())));
	    		inMateService.saveInMate(inmate);
	    		saveBillingAdd(paymentDetails);
	    	}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		paymentRes.setStatusCode("-1");
	    		paymentRes.setStatusMessage("Errror while processing request");
				paymentRes.setTransID("Assigin Number Error");;
	    	}
    	}
    	 
    	return paymentRes;
        }
    @RequestMapping(value="/getInMate" ,method = RequestMethod.POST)
    public @ResponseBody List<InMate> getInMate(@RequestBody PaymentDetails paymentDetails,HttpServletRequest  request) {
    	List<InMate> inmates=new ArrayList<InMate>();
    	InMate inmate=new InMate();
    	if(paymentDetails.getBop()!=null){
    		inmate.setBopNumber(paymentDetails.getBop());
    		 inmates= inMateService.getInmateByBOP(inmate);	
    	}else{
    		inmate.setInmateFirstName(paymentDetails.getFname());
    		inmate.setInmateLastName(paymentDetails.getLname());
    		 inmates= inMateService.getInmateByByFirstAndLastName(inmate);	
    	}
    		
    	
    	return inmates;
        }
    
    @RequestMapping(value="/getInMateName" ,method = RequestMethod.POST)
    public @ResponseBody String getInMateName(@RequestBody String bop,HttpServletRequest  request) {
    	String inmateNme="";
    	List<InMate> inmates=new ArrayList<InMate>();
    	InMate inmate=new InMate();
    	if(bop!=null){
    		inmate.setBopNumber(bop);
    		 inmates= inMateService.getInmateByBOP(inmate);	
    	}
    		for(InMate inmater:inmates){
    			inmateNme=inmater.getInmateFirstName()+" "+inmater.getInmateLastName();
    		}
    			
    	
    	return inmateNme;
        }
    
    @RequestMapping(value="/saveInMate" ,method = RequestMethod.POST)
    public @ResponseBody List<InMate> saveInMate(@RequestBody PaymentDetails paymentDetails,HttpServletRequest  request) {
    	List<InMate> inmates=new ArrayList<InMate>();
    	InMate inmate=new InMate();
    	try{
	    	inmate.setBopNumber(paymentDetails.getBop());
	    	inmate.setInmateFirstName(paymentDetails.getFname());
			inmate.setInmateLastName(paymentDetails.getLname());
			
			//TODO Validate these data where to get when adding inmate
			inmate.setInmateCode(paymentDetails.getBop());
	    	inmate.setReferralCode(paymentDetails.getBop());
	    	inmate.setPrePaidAmount(new BigDecimal(0));
	    	FacilityLocation facilityLocation=new FacilityLocation();
			facilityLocation.setFacilityID(paymentDetails.getInmateFacility());
			inmate.setFacilityLocation(facilityLocation);
			InmateStatus inmateStatus=new InmateStatus();
			inmateStatus.setInmateStatusID(1);
			inmate.setInmateStatus(inmateStatus);
			inmate.setActive(new Byte("1"));
			inmate.setAllowedCallLines(1234);
			
	    	inMateService.saveInMate(inmate);
	    	inmates= inMateService.getInmateByBOP(inmate);
	    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return inmates;
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
    	User user=new User();
    	user.setCustomerID(Integer.parseInt(userID));
    	try {
			user=userService.findByUserById(user);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	return user;
    }
 private void saveBillingAdd(PaymentDetails paymentDetails){
	 
	 
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 	 String userID=auth.getName();
	 	if(userID!=null & !YlcConstents.ANONYMOUSUser.equalsIgnoreCase(userID)){
	 	Customer customer=new Customer();
	 	customer.setCustomerID(Integer.parseInt(userID));   
	 	try {
			customer=customerService.getCustomerById(customer);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
			BillingAddress bill=new BillingAddress();
			bill.setAddress1(getCustomer().getAddress1());
			bill.setAddress2(getCustomer().getAddress2());
			bill.setCity(getCustomer().getCity());		
			bill.setZipCode(paymentDetails.getZip());		
			//bill.setCustomer(YlcUtils.copy(customer));
			
			//TODO Populate actual city & State
			Country country=new Country();
			country.setCountryID(paymentDetails.getCountryID());
			State state=new State();
			state.setStateID(paymentDetails.getStateID());
			bill.setCountry(country);
			bill.setState(state);
			User user=customer.getUser();
			if(user==null){
				user=new User();
				user.setCustomerID(customer.getCustomerID());
				
			}
			bill.setUser(user);
			
			
		try {
				billlingService.saveAddress(bill);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 }
 }
