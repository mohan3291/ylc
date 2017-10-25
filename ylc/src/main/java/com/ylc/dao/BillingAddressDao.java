package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.BillingAddress;
import com.ylc.domain.Customer;

@Repository
public class BillingAddressDao {
	
	@Autowired
    SessionFactory sessionFactory;
	
	public BillingAddress getAddressByCustomerId(Customer customer){
		@SuppressWarnings("unchecked")
		List<BillingAddress> billingAddress =sessionFactory.getCurrentSession()
				.createQuery("from BillingAddress where CustomerID=?")
				.setParameter(0, customer.getCustomerID()).list();
		return billingAddress.get(0);
	}
	
	public void saveAddress(BillingAddress billingAddress){		
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);		
	}
	


}
