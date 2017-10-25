package com.ylc.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.ylc.domain.BillingAddress;
import com.ylc.domain.CustomerLine;
import com.ylc.domain.CustomerLinePaymentDetail;
import com.ylc.domain.CustomerPaymentDetail;
import com.ylc.domain.FacilityLocation;
import com.ylc.domain.FacilityNumberPool;
import com.ylc.domain.InMate;
import com.ylc.domain.InmateStatus;
import com.ylc.domain.LineType;
import com.ylc.domain.PaymentCardType;
import com.ylc.domain.PrepaidPricing;
import com.ylc.domain.RateCenter;
import com.ylc.model.Country;
import com.ylc.model.Customer;
import com.ylc.model.Role;
import com.ylc.model.State;
import com.ylc.model.User;

public class YlcUtils {	
	static Random random= new Random();
	public static String   getInvoiceNum(){
		return "In_"+random.nextInt();
	}
	static Random random1= new Random();
	public static int   getPONumber(){
		return random.nextInt();
	}
	public static void copyProperties(Object destination,Object orig) throws IllegalAccessException, InvocationTargetException{
		BeanUtils.copyProperties(destination, orig);		
	}
	
	
	public static void copyProperties(List destinationList,List origList,Class destinationType) throws IllegalAccessException, InvocationTargetException, InstantiationException{
		for(Object orig:origList){
			Object destination=destinationType.newInstance();
			BeanUtils.copyProperties(destination, orig);
			destinationList.add(destination);			
		}	
	}
	public static List<User> copy(List<com.ylc.domain.User> domainUsers){
		List<User> modelUsers=new ArrayList<User>();		
		for(com.ylc.domain.User domainUser:domainUsers ){
			User modelUser=new User();
			modelUser=copy(domainUser);
			modelUsers.add(modelUser);
		}
		return modelUsers;
		
	}	
	public static com.ylc.domain.User copy(User modelUser){
		    com.ylc.domain.User domainUser=new com.ylc.domain.User();
		    if(modelUser!=null){
			domainUser.setActive(modelUser.getActive());
			domainUser.setAnswer(modelUser.getAnswer());
			domainUser.setCreatedBy(modelUser.getCreatedBy());
			domainUser.setCreatedDate(modelUser.getCreatedDate());
			domainUser.setEmailID(modelUser.getEmailID());
			domainUser.setPassword(modelUser.getPassword());
			domainUser.setSecurityQuestion(modelUser.getSecurityQuestion());
			domainUser.setUpdatedBy(modelUser.getUpdatedBy());
			domainUser.setUpdatedDate(modelUser.getUpdatedDate());
			domainUser.setCustomerID(modelUser.getCustomerID());
			domainUser.setUpdatedDate(modelUser.getUpdatedDate());
			domainUser.setRole(copy(modelUser.getRole()));
			domainUser.setType(modelUser.getType());
			domainUser.setCustomer(copy(modelUser.getCustomer()));
		
		    }
     		return domainUser;
		
	}
	public static User copy(com.ylc.domain.User domainUser){
		    User modelUser=new User();
		    if(domainUser!=null){
			modelUser.setActive(domainUser.getActive());
			modelUser.setAnswer(domainUser.getAnswer());
			modelUser.setCreatedBy(domainUser.getCreatedBy());
			modelUser.setCreatedDate(domainUser.getCreatedDate());
			modelUser.setEmailID(domainUser.getEmailID());
			modelUser.setPassword(domainUser.getPassword());
			modelUser.setSecurityQuestion(domainUser.getSecurityQuestion());
			modelUser.setUpdatedBy(domainUser.getUpdatedBy());
			modelUser.setUpdatedDate(domainUser.getUpdatedDate());
			modelUser.setCustomerID(domainUser.getCustomerID());
			modelUser.setUpdatedDate(domainUser.getUpdatedDate());
			modelUser.setRole(copy(domainUser.getRole()));
			modelUser.setType(domainUser.getType());
			if(domainUser.getCustomerLines()!=null){
				Set<CustomerLine> customerLines=domainUser.getCustomerLines();
				for(CustomerLine customerLine:customerLines){
					modelUser.getCustomerLines().add(copy(customerLine));
					
				}
			 }	
			 modelUser.setCustomer(copy(domainUser.getCustomer()));			
		    }
			return modelUser;
		 
	}
	public static Customer copy(com.ylc.domain.Customer domainCustomer){
		Customer modelCustomerr=new  Customer();
		if(domainCustomer!=null){		
			modelCustomerr.setActive(domainCustomer.getActive());
			modelCustomerr.setAddress1(domainCustomer.getAddress1());
			modelCustomerr.setAddress2(domainCustomer.getAddress2());
			modelCustomerr.setCity(domainCustomer.getCity());
			modelCustomerr.setCountry(copy(domainCustomer.getCountry()));
			modelCustomerr.setCreatedBy(domainCustomer.getCreatedBy());
			modelCustomerr.setCreatedDate(domainCustomer.getCreatedDate());
			modelCustomerr.setFirstName(domainCustomer.getFirstName());
			modelCustomerr.setLastName(domainCustomer.getLastName());
			modelCustomerr.setMiddleName(domainCustomer.getMiddleName());
			modelCustomerr.setMobileNumber(domainCustomer.getMobileNumber());
			modelCustomerr.setState(copy(domainCustomer.getState()));
			modelCustomerr.setUpdatedBy(domainCustomer.getUpdatedBy());
			modelCustomerr.setUpdatedDate(domainCustomer.getUpdatedDate());
			modelCustomerr.setZipCode(domainCustomer.getZipCode());
				modelCustomerr.setPaymentGatewayId(domainCustomer.getPaymentGatewayId());
			modelCustomerr.setPrePaidAmount(domainCustomer.getPrePaidAmount());
			
			if(domainCustomer.getCustomerID()==null){
				User  modelUser=new User();
				modelUser.setCustomerID(domainCustomer.getUser().getCustomerID());
				modelCustomerr.setUser(modelUser);
			}else
				modelCustomerr.setCustomerID(domainCustomer.getCustomerID());
		}
		return modelCustomerr;
		
	}
	
