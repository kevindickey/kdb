package com.kevindickey.kdb.kdb.connections;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionProvider {
    Connection connect(String uri, String user, String password) throws SQLException, ClassNotFoundException;
    Connection getConnection();
}