package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.RateCenterDao;
import com.ylc.domain.RateCenter;
import com.ylc.util.YlcUtils;

@Service
public class RateCenterService {

	@Autowired
	RateCenterDao rateCenterDao;

	public void saveRateCenter(com.ylc.model.RateCenter rateCenter)
			throws IllegalAccessException, InvocationTargetException {
		RateCenter rateCenterD = new RateCenter();
		YlcUtils.copyProperties(rateCenterD, rateCenter);
		rateCenterDao.saveRateCenter(rateCenterD);
	}

	public List<com.ylc.model.RateCenter> getRateCenters() throws IllegalAccessException, InvocationTargetException, InstantiationException {
		List<RateCenter> rateCentersD = rateCenterDao.getRateCenters();
		List<com.ylc.model.RateCenter> rateCentersM = new ArrayList<com.ylc.model.RateCenter>();
		YlcUtils.copyProperties(rateCentersM, rateCentersD, com.ylc.model.RateCenter.class);
		return rateCentersM;
	}

	

	

}