	public static com.ylc.domain.Customer copy(Customer modelCustomerr){
		com.ylc.domain.Customer domainCustomer=null;
		if(modelCustomerr!=null){
			domainCustomer=new com.ylc.domain.Customer();	
			domainCustomer.setActive(modelCustomerr.getActive());
			domainCustomer.setAddress1(modelCustomerr.getAddress1());
			domainCustomer.setAddress2(modelCustomerr.getAddress2());
			domainCustomer.setCity(modelCustomerr.getCity());
			domainCustomer.setCountry(copy(modelCustomerr.getCountry()));
			domainCustomer.setCreatedBy(modelCustomerr.getCreatedBy());
			domainCustomer.setCreatedDate(modelCustomerr.getCreatedDate());
			domainCustomer.setCustomerID(modelCustomerr.getCustomerID());
			domainCustomer.setFirstName(modelCustomerr.getFirstName());
			domainCustomer.setLastName(modelCustomerr.getLastName());
			domainCustomer.setMiddleName(modelCustomerr.getMiddleName());
			domainCustomer.setMobileNumber(modelCustomerr.getMobileNumber());
			domainCustomer.setState(copy(modelCustomerr.getState()));
			domainCustomer.setUpdatedBy(modelCustomerr.getUpdatedBy());
			domainCustomer.setUpdatedDate(modelCustomerr.getUpdatedDate());			
			domainCustomer.setZipCode(modelCustomerr.getZipCode());
			domainCustomer.setPaymentGatewayId(modelCustomerr.getPaymentGatewayId());
			domainCustomer.setPrePaidAmount(modelCustomerr.getPrePaidAmount());
			if(modelCustomerr.getUser()!=null){
				System.err.println("setting useeeeeeeeeeeeeeeeeeeeeeeerrrrrrrrr"+modelCustomerr.getUser().getCustomerID());
				com.ylc.domain.User user=new com.ylc.domain.User();
				user.setCustomerID(modelCustomerr.getUser().getCustomerID());
				domainCustomer.setUser(user);
			}else{
				domainCustomer.setCustomerID(modelCustomerr.getCustomerID());
			}
		}
		return domainCustomer;
		
	}	
	
	public static com.ylc.domain.Role copy(Role modelRole){		
		   com.ylc.domain.Role domainRole=new com.ylc.domain.Role();
		   if(modelRole!=null){
			domainRole.setActive(modelRole.getActive());
			domainRole.setCreatedBy(modelRole.getCreatedBy());
			domainRole.setCreatedDate(modelRole.getUpdatedDate());
			domainRole.setRoleName(modelRole.getRoleName());
			domainRole.setRoleID(modelRole.getRoleID());
			domainRole.setUpdatedBy(modelRole.getUpdatedBy());
			domainRole.setUpdatedDate(modelRole.getUpdatedDate());
		   }
		   return domainRole;		
	}
	
	public static Role copy(com.ylc.domain.Role domainRole){
		Role modelRole=new Role();
		if(domainRole!=null){
			modelRole.setActive(domainRole.getActive());
			modelRole.setCreatedBy(domainRole.getCreatedBy());
			modelRole.setCreatedDate(domainRole.getUpdatedDate());
			modelRole.setRoleName(domainRole.getRoleName());
			modelRole.setRoleID(domainRole.getRoleID());
			modelRole.setUpdatedBy(domainRole.getUpdatedBy());
			modelRole.setUpdatedDate(domainRole.getUpdatedDate());
		}
		return modelRole;		
	}
	
	public static State copy(com.ylc.domain.State domainState){
		State modelState=new State();
		if(domainState!=null){
			modelState.setStateAbbr(domainState.getStateAbbr());
			modelState.setStateID(domainState.getStateID());
			modelState.setStateName(domainState.getStateName());
		}
		return modelState;
		
	}
	public static com.ylc.domain.State copy(State modelState){
		com.ylc.domain.State domainState=new com.ylc.domain.State();
		if(modelState!=null){
			domainState.setStateAbbr(modelState.getStateAbbr());
			domainState.setStateID(modelState.getStateID());
			domainState.setStateName(modelState.getStateName());
		}
		return domainState;
		
	}
	
	public static Country copy(com.ylc.domain.Country domainCountry){
		Country modelCountry=new Country();
		if(domainCountry!=null){
			modelCountry.setCountryAbbr(domainCountry.getCountryAbbr());
			modelCountry.setCountryCode(domainCountry.getCountryCode());
			modelCountry.setCountryID(domainCountry.getCountryID());
			modelCountry.setCountryName(domainCountry.getCountryName());		
		}
		return modelCountry;
		
	}
	public static com.ylc.domain.Country copy(Country modelCountry){
		com.ylc.domain.Country domainCountry =new com.ylc.domain.Country();
		if(modelCountry!=null){
			domainCountry.setCountryAbbr(modelCountry.getCountryAbbr());
			domainCountry.setCountryCode(modelCountry.getCountryCode());
			domainCountry.setCountryID(modelCountry.getCountryID());
			domainCountry.setCountryName(modelCountry.getCountryName());
		}
		return domainCountry;
		
	}
	public static FacilityNumberPool copy(com.ylc.model.FacilityNumberPool modelfacilityNumberPool) throws IllegalAccessException, InvocationTargetException{
		FacilityNumberPool facilityNumberPoolD=new FacilityNumberPool();
		if(modelfacilityNumberPool!=null){
		FacilityLocation facilityLocation=copy(modelfacilityNumberPool.getFacilityLocation());	
		facilityNumberPoolD.setFacilityNumberPoolID(modelfacilityNumberPool.getFacilityNumberPoolID());
		facilityNumberPoolD.setFacilityLocation(facilityLocation);
		facilityNumberPoolD.setpNumber(modelfacilityNumberPool.getpNumber());
		facilityNumberPoolD.setRateCenterID(modelfacilityNumberPool.getRateCenterID());
		facilityNumberPoolD.setStatus(modelfacilityNumberPool.getStatus());
		facilityNumberPoolD.setCreatedBy(modelfacilityNumberPool.getCreatedBy());
		facilityNumberPoolD.setCreatedDate(modelfacilityNumberPool.getCreatedDate());
		facilityNumberPoolD.setUpdatedBy(modelfacilityNumberPool.getUpdatedBy());
		facilityNumberPoolD.setUpdatedDate(modelfacilityNumberPool.getUpdatedDate());
		}
		return facilityNumberPoolD;		
	}
	
