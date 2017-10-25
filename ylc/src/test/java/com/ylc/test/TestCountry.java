package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.Country;
import com.ylc.service.CountryService;


public class TestCountry extends BaseTest{
	
	
	@Autowired
    private CountryService countryService;
	

	@Ignore("Only one time insert") 
	@Test
	public void  insertCounrty() {		
		Country country=new Country();
		country.setCountryAbbr("PK");
		country.setCountryName("Pakistan");		
		try {
			countryService.saveCountry(country);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
/*	@Test
	public void printCountryById(){
		Country country=new Country();
		country.setCountryID(1);
		 try {
			country=countryService.getCountryById(country);
		} catch (IllegalAccessException | InvocationTargetException e) {		
			e.printStackTrace();
		}
		System.err.println("getCountryAbbr>>"+country.getCountryAbbr());
		System.err.println("getCountryAbbr>>"+country.getCountryName());		
	}
	
	@Test
	public void printCountries(){		
		List<Country> countries;
		try {
			countries = countryService.getCountries();
			System.err.println("countries size >>>>"+countries.size());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	

}
