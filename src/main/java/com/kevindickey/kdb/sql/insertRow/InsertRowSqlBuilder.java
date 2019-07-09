package com.kevindickey.kdb.sql.insertRow;

import com.kevindickey.kdb.row.DataRow;

public interface InsertRowSqlBuilder {
    public String build(String tableName, DataRow data) throws IllegalArgumentException, IllegalAccessException;
}