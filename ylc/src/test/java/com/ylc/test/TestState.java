package com.ylc.test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.State;
import com.ylc.service.StateService;

public class TestState extends BaseTest{
	
	
	@Autowired
    private StateService stateService;
	

	@Ignore("Only one time insert") 
	@Test
	public void  insertState() {		
		State state=new State();
		state.setStateName("washington");
		state.setStateAbbr("wa");
		try {
			stateService.saveState(state);
		} catch (IllegalAccessException e) {		
			e.printStackTrace();
		} catch (InvocationTargetException e) {			
			e.printStackTrace();
		};		
	}
	
	@Test
	public void printStateById(){
		State state=new State();
		state.setStateID(1);
		try {
			state=stateService.getStateById(state);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.err.println("getStateAbbr"+state.getStateAbbr());
		 System.err.println("getStateName"+state.getStateName());
		
	}
	
	@Test
	public void printStates(){		
		List<State> states;
		try {
			states = stateService.getStates();
			System.err.println("states"+states.size());	
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
		

}

