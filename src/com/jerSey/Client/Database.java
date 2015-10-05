package com.jerSey.Client;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public  void establishJDBC() throws ClassNotFoundException
	{
		java.sql.Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		 connection= DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/client","root","root"); 
		 Statement statement = connection.createStatement();
		 String query = "SELECT * FROM data";
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
}
