package com.kevindickey.kdb.kdb.sql.dropTable;

public interface DropTableSqlBuilder {
    public String build(String tableName, boolean dropIfExists, boolean shouldCascade) throws Exception;
}