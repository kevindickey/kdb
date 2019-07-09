package com.kevindickey.kdb.kdb.sql.createTable;

import java.lang.reflect.Field;

import com.kevindickey.kdb.kdb.field.DataFieldProperties;

public class CreateTablePostgreSqlBuilder implements CreateTableSqlBuilder {

    @Override
    public String build(String tableName, Field[] fields) throws Exception {
        StringBuilder sqlStatement = new StringBuilder("CREATE TABLE ").append(tableName).append(" ");
        sqlStatement.append("(");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            for (DataFieldProperties fieldProperties : field.getAnnotationsByType(DataFieldProperties.class)) {
                validateFieldProperties(fieldProperties);
                buildFieldSql(sqlStatement, fields, i, fieldProperties);
            }
        }

        sqlStatement.append(")");

        return sqlStatement.toString();
    }

    private void validateFieldProperties(DataFieldProperties fieldProperties) throws Exception {
        if (fieldProperties.Name() == null) {
            throw new Exception("Field specified no name!");
        }

        if (fieldProperties.Type() == null) {
            throw new Exception("Field specified no type: " + fieldProperties.Name());
        }
    }

    private void buildFieldSql(StringBuilder sqlStatement, Field[] fields, int i, DataFieldProperties fieldProperties) {
        sqlStatement.append(fieldProperties.Name()).append(" ");
        sqlStatement.append(fieldProperties.Type()).append(" ");

        if (fieldProperties.Length() > 0) {
            sqlStatement.append("(").append(fieldProperties.Length()).append(")");
        }

        if (fieldProperties.IsPrimaryKey()) {
            sqlStatement.append("PRIMARY KEY").append(" ");
        }

        if (!fieldProperties.IsNullable()) {
            sqlStatement.append("NOT NULL");
        }

        if (i != fields.length - 1) { // if this is true, this is the last field - don't add a comma at the end
            sqlStatement.append(", ");
        }
    }

}