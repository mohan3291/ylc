package com.ylc.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.PaymentCardTypeDao;
import com.ylc.domain.PaymentCardType;
import com.ylc.util.YlcUtils;
@Service
public class PaymentCardTypeService {

	@Autowired
    PaymentCardTypeDao paymentCardTypeDao;

	public void savePaymentCardType(
			com.ylc.model.PaymentCardType paymentCardType)
			throws IllegalAccessException, InvocationTargetException {
		PaymentCardType paymentCardTypeD = new PaymentCardType();
		YlcUtils.copyProperties(paymentCardTypeD, paymentCardType);
		paymentCardTypeDao.savePaymentCardType(paymentCardTypeD);
	}

	public void setPaymentCardTypeDao(PaymentCardTypeDao paymentCardTypeDao) {
		this.paymentCardTypeDao = paymentCardTypeDao;
	}
}
