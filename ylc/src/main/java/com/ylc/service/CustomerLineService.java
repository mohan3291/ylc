package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.CustomerLineDao;
import com.ylc.domain.Customer;
import com.ylc.domain.CustomerLine;
import com.ylc.domain.InMate;
import com.ylc.domain.LineType;
import com.ylc.util.YlcUtils;

@Service
public class CustomerLineService {
	@Autowired
	CustomerLineDao customerLineDao;

	public void setCustomerLineDao(CustomerLineDao customerLineDao) {
		this.customerLineDao = customerLineDao;
	}

	public void saveCustomerLine(com.ylc.model.CustomerLine customerLine)
			throws IllegalAccessException, InvocationTargetException {		
		 CustomerLine customerLineD =YlcUtils.copy(customerLine);
		customerLineDao.saveCustomerLine(customerLineD);
	}

	public List<com.ylc.model.CustomerLine> getCustomerLineByCustomer(
			com.ylc.model.Customer customer) {
		Customer customerD = new Customer();
		customerD.setCustomerID(customer.getCustomerID());
		List<CustomerLine> customerLines = customerLineDao
				.getCustomerLineByCustomer(customerD);
		return copyDomainToModelList(customerLines);
	}

	private List<com.ylc.model.CustomerLine> copyDomainToModelList(
			List<CustomerLine> customerLines) {
		List<com.ylc.model.CustomerLine> customerLinesM = new ArrayList<com.ylc.model.CustomerLine>();
		for (CustomerLine customerLine : customerLines) {
			customerLinesM.add(YlcUtils.copy(customerLine));
		}
		return customerLinesM;
	}

	
	public com.ylc.model.CustomerLine getCustomerLineByLineID(
			com.ylc.model.CustomerLine customerLine) {
		List<com.ylc.model.CustomerLine> retunList=new ArrayList<com.ylc.model.CustomerLine>();
		CustomerLine customerLineD = new CustomerLine();
		customerLineD.setCustomerLineID(customerLine.getCustomerLineID());
		CustomerLine customerLines = customerLineDao.getCustomerLineByCustomerLineID(customerLineD);
			
		return YlcUtils.copy(customerLines);
	}
}
