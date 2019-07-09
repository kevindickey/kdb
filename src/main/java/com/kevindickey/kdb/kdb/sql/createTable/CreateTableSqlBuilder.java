package com.kevindickey.kdb.kdb.sql.createTable;

import java.lang.reflect.Field;

public interface CreateTableSqlBuilder {
    public String build(String tableName, Field[] fields) throws Exception;
}