package com.ylc.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.Role;
import com.ylc.domain.User;

@Repository
public class UserDao  {

	@Autowired
    SessionFactory sessionFactory;	

	@SuppressWarnings("unchecked")
	public User findByUserByEmail(User user) {
		System.err.println("Emailxxxxxxxxxxxxxxxxxx"+user.getEmailID());
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession()
				.createQuery("from User where EmailID=?")
				.setParameter(0, user.getEmailID()).list();
		System.err.println("sizeeeeeee>>>>>>>>>>>>>>"+users.size());
		if (users.size() > 0) {		
			return users.get(0);
		} else {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public User findByUserById(User user) {
		System.err.println("Emailxxxxxxxxxxxxxxxxxx"+user.getEmailID());
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession()
				.createQuery("from User where CustomerID=?")
				.setParameter(0, user.getCustomerID()).list();
		System.err.println("sizeeeeeee>>>>>>>>>>>>>>"+users.size());
		if (users.size() > 0) {		
			return users.get(0);
		} else {
			return null;
		}
	}
	
	 public void saveUser(User user){
		try{
		 if(user.getCustomerID()==null){
			 user.setCreatedDate(new Timestamp(System.currentTimeMillis())); 
		 }
		 user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));		
		 sessionFactory.getCurrentSession().saveOrUpdate(user);		
		}catch(Exception e){
			e.printStackTrace();
		}
	 }	
	
	public void saveRole(Role role){
		sessionFactory.getCurrentSession().saveOrUpdate(role);		
	}

}
