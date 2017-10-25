package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.CallLog;
import com.ylc.model.CustomerLine;
import com.ylc.model.CustomerLinePaymentDetail;
import com.ylc.service.CallLogService;

public class TestCallLog extends BaseTest {
	
	@Autowired
    private CallLogService callLogService;
	
	@Ignore("Only one time insert")	
	@Test
	public void saveCallLog(){
		CallLog callLogD = new CallLog();
		callLogD.setCallDuration("123");
		callLogD.setCallEndDateTime(new Timestamp(new Date().getMinutes()));
		callLogD.setCallStartDateTime(new Timestamp(new Date().getMinutes()));
		callLogD.setDestinationLineNumber("11111111");
		callLogD.setLocalLineNumber("22222222");
		callLogD.setMinutesLeft(3333);
		CustomerLinePaymentDetail customerLinePaymentDetail=new CustomerLinePaymentDetail();
		customerLinePaymentDetail.setLinePaymentDetailID(1);
		callLogD.setCustomerLinePaymentDetail(customerLinePaymentDetail);
		CustomerLine customerLine=new CustomerLine();
		customerLine.setCustomerLineID(1);		
		callLogD.setCustomerLine(customerLine);	
		
		try {
			callLogService.saveCallLog(callLogD);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
