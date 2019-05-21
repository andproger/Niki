package com.niki.data.cache.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {
    private Connection connection;
    private final String database;

    private SqlConnector(String host, String database, String user, String password) {
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

    private static SqlConnector intent;

    public static void init(String host, String database, String user, String password) {
        intent = new SqlConnector(host, database, user, password);
    }

    public static SqlConnector getIntent() {
        return intent;
    }
}

