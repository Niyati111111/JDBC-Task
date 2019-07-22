package com.stackroute.jdbc;

import java.sql.*;

public class JdbcTransactionDemo {
    public void jdbcTransaction() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into EmployeeDetails values('Kyle',7,20000000,'female')");
            statement.executeUpdate("insert into EmployeeDetails values('Keanu',8,4000000,'male')");

            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
