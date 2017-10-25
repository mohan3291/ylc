package com.ylc.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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
import com.ylc.model.Country;
import com.ylc.model.Customer;
import com.ylc.model.CustomerLine;
import com.ylc.model.CustomerLinePaymentDetail;
import com.ylc.model.FacilityLocation;
import com.ylc.model.FacilityNumberPool;
import com.ylc.model.InMate;
import com.ylc.model.Linetype;
import com.ylc.model.Linetype;
import com.ylc.model.PaymentCardType;
import com.ylc.model.PaymentResponse;
import com.ylc.model.PrepaidPricing;
import com.ylc.model.TeliphoneLine;
import com.ylc.model.InMateNumberDetails;
import com.ylc.model.PaymentDetails;
import com.ylc.model.User;
import com.ylc.peer.listaval.response.model.PEER;
import com.ylc.peer.listaval.response.model.PEER.RESP.AVAILDID;
import com.ylc.peer.service.NumberPeeringService;
import com.ylc.service.CountryService;
import com.ylc.service.CustermerService;
import com.ylc.service.CustomerLineService;
import com.ylc.service.FacilityNumberPoolService;
import com.ylc.service.FacilityService;
import com.ylc.service.InMateService;
import com.ylc.service.UserService;
import com.ylc.util.ProcessPayment;
import com.ylc.util.YlcConstents;


/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/managelines")
@SessionAttributes("lineList")
public class ManageLinesController {
	@Autowired
	private CustomerLineService customerLineService;
	@Autowired
	AuthorizeNetService authorizeNetService;
	@Autowired
	NumberPeeringService numberPeeringService;
	@Autowired
    private CountryService countryService;
	@Autowired
	 private CustermerService customerService;
	@Autowired
	FacilityNumberPoolService facilityNumberPoolService;

	@Autowired
    private FacilityService facilityService;
	@Autowired
    private UserService userService;
	@Autowired
    private InMateService inMateService;
	@RequestMapping("/layout")
    public String getLinesPartialPage() {
        return "managelines/layout";
    }
    @RequestMapping("/imateNumberDetails")
    public @ResponseBody PaymentDetails imateNumberDetails(HttpServletRequest  request) {
    	
    	PaymentDetails pd=new PaymentDetails();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	pd.setUserName(auth.getName());
    	 Customer customer=getCustomer();
    	 pd.setAddress(customer.getAddress1());
    	 pd.setCity(customer.getCity());
    	 if(customer.getState()!=null){
	    	 pd.setState(customer.getState().getStateName());
	    	 pd.setStateID(customer.getState().getStateID());
    	 }
    	// pd.setEmail(customer.getUser().getEmailID());
    	 if(customer.getCountry()!=null){
	    	 pd.setCountry(customer.getCountry().getCountryName());
	    	 pd.setCountryID(customer.getCountry().getCountryID());
    	 }
    	// pd.setState(customer.getState().getStateName());
    	 pd.setZip(customer.getZipCode());
    	 pd.setPhone(customer.getMobileNumber());
    	 pd.setPhone(customer.getMobileNumber());
     	
    	// pd.setCardHolderName();
    	return pd;
        }
    
