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
				 "jdbc:mysql://localhost:3306/client","root","102012"); 
		 Statement statement = connection.createStatement();
		 String query = "SELECT * FROM employee";
		 ResultSet result = statement.executeQuery(query);
		 while (result.next()){
			 System.out.println(result.getInt("ID"));
			 System.out.println(result.getString("NAME"));
			 System.out.println(result.getInt("SALARY")); 
		 }
		 connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
