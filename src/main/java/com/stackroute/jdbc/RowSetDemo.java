package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import com.sun.rowset.JdbcRowSetImpl;


public class RowSetDemo {

    public  void rowSet()  {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            JdbcRowSet rowSet = new JdbcRowSetImpl(connection);
            rowSet.setCommand("SELECT * FROM EmployeeDetails");
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println("id: "+rowSet.getString(2)+" name: "+rowSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