	public static com.ylc.model.FacilityNumberPool copy(FacilityNumberPool domainFacilityNumberPool) throws IllegalAccessException, InvocationTargetException{		
		com.ylc.model.FacilityNumberPool facilityNumberPoolD=new com.ylc.model.FacilityNumberPool();
		if(domainFacilityNumberPool!=null){
		facilityNumberPoolD.setFacilityLocation(copy(domainFacilityNumberPool.getFacilityLocation()));
		facilityNumberPoolD.setCreatedBy(domainFacilityNumberPool.getCreatedBy());
		facilityNumberPoolD.setCreatedDate(domainFacilityNumberPool.getCreatedDate());
		facilityNumberPoolD.setFacilityNumberPoolID(domainFacilityNumberPool.getFacilityNumberPoolID());
		facilityNumberPoolD.setpNumber(domainFacilityNumberPool.getpNumber());
		facilityNumberPoolD.setRateCenterID(domainFacilityNumberPool.getRateCenterID());
		facilityNumberPoolD.setStatus(domainFacilityNumberPool.getStatus());	
		}
		return facilityNumberPoolD;		
	}
	
	
	
	
	
	public static com.ylc.model.InMate copy(InMate domainInMate){
		com.ylc.model.InMate modelInmate=new com.ylc.model.InMate();
		if(domainInMate!=null){
			modelInmate.setActive(domainInMate.getActive());
			modelInmate.setAllowedCallLines(domainInMate.getAllowedCallLines());
			modelInmate.setBopNumber(domainInMate.getBopNumber());
			modelInmate.setChargePerLine(domainInMate.getChargePerLine());
			modelInmate.setCreatedBy(domainInMate.getCreatedBy());
			modelInmate.setCreatedDate(domainInMate.getCreatedDate());
			modelInmate.setFacilityLocation(copy(domainInMate.getFacilityLocation()));
			modelInmate.setInmateCode(domainInMate.getInmateCode());
			modelInmate.setInmateFirstName(domainInMate.getInmateFirstName());
			modelInmate.setInmateID(domainInMate.getInmateID());
			modelInmate.setInmateLastName(domainInMate.getInmateLastName());
			modelInmate.setInmateStatus(copy(domainInMate.getInmateStatus()));
			modelInmate.setIsCreditAllowed(domainInMate.getIsCreditAllowed());
			modelInmate.setMaxAmtLimit(domainInMate.getMaxAmtLimit());	
			modelInmate.setPrePaidAmount(domainInMate.getPrePaidAmount());
			modelInmate.setReferralCode(domainInMate.getReferralCode());
			modelInmate.setUpdatedBy(domainInMate.getUpdatedBy());
			modelInmate.setUpdatedDate(domainInMate.getUpdatedDate());	
		}
		return modelInmate;		
	}
	
	public static InMate copy(com.ylc.model.InMate modelInMate){
		InMate domainInmate=new InMate();
		if(modelInMate!=null){
			domainInmate.setActive(modelInMate.getActive());
			domainInmate.setAllowedCallLines(modelInMate.getAllowedCallLines());
			domainInmate.setBopNumber(modelInMate.getBopNumber());
			domainInmate.setChargePerLine(modelInMate.getChargePerLine());
			domainInmate.setCreatedBy(modelInMate.getCreatedBy());
			domainInmate.setCreatedDate(modelInMate.getCreatedDate());
			domainInmate.setFacilityLocation(copy(modelInMate.getFacilityLocation()));
			domainInmate.setInmateCode(modelInMate.getInmateCode());
			domainInmate.setInmateFirstName(modelInMate.getInmateFirstName());
			domainInmate.setInmateID(modelInMate.getInmateID());
			domainInmate.setInmateLastName(modelInMate.getInmateLastName());
			domainInmate.setInmateStatus(copy(modelInMate.getInmateStatus()));
			domainInmate.setIsCreditAllowed(modelInMate.getIsCreditAllowed());
			domainInmate.setMaxAmtLimit(modelInMate.getMaxAmtLimit());	
			domainInmate.setPrePaidAmount(modelInMate.getPrePaidAmount());
			domainInmate.setReferralCode(modelInMate.getReferralCode());
			domainInmate.setUpdatedBy(modelInMate.getUpdatedBy());
			domainInmate.setUpdatedDate(modelInMate.getUpdatedDate());
		}
	
		return domainInmate;		
	}
	
