package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB implements IDB {
    String login = "postgres";
    String password = "Giant_Tuzik2002";
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(connectionURL, login, password);
            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
