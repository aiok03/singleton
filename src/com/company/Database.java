package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private static Database instance; //the field for storing the singleton instance should be declared static
    private Connection connection;  //connection with db
    private String url = "jdbc:postgresql://localhost:5432/Aruzhan";
    private String username = "postgres";
    private String password = "123";
    private Database() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public static Database getInstance() throws SQLException{   //the static method that controls access to singleton instance
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }

        return instance;

    }

}
