package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.Customer;
import com.ylc.domain.CustomerLinePaymentDetail;
import com.ylc.domain.CustomerPaymentDetail;
import com.ylc.domain.InMate;

@Repository
public class CustomerLinePaymentDetailDao {

	@Autowired
    SessionFactory sessionFactory;	

	public void saveCustomerLinePaymentDetail(CustomerLinePaymentDetail customerPaymentDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(customerPaymentDetail);
	}
	
	
	/*public List<CustomerLinePaymentDetail> getCustomerLinePaymentDetail(Customer CustomerID){
		
		String hql="from customer_line_payment_details where CustomerID=:CustomerID";
		@SuppressWarnings("unchecked")
		List<CustomerLinePaymentDetail> inmates = sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("CustomerID",CustomerID.getCustomerID()).list();
		return inmates;
	}*/

	public List<CustomerLinePaymentDetail> getCustomerLinePaymentDetailByCustomer(Customer customer) {
		@SuppressWarnings("unchecked")
		List<CustomerLinePaymentDetail> customerPaymentDetail = sessionFactory.getCurrentSession()
				.createQuery("from CustomerPaymentDetail where CustomerID=?")
				.setParameter(0, customer.getCustomerID()).list();
		return customerPaymentDetail;
	}
}
