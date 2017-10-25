package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.service.PaymentCardTypeService;
import com.ylc.service.PrepaidPricingService;

public class TestPaymentCardType extends BaseTest {

	@Autowired
	private PaymentCardTypeService paymentCardTypeService;


	@Ignore("Only one time insert")
	@Test
	public void inssertPaymetCardType() {
		com.ylc.model.PaymentCardType paymentCardType = new com.ylc.model.PaymentCardType();

		paymentCardType.setActive(new Byte("1"));
		paymentCardType.setPaymentCardName("xyz");

		try {
			paymentCardTypeService.savePaymentCardType(paymentCardType);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
