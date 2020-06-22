package com.hibernate.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ishtiaque on 6/22/2020.
 */
public class HibernateDemoApplication {

    public static void main(String args[]){

        String jdbcUrl = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
