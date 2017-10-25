package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.PrepaidPricing;

@Repository
public class PrepaidPricingDao {

	@Autowired
	SessionFactory sessionFactory;

	public void savePrepaidPricing(PrepaidPricing prepaidPricing) {
		sessionFactory.getCurrentSession().saveOrUpdate(prepaidPricing);
	}

	public List<PrepaidPricing> getPrepaidPricings() {

		String hql = "from PrepaidPricing";
		@SuppressWarnings("unchecked")
		List<PrepaidPricing> prepaidPricings = sessionFactory
				.getCurrentSession().createQuery(hql).list();
		return prepaidPricings;
	}

}
