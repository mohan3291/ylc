package com.ylc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.State;

@Repository
public class StateDao {
	
	@Autowired
    SessionFactory sessionFactory;	
	
	public State getStateById(State state){
		@SuppressWarnings("unchecked")
		List<State> states =sessionFactory.getCurrentSession()
				.createQuery("from State where stateID=?")
				.setParameter(0, state.getStateID()).list();
		return states.get(0);
	}
	
	public List<State> getStates(){
		@SuppressWarnings("unchecked")
		List<State> states =sessionFactory.getCurrentSession()
				.createQuery("from State").list();
		return states;
	}
	
	public void saveState(State state){		
		sessionFactory.getCurrentSession().saveOrUpdate(state);		
	}
	


}
