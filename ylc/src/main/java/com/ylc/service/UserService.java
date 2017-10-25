package com.ylc.service;

import java.lang.reflect.InvocationTargetException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.UserDao;
import com.ylc.domain.Role;
import com.ylc.domain.User;
import com.ylc.util.YlcUtils;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public com.ylc.model.User findByUserByEmail(com.ylc.model.User user) {		
		User userD = userDao.findByUserByEmail(YlcUtils.copy(user));
		return (YlcUtils.copy(userD));
	}
	
	public com.ylc.model.User findByUserById(com.ylc.model.User user) {		
		User userD = userDao.findByUserById(YlcUtils.copy(user));
		return (YlcUtils.copy(userD));
	}

	public int saveUser(com.ylc.model.User user) {
		int status = 0;
		try {
			userDao.saveUser(YlcUtils.copy(user));
		} catch (ConstraintViolationException e) {
			if ("EmailID_UNIQUE".equalsIgnoreCase(e.getConstraintName()))
				status = 1;
		}
		return status;
	}

	public void saveRole(com.ylc.model.Role role)
			throws IllegalAccessException, InvocationTargetException {
		Role destination = new Role();
		YlcUtils.copyProperties(destination, role);
		destination.setRoleID(role.getRoleID());
		userDao.saveRole(destination);
	}

}
