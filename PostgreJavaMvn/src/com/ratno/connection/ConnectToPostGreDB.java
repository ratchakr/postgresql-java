package com.ratno.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToPostGreDB {
	
    public static void main(String[] argv) throws SQLException
    {

            System.out.println("-------- PostgreSQL "
                            + "JDBC Connection Testing ------------");

            try {

                    Class.forName("org.postgresql.Driver");

            } catch (ClassNotFoundException e) {

                    System.out.println("Where is your PostgreSQL JDBC Driver? "
                                    + "Include in your library path!");
                    e.printStackTrace();
                    return;

            }

            System.out.println("PostgreSQL JDBC Driver Registered!");

            Connection connection = null;
            Statement st = null;
            ResultSet rs = null;
            String DB_URL = "jdbc:postgresql://localhost:5432/testdb";
            String user = "myadmin";
            String password = "myadmin";

            try {

                    connection = DriverManager.getConnection(DB_URL, user, password);
                    if (connection != null) {
                        System.out.println("You made it, take control your database now!");
                } else {
                        System.out.println("Failed to make connection!");
                        return;
                }                    
                    st = connection.createStatement();
                    // print postgresql version
                    rs = st.executeQuery("SELECT VERSION()");
                    if (rs.next()) {
                    	System.out.println("version := "+rs.getString(1));
                    }
                    
                    // print user defined schema
                    rs = st.executeQuery("SELECT * FROM pg_catalog.pg_tables WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema'");
                    String schema = null;
                    if (rs.next()) {
                    	schema = rs.getString(1);
                        System.out.println("Schema := "+schema);
                    }
                    
                    // print table name in user defined schema
                    rs = st.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = '"+schema+ "';");
                    
                    if (rs.next()) {
                        
                        System.out.println("Table Name := "+rs.getString(1));
                    }


            } catch (SQLException e) {

                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return;

            }



    }

}
