package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.InMate;
@Repository
public class InMateDao {
	
	@Autowired
    SessionFactory sessionFactory;	
	
	
	public void saveInMate(InMate inmate){		
		sessionFactory.getCurrentSession().saveOrUpdate(inmate);		
	}
	
	public List<InMate> getInmateByByFirstAndLastName(InMate inmate){
	
		String hql="from InMate where inmateFirstName=:inmateFirstName  and inmateLastName=:inmateLastName";
		@SuppressWarnings("unchecked")
		List<InMate> inmates = sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("inmateFirstName",inmate.getInmateFirstName())
				.setParameter("inmateLastName", inmate.getInmateLastName()).list();
		return inmates;
	}
	
	public List<InMate> getInmateByCode(InMate inmate){
		
		String hql="from InMate where InmateCode=:InmateCode";
		@SuppressWarnings("unchecked")
		List<InMate> inmates = sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("InmateCode",inmate.getInmateCode()).list();
		return inmates;
	}
public List<InMate> getInmateByBOP(InMate inmate){
		
		String hql="from InMate where BOPNumber=:BOPNumber";
		@SuppressWarnings("unchecked")
		List<InMate> inmates = sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("BOPNumber",inmate.getBopNumber()).list();
		return inmates;
	}
	

}
