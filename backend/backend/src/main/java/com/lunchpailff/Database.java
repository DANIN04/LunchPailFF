package com.lunchpailff;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static final String URL = System.getProperty("db.url");
    private static final String USER = System.getProperty("db.user");
    private static final String PASSWORD = System.getProperty("db.password");

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to database");
        }
    }
}
