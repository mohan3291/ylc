package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.StateDao;
import com.ylc.domain.State;
import com.ylc.util.YlcUtils;
@Service
public class StateService {
	
	@Autowired
    StateDao stateDao;
	

	public void setStateDao(StateDao stateDao) {
		this.stateDao = stateDao;
	}

	public com.ylc.model.State getStateById(com.ylc.model.State state) throws IllegalAccessException, InvocationTargetException{		
		State destination=new State();
		YlcUtils.copyProperties(destination,state);		
		destination= stateDao.getStateById(destination);
		YlcUtils.copyProperties(state,destination);	
		return state;
	}
	
	public List<com.ylc.model.State> getStates() throws IllegalAccessException, InvocationTargetException, InstantiationException{		
		List<com.ylc.model.State> destinationList=new ArrayList<com.ylc.model.State>();
		List<State> states= stateDao.getStates();
		YlcUtils.copyProperties(destinationList,states,com.ylc.model.State.class);	
		return destinationList;
	}
	
	public void saveState(com.ylc.model.State state) throws IllegalAccessException, InvocationTargetException{	
		State destination=new State();
		System.err.println("sssssssssssssss"+state.getStateID());
		YlcUtils.copyProperties(destination,state);		
		stateDao.saveState(destination);	
	}

}
