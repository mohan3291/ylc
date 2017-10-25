package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.RateCenter;
import com.ylc.service.RateCenterService;

public class TestRateCenter extends BaseTest{

	@Autowired
	private RateCenterService rateCenterService;
	
	@Ignore("Only one time insert")	
	@Test
	public void inserRateCenter(){
		 RateCenter  rateCenter=new  RateCenter();
		 rateCenter.setEffective(new Timestamp(new Date().getTime()));
		 rateCenter.setLata(1);
		 rateCenter.setNpanxx(111);
		 rateCenter.setOcn("ocn");
		 rateCenter.setRateCenterName("xyz");	 
		 
		 try {
			rateCenterService.saveRateCenter(rateCenter);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
