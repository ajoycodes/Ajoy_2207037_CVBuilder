package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:cv.db";

    static {
        try (Connection c = getConnection();
             Statement s = c.createStatement()) {
            s.executeUpdate(
                    "create table if not exists cv (" +
                            "id integer primary key autoincrement," +
                            "data text not null" +
                            ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}