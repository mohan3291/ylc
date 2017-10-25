package com.ylc.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.LineTypeDao;
import com.ylc.domain.LineType;
import com.ylc.util.YlcUtils;
@Service
public class LineTypeService {

	@Autowired
    LineTypeDao lineTypeDao;
	
	
	public void setLineTypeDao(LineTypeDao lineTypeDao) {
		this.lineTypeDao = lineTypeDao;
	}

	public void saveLineType(com.ylc.model.Linetype lineType) throws IllegalAccessException, InvocationTargetException{
		LineType lineTypeD=new LineType();
		YlcUtils.copyProperties(lineTypeD, lineType);		
		lineTypeDao.saveLineType(lineTypeD);
	}
}
