package com.kevindickey.kdb.sql.dropTable;

public interface DropTableSqlBuilder {
    public String build(String tableName, boolean dropIfExists, boolean shouldCascade) throws Exception;
}