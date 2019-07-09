package com.kevindickey.kdb.kdb.sql;

import java.sql.Statement;

import com.kevindickey.kdb.kdb.table.DataTable;

public interface SqlProvider {
    public String createTableSql(DataTable table) throws Exception;
    public String dropTableSql(DataTable table, boolean ifExists, boolean shouldCascade) throws Exception;
}