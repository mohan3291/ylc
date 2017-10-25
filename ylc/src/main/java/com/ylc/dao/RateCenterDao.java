package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.RateCenter;

@Repository
public class RateCenterDao {
	@Autowired
	SessionFactory sessionFactory;

	public void saveRateCenter(RateCenter rateCenter) {
		sessionFactory.getCurrentSession().saveOrUpdate(rateCenter);
	}

	public List<RateCenter> getRateCenters() {
		String hql = "from RateCenter";
		@SuppressWarnings("unchecked")
		List<RateCenter> rateCenters = sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return rateCenters;
	}

}
