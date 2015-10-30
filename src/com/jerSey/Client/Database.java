package com.jerSey.Client;

import java.sql.DriverManager;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.sql.ResultSet;
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
	
	
	public String parseDeviceInfo(String info) throws JSONException
	{
		JSONObject obj1 = new JSONObject(info);
		System.out.println("*"+obj1);
		
		String ObjectID = "'"+obj1.optString("Object-ID-3")+"'";
		String Manuvalue = "'"+obj1.optString("Manufacture-17")+"'";
		String Module = "'"+obj1.optString("Model-Num-1")+"'";
		String Seriesvalue = "'"+obj1.optString("Serial-Num-2")+"'";
		String Hardware = "'"+obj1.optString("Hardware-18")+"'";
		String ProdDate = "'"+obj1.optString("Produce-Date-13")+"'";
		String ObjInt = "'"+obj1.optString("Object-Instance-1")+"'";
		String Updatetime = "'"+obj1.optString("Update-Time")+"'";
		
		
		
		String query = "("+ObjectID+","+Manuvalue+","+Module+","+Seriesvalue
				+","+Hardware+","+ProdDate+","+ObjInt+","+Updatetime+")";
		
		return query;	
	}
	
	public String readFromClientDB (String clientName)throws ClassNotFoundException
	{
		
		java.sql.Connection connection = null;
		java.sql.ResultSet resultSet = null;
		String ret = "";
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/"+clientName,"root","root"); 
		 Statement statement = connection.createStatement();
	//	 SELECT * FROM watchB.`Product-Info``new_table`
	//	 select* from watchA.`product_info`;
		String query = "select * from "+clientName+".`new_table`;";
		System.out.println(query);
		resultSet =  statement.executeQuery(query);
		ret = getSqlData(resultSet);
		connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
	
	public String getSqlData(ResultSet resultSet) throws SQLException
	{
		String result=""; String ObjectID="";String Manuvalue="";String Module="";String Seriesvalue="";
		String Hardware="";String ProdDate="";String ObjInt=""; String updatetime = "";
		while (resultSet.next()) {
	
			ObjectID = resultSet.getString("Object-ID-3");
			Manuvalue = resultSet.getString("Manufacture-17");
			Module = resultSet.getString("Model-Num-1");
			Seriesvalue = resultSet.getString("Serial-Num-2");
			Hardware = resultSet.getString("Hardware-18");
			ProdDate = resultSet.getString("Produce-Date-13");
			ObjInt = resultSet.getString("Object-Instance-1");
			updatetime = resultSet.getString("Update-Time");
			
		}
		result +="{";
		result+="Object-ID-3:"+ObjectID+",";
		result+="Manufacture-17:"+Manuvalue+",";
		result+="Model-Num-1:"+Module+",";
		result+="Serial-Num-2:"+Seriesvalue+",";
		result+="Hardware-18:"+Hardware+",";
		result+="Produce-Date-13:"+ProdDate+",";
		result+="Object-Instance-1:"+ObjInt+",";
		result+="Update-Time:"+updatetime;
		result +="}";
		return result;	
	}
	
	public void create(String dbname)throws ClassNotFoundException
	{
		
		java.sql.Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/","root","root"); 
		 Statement statement = connection.createStatement();

     	 String query = "CREATE DATABASE "+dbname+";";
		 statement.executeUpdate(query);
		 
		 String buildTable = "CREATE TABLE "+ dbname+".`new_table` ("+
				  "`Object-ID-3` VARCHAR(45) NOT NULL COMMENT '',"+
				  "`Manufacture-17` VARCHAR(45) NULL COMMENT '',"+
				  "`Model_Num-1` VARCHAR(45) NULL COMMENT '',"+
				  "`Serial_Num-2` VARCHAR(45) NULL COMMENT '',"+
				  "`Hardware-18` VARCHAR(45) NULL COMMENT '',"+
				  "`Produce-Date-13` VARCHAR(45) NULL COMMENT '',"+
				  "`Object-Instance-1` VARCHAR(45) NULL COMMENT '',"+
				  "`Update_Time` VARCHAR(45) NULL COMMENT '');";
		 statement.executeUpdate(buildTable);
		 connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	
	public void delete( String clientName)throws ClassNotFoundException
	{
		
		java.sql.Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/","root","root"); 
		 Statement statement = connection.createStatement();
	
		
		String query = "DROP DATABASE " + clientName+";";
		 System.out.println(query);
		 statement.executeUpdate(query);
		 connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	
	public void dropTable (String clientName) throws ClassNotFoundException
	{
		java.sql.Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/","root","root"); 
		 Statement statement = connection.createStatement();
	
		
		String query = "DROP table " + clientName+".`new_table`;";
		 System.out.println(query);
		 statement.executeUpdate(query);
		 connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}	
		
		
		
		
	}

	public void insert(String values, String clientName)throws ClassNotFoundException
	{
		
		java.sql.Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/"+clientName,"root","root"); 
		 Statement statement = connection.createStatement();
		
		 
		String query = "insert into "+ clientName+".`new_table` values "+ values+";";
		System.out.println(query);
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
