package com.carrental.db.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {

	 private static Connection connection = null;
	     public static Connection getConnection() {
	    	 System.out.println(" getConnection Called");
	         if (connection != null)
	             return connection;
	         else {
	             try {
	              Properties prop = new Properties();
	                 InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/DBConfig.properties");
	                 prop.load(inputStream);
	                 String driver = prop.getProperty("driver");
	                 String url = prop.getProperty("url");
	                 String user = prop.getProperty("user");
	                 String password = prop.getProperty("password");
	                 Class.forName(driver);
	                 connection = DriverManager.getConnection(url, user, password);
	                 System.out.println("Connection to postgresqlDB is Successful");
	             } catch (ClassNotFoundException e) {
	                 e.printStackTrace();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             } catch (FileNotFoundException e) {
	                 e.printStackTrace();
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	             return connection;
	         }
	  

	     }
	
	
}
