package com.ylc.util;

public class Test {
	@org.junit.Test
	public void singletonTest(){
		String x=TestClass.getObj();
		String y=TestClass.getObj();
		System.out.println(x.hashCode()==y.hashCode());
	}

}
