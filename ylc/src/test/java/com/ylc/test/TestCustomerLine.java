package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.Customer;
import com.ylc.model.InMate;
import com.ylc.model.Linetype;
import com.ylc.service.CustomerLineService;

public class TestCustomerLine extends BaseTest {

	@Autowired
	private CustomerLineService customerLineService;

	@Ignore("Only one time insert")
	@Test
	public void insertCustomerLine() {
		com.ylc.model.CustomerLine customerLineD = new com.ylc.model.CustomerLine();
		customerLineD.setActive(new Byte("1"));
		customerLineD.setCreatedBy(1);
		customerLineD.setCreatedDate(new Timestamp(new Date().getTime()));
		Customer customer = new Customer();
		customer.setCustomerID(1);
		customerLineD.setCustomer(customer);

		customerLineD.setDestinationLineNumber("123");
		customerLineD.setEndDate(new Timestamp(new Date().getTime()));
		InMate inmate = new InMate();
		inmate.setInmateID(1);
		customerLineD.setInMate(inmate);
		customerLineD.setInmateLocationID(1);
		customerLineD.setIsInitiatedByInmate(new Byte("1"));
		customerLineD.setIsPaidByQuickPay(new Byte("1"));
		Linetype lineType = new Linetype();
		lineType.setLineTypeID(1);
		customerLineD.setLineType(lineType);
		customerLineD.setPrepaidMinutes(123);
		customerLineD.setStartDate(new Timestamp(new Date().getTime()));
		customerLineD.setUpdatedBy(1);
		customerLineD.setUpdatedDate(new Timestamp(new Date().getTime()));
		customerLineD.setLocalLineNumber("1234");
		
		try {
			customerLineService.saveCustomerLine(customerLineD);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