	public static com.ylc.model.InmateStatus copy(InmateStatus domainInmateStatus){
		com.ylc.model.InmateStatus modelInmateStatus=new com.ylc.model.InmateStatus();
		if(domainInmateStatus!=null){
			modelInmateStatus.setInmateStatusDescription(domainInmateStatus.getInmateStatusDescription());
			modelInmateStatus.setInmateStatusID(domainInmateStatus.getInmateStatusID());
			modelInmateStatus.setInmateStatusName(domainInmateStatus.getInmateStatusName());
		}
		return modelInmateStatus;
	}
	public static InmateStatus copy(com.ylc.model.InmateStatus modelInmateStatus){
		com.ylc.domain.InmateStatus domainInmateStatus=new com.ylc.domain.InmateStatus();
		if(modelInmateStatus!=null){
			domainInmateStatus.setInmateStatusDescription(modelInmateStatus.getInmateStatusDescription());
			domainInmateStatus.setInmateStatusID(modelInmateStatus.getInmateStatusID());
			domainInmateStatus.setInmateStatusName(modelInmateStatus.getInmateStatusName());		
		}
		return domainInmateStatus;
	}
	public static com.ylc.model.FacilityLocation copy(FacilityLocation domainFacilityLocation){
		
		com.ylc.model.FacilityLocation modelFacilityLocation=new com.ylc.model.FacilityLocation();
		if(domainFacilityLocation!=null){
			modelFacilityLocation.setAddress(domainFacilityLocation.getAddress());
			modelFacilityLocation.setCitystatezip(domainFacilityLocation.getCitystatezip());
			modelFacilityLocation.setF7(domainFacilityLocation.getF7());
			modelFacilityLocation.setFacilityID(domainFacilityLocation.getFacilityID());
			modelFacilityLocation.setFacilityName(domainFacilityLocation.getFacilityName());
			modelFacilityLocation.setInmates(domainFacilityLocation.getInmates());
			//modelFacilityLocation.setLocalExchanges(domainFacilityLocation.getLocalExchanges());
			modelFacilityLocation.setPhone(domainFacilityLocation.getPhone());
			modelFacilityLocation.setTimezone(domainFacilityLocation.getTimezone());
		}
		return modelFacilityLocation;
		
	}
	
	public static FacilityLocation copy(com.ylc.model.FacilityLocation modelFacilityLocation){		
		com.ylc.domain.FacilityLocation domainFacilityLocation=new com.ylc.domain.FacilityLocation();
		if(modelFacilityLocation!=null){
			domainFacilityLocation.setAddress(modelFacilityLocation.getAddress());
			domainFacilityLocation.setCitystatezip(modelFacilityLocation.getCitystatezip());
			domainFacilityLocation.setF7(modelFacilityLocation.getF7());
			domainFacilityLocation.setFacilityID(modelFacilityLocation.getFacilityID());
			domainFacilityLocation.setFacilityName(modelFacilityLocation.getFacilityName());
			domainFacilityLocation.setInmates(modelFacilityLocation.getInmates());		
			domainFacilityLocation.setPhone(modelFacilityLocation.getPhone());
			domainFacilityLocation.setTimezone(modelFacilityLocation.getTimezone());
			if(modelFacilityLocation.getRateCenter()!=null){
			RateCenter rateCenter=new RateCenter();			
			rateCenter.setRateCenterID(modelFacilityLocation.getRateCenter().getRateCenterID());
			domainFacilityLocation.setRateCenter(rateCenter);
			}
		}
		
		return domainFacilityLocation;
		
	}

	public static InMate copyModelToDomainForGet(com.ylc.model.InMate inMate){
    	InMate inmateD=new InMate();
    	if(inMate!=null){
		inmateD.setInmateCode(inMate.getInmateCode());
		inmateD.setInmateFirstName(inMate.getInmateFirstName());
		inmateD.setInmateLastName(inMate.getInmateLastName());
    	}
		return inmateD;
	}
	
	
	public static InMate copyModelToDomain(com.ylc.model.InMate inMate){
		InMate inmateD=new InMate();
		if(inMate!=null){
		inmateD.setActive(inMate.getActive());
		inmateD.setAllowedCallLines(inMate.getAllowedCallLines());
		inmateD.setBopNumber(inMate.getBopNumber());
		inmateD.setChargePerLine(inMate.getChargePerLine());
		FacilityLocation facilityLocation=new FacilityLocation();
		facilityLocation.setFacilityID(inMate.getFacilityLocation().getFacilityID());
		inmateD.setFacilityLocation(facilityLocation);
		inmateD.setInmateCode(inMate.getInmateCode());
		inmateD.setInmateFirstName(inMate.getInmateFirstName());
		inmateD.setInmateID(inMate.getInmateID());
		inmateD.setInmateLastName(inMate.getInmateLastName());
		InmateStatus inmateStatus=new InmateStatus();
		inmateStatus.setInmateStatusID(1);
		inmateD.setInmateStatus(inmateStatus);
		inmateD.setPrePaidAmount(inMate.getPrePaidAmount());
		inmateD.setReferralCode(inMate.getReferralCode());
		inmateD.setMaxAmtLimit(inMate.getMaxAmtLimit());	
		inmateD.setIsCreditAllowed(inMate.getIsCreditAllowed());
		}
		return inmateD;
		
	}
	
