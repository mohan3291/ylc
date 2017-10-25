package com.ylc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.InmateReferral;
@Repository
public class InmateReferralDao {
	@Autowired
    SessionFactory sessionFactory;
	

	public void saveInmateReferral(InmateReferral inmateReferral){		
		sessionFactory.getCurrentSession().saveOrUpdate(inmateReferral);		
	}

}
