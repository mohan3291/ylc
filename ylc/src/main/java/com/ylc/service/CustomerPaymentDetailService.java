package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.CustomerLinePaymentDetailDao;
import com.ylc.dao.CustomerPaymentDetailDao;
import com.ylc.domain.CustomerLinePaymentDetail;
import com.ylc.domain.CustomerPaymentDetail;
import com.ylc.util.YlcUtils;

@Service
public class CustomerPaymentDetailService {
	
	@Autowired
    CustomerPaymentDetailDao customerPaymentDetailDao;
	
		
	public void saveCustomerPaymentDetail(com.ylc.model.CustomerPaymentDetail customerPaymentDetail) throws IllegalAccessException, InvocationTargetException{	
	CustomerPaymentDetail customerPaymentDetailD=YlcUtils.copy(customerPaymentDetail);		
	customerPaymentDetailDao.saveCustomerPaymentDetail(customerPaymentDetailD);	
		
	}
	public List<com.ylc.model.CustomerPaymentDetail> getCustomerPaymentDetailByCustomer(com.ylc.model.Customer customer) {
		List<CustomerPaymentDetail> customerPaymentDetails=customerPaymentDetailDao.getCustomerPaymentDetailByCustomer(YlcUtils.copy(customer));
		List<com.ylc.model.CustomerPaymentDetail> customerPaymentDetailList=new ArrayList();
		for(CustomerPaymentDetail customerPaymentDetail:customerPaymentDetails){
			customerPaymentDetailList.add(YlcUtils.copy(customerPaymentDetail));			
		}
		return customerPaymentDetailList;
	}
	
	
}
