package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB implements IDB {
    String login = "postgres";
    String password = "Giant_Tuzik2002";
    @Override
    public Connection getConnection() {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connectionURL, login, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
