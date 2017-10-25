package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.FacilityLocation;
import com.ylc.model.InMate;
import com.ylc.model.InmateStatus;
import com.ylc.service.InMateService;

public class TestInMate extends BaseTest{
	
	@Autowired
    private InMateService inMateService;
	
	@Ignore("Only one time insert") 
	@Test
	public  void insertInmate(){
		InMate inmate=new InMate();
		inmate.setActive(new Byte("1"));
		inmate.setAllowedCallLines(1234);
		inmate.setBopNumber("12345");
		inmate.setChargePerLine(new BigDecimal(20.2));
		FacilityLocation facilityLocation=new FacilityLocation();
		facilityLocation.setFacilityID(1);
		inmate.setFacilityLocation(facilityLocation);
		inmate.setInmateCode("111");
		inmate.setInmateFirstName("Raghu");	
		inmate.setInmateLastName("reddy");
		InmateStatus inmateStatus=new InmateStatus();
		inmateStatus.setInmateStatusID(1);
		inmate.setInmateStatus(inmateStatus);
		inmate.setIsCreditAllowed(true);
		inmate.setPrePaidAmount(new BigDecimal(30.2));
		inmate.setReferralCode("1112");
		try {
			inMateService.saveInMate(inmate);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}	
	

}
