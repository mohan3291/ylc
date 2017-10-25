package com.ylc.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.FacilityLocation;
import com.ylc.model.FacilityNumberPool;
import com.ylc.service.FacilityNumberPoolService;

public class TestFacilityNumberPool extends BaseTest{

	@Autowired
	FacilityNumberPoolService facilityNumberPoolService;
	
	@Ignore("Only one time insert")	
	@Test
	public void testSaveFacilityNumberPool(){
		FacilityNumberPool facilityNumberPoolD=new FacilityNumberPool();	
		FacilityLocation facilityLocation=new FacilityLocation();
		facilityLocation.setFacilityID(1);
		facilityNumberPoolD.setFacilityLocation(facilityLocation);
		facilityNumberPoolD.setpNumber(1111);
		facilityNumberPoolD.setRateCenterID(1);
		facilityNumberPoolD.setStatus(new Byte("1"));	
		
	}
}
