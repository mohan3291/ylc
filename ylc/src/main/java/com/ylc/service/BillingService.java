package com.ylc.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.BillingAddressDao;
import com.ylc.domain.BillingAddress;
import com.ylc.domain.Customer;
import com.ylc.util.YlcUtils;

@Service
public class BillingService {

	@Autowired
	BillingAddressDao billingAddressDao;

	public com.ylc.model.BillingAddress getAddressByCustomerId(
			com.ylc.model.Customer customer) throws IllegalAccessException,
			InvocationTargetException {
		Customer domainCustomer = new Customer();
		YlcUtils.copyProperties(domainCustomer, customer);
		BillingAddress billingAddressD = billingAddressDao
				.getAddressByCustomerId(domainCustomer);
		return YlcUtils.copy(billingAddressD);

	}

	public void saveAddress(com.ylc.model.BillingAddress billingAddress)
			throws IllegalAccessException, InvocationTargetException {
		billingAddressDao.saveAddress(YlcUtils.copy(billingAddress));
	}

}
