package com.ylc.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.InMate;
import com.ylc.model.InmateReferral;
import com.ylc.service.InmateReferralService;

public class TestInmateReferral extends BaseTest{

	@Autowired
	private InmateReferralService inmateReferralService;
	
	@Ignore("Only one time insert")	
	@Test
	public void inserInmateReferralService(){
		InmateReferral inmateReferral=new InmateReferral();
		InMate inMate=new InMate();
		inMate.setInmateID(1);		
		inmateReferral.setInMate(inMate);
		InMate inMater=new InMate();
		inMater.setInmateID(1);		
		inmateReferral.setInMateReferredBy(inMater);	
		inmateReferralService.saveInmateNote(inmateReferral);
	}
}
