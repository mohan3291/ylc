package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.Customer;
import com.ylc.domain.CustomerPaymentDetail;

@Repository
public class CustomerPaymentDetailDao {

	@Autowired
    SessionFactory sessionFactory;	

	public void saveCustomerPaymentDetail(CustomerPaymentDetail customerLinePaymentDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(customerLinePaymentDetail);
	}
	
	
	/*public List<CustomerLinePaymentDetail> getCustomerLinePaymentDetail(Customer CustomerID){
		
		String hql="from customer_line_payment_details where CustomerID=:CustomerID";
		@SuppressWarnings("unchecked")
		List<CustomerLinePaymentDetail> inmates = sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("CustomerID",CustomerID.getCustomerID()).list();
		return inmates;
	}*/
	
	public List<CustomerPaymentDetail> getCustomerPaymentDetailByCustomer(Customer customer) {
		@SuppressWarnings("unchecked")
		List<CustomerPaymentDetail> customerLinePaymentDetail = sessionFactory.getCurrentSession()
				.createQuery("from CustomerPaymentDetail where CustomerID=?")
				.setParameter(0, customer.getCustomerID()).list();
		return customerLinePaymentDetail;
	}
}

