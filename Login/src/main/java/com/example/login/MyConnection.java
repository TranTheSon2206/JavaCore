package com.example.login;

import  java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getMyConnection() throws SQLException {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/aptech";
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
}

