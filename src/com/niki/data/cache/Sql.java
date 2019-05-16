package com.niki.data.cache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sql {
    private Connection connection;
    private final String database;

    private Sql(String host, String database, String user, String password) {
        this.database = database;

        String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
        String connectionString = String.format(connectionUrl, host, database, user, password);

        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private static Sql intent;

    public static void init(String host, String database, String user, String password) {
        intent = new Sql(host, database, user, password);
    }

    public static Sql getIntent() {
        return intent;
    }
}

