package com.ylc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.InmateStatus;
@Repository
public class InmateStatusDao {
	@Autowired
    SessionFactory sessionFactory;	
	
	
	
	public void saveInmateStatus(InmateStatus inmateStatus){		
		sessionFactory.getCurrentSession().saveOrUpdate(inmateStatus);		
	}
	

}
