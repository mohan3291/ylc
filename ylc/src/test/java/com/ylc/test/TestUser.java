package com.ylc.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.Country;
import com.ylc.model.Customer;
import com.ylc.model.Role;
import com.ylc.model.State;
import com.ylc.model.User;
import com.ylc.service.UserService;

public class TestUser extends BaseTest{
	
	@Autowired
    private UserService userService;
	
	@Ignore("Only one time insert") 
	@Test
	public  void insertUser(){
		User user=new User();
		user.setActive(new Byte("1"));
		user.setPassword("admin");
		user.setSecurityQuestion("where u born");
		user.setAnswer("Ashta");
		user.setEmailID("rrr@aa.com");			
		Role role=new Role();
		role.setRoleID(1);
		user.setRole(role);		
		Country country=new Country();
		country.setCountryID(1);
		
		State state=new State();
		state.setStateID(1);		
		Customer customer=new Customer();		
		customer.setFirstName("Raghu");
		customer.setActive(new Byte("1"));
		customer.setAddress1("2001 E Spring");
		customer.setAddress2("7103");
		customer.setCity("Plano");
		customer.setCountry(country);
		customer.setState(state);		
		user.setCustomer(customer);
		customer.setUser(user);
		userService.saveUser(user);		
	}
	
	@Test
	public  void getUser(){
		User user=new User();
		user.setEmailID("rrr@aa.com");	
		user=userService.findByUserByEmail(user);
		System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.err.println(user.getSecurityQuestion());
		System.err.println(user.getRole().getRoleName());
		System.err.println(user.getCustomer().getAddress1());
		System.err.println(user.getCustomer().getState().getStateAbbr());
		
	}
	
	

}
