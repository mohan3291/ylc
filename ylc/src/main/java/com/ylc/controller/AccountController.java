package com.ylc.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylc.authorize.model.CreateCustomerProfileRequest;
import com.ylc.authorize.model.CreateCustomerProfileResponse;
import com.ylc.authorize.model.CreditCardType;
import com.ylc.authorize.model.CustomerAddressType;
import com.ylc.authorize.model.CustomerPaymentProfileExType;
import com.ylc.authorize.model.CustomerPaymentProfileMaskedType;
import com.ylc.authorize.model.CustomerPaymentProfileType;
import com.ylc.authorize.model.CustomerProfileType;
import com.ylc.authorize.model.CustomerTypeEnum;
import com.ylc.authorize.model.GetCustomerProfileRequest;
import com.ylc.authorize.model.GetCustomerProfileResponse;
import com.ylc.authorize.model.MerchantAuthenticationType;
import com.ylc.authorize.model.ObjectFactory;
import com.ylc.authorize.model.PaymentProfile;
import com.ylc.authorize.model.PaymentType;
import com.ylc.authorize.model.UpdateCustomerPaymentProfileRequest;
import com.ylc.authorize.model.UpdateCustomerPaymentProfileResponse;
import com.ylc.authorize.model.ValidationModeEnum;
import com.ylc.authorize.service.AuthorizeNetService;
import com.ylc.model.Country;
import com.ylc.model.CreditCard;
import com.ylc.model.CustomerLine;
import com.ylc.model.CustomerLinePaymentDetail;
import com.ylc.model.Invoice;
import com.ylc.model.State;
import com.ylc.model.TeliphoneLine;
import com.ylc.model.User;
import com.ylc.model.AccountDetails;
import com.ylc.model.Customer;
import com.ylc.model.PaymentDetails;
import com.ylc.service.CountryService;
import com.ylc.service.CustermerService;
import com.ylc.service.CustomerLinePaymentDetailService;
import com.ylc.service.CustomerLineService;
import com.ylc.service.StateService;
import com.ylc.service.UserService;


