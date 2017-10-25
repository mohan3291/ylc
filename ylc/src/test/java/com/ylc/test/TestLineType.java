package com.ylc.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.Linetype;
import com.ylc.service.LineTypeService;

public class TestLineType extends BaseTest{
	
	@Autowired
    private LineTypeService lineTypeService;
	
	@Ignore("Only one time insert")
	@Test
	public void insertLineType(){
		Linetype lineType=new Linetype();
		lineType.setLineTypeName("ABC");
		try {
			lineTypeService.saveLineType(lineType);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}

}
