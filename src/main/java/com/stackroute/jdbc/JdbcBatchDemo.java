package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {

    public void jdbcBatch() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.addBatch("insert into EmployeeDetails values('Maine',5,400000,'female')");
            statement.addBatch("insert into EmployeeDetails values('Shawn',6,300000,'male')");

            statement.executeBatch();//executing the batch

            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
