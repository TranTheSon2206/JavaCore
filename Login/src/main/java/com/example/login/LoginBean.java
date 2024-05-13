package com.example.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Connection;

public class LoginBean {
    private Connection connection;

    public LoginBean() throws SQLException {
        // Khởi tạo kết nối tại constructor
        connection = MyConnection.getMyConnection();
    }

    public boolean checkLogin(String username, String password) throws SQLException {
        boolean isValid = false;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
