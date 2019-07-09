package com.kevindickey.kdb.sql.dropTable;

public class DropTablePostgreSqlBuilder implements DropTableSqlBuilder {

    @Override
    public String build(String tableName, boolean dropIfExists, boolean shouldCascade) throws Exception {
        if(tableName == null) {
            throw new Exception("Table name is null!");
        }

        StringBuilder sqlStatement = new StringBuilder("DROP TABLE ");
        if(dropIfExists) {
            sqlStatement.append("IF EXISTS").append(" ");
        }

        sqlStatement.append(tableName).append(" ");

        if(shouldCascade) {
            sqlStatement.append("CASCADE").append(" ");
        } else {
            sqlStatement.append("RESTRICT").append(" ");
        }

        sqlStatement.append(";");

        return sqlStatement.toString();
    }
    
}