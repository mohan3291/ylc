package com.ylc.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
    SessionFactory sessionFactory;	
 	
	public void saveCustomer(Customer customer){
		customer.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		if(customer.getCreatedDate()==null)
			customer.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		System.out.println("Before savingggggggggggggggggggggggg");
		sessionFactory.getCurrentSession().saveOrUpdate(customer);		
	}
	
	public Customer getCustomerById(Customer customer){
		@SuppressWarnings("unchecked")
		List<Customer> customers = sessionFactory.getCurrentSession()
				.createQuery("from Customer where customerID=?")
				.setParameter(0, customer.getCustomerID()).list();
		if(customers.size()>0){
		  return customers.get(0);
		}
		return null;
		
	}


}
