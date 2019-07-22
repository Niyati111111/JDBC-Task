package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public  void resultSetMetadata(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");

            PreparedStatement preparedStatement=connection.prepareStatement("select * from EmployeeDetails");
            ResultSet resultSet=preparedStatement.executeQuery();
            ResultSetMetaData metaData=resultSet.getMetaData();

            System.out.println("Total columns: "+metaData.getColumnCount());
            System.out.println("Column Name of 1st column: "+metaData.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+metaData.getColumnTypeName(1));

            connection.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