	public static com.ylc.model.CustomerLine copyCustomerLine(CustomerLine domainCustomerLine){
		com.ylc.model.CustomerLine modelCustomerLine=null;
		if(domainCustomerLine!=null){
			modelCustomerLine=new com.ylc.model.CustomerLine();
			modelCustomerLine.setActive(domainCustomerLine.getActive());
			modelCustomerLine.setCreatedBy(domainCustomerLine.getCreatedBy());
			modelCustomerLine.setCreatedDate(domainCustomerLine.getCreatedDate());
			modelCustomerLine.setUser(copy(domainCustomerLine.getUser()));
	
			modelCustomerLine.setDestinationLineNumber(domainCustomerLine.getDestinationLineNumber());
			modelCustomerLine.setEndDate(domainCustomerLine.getEndDate());
			modelCustomerLine.setInMate(copy(domainCustomerLine.getInMate()));
			modelCustomerLine.setInmateLocationID(domainCustomerLine.getInmateLocationID());
			modelCustomerLine.setIsInitiatedByInmate(domainCustomerLine.getIsInitiatedByInmate());
			modelCustomerLine.setIsPaidByQuickPay(domainCustomerLine.getIsPaidByQuickPay());
			modelCustomerLine.setLineType(copyLineType(domainCustomerLine.getLineType()));
			modelCustomerLine.setCustomerLineID(domainCustomerLine.getCustomerLineID());
			modelCustomerLine.setLocalLineNumber(domainCustomerLine.getLocalLineNumber());
			modelCustomerLine.setPrepaidMinutes(domainCustomerLine.getPrepaidMinutes());
			modelCustomerLine.setStartDate(domainCustomerLine.getStartDate());
			modelCustomerLine.setUpdatedBy(domainCustomerLine.getUpdatedBy());
			modelCustomerLine.setUpdatedDate(domainCustomerLine.getUpdatedDate());
			modelCustomerLine.setLocalLineNumber(domainCustomerLine.getLocalLineNumber());
		}
		return modelCustomerLine;
	}
	
	
	public static CustomerLine copyCustomerLine(com.ylc.model.CustomerLine modelCustomerLine){
		CustomerLine domainCustomerLine=null;
		if(modelCustomerLine!=null){
			domainCustomerLine=new CustomerLine();
			domainCustomerLine.setActive(modelCustomerLine.getActive());
			domainCustomerLine.setCreatedBy(modelCustomerLine.getCreatedBy());
			domainCustomerLine.setCreatedDate(modelCustomerLine.getCreatedDate());
			domainCustomerLine.setUser(copy(modelCustomerLine.getUser()));
			domainCustomerLine.setCustomerLineID(modelCustomerLine.getCustomerLineID());
	
			domainCustomerLine.setDestinationLineNumber(modelCustomerLine.getDestinationLineNumber());
			domainCustomerLine.setEndDate(modelCustomerLine.getEndDate());
			domainCustomerLine.setInMate(copy(modelCustomerLine.getInMate()));
			domainCustomerLine.setInmateLocationID(modelCustomerLine.getInmateLocationID());
			domainCustomerLine.setIsInitiatedByInmate(modelCustomerLine.getIsInitiatedByInmate());
			domainCustomerLine.setIsPaidByQuickPay(modelCustomerLine.getIsPaidByQuickPay());
			domainCustomerLine.setLineType(copyLineType(modelCustomerLine.getLineType()));
			domainCustomerLine.setLocalLineNumber(modelCustomerLine.getLocalLineNumber());
			domainCustomerLine.setPrepaidMinutes(modelCustomerLine.getPrepaidMinutes());
			domainCustomerLine.setStartDate(modelCustomerLine.getStartDate());
			domainCustomerLine.setUpdatedBy(modelCustomerLine.getUpdatedBy());
			domainCustomerLine.setUpdatedDate(modelCustomerLine.getUpdatedDate());
			domainCustomerLine.setLocalLineNumber(modelCustomerLine.getLocalLineNumber());
		}
		return domainCustomerLine;

	}	
	public static LineType copyLineType(com.ylc.model.Linetype modelLineType){
		LineType domainLineType=null;
		if(modelLineType!=null){
			domainLineType=new LineType();
			domainLineType.setLineTypeID(modelLineType.getLineTypeID());
			domainLineType.setLineTypeName(modelLineType.getLineTypeName());
		}
		return domainLineType;
	}
	
	public static com.ylc.model.Linetype copyLineType(LineType domainLineType){
		com.ylc.model.Linetype modelLineType=null;
		if(domainLineType!=null){
			modelLineType=new com.ylc.model.Linetype();
			modelLineType.setLineTypeID(domainLineType.getLineTypeID());
			modelLineType.setLineTypeName(domainLineType.getLineTypeName());
		}
		return modelLineType;
	}
	public static com.ylc.model.CustomerLine copy(CustomerLine customerLineD){
		com.ylc.model.CustomerLine customerLineM=new com.ylc.model.CustomerLine();
		if(customerLineD!=null){
		customerLineM.setActive(customerLineD.getActive());
		customerLineM.setCreatedBy(customerLineD.getCreatedBy());
		customerLineM.setCreatedDate(customerLineD.getCreatedDate());	
		customerLineM.setDestinationLineNumber(customerLineD.getDestinationLineNumber());
		customerLineM.setEndDate(customerLineD.getEndDate());
		customerLineM.setInMate(copy(customerLineD.getInMate()));
		customerLineM.setInmateLocationID(customerLineD.getInmateLocationID());
		customerLineM.setIsInitiatedByInmate(customerLineD.getIsInitiatedByInmate());
		customerLineM.setIsPaidByQuickPay(customerLineD.getIsPaidByQuickPay());
		customerLineM.setLineType(copyLineType(customerLineD.getLineType()));
		customerLineM.setPrepaidMinutes(customerLineD.getPrepaidMinutes());
		customerLineM.setStartDate(customerLineD.getStartDate());
		customerLineM.setUpdatedBy(customerLineD.getUpdatedBy());
		customerLineM.setUpdatedDate(customerLineD.getUpdatedDate());
		customerLineM.setLocalLineNumber(customerLineD.getLocalLineNumber());
		customerLineM.setCustomerLineID(customerLineD.getCustomerLineID());
		com.ylc.model.User user=new com.ylc.model.User();
		user.setCustomerID(customerLineD.getUser().getCustomerID());
		customerLineM.setUser(user);
		
		for(com.ylc.domain.CustomerLinePaymentDetail custpayDet:customerLineD.getCustomerLinePaymentDetails())
			customerLineM.getCustomerLinePaymentDetails().add(copy(custpayDet));
			
			//customerLineM.setInMate(copy(customerLineD.getInMate()));
		}
		return customerLineM;
	}

