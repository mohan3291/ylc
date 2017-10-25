package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.service.PaymentCardTypeService;
import com.ylc.service.PrepaidPricingService;

public class TestPrepaidPricing extends BaseTest {

	
	
	@Autowired
	private PrepaidPricingService prepaidPricingService;

  @Ignore("Only one time insert")
	@Test
	public void insertPrepaidPricing() {
		com.ylc.model.PrepaidPricing prepaidPricing = new com.ylc.model.PrepaidPricing();
		prepaidPricing.setActive(new Byte("1"));
		prepaidPricing.setBlockPrice(new BigDecimal(123.33));
		prepaidPricing.setDescription("xyz");
		prepaidPricing.setNameOfBlock("abc");
		prepaidPricing.setNoOfMinutes(123);
		try {
			prepaidPricingService.savePrepaidPricing(prepaidPricing);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}