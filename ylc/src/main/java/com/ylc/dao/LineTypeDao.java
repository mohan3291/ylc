package com.ylc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.LineType;
@Repository
public class LineTypeDao {
	@Autowired
    SessionFactory sessionFactory;	
	
	public void saveLineType(LineType lineType){		
		sessionFactory.getCurrentSession().saveOrUpdate(lineType);		
	}
	
	

}
