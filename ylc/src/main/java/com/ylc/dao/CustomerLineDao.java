package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.Customer;
import com.ylc.domain.CustomerLine;

@Repository
public class CustomerLineDao {
	@Autowired
    SessionFactory sessionFactory;	
	

	public void saveCustomerLine(CustomerLine customerLine) {
		sessionFactory.getCurrentSession().saveOrUpdate(customerLine);
	}
	
	
	public List<CustomerLine> getCustomerLineByCustomer(Customer customer){
	
		String hql="from CustomerLine where CustomerID=:CustomerID and Active=1";
		@SuppressWarnings("unchecked")
		List<CustomerLine> customerLines = sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("CustomerID",customer.getCustomerID()).list();
		return customerLines;
	}
	public CustomerLine getCustomerLineByCustomerLineID(CustomerLine customerLine){
		
		String hql="from CustomerLine where CustomerLineID=:CustomerLineID";
		@SuppressWarnings("unchecked")
		List<CustomerLine> customerLines = sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("CustomerLineID",customerLine.getCustomerLineID()).list();
		if(customerLines.size()>0)
			return customerLines.get(0);
		else
			return null;
	}
	

}
