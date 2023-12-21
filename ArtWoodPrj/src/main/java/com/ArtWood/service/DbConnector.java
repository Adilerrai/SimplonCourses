package com.ArtWood.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/artwoodsorders";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    private static final DbConnector instance = new DbConnector();

    private DbConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load JDBC driver.");
        }
    }

    public static DbConnector getInstance() {
        return instance;
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to obtain a database connection.");
        }
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
