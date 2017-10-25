package com.ylc.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.Role;
import com.ylc.service.UserService;

public class TestRole  extends BaseTest{
	@Autowired
    private UserService userService;
	
	@Ignore("Only one time insert") 
	@Test
	public void	insertRole(){
		Role role=new Role();
		role.setActive(new Byte("1"));
		role.setRoleName("ROLE_GUEST");
		try {
			userService.saveRole(role);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}	
	}

}
