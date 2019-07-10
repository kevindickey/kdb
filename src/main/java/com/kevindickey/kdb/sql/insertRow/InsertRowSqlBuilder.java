package com.kevindickey.kdb.sql.insertRow;

import java.sql.PreparedStatement;

import com.kevindickey.kdb.connections.ConnectionProvider;
import com.kevindickey.kdb.connections.PostgreSqlConnectionProvider;
import com.kevindickey.kdb.row.DataRow;

public interface InsertRowSqlBuilder {
    public PreparedStatement build(String tableName, DataRow data, ConnectionProvider connectionProvider) throws IllegalArgumentException, IllegalAccessException, Exception;
}