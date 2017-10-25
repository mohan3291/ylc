package com.ylc.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.InmateStatus;
import com.ylc.service.InmateStatusService;

public class TestInmateStatus extends BaseTest {
	
	@Autowired
    private InmateStatusService inmateStatusService;
	
	@Ignore("Only one time insert")
	@Test
	public void insertInmateStatus(){
		InmateStatus inmateStatus=new InmateStatus();
		inmateStatus.setInmateStatusName("XYZ");
		try {
			inmateStatusService.saveInmateStatus(inmateStatus);
		} catch (IllegalAccessException e) {		
			e.printStackTrace();
		} catch (InvocationTargetException e) {		
			e.printStackTrace();
		}
		
	}

}
