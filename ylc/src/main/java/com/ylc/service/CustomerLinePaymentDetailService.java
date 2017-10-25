package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.CustomerLinePaymentDetailDao;
import com.ylc.domain.CustomerLinePaymentDetail;
import com.ylc.util.YlcUtils;

@Service
public class CustomerLinePaymentDetailService {
	
	@Autowired
    CustomerLinePaymentDetailDao customerLinePaymentDetailDao;
	
		
	public void saveCustomerLinePaymentDetail(com.ylc.model.CustomerLinePaymentDetail customerLinePaymentDetail) throws IllegalAccessException, InvocationTargetException{	
	CustomerLinePaymentDetail customerLinePaymentDetailD=YlcUtils.copy(customerLinePaymentDetail);		
		customerLinePaymentDetailDao.saveCustomerLinePaymentDetail(customerLinePaymentDetailD);	
		
	}
	public List<com.ylc.model.CustomerLinePaymentDetail> getCustomerLinePaymentDetailByCustomer(com.ylc.model.Customer customer) {
		List<CustomerLinePaymentDetail> customerLinePaymentDetails=customerLinePaymentDetailDao.getCustomerLinePaymentDetailByCustomer(YlcUtils.copy(customer));
		List<com.ylc.model.CustomerLinePaymentDetail> customerLinePaymentDetailList=new ArrayList<com.ylc.model.CustomerLinePaymentDetail>();
		for(CustomerLinePaymentDetail customerLinePaymentDetail:customerLinePaymentDetails){
			customerLinePaymentDetailList.add(YlcUtils.copy(customerLinePaymentDetail));			
		}
		return customerLinePaymentDetailList;
	}
	
	
}
