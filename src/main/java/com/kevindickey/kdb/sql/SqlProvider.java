package com.kevindickey.kdb.sql;

import java.sql.Statement;

import com.kevindickey.kdb.table.DataTable;

public interface SqlProvider {
    public String createTableSql(DataTable table) throws Exception;
    public String dropTableSql(DataTable table, boolean ifExists, boolean shouldCascade) throws Exception;
}