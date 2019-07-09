package com.kevindickey.kdb.sql.insertRow;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.kevindickey.kdb.field.DataField;
import com.kevindickey.kdb.field.DataFieldProperties;
import com.kevindickey.kdb.row.DataRow;

public class InsertRowPostgreSqlBuilder implements InsertRowSqlBuilder {

    @Override
    public String build(String tableName, DataRow data) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
        sqlBuilder.append(tableName).append(" ");
        Field[] fields = data.getClass().getFields(); /*Each of these fields is a column in the row we want to insert*/
        sqlBuilder.append("(");

        for(int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            for(DataFieldProperties fldProperties : field.getAnnotationsByType(DataFieldProperties.class)) {
                /*If the field value is null and the field is not nullable, don't include it!*/
                if(fldProperties.Type().equals("INT")) {
                    DataField<Integer> dataField = (DataField<Integer>)field.get(data);
                    System.out.println(dataField.getValue());
                }

            }
                
        }


        return sqlBuilder.toString();
    }

}