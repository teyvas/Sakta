package com.alatoo.sakta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:postgresql://sakta-do-user-18270856-0.i.db.ondigitalocean.com:25060/defaultdb";
    private static final String USER = "doadmin";
    private static final String PASSWORD = "AVNS_Ly595UDGmkZs5RVU6Sz";

    public static Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void testConnection() {
        try (Connection connection = connect()) {
            if (connection != null) {
                System.out.println("Database connected successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}