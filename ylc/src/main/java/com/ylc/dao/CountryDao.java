package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.Country;

@Repository
public class CountryDao {
	
	@Autowired
    SessionFactory sessionFactory;	
	
	public Country getCountryId(Country country){		
		@SuppressWarnings("unchecked")
		List<Country> countries = sessionFactory.getCurrentSession()
				.createQuery("from Country where CountryID=?")
				.setParameter(0, country.getCountryID()).list();
		return countries.get(0);
	}
	
	public List<Country> getCountries(){
		@SuppressWarnings("unchecked")
		List<Country> countries =sessionFactory.getCurrentSession()
				.createQuery("from Country").list();
		return countries;
	}
	
	public void saveCountry(Country country){		
		sessionFactory.getCurrentSession().saveOrUpdate(country);		
	}
	

}