/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AuthorizeNetService authorizeNetService;
	@Autowired
    private UserService userService;
	@Autowired
	private CustomerLinePaymentDetailService customerLinePaymentDetailService;

	@Autowired
    private StateService stateService;
	@Autowired
    private CustermerService customerService;
	@Autowired
    private CountryService countryService;
	
    @RequestMapping("/layout")
    public String getCarPartialPage() {
        return "account/layout";
    }
    @RequestMapping("/customerDetails")
    public @ResponseBody AccountDetails getCustomerDetails(HttpServletRequest  request) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    	
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String userID=auth.getName();
    	Customer customer=new Customer();
    	customer.setCustomerID(Integer.parseInt(userID));   
    	customer=customerService.getCustomerById(customer);
    	User user=new User();
    	user.setCustomerID(Integer.parseInt(userID));
    	user=userService.findByUserById(user);
    	AccountDetails accountDetails=new AccountDetails();
    	accountDetails.setUserID(user.getEmailID());
    	accountDetails.setCustomerID(customer.getCustomerID());
    	accountDetails.setFirstName(customer.getFirstName());
    	accountDetails.setLastName(customer.getLastName());
    	accountDetails.setMiddleName(customer.getMiddleName());
    	accountDetails.setAddress1(customer.getAddress1());
    	accountDetails.setAddress2(customer.getAddress2());
    	accountDetails.setMobileNumber(customer.getMobileNumber());
    	accountDetails.setCity(customer.getCity());
    	accountDetails.setCustomerID(customer.getCustomerID());
    	accountDetails.setState(customer.getState()!=null?customer.getState().getStateName():null);  
    	accountDetails.setStateID(customer.getState()!=null?customer.getState().getStateID():null);
    	accountDetails.setCountry(customer.getCountry()!=null?customer.getCountry().getCountryName():null);
    	accountDetails.setCountryID(customer.getCountry()!=null?customer.getCountry().getCountryID():null);
    	accountDetails.setZipCode(""+customer.getZipCode());   
    	if(customer.getPrePaidAmount()!=null)
    		accountDetails.setBalance(""+customer.getPrePaidAmount());
    	else
    		accountDetails.setBalance("0.00");
    	return accountDetails;
        }
    
    @RequestMapping("/getCCInfo")
    public @ResponseBody com.ylc.model.PaymentProfile getCCInfo(HttpServletRequest  request) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    	
    	CreditCard cc=new CreditCard();
    	com.ylc.model.PaymentProfile paymentProfile=new com.ylc.model.PaymentProfile() ;
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String userID=auth.getName();
    	Customer customer=new Customer();
    	customer.setCustomerID(Integer.parseInt(userID));   
    	customer=customerService.getCustomerById(customer);
    	
    	if(customer.getPaymentGatewayId()!=null){
    		paymentProfile=authorizeNetService.getdetailsForProfile(customer.getPaymentGatewayId());
    	}
     
           return paymentProfile;
        }
    
    @RequestMapping("/getPaymentProfile")
    public @ResponseBody PaymentDetails getPaymentProfile(HttpServletRequest  request) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    	
    //	CreditCard cc=new CreditCard();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String userID=auth.getName();
    	Customer customer=new Customer();
    	customer.setCustomerID(Integer.parseInt(userID));   
    	customer=customerService.getCustomerById(customer);
    	PaymentDetails paymentDetails=new PaymentDetails();
    	
    	if(customer.getPaymentGatewayId()!=null){
    	ObjectFactory objectFactory=new ObjectFactory();
		MerchantAuthenticationType merchantAuthenticationType=objectFactory.createMerchantAuthenticationType();		
		GetCustomerProfileRequest getCustomerProfileRequest=objectFactory.createGetCustomerProfileRequest();
		getCustomerProfileRequest.setMerchantAuthentication(merchantAuthenticationType);
		getCustomerProfileRequest.setCustomerProfileId(customer.getPaymentGatewayId());	
	
		try {
			GetCustomerProfileResponse getCustomerProfileResponse=(GetCustomerProfileResponse)authorizeNetService.callPaymentService(getCustomerProfileRequest,GetCustomerProfileRequest.class,GetCustomerProfileResponse.class);
			if(getCustomerProfileResponse!=null){
				List<CustomerPaymentProfileMaskedType> ppList=getCustomerProfileResponse.getProfile().getPaymentProfiles();
				paymentDetails.setPaymentGatewayProfileID(customer.getPaymentGatewayId());
				for(CustomerPaymentProfileMaskedType paymentProfile :ppList){
					paymentDetails.setCardNumber(paymentProfile.getPayment().getCreditCard().getCardNumber());
					paymentDetails.setExpiration(paymentProfile.getPayment().getCreditCard().getExpirationDate());
					//paymentDetails.setCardType(paymentProfile.getPayment().getCreditCard().getCardType());
					paymentDetails.setAddress(paymentProfile.getBillTo().getAddress());
					paymentDetails.setCity(paymentProfile.getBillTo().getCity());
					paymentDetails.setZip(paymentProfile.getBillTo().getZip());
					paymentDetails.setPaymentProfileID(paymentProfile.getCustomerPaymentProfileId());
					
				}
				
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
           return paymentDetails;
        }
    
    
    @RequestMapping("/getStates")
    public @ResponseBody List<State> getStates(HttpServletRequest  request) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    	
    	List<State> states=new ArrayList<State>();
    	states = stateService.getStates();
    	return states;
        }
    @RequestMapping("/getCountry")
    public @ResponseBody List<Country> getCountry(HttpServletRequest  request) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    	
    	List<Country> countryList=new ArrayList<Country>();
    	countryList = countryService.getCountries();
    	return countryList;
        }
    
    
    @RequestMapping(value="/saveAccountInfo",method = RequestMethod.POST)
    public String  saveAddMin(@RequestBody AccountDetails  accountDetails) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String userID=auth.getName();
    	
    	Country country=new Country();
		country.setCountryID(accountDetails.getCountryID());
		State state=new State();
		state.setStateID(accountDetails.getStateID());
		
		Customer customer=new Customer();	
		customer.setCustomerID(Integer.parseInt(userID));     
    	customer=getCustomer();
    	System.err.println("customer.getCustomerID()"+customer.getCustomerID());
    	if(customer.getCustomerID()==null){
    		User user=new User();
    		user.setCustomerID(Integer.parseInt(userID));
        	customer=new Customer();
        	customer.setUser(user);
    	}
		customer.setFirstName(accountDetails.getFirstName());
		customer.setMiddleName(accountDetails.getMiddleName());
		customer.setLastName(accountDetails.getLastName());
		customer.setMobileNumber(accountDetails.getMobileNumber());
		customer.setActive(new Byte("1"));
		customer.setAddress1(accountDetails.getAddress1());
		customer.setAddress2(accountDetails.getAddress2());
		customer.setCity(accountDetails.getCity());
		customer.setZipCode(accountDetails.getZipCode());
		customer.setCountry(country);
		customer.setState(state);	
		try {
			customerService.saveCustomer(customer);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		 return "account/layout";
        }
    
    private Customer getCustomer(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String userID=auth.getName();
    	Customer customer=new Customer();	
		customer.setCustomerID(Integer.parseInt(userID));     
    	try {
			customer=customerService.getCustomerById(customer);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return customer;
    }
    
    @RequestMapping(value="/saveCCInfo",method = RequestMethod.POST)
    public String  saveCCInfo(@RequestBody PaymentDetails  paymentDetails) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    //	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	//String userID=auth.getName();
    	
    	ObjectFactory objectFactory=new ObjectFactory();
		CreditCardType creditCardType=objectFactory.createCreditCardType();
		creditCardType.setCardCode(paymentDetails.getCvc());
		creditCardType.setCardNumber(paymentDetails.getCardNumber());
		creditCardType.setExpirationDate(paymentDetails.getExpiration());
		
		PaymentType paymentType=objectFactory.createPaymentType();		
		paymentType.setCreditCard(creditCardType);
		
		
		CustomerAddressType customerAddressType=objectFactory.createCustomerAddressType();
		customerAddressType.setFirstName(paymentDetails.getFname());
		customerAddressType.setLastName(paymentDetails.getLname());
		customerAddressType.setCompany("");
		customerAddressType.setCountry(paymentDetails.getCountry());
		customerAddressType.setCity(paymentDetails.getCity());
		customerAddressType.setEmail(paymentDetails.getEmail());
		customerAddressType.setFaxNumber(null);
		customerAddressType.setAddress(paymentDetails.getAddress());
		customerAddressType.setPhoneNumber(paymentDetails.getPhone());
		customerAddressType.setState(paymentDetails.getState());
		customerAddressType.setZip(paymentDetails.getZip());
		
		CustomerPaymentProfileType customerPaymentProfileType=objectFactory.createCustomerPaymentProfileType();
		customerPaymentProfileType.setCustomerType(CustomerTypeEnum.INDIVIDUAL);
		customerPaymentProfileType.setPayment(paymentType);
		customerPaymentProfileType.setBillTo(customerAddressType);
		
		CustomerProfileType customerProfileType=objectFactory.createCustomerProfileType();
		customerProfileType.setDescription("payment Details");
		customerProfileType.setEmail(paymentDetails.getEmail());
		customerProfileType.getPaymentProfiles().add(customerPaymentProfileType);
		
		
		if(paymentDetails.getPaymentProfileID()==null){
			MerchantAuthenticationType merchantAuthenticationType=objectFactory.createMerchantAuthenticationType();		
			CreateCustomerProfileRequest createCustomerProfileRequest=objectFactory.createCreateCustomerProfileRequest();
			createCustomerProfileRequest.setMerchantAuthentication(merchantAuthenticationType);
			createCustomerProfileRequest.setProfile(customerProfileType);
			createCustomerProfileRequest.setValidationMode(ValidationModeEnum.TEST_MODE);
			
			try {
				CreateCustomerProfileResponse createCustomerProfileResponse=(CreateCustomerProfileResponse)authorizeNetService.callPaymentService(createCustomerProfileRequest,CreateCustomerProfileRequest.class,CreateCustomerProfileResponse.class);
				if(createCustomerProfileResponse!=null){
					System.err.println("customer profile id>>>>>>>>"+createCustomerProfileResponse.getCustomerProfileId());
					//customer profile id>>>>>>>>36978033
					//paymentProfile id>>>>33453145
					Customer customer=getCustomer();
					try {
						customer.setPaymentGatewayId(createCustomerProfileResponse.getCustomerProfileId());
						customerService.saveCustomer(customer);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
	    	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}else{
			CustomerPaymentProfileExType customerPaymentProfileExType=objectFactory.createCustomerPaymentProfileExType();
			customerPaymentProfileExType.setCustomerPaymentProfileId(paymentDetails.getPaymentProfileID());
			customerPaymentProfileExType.setBillTo(customerAddressType);
			customerPaymentProfileExType.setPayment(paymentType);		
			
			MerchantAuthenticationType merchantAuthenticationType=objectFactory.createMerchantAuthenticationType();		
			UpdateCustomerPaymentProfileRequest updateCustomerPaymentProfileRequest=objectFactory.createUpdateCustomerPaymentProfileRequest();
			updateCustomerPaymentProfileRequest.setMerchantAuthentication(merchantAuthenticationType);
			updateCustomerPaymentProfileRequest.setCustomerProfileId(paymentDetails.getPaymentProfileID());
			updateCustomerPaymentProfileRequest.setPaymentProfile(customerPaymentProfileExType);
			
			try {
				UpdateCustomerPaymentProfileResponse updateCustomerPaymentProfileResponse=(UpdateCustomerPaymentProfileResponse)authorizeNetService.callPaymentService(updateCustomerPaymentProfileRequest,UpdateCustomerPaymentProfileRequest.class,UpdateCustomerPaymentProfileResponse.class);
				if(updateCustomerPaymentProfileResponse!=null){
					System.err.println("customer profile id>>>>>>>>"+updateCustomerPaymentProfileResponse.getMessages().getResultCode());
					//customer profile id>>>>>>>>36935848
				}
				
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
    	
    	 return "account/layout";
    }
    public void getCustomerPaymentProfile(){		
		ObjectFactory objectFactory=new ObjectFactory();
			MerchantAuthenticationType merchantAuthenticationType=objectFactory.createMerchantAuthenticationType();		
		GetCustomerProfileRequest getCustomerProfileRequest=objectFactory.createGetCustomerProfileRequest();
		getCustomerProfileRequest.setMerchantAuthentication(merchantAuthenticationType);
		getCustomerProfileRequest.setCustomerProfileId("36978033");	
		
		
		try {
			GetCustomerProfileResponse getCustomerProfileResponse=(GetCustomerProfileResponse)authorizeNetService.callPaymentService(getCustomerProfileRequest,GetCustomerProfileRequest.class,GetCustomerProfileResponse.class);
			if(getCustomerProfileResponse!=null){
				System.err.println("customer profile id>>>>>>>>"+getCustomerProfileResponse.getMessages().getResultCode());
				//customer profile id>>>>>>>>36935848
				//payment profile id 33414410
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
}
