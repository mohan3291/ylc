package com.ylc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.PaymentCardType;
@Repository
public class PaymentCardTypeDao {
	
	@Autowired
    SessionFactory sessionFactory;	
	

	public void savePaymentCardType(PaymentCardType paymentCardType){		
		sessionFactory.getCurrentSession().saveOrUpdate(paymentCardType);		
	}
	


}
