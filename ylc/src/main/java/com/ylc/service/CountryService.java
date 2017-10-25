package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.CountryDao;
import com.ylc.domain.Country;
import com.ylc.util.YlcUtils;
@Service
public class CountryService {
	@Autowired
	CountryDao countryDao;	
	
	
	public List<com.ylc.model.Country> getCountries() throws IllegalAccessException, InvocationTargetException, InstantiationException {				 
		 List<com.ylc.model.Country> destinations=new ArrayList<com.ylc.model.Country>();		
		 List<Country> countrie= countryDao.getCountries();
		 YlcUtils.copyProperties(destinations, countrie, com.ylc.model.Country.class);
		 return destinations;
	}
	
	public com.ylc.model.Country   getCountryById(com.ylc.model.Country county) throws IllegalAccessException, InvocationTargetException {
		Country destination=new Country();
		YlcUtils.copyProperties(destination,county);		
		destination= countryDao.getCountryId(destination);
		YlcUtils.copyProperties(county,destination);	
		return county;
	
	}
	
	public void saveCountry(com.ylc.model.Country country) throws IllegalAccessException, InvocationTargetException {
		Country destination=new Country();
		YlcUtils.copyProperties(destination,country);		
		countryDao.saveCountry(destination);
	}
	
	

}