	public static  CustomerLine copy(com.ylc.model.CustomerLine customerLineM)  {
		CustomerLine customerLineD=new CustomerLine();
		if(customerLineM!=null){
		customerLineD.setActive(customerLineM.getActive());
		customerLineD.setCreatedBy(customerLineM.getCreatedBy());
		customerLineD.setCreatedDate(customerLineM.getCreatedDate());
		customerLineD.setUser(copy(customerLineM.getUser()));
		customerLineD.setDestinationLineNumber(customerLineM.getDestinationLineNumber());
		customerLineD.setEndDate(customerLineM.getEndDate());
		
		customerLineD.setInMate(copy(customerLineM.getInMate()));
		customerLineD.setInmateLocationID(customerLineM.getInmateLocationID());
		customerLineD.setIsInitiatedByInmate(customerLineM.getIsInitiatedByInmate());
		customerLineD.setIsPaidByQuickPay(customerLineM.getIsPaidByQuickPay());
		customerLineD.setLineType(copyLineType(customerLineM.getLineType()));
		customerLineD.setPrepaidMinutes(customerLineM.getPrepaidMinutes());
		customerLineD.setStartDate(customerLineM.getStartDate());
		customerLineD.setUpdatedBy(customerLineM.getUpdatedBy());
		customerLineD.setUpdatedDate(customerLineM.getUpdatedDate());
		customerLineD.setLocalLineNumber(customerLineM.getLocalLineNumber());
		customerLineD.setCustomerLineID(customerLineM.getCustomerLineID());
		if(customerLineM.getCustomerLinePaymentDetails()!=null){
		Iterator iterator=customerLineM.getCustomerLinePaymentDetails().iterator();
		if(iterator.hasNext()){
			CustomerLinePaymentDetail customerLinePaymentDetail=copy((com.ylc.model.CustomerLinePaymentDetail)iterator.next());
			customerLineD.getCustomerLinePaymentDetails().add(customerLinePaymentDetail);
			customerLinePaymentDetail.setCustomerLine(customerLineD);
			}	
			}
		}
		return customerLineD;

	}
	
	public static  CustomerLinePaymentDetail copy(com.ylc.model.CustomerLinePaymentDetail customerLinePaymentDetailM){
		CustomerLinePaymentDetail customerLinePaymentDetailD=new CustomerLinePaymentDetail();
		User customer=new User();
		if(customerLinePaymentDetailM!=null){
		//customer.setCustomerID(customerLinePaymentDetailM.getUser().getCustomerID());
		//customerLinePaymentDetailD.setUser(copy(customer));
		CustomerLine customerLine=copyCustomerLine(customerLinePaymentDetailM.getCustomerLine());
		customerLine.setCustomerLineID(customerLinePaymentDetailM.getCustomerLine().getCustomerLineID());
		customerLinePaymentDetailD.setCustomerLine(customerLine);
		customerLinePaymentDetailD.setCreatedDate(customerLinePaymentDetailM.getCreatedDate());
		//customerLinePaymentDetailD.setInMate(customerLine.getInMate());
		customerLinePaymentDetailD.setInvoiceGeneratedDate(customerLinePaymentDetailM.getInvoiceGeneratedDate());
		customerLinePaymentDetailD.setIsInitiatedByInmate(customerLinePaymentDetailM.getIsInitiatedByInmate());
		customerLinePaymentDetailD.setIsInvoiceGenerated(customerLinePaymentDetailM.getIsInvoiceGenerated());
		customerLinePaymentDetailD.setIsPaidByQuickPay(customerLinePaymentDetailM.getIsPaidByQuickPay());
		customerLinePaymentDetailD.setIsRecurringPayemnt(customerLinePaymentDetailM.getIsRecurringPayemnt());
		customerLinePaymentDetailD.setLast4DigitsOfCard(customerLinePaymentDetailM.getLast4DigitsOfCard());	
		customerLinePaymentDetailD.setNameOnCard(customerLinePaymentDetailM.getNameOnCard());
		customerLinePaymentDetailD.setNumberOfMinutes(customerLinePaymentDetailM.getNumberOfMinutes());
		customerLinePaymentDetailD.setPaidFor(customerLinePaymentDetailM.getPaidFor());
		customerLinePaymentDetailD.setPaymentAmount(customerLinePaymentDetailM.getPaymentAmount());
		customerLinePaymentDetailD.setPaymentAmount(customerLinePaymentDetailM.getPaymentAmount());
		PaymentCardType paymentCardType=new PaymentCardType();
		paymentCardType.setPaymentCardTypeID(customerLinePaymentDetailM.getPaymentCardType().getPaymentCardTypeID());
		customerLinePaymentDetailD.setPaymentCardType(paymentCardType);		
		customerLinePaymentDetailD.setPaymentConformationCode(customerLinePaymentDetailM.getPaymentConformationCode());
		customerLinePaymentDetailD.setPaymentDate(customerLinePaymentDetailM.getPaymentDate());		
		customerLinePaymentDetailD.setPaymentType(customerLinePaymentDetailM.getPaymentType());
		PrepaidPricing repaidPricing=new PrepaidPricing();
		repaidPricing.setPrepaidPricingID(customerLinePaymentDetailM.getPrepaidPricing().getPrepaidPricingID());
		//customerLinePaymentDetailD.setInMate(copy(customerLinePaymentDetailM.getInMate()));
		customerLinePaymentDetailD.setPrepaidPricing(repaidPricing);
		}
		return customerLinePaymentDetailD;	   
	}
	
