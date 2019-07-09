package com.kevindickey.kdb.sql.insertRows;

import java.util.List;

import com.kevindickey.kdb.row.DataRow;

public interface InsertRowsSqlBuilder {
    String build(String tableName, List<DataRow> data);
}