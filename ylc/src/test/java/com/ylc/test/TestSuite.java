package com.ylc.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	    TestCountry.class,
	    TestState.class, 
	    TestRole.class,  
	    TestUser.class,
	    TestCustomer.class,
		TestBillingService.class, 
		TestFacilityLocation.class,
		TestInmateStatus.class,
		TestInMate.class,
		TestLineType.class,
		TestCustomerLine.class,
	    TestPaymentCardType.class,
	    TestPrepaidPricing.class,
	    TestCustomerLinePaymentDetail.class,
		TestCallLog.class,
		TestFacilityNumberPool.class,
		TestInmateNote.class,
		TestRateCenter.class, 
	    TestDB.class  
	   
	        
})
public class TestSuite {

}
