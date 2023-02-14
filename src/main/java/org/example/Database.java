package org.example;

import java.sql.*;


public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database() {
        try {
            String connectionUrl = "jdbc:h2:./DB";
            connection = DriverManager.getConnection(connectionUrl);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection(){
        return connection;
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




