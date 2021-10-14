package com.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
   
public class SingleConnection {
private	String url="jdbc:mysql://localhost:3306/db-appgestion";
private  static	Connection connection=null;
	private SingleConnection(){
	try{
		connection=DriverManager.getConnection(url,"root","");
		System.out.println("vous ete connecter");
	}catch(Exception exp){
	System.out.println(exp);
	}
	}
public static Connection getConnection(){
	if(connection==null)
	       new SingleConnection();
	
	return connection; 
}	
}
