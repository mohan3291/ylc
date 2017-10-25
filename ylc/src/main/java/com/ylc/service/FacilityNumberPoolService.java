package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.FacilityNumberPoolDao;
import com.ylc.domain.FacilityNumberPool;
import com.ylc.util.YlcUtils;

@Service
public class FacilityNumberPoolService {

	@Autowired
	FacilityNumberPoolDao facilityNumberPoolDao;

	public void saveFacilityNumberPool(
			com.ylc.model.FacilityNumberPool facilityNumberPool)
			throws IllegalAccessException, InvocationTargetException {
	    	FacilityNumberPool facilityNumberPoolD =YlcUtils.copy(facilityNumberPool);	  
	    	if(facilityNumberPoolD.getCreatedDate()==null){
	    		facilityNumberPoolD.setCreatedDate(new Timestamp(System.currentTimeMillis()));
	    	}else
	    		facilityNumberPoolD.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		     facilityNumberPoolDao.saveFacilityNumberPool(facilityNumberPoolD);
	}
	
	public List<com.ylc.model.FacilityNumberPool> getFacilityNumberPools() throws IllegalAccessException, InvocationTargetException, InstantiationException {		
		List<FacilityNumberPool> facilityNumberPools=facilityNumberPoolDao.getFacilityNumberPools();
		List<com.ylc.model.FacilityNumberPool> facilityNumberPoolsM=new ArrayList<com.ylc.model.FacilityNumberPool>();
		for(FacilityNumberPool facilityNumberPool:facilityNumberPools){
			facilityNumberPoolsM.add(YlcUtils.copy(facilityNumberPool));
		}		
		return facilityNumberPoolsM;
	}
	public com.ylc.model.FacilityNumberPool getFacilityNumberPoolsByPhoneNumber(com.ylc.model.FacilityNumberPool facilityNumberPool) throws IllegalAccessException, InvocationTargetException, InstantiationException {		
		FacilityNumberPool domainfacilityNumberPool=facilityNumberPoolDao.getFacilityNumberPoolsByPhoneNumber(YlcUtils.copy(facilityNumberPool));
		if(domainfacilityNumberPool!=null)
			return YlcUtils.copy(domainfacilityNumberPool);
		else
			return null;
	}

}