	public static  com.ylc.model.CustomerLinePaymentDetail copy(CustomerLinePaymentDetail domainCustomerLinePaymentDetail){		
		com.ylc.model.CustomerLinePaymentDetail modelcustomerLinePaymentDetail=new com.ylc.model.CustomerLinePaymentDetail();
		if(domainCustomerLinePaymentDetail!=null){
			com.ylc.model.User user=new com.ylc.model.User();
			//user.setCustomerID(domainCustomerLinePaymentDetail.getUser().getCustomerID());
			
			//modelcustomerLinePaymentDetail.setUser(user);
			com.ylc.model.CustomerLine customerLineM=new com.ylc.model.CustomerLine();
			customerLineM.setCustomerLineID(domainCustomerLinePaymentDetail.getCustomerLine().getCustomerLineID());
			modelcustomerLinePaymentDetail.setCustomerLine(customerLineM);
			com.ylc.model.InMate inmateM=new com.ylc.model.InMate();
			inmateM.setInmateID(domainCustomerLinePaymentDetail.getCustomerLine().getInMate().getInmateID());
			//modelcustomerLinePaymentDetail.setInMate(inmateM);
		
		modelcustomerLinePaymentDetail.setCreatedDate(domainCustomerLinePaymentDetail.getCreatedDate());
		modelcustomerLinePaymentDetail.setInvoiceGeneratedDate(domainCustomerLinePaymentDetail.getInvoiceGeneratedDate());
		modelcustomerLinePaymentDetail.setIsInitiatedByInmate(domainCustomerLinePaymentDetail.getIsInitiatedByInmate());
		modelcustomerLinePaymentDetail.setIsInvoiceGenerated(domainCustomerLinePaymentDetail.getIsInvoiceGenerated());
		modelcustomerLinePaymentDetail.setIsPaidByQuickPay(domainCustomerLinePaymentDetail.getIsPaidByQuickPay());
		modelcustomerLinePaymentDetail.setIsRecurringPayemnt(domainCustomerLinePaymentDetail.getIsRecurringPayemnt());
		modelcustomerLinePaymentDetail.setLast4DigitsOfCard(domainCustomerLinePaymentDetail.getLast4DigitsOfCard());	
		modelcustomerLinePaymentDetail.setNameOnCard(domainCustomerLinePaymentDetail.getNameOnCard());
		modelcustomerLinePaymentDetail.setNumberOfMinutes(domainCustomerLinePaymentDetail.getNumberOfMinutes());
		modelcustomerLinePaymentDetail.setPaidFor(domainCustomerLinePaymentDetail.getPaidFor());
		modelcustomerLinePaymentDetail.setPaymentAmount(domainCustomerLinePaymentDetail.getPaymentAmount());
		modelcustomerLinePaymentDetail.setPaymentAmount(domainCustomerLinePaymentDetail.getPaymentAmount());
		com.ylc.model.PaymentCardType paymentCardType=new com.ylc.model.PaymentCardType();
		paymentCardType.setPaymentCardTypeID(domainCustomerLinePaymentDetail.getPaymentCardType().getPaymentCardTypeID());
		modelcustomerLinePaymentDetail.setPaymentCardType(paymentCardType);		
		modelcustomerLinePaymentDetail.setPaymentConformationCode(domainCustomerLinePaymentDetail.getPaymentConformationCode());
		modelcustomerLinePaymentDetail.setPaymentDate(domainCustomerLinePaymentDetail.getPaymentDate());		
		modelcustomerLinePaymentDetail.setPaymentType(domainCustomerLinePaymentDetail.getPaymentType());
		com.ylc.model.PrepaidPricing repaidPricing=new com.ylc.model.PrepaidPricing();
		repaidPricing.setPrepaidPricingID(domainCustomerLinePaymentDetail.getPrepaidPricing().getPrepaidPricingID());
		modelcustomerLinePaymentDetail.setPrepaidPricing(repaidPricing);
		}
		return modelcustomerLinePaymentDetail;	   
	}
	
	public static BillingAddress copy(com.ylc.model.BillingAddress billingAddress) throws IllegalAccessException, InvocationTargetException{
		BillingAddress billingAddressD=new BillingAddress();
		if(billingAddress!=null){
		billingAddressD.setAddress1(billingAddress.getAddress1());
		billingAddressD.setAddress2(billingAddress.getAddress2());	
		billingAddressD.setCity(billingAddress.getCity());
		billingAddressD.setZipCode(billingAddress.getZipCode());
		com.ylc.domain.State state=new com.ylc.domain.State();
		YlcUtils.copyProperties(state,billingAddress.getState());
		billingAddressD.setState(state);
		com.ylc.domain.Country country=new com.ylc.domain.Country();
		YlcUtils.copyProperties(country,billingAddress.getCountry());
		billingAddressD.setCountry(country);
		com.ylc.domain.User user =new com.ylc.domain.User();
		user.setCustomerID(billingAddress.getUser().getCustomerID());
	    billingAddressD.setUser(user);
		}
	    return billingAddressD;
	   
	}
	
	public static com.ylc.model.BillingAddress copy(BillingAddress billingAddressD) throws IllegalAccessException, InvocationTargetException{
		com.ylc.model.BillingAddress  billingAddress=new com.ylc.model.BillingAddress();
		if(billingAddressD!=null){
		billingAddress.setAddress1(billingAddressD.getAddress1());
		billingAddress.setAddress2(billingAddressD.getAddress2());	
		billingAddress.setCity(billingAddressD.getCity());
		billingAddress.setZipCode(billingAddressD.getZipCode());
		com.ylc.model.State state=new com.ylc.model.State();
		YlcUtils.copyProperties(billingAddressD.getState(),state);
		billingAddress.setState(state);
		com.ylc.model.Country country=new com.ylc.model.Country();
		YlcUtils.copyProperties(billingAddressD.getCountry(),country);
		billingAddress.setCountry(country);
		com.ylc.model.User user =new com.ylc.model.User();
	    user.setCustomerID(billingAddressD.getUser().getCustomerID());
	    billingAddress.setUser(user);
		}
	    return billingAddress;
		
	}
	
