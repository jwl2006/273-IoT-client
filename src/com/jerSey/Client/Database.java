package com.jerSey.Client;

import java.sql.DriverManager;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public String parseData(String info) throws JSONException
	{
		JSONObject obj1 = new JSONObject(info);
		System.out.println(obj1);
		
		String IDvalue = "'"+obj1.optString("ID")+"'";
		String Manuvalue = "'"+obj1.optString("Manufacture")+"'";
		String Datevalue = "'"+obj1.optString("Date")+"'";
		String Productvalue = "'"+obj1.optString("ProductID")+"'";
		String Urivalue = "'"+obj1.optString("URI")+"'";
		String query = "("+IDvalue+","+Manuvalue+","+Datevalue+","+Productvalue
				+","+Urivalue+")";
		return query;	
	}
	
	public void insert(String values)throws ClassNotFoundException
	{
		
		java.sql.Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/client","root","root"); 
		 Statement statement = connection.createStatement();
		
		 
		String query = "insert into data value "+values+";";
		 statement.executeUpdate(query);
	
		 connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public void delete(String value)throws ClassNotFoundException
	{
		
		java.sql.Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/client","root","root"); 
		 Statement statement = connection.createStatement();
	
		 
		String query = "delete from data where ID=" + "'" +value +"';";
	
		 statement.executeUpdate(query);
	
		 connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	/*
	public  void establishJDBC() throws ClassNotFoundException
	{
		java.sql.Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/client","root","root"); 
		 Statement statement = connection.createStatement();
		 String query = "select * from data;";
		 ResultSet result = statement.executeQuery(query);
		 while (result.next()){
			 System.out.println(result.getString("ID"));
			 System.out.println(result.getString("Manufacture"));
			 System.out.println(result.getString("Product_ID"));
			 System.out.println(result.getString("DATE")); 
			 System.out.println(result.getString("URI")); 
		 }
		 connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	*/
	
}
