package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.FacilityNumberPool;

@Repository
public class FacilityNumberPoolDao {

	@Autowired
	SessionFactory sessionFactory;

	public void saveFacilityNumberPool(FacilityNumberPool facilityNumberPool) {
		sessionFactory.getCurrentSession().saveOrUpdate(facilityNumberPool);
	}

	public List<FacilityNumberPool> getFacilityNumberPools() {
		@SuppressWarnings("unchecked")
		List<FacilityNumberPool> facilityNumberPools = sessionFactory
				.getCurrentSession().createQuery("from FacilityNumberPool where Status=1")
				.list();
		return facilityNumberPools;

	}
	public FacilityNumberPool getFacilityNumberPoolsByPhoneNumber(FacilityNumberPool facilityNumberPool) {
		@SuppressWarnings("unchecked")
		List<FacilityNumberPool> facilityNumberPools = sessionFactory
				.getCurrentSession().createQuery("from FacilityNumberPool where PNumber=:number")
				.setParameter("number",facilityNumberPool.getpNumber())
				.list();
		if(facilityNumberPools.size()>=1)
			return facilityNumberPools.get(0);
		else
			return null;

	}

}
