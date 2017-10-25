package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.FacilityLocation;

@Repository
public class FacilityDao {
	@Autowired
    SessionFactory sessionFactory;	
	
	public void saveFacility(FacilityLocation facilityLocation){
		sessionFactory.getCurrentSession().saveOrUpdate(facilityLocation);		
	}
	
	public List<FacilityLocation> getFacilities(){
		@SuppressWarnings("unchecked")
		List<FacilityLocation> facilityLocations =sessionFactory.getCurrentSession()
				.createQuery("from FacilityLocation").list();
		return facilityLocations;
		
	}
	public List<FacilityLocation> getFacilitiesByID(Integer facID){
		@SuppressWarnings("unchecked")
		List<FacilityLocation> facilityLocations =sessionFactory.getCurrentSession()
				.createQuery("from FacilityLocation where FacilityID =:facID")
				.setParameter("facID",facID).list();
		return facilityLocations;
		
	}

}
