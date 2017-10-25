package com.ylc.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.BillingAddress;
import com.ylc.model.Country;
import com.ylc.model.Customer;
import com.ylc.model.State;
import com.ylc.service.BillingService;

public class TestBillingService extends BaseTest{
	
	
	@Autowired
    private BillingService billlingService;
	
	@Ignore("Only one time insert")	
	@Test
	public void  insertBilling() {		
		Country country=new Country();
		country.setCountryID(1);
		State state=new State();
		state.setStateID(1);
		Customer customer=new Customer();
		customer.setCustomerID(1);
		BillingAddress bill=new BillingAddress();
		bill.setAddress1("2001 e spring ");
		bill.setAddress2("apt 7103");
		bill.setCity("Plano");		
		bill.setCountry(country);
		bill.setState(state);
		bill.setZipCode("75074");		
		bill.setCustomer(customer);
		try {
			billlingService.saveAddress(bill);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
