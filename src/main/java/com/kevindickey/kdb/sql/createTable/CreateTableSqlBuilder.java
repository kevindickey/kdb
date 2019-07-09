package com.kevindickey.kdb.sql.createTable;

import java.lang.reflect.Field;

public interface CreateTableSqlBuilder {
    public String build(String tableName, Field[] fields) throws Exception;
}