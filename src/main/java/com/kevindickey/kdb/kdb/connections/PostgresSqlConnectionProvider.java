package com.kevindickey.kdb.kdb.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSqlConnectionProvider implements ConnectionProvider {

    private Connection connection;

    @Override
    public Connection connect(String uri, String user, String password) throws SQLException, ClassNotFoundException {
       // Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(uri, user, password);
        return this.getConnection();
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    
    
}