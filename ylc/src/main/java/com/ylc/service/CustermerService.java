package com.ylc.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.CustomerDao;
import com.ylc.domain.Customer;
import com.ylc.util.YlcUtils;
@Service
public class CustermerService {
	@Autowired
	CustomerDao customerDao;

	public void saveCustomer(com.ylc.model.Customer customer) throws IllegalAccessException, InvocationTargetException{		
		customerDao.saveCustomer(YlcUtils.copy(customer));
	}		

	
	public com.ylc.model.Customer getCustomerById(com.ylc.model.Customer customer) throws IllegalAccessException, InvocationTargetException{		
		Customer destination=new Customer();
		destination.setCustomerID(customer.getCustomerID());
		Customer orig= customerDao.getCustomerById(destination);		
		return YlcUtils.copy(orig);
	}	

}