	public static  CustomerPaymentDetail copy(com.ylc.model.CustomerPaymentDetail customerPaymentDetailM){
		CustomerPaymentDetail customerPaymentDetailD=new CustomerPaymentDetail();		
		if(customerPaymentDetailM!=null){
		com.ylc.domain.User user=new com.ylc.domain.User();
		user.setCustomerID(customerPaymentDetailM.getUser().getCustomerID());		
		customerPaymentDetailD.setUser(user);
		customerPaymentDetailD.setCreatedDate(customerPaymentDetailM.getCreatedDate());		
		customerPaymentDetailD.setInvoiceGeneratedDate(customerPaymentDetailM.getInvoiceGeneratedDate());
		customerPaymentDetailD.setIsInitiatedByInmate(customerPaymentDetailM.getIsInitiatedByInmate());
		customerPaymentDetailD.setIsInvoiceGenerated(customerPaymentDetailM.getIsInvoiceGenerated());
		customerPaymentDetailD.setIsPaidByQuickPay(customerPaymentDetailM.getIsPaidByQuickPay());
		customerPaymentDetailD.setIsRecurringPayemnt(customerPaymentDetailM.getIsRecurringPayemnt());
		customerPaymentDetailD.setLast4DigitsOfCard(customerPaymentDetailM.getLast4DigitsOfCard());	
		customerPaymentDetailD.setNameOnCard(customerPaymentDetailM.getNameOnCard());
		customerPaymentDetailD.setNumberOfMinutes(customerPaymentDetailM.getNumberOfMinutes());
		customerPaymentDetailD.setPaidFor(customerPaymentDetailM.getPaidFor());
		customerPaymentDetailD.setPaymentAmount(customerPaymentDetailM.getPaymentAmount());
		customerPaymentDetailD.setPaymentAmount(customerPaymentDetailM.getPaymentAmount());
		PaymentCardType paymentCardType=new PaymentCardType();
		paymentCardType.setPaymentCardTypeID(customerPaymentDetailM.getPaymentCardType().getPaymentCardTypeID());
		customerPaymentDetailD.setPaymentCardType(paymentCardType);		
		customerPaymentDetailD.setPaymentConformationCode(customerPaymentDetailM.getPaymentConformationCode());
		customerPaymentDetailD.setPaymentDate(customerPaymentDetailM.getPaymentDate());		
		customerPaymentDetailD.setPaymentType(customerPaymentDetailM.getPaymentType());
		PrepaidPricing repaidPricing=new PrepaidPricing();
		repaidPricing.setPrepaidPricingID(customerPaymentDetailM.getPrepaidPricing().getPrepaidPricingID());
		customerPaymentDetailD.setPrepaidPricing(repaidPricing);
		}
		return customerPaymentDetailD;	   
	}
	
	public static  com.ylc.model.CustomerPaymentDetail copy(CustomerPaymentDetail customerPaymentDetailD){		
		com.ylc.model.CustomerPaymentDetail customerPaymentDetailM=new com.ylc.model.CustomerPaymentDetail();
		if(customerPaymentDetailD!=null){	
				
			customerPaymentDetailM.setCreatedDate(customerPaymentDetailD.getCreatedDate());
			customerPaymentDetailM.setInvoiceGeneratedDate(customerPaymentDetailD.getInvoiceGeneratedDate());
			customerPaymentDetailM.setIsInitiatedByInmate(customerPaymentDetailD.getIsInitiatedByInmate());
			customerPaymentDetailM.setIsInvoiceGenerated(customerPaymentDetailD.getIsInvoiceGenerated());
			customerPaymentDetailM.setIsPaidByQuickPay(customerPaymentDetailD.getIsPaidByQuickPay());
			customerPaymentDetailM.setIsRecurringPayemnt(customerPaymentDetailD.getIsRecurringPayemnt());
			customerPaymentDetailM.setLast4DigitsOfCard(customerPaymentDetailD.getLast4DigitsOfCard());	
			customerPaymentDetailM.setNameOnCard(customerPaymentDetailD.getNameOnCard());
			customerPaymentDetailM.setNumberOfMinutes(customerPaymentDetailD.getNumberOfMinutes());
			customerPaymentDetailM.setPaidFor(customerPaymentDetailD.getPaidFor());
			customerPaymentDetailM.setPaymentAmount(customerPaymentDetailD.getPaymentAmount());
			customerPaymentDetailM.setPaymentAmount(customerPaymentDetailD.getPaymentAmount());
		com.ylc.model.PaymentCardType paymentCardType=new com.ylc.model.PaymentCardType();
		paymentCardType.setPaymentCardTypeID(customerPaymentDetailD.getPaymentCardType().getPaymentCardTypeID());
		customerPaymentDetailM.setPaymentCardType(paymentCardType);		
		customerPaymentDetailM.setPaymentConformationCode(customerPaymentDetailD.getPaymentConformationCode());
		customerPaymentDetailM.setPaymentDate(customerPaymentDetailD.getPaymentDate());		
		customerPaymentDetailM.setPaymentType(customerPaymentDetailD.getPaymentType());
		com.ylc.model.PrepaidPricing repaidPricing=new com.ylc.model.PrepaidPricing();
		repaidPricing.setPrepaidPricingID(customerPaymentDetailD.getPrepaidPricing().getPrepaidPricingID());
		customerPaymentDetailM.setPrepaidPricing(repaidPricing);
		}
		return customerPaymentDetailM;	   
	}
	
	
	

}

