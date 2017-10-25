package com.ylc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.CallLog;

@Repository
public class CallLogDao {
	@Autowired
    SessionFactory sessionFactory;
	
	public void saveCallLog(CallLog callLog){		
		sessionFactory.getCurrentSession().saveOrUpdate(callLog);		
	}

}
