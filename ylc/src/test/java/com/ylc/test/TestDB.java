package com.ylc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class TestDB {
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/ylc";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   @Test
	   public void testDBConnection(){
	   Connection conn = null;
	   Statement stmt = null;
	   try{	    
	      Class.forName("com.mysql.jdbc.Driver");	     
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);	     
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT userID FROM users";
	      ResultSet rs = stmt.executeQuery(sql);	     
	      
	   	}catch(Exception e){
	   		e.printStackTrace();
	   	}
	   }
  }
