package com.kevindickey.kdb.sql;

import java.sql.PreparedStatement;
import java.sql.Statement;

import com.kevindickey.kdb.connections.ConnectionProvider;
import com.kevindickey.kdb.row.DataRow;
import com.kevindickey.kdb.table.DataTable;

public interface SqlProvider {
    public String createTableSql(DataTable table) throws Exception;
    public String dropTableSql(DataTable table, boolean ifExists, boolean shouldCascade) throws Exception;
    public PreparedStatement insertRowSql(DataTable table, DataRow row, ConnectionProvider connectionProvider) throws IllegalArgumentException, IllegalAccessException, Exception;
}