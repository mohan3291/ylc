package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.PrepaidPricingDao;
import com.ylc.domain.PrepaidPricing;
import com.ylc.util.YlcUtils;
@Service
public class PrepaidPricingService {
	@Autowired
    PrepaidPricingDao prepaidPricingDao;
	
	
	public void savePrepaidPricing(com.ylc.model.PrepaidPricing prepaidPricing) throws IllegalAccessException, InvocationTargetException{	
		PrepaidPricing prepaidPricingD=new PrepaidPricing();
		YlcUtils.copyProperties(prepaidPricingD, prepaidPricing);		
		prepaidPricingDao.savePrepaidPricing(prepaidPricingD); 	
	}	
	
	public List<com.ylc.model.PrepaidPricing> getPrepaidPricings() throws IllegalAccessException, InvocationTargetException, InstantiationException {
		List<PrepaidPricing> prepaidPricingsListD = prepaidPricingDao.getPrepaidPricings();
		List<com.ylc.model.PrepaidPricing> prepaidPricingsList = new ArrayList<com.ylc.model.PrepaidPricing>();
		YlcUtils.copyProperties(prepaidPricingsList,prepaidPricingsListD,com.ylc.model.PrepaidPricing.class);	
		return prepaidPricingsList;
	}
	

}
