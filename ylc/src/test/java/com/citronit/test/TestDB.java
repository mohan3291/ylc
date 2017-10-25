package com.citronit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/ylc";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Mohank123";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{	    
	      Class.forName("com.mysql.jdbc.Driver");	     
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);	     
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT username,password,enabled FROM users";
	      ResultSet rs = stmt.executeQuery(sql);	     
	      while(rs.next()){	        
	    	  String username  = rs.getString("username");
	    	  String password = rs.getString("password");	     
	          int enabled = rs.getInt("enabled");      
	          System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX");
	         System.out.println("username: " + username);
	         System.out.println("password: " + password);
	         System.out.println("enabled: " + enabled);	         
	      }
	   	}catch(Exception e){
	   		e.printStackTrace();
	   	}
	   }
  }