    @RequestMapping("/getCountries")
    public @ResponseBody List<Country> getCountries(HttpServletRequest  request) {
    	
    	List<Country> countries=null;
		try {
			countries=countryService.getCountries();
			//facilityLocations = facilityService.getFacilities();
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
    	
    	return countries;
        }
    
    

    @RequestMapping("/getFacilities")
    public @ResponseBody List<com.ylc.model.FacilityLocation> getFacilities(@RequestParam String facId) {
    	
    	List<com.ylc.model.FacilityLocation> facilityLocations=null;
		try {
			if("All".equalsIgnoreCase(facId))
				facilityLocations = facilityService.getFacilities();
			else
				facilityLocations = facilityService.getFacilitiesByID(new Integer(facId));
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
    	
    	return facilityLocations;
        }
    
    
    @RequestMapping("/getFacilitiesByInmate")
    public @ResponseBody List<com.ylc.model.FacilityLocation> getFacilitiesByInamte(@RequestParam String inametBOP) {
    	
    	
    	List<com.ylc.model.FacilityLocation> facilityLocations=new ArrayList<com.ylc.model.FacilityLocation>();
		try {
			InMate inmate=new InMate();
			List<InMate> inmates=new ArrayList<InMate>();
	    		inmate.setBopNumber(inametBOP);
	    		 inmates= inMateService.getInmateByBOP(inmate);	
	    		 for(InMate inMate:inmates){
	    			 facilityLocations.add(inMate.getFacilityLocation());
	    		 }
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return facilityLocations;
        }
    
    
    
    
    
    @RequestMapping("/getFacilityNumber")
    public @ResponseBody List<com.ylc.model.FacilityNumberPool> getFacilityNumber(HttpServletRequest  request) {
    	
    	List<com.ylc.model.FacilityNumberPool> pools=null;
    	com.ylc.model.FacilityNumberPool newNumber=null;
		try {
			pools = facilityNumberPoolService.getFacilityNumberPools();
			/*newNumber=new com.ylc.model.FacilityNumberPool();
			newNumber.setpNumber("6098519867");
			pools.add(newNumber);*/
			PEER peerRes=getNumberFromPeer();
			for (AVAILDID num:peerRes.getRESP().getAVAILDID()){
				newNumber=new com.ylc.model.FacilityNumberPool();
				newNumber.setpNumber(num.getNUM());
				pools.add(newNumber);
			}
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
    	
    	return pools;
        }
    
    @RequestMapping("/inmateNumDetails")
    public @ResponseBody InMateNumberDetails getCustomer(HttpServletRequest  request) {
    	
    	List<CustomerLine> customerLines =customerLineService.getCustomerLineByCustomer(getCustomer());
    	InMateNumberDetails inameteNum=new InMateNumberDetails();
    	for(CustomerLine customerLine:customerLines){
    		//inameteNum.set
    	}
    	return inameteNum;
        }
    @RequestMapping(value="/saveInmateNumDetails" ,method = RequestMethod.POST)
    public @ResponseBody PaymentResponse savePaymetDetails(@RequestBody PaymentDetails inameteNum) {
    	PaymentResponse rsponse=new PaymentResponse();
    	String message="Your order is processed with errors .. pls contact heldesk";
    	ProcessPayment pp =new ProcessPayment();
    	inameteNum.setTotalPrice("1");
    	/*if(inameteNum.getPaymentProfileID()!=null && inameteNum.getPaymentGatewayProfileID()!=null)
    		rsponse=pp.processPaymentWithProfileId(inameteNum,authorizeNetService);
    	else
    		rsponse=pp.processPayment(inameteNum,authorizeNetService);
	    if(YlcConstents.PAYMENT_SUCCESS.equalsIgnoreCase(rsponse.getStatusCode()))*/
	    {
	    	//String transID=rsponse.getTransID();
	    	com.ylc.model.CustomerLine customerLineD = new com.ylc.model.CustomerLine();
	    	//CustomerLinePaymentDetail custLinePayDet= new CustomerLinePaymentDetail();
	    	String userID=SecurityContextHolder.getContext().getAuthentication().getName();
	    	User user=new User();
	    	user.setCustomerID(Integer.parseInt(userID)); 
			customerLineD.setUser(user);
			customerLineD.setDestinationLineNumber(inameteNum.getFwdLineNumber());
			customerLineD.setLocalLineNumber(inameteNum.getLineNumber());
			customerLineD.setPrepaidMinutes(0);
			 
		 	//custLinePayDet.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			//custLinePayDet.setCustomer(customer);
			//custLinePayDet.setInvoiceGeneratedDate(new Timestamp(System.currentTimeMillis()));
			//custLinePayDet.setIsInitiatedByInmate(customer.getCustomerID());
			//custLinePayDet.setInMate(inMate);
			//custLinePayDet.setUser(user);
			//custLinePayDet.setIsInvoiceGenerated(new Byte("1"));
			//custLinePayDet.setIsPaidByQuickPay(new Byte("0"));
			//custLinePayDet.setIsRecurringPayemnt(new Byte("0"));
			//custLinePayDet.setLast4DigitsOfCard(inameteNum.getCardNumber().substring(inameteNum.getCardNumber().length()-4, inameteNum.getCardNumber().length()));
			//custLinePayDet.setNameOnCard(inameteNum.getCardHolderName());
			if(inameteNum.getBlockOfMins()!=null){
				//custLinePayDet.setNumberOfMinutes(new Integer(inameteNum.getBlockOfMins()));
				customerLineD.setPrepaidMinutes(new Integer(inameteNum.getBlockOfMins()));
			}else{
				//custLinePayDet.setNumberOfMinutes(new Integer(0));
				customerLineD.setPrepaidMinutes(0);
			}
			//custLinePayDet.setPaidFor(inameteNum.getLineNumber());
			//custLinePayDet.setPaymentAmount(new BigDecimal(inameteNum.getTotalPrice()));
			//custLinePayDet.setPaymentCardType(paymentCardType);
			
			//TODO populate original
			//PaymentCardType paymentCardType=new PaymentCardType();
			//paymentCardType.setPaymentCardTypeID(1);
			//custLinePayDet.setPaymentCardType(paymentCardType);
			//custLinePayDet.setPaymentConformationCode(transID);
			//custLinePayDet.setPaymentDate(new Timestamp(System.currentTimeMillis()));
			//custLinePayDet.setPaymentType("online");
			//custLinePayDet.setNumberOfMinutes(new Integer(0));
			//PrepaidPricing prepaidPricing=new PrepaidPricing();
			//prepaidPricing.setPrepaidPricingID(1);
			//custLinePayDet.setPrepaidPricing(prepaidPricing);
			//custLinePayDet.setPrepaidPricing(prepaidPricing);
			//custLinePayDet.setUpdatedBy(updatedBy);
			//custLinePayDet.setUpdatedDate(updatedDate);
			//custLinePayDet.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			
			
			// TODO values needs to be validated 
			customerLineD.setEndDate(new Timestamp(new Date().getTime()));
			customerLineD.setActive(new Byte("1"));
			customerLineD.setCreatedBy(1);
			customerLineD.setCreatedDate(new Timestamp(new Date().getTime()));
			customerLineD.setIsInitiatedByInmate(new Byte("1"));
			customerLineD.setIsPaidByQuickPay(new Byte("1"));
			customerLineD.setStartDate(new Timestamp(new Date().getTime()));
			customerLineD.setUpdatedBy(1);
			customerLineD.setUpdatedDate(new Timestamp(new Date().getTime()));
			
			
			
			InMate inmate = new InMate();
			inmate.setBopNumber(inameteNum.getBop());
			List<InMate> inmates= inMateService.getInmateByBOP(inmate);
			inmate=inmates.get(0);
			customerLineD.setInMate(inmate);
			//custLinePayDet.setInMate(inmate);
			customerLineD.setInmateLocationID(new Integer(inameteNum.getLocation()));
			Linetype lineType = new Linetype();
			lineType.setLineTypeID(1);
			customerLineD.setLineType(lineType);
			//customerLineD.setCustomerLinePaymentDetails(customerLinePaymentDetails);
			FacilityNumberPool facilityNumberPool = new FacilityNumberPool();
			
			//customerLineD.getCustomerLinePaymentDetails().add(custLinePayDet);
			//custLinePayDet.setCustomerLine(customerLineD);
			try {
				
				
				customerLineService.saveCustomerLine(customerLineD);
				facilityNumberPool.setpNumber(inameteNum.getLineNumber());
				FacilityNumberPool facilityNumberPoolDB=facilityNumberPoolService.getFacilityNumberPoolsByPhoneNumber(facilityNumberPool);
				if(facilityNumberPoolDB!=null){
					facilityNumberPoolDB.setStatus(new Byte("0"));
				}else{
					facilityNumberPool.setStatus(new Byte("0"));
					facilityNumberPool.setFacilityLocation(inmate.getFacilityLocation());
					facilityNumberPool.setRateCenterID(1);
					facilityNumberPool.setFacilityLocation(inmate.getFacilityLocation());
					facilityNumberPoolDB=facilityNumberPool;
				}
					facilityNumberPoolService.saveFacilityNumberPool(facilityNumberPoolDB);
					rsponse.setStatusCode("0");
					rsponse.setStatusMessage("Number created Successfully");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				rsponse.setStatusCode("-1");
				rsponse.setStatusMessage("Errror while processing request");
				rsponse.setTransID("Assigin Number Error");
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				rsponse.setStatusCode("-1");
				rsponse.setStatusMessage("Errror while processing request");
				rsponse.setTransID("Assigin Number Error");
			}catch(Exception e){
				e.printStackTrace();
				rsponse.setStatusCode("-1");
				rsponse.setStatusMessage("Errror while processing request");
				rsponse.setTransID("Assigin Number Error");
			}
	    	}
	    
    	return rsponse;
        }
    
    
   /* @RequestMapping(value="/saveInmateNumDetails" ,method = RequestMethod.POST)
    public @ResponseBody PaymentResponse savePaymetDetails(@RequestBody PaymentDetails inameteNum) {
    	PaymentResponse rsponse=new PaymentResponse();
    	String message="Your order is processed with errors .. pls contact heldesk";
    	ProcessPayment pp =new ProcessPayment();
    	inameteNum.setTotalPrice("1");
    	if(inameteNum.getPaymentProfileID()!=null && inameteNum.getPaymentGatewayProfileID()!=null)
    		rsponse=pp.processPaymentWithProfileId(inameteNum,authorizeNetService);
    	else
    		rsponse=pp.processPayment(inameteNum,authorizeNetService);
	    if(YlcConstents.PAYMENT_SUCCESS.equalsIgnoreCase(rsponse.getStatusCode())){
	    	String transID=rsponse.getTransID();
	    	com.ylc.model.CustomerLine customerLineD = new com.ylc.model.CustomerLine();
	    	CustomerLinePaymentDetail custLinePayDet= new CustomerLinePaymentDetail();
	    	String userID=SecurityContextHolder.getContext().getAuthentication().getName();
	    	User user=new User();
	    	user.setCustomerID(Integer.parseInt(userID)); 
			customerLineD.setUser(user);
			customerLineD.setDestinationLineNumber(inameteNum.getFwdLineNumber());
			customerLineD.setLocalLineNumber(inameteNum.getLineNumber());
			customerLineD.setPrepaidMinutes(0);
			 
		 	custLinePayDet.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			//custLinePayDet.setCustomer(customer);
			custLinePayDet.setInvoiceGeneratedDate(new Timestamp(System.currentTimeMillis()));
			//custLinePayDet.setIsInitiatedByInmate(customer.getCustomerID());
			//custLinePayDet.setInMate(inMate);
			//custLinePayDet.setUser(user);
			custLinePayDet.setIsInvoiceGenerated(new Byte("1"));
			custLinePayDet.setIsPaidByQuickPay(new Byte("0"));
			custLinePayDet.setIsRecurringPayemnt(new Byte("0"));
			//custLinePayDet.setLast4DigitsOfCard(inameteNum.getCardNumber().substring(inameteNum.getCardNumber().length()-4, inameteNum.getCardNumber().length()));
			//custLinePayDet.setNameOnCard(inameteNum.getCardHolderName());
			if(inameteNum.getBlockOfMins()!=null){
				custLinePayDet.setNumberOfMinutes(new Integer(inameteNum.getBlockOfMins()));
				customerLineD.setPrepaidMinutes(new Integer(inameteNum.getBlockOfMins()));
			}else{
				custLinePayDet.setNumberOfMinutes(new Integer(0));
				customerLineD.setPrepaidMinutes(0);
			}
			custLinePayDet.setPaidFor(inameteNum.getLineNumber());
			custLinePayDet.setPaymentAmount(new BigDecimal(inameteNum.getTotalPrice()));
			//custLinePayDet.setPaymentCardType(paymentCardType);
			
			//TODO populate original
			PaymentCardType paymentCardType=new PaymentCardType();
			paymentCardType.setPaymentCardTypeID(1);
			custLinePayDet.setPaymentCardType(paymentCardType);
			custLinePayDet.setPaymentConformationCode(transID);
			custLinePayDet.setPaymentDate(new Timestamp(System.currentTimeMillis()));
			custLinePayDet.setPaymentType("online");
			custLinePayDet.setNumberOfMinutes(new Integer(0));
			PrepaidPricing prepaidPricing=new PrepaidPricing();
			prepaidPricing.setPrepaidPricingID(1);
			custLinePayDet.setPrepaidPricing(prepaidPricing);
			//custLinePayDet.setPrepaidPricing(prepaidPricing);
			//custLinePayDet.setUpdatedBy(updatedBy);
			//custLinePayDet.setUpdatedDate(updatedDate);
			custLinePayDet.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			
			
			// TODO values needs to be validated 
			customerLineD.setEndDate(new Timestamp(new Date().getTime()));
			customerLineD.setActive(new Byte("1"));
			customerLineD.setCreatedBy(1);
			customerLineD.setCreatedDate(new Timestamp(new Date().getTime()));
			customerLineD.setIsInitiatedByInmate(new Byte("1"));
			customerLineD.setIsPaidByQuickPay(new Byte("1"));
			customerLineD.setStartDate(new Timestamp(new Date().getTime()));
			customerLineD.setUpdatedBy(1);
			customerLineD.setUpdatedDate(new Timestamp(new Date().getTime()));
			
			
			
			InMate inmate = new InMate();
			inmate.setBopNumber(inameteNum.getBop());
			List<InMate> inmates= inMateService.getInmateByBOP(inmate);
			inmate=inmates.get(0);
			customerLineD.setInMate(inmate);
			//custLinePayDet.setInMate(inmate);
			customerLineD.setInmateLocationID(new Integer(inameteNum.getLocation()));
			LineType lineType = new LineType();
			lineType.setLineTypeID(1);
			customerLineD.setLineType(lineType);
			//customerLineD.setCustomerLinePaymentDetails(customerLinePaymentDetails);
			FacilityNumberPool facilityNumberPool = new FacilityNumberPool();
			
			customerLineD.getCustomerLinePaymentDetails().add(custLinePayDet);
			custLinePayDet.setCustomerLine(customerLineD);
			try {
				
				
				customerLineService.saveCustomerLine(customerLineD);
				facilityNumberPool.setpNumber(inameteNum.getLineNumber());
				FacilityNumberPool facilityNumberPoolDB=facilityNumberPoolService.getFacilityNumberPoolsByPhoneNumber(facilityNumberPool);
				if(facilityNumberPoolDB!=null){
					facilityNumberPoolDB.setStatus(new Byte("0"));
				}else{
					facilityNumberPool.setStatus(new Byte("0"));
					facilityNumberPool.setFacilityLocation(inmate.getFacilityLocation());
					facilityNumberPool.setRateCenterID(1);
					facilityNumberPoolDB=facilityNumberPool;
				}
					facilityNumberPoolService.saveFacilityNumberPool(facilityNumberPoolDB);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				rsponse.setStatusCode("-1");
				rsponse.setStatusMessage("Errror while processing request");
				rsponse.setTransID("Assigin Number Error");
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				rsponse.setStatusCode("-1");
				rsponse.setStatusMessage("Errror while processing request");
				rsponse.setTransID("Assigin Number Error");
			}catch(Exception e){
				e.printStackTrace();
				rsponse.setStatusCode("-1");
				rsponse.setStatusMessage("Errror while processing request");
				rsponse.setTransID("Assigin Number Error");
			}
	    	}
	    
    	return rsponse;
        }*/
    

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
    
    public PEER getNumberFromPeer(){
		com.ylc.peer.listaval.request.model.ObjectFactory  objectFactory=new com.ylc.peer.listaval.request.model.ObjectFactory();
		com.ylc.peer.listaval.request.model.PEER peer=objectFactory.createPEER();
		com.ylc.peer.listaval.request.model.PEER.HDR hdr=objectFactory.createPEERHDR();	
		com.ylc.peer.listaval.request.model.PEER.Payload.Listavail listavail=objectFactory.createPEERPayloadListavail();
	//	listavail.setCPN("6036");
		listavail.setMAXAVAIL(10);
		com.ylc.peer.listaval.response.model.PEER resp=null;
		com.ylc.peer.listaval.request.model.PEER.Payload payload=objectFactory.createPEERPayload();
		payload.setListavail(listavail);
		payload.setREQTYPE("LISTAVAIL");		
		peer.setHDR(hdr);
		peer.setPayload(payload);
		try {
			 resp=	numberPeeringService.listAvailableNumbers(peer);
			System.err.println("getSTATUS>>>>>>>>>>>>>>>>>"+resp.getHDR().getSTATUS());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resp;
	}
    
    

}

