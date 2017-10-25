package com.ylc.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.FacilityLocation;
import com.ylc.service.FacilityService;

public class TestFacilityLocation extends BaseTest{
	
	
	@Autowired
    private FacilityService facilityService;
	
	@Ignore("Only one time insert")
	@Test
	public void InsertFacility(){
		FacilityLocation facilityLocation=new FacilityLocation();
		facilityLocation.setAddress("2001");
		facilityLocation.setCitystatezip("Plano");
		facilityLocation.setF7("f11");
		facilityLocation.setFacilityName("PPPP");
		facilityLocation.setInmates(7.5f);
		facilityLocation.setLocalExchanges("plano");
		facilityLocation.setPhone("1111111");
		facilityLocation.setTimezone("CST");
		
		try {
			facilityService.saveFacility(facilityLocation);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
