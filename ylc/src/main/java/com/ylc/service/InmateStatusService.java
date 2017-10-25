package com.ylc.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.InmateStatusDao;
import com.ylc.domain.InmateStatus;
import com.ylc.util.YlcUtils;
@Service
public class InmateStatusService {
	
	@Autowired
    InmateStatusDao inmateStatusDao;
	
	
	public void saveInmateStatus(com.ylc.model.InmateStatus inmateStatus) throws IllegalAccessException, InvocationTargetException{		
		InmateStatus inmateStatusD=new InmateStatus();
		YlcUtils.copyProperties(inmateStatusD, inmateStatus);		
		inmateStatusDao.saveInmateStatus(inmateStatusD);
	}
	

	public void setInmateStatusDao(InmateStatusDao inmateStatusDao) {
		this.inmateStatusDao = inmateStatusDao;
	}	



}
