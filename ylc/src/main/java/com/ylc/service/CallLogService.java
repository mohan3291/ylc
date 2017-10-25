package com.ylc.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.CallLogDao;
import com.ylc.domain.CallLog;
import com.ylc.domain.CustomerLine;
import com.ylc.domain.CustomerLinePaymentDetail;

@Service
public class CallLogService {
	@Autowired
	CallLogDao callLogDao;

	public void saveCallLog(com.ylc.model.CallLog callLog)
			throws IllegalAccessException, InvocationTargetException {
		CallLog callLogD = new CallLog();
		copyModelToDomain(callLog, callLogD);
		callLogDao.saveCallLog(callLogD);
	}

	private void copyModelToDomain(com.ylc.model.CallLog callLog,
			CallLog callLogD) throws IllegalAccessException,
			InvocationTargetException {	
		
		callLogD.setCallDuration(callLog.getCallDuration());
		callLogD.setCallEndDateTime(callLog.getCallEndDateTime());
		callLogD.setCallStartDateTime(callLog.getCallStartDateTime());
		callLogD.setDestinationLineNumber(callLog.getDestinationLineNumber());
		callLogD.setLocalLineNumber(callLog.getLocalLineNumber());
		callLogD.setMinutesLeft(callLog.getMinutesLeft());
		CustomerLinePaymentDetail customerLinePaymentDetail=new CustomerLinePaymentDetail();
		customerLinePaymentDetail.setLinePaymentDetailID(callLog.getCustomerLinePaymentDetail().getLinePaymentDetailID());
		callLogD.setCustomerLinePaymentDetail(customerLinePaymentDetail);
		CustomerLine customerLine=new CustomerLine();
		customerLine.setCustomerLineID(callLog.getCustomerLine().getCustomerLineID());
		//callLogD.setCustomerLine(customerLine);	

	}

}
