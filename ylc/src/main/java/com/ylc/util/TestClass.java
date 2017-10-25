package com.ylc.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.ylc.authorize.model.OrderType;

import antlr.collections.List;

public class TestClass {
	private TestClass(){
	}
	private static String obj;
	public static String getObj(){
		if(obj==null)
		//synchronized (obj) 
		{
			obj=new String();
		}
		
		return obj;
		
	}
	}
