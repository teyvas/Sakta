package com.alatoo.sakta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyJDBC {

    // Database credentials
    private static final String URL = "jdbc:postgresql://sakta-do-user-18270856-0.i.db.ondigitalocean.com:25060/defaultdb";
    private static final String USER = "doadmin";
    private static final String PASSWORD = "AVNS_Ly595UDGmkZs5RVU6Sz";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to check if user exists in the database based on role
    public static boolean validateUser(String username, String password) {
        Connection connection = null;
        boolean isValidUser = false;

        try {
            connection = getConnection();

            // Determine which table to query based on the username
            String table = "";
            if ("user".equalsIgnoreCase(username)) {
                table = "users";  // Query 'users' table if username is 'user'
            } else if ("doctor".equalsIgnoreCase(username)) {
                table = "doctors";  // Query 'doctors' table if username is 'doctor'
            } else {
                return false;  // Invalid username (neither 'user' nor 'doctor')
            }

            // Query the selected table for the given username and password
            String sql = "SELECT * FROM " + table + " WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isValidUser = true;  // User is found and credentials are correct
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isValidUser;
    }


}