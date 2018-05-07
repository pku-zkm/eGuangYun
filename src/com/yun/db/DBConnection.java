package com.yun.db;

import java.sql.*;

public class DBConnection {

    private DBConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL);
            conn.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }


    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection conn;
    private static DBConnection instance;
    private static final String DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:C:/Users/zkm/IdeaProjects/eGuangYun/db/GUANGYUN";

}