package com.ylc.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.Country;
import com.ylc.model.Customer;
import com.ylc.model.State;
import com.ylc.model.User;
import com.ylc.service.CustermerService;

public class TestCustomer extends BaseTest  {
	
	@Autowired
    private CustermerService customerService;
	
	
	@Ignore("Only one time insert")
	@Test
	public void insertCustomer() {
		/*Country country=new Country();
		country.setCountryID(1);
		State state=new State();
		state.setStateID(1);
		User user=new User();
		user.setUserID(1);
		Customer customer=new Customer();
		customer.setUserID(1234);
		customer.setFirstName("Raghu");
		customer.setActive(new Byte("1"));
		customer.setAddress1("2001");
		customer.setAddress2("7103");
		customer.setCity("Plano");
		customer.setCountry(country);
		customer.setState(state);
		customer.setUser(user);
		try {
			customerService.saveCustomer(customer);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
	
	@Ignore("Only one time ")
	@Test
	public void getCustomer(){
		Customer customer=new Customer();
		customer.setCustomerID(1);
		try {
			customer=customerService.getCustomerById(customer);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("firstname"+customer.getFirstName());
	}

}
