package com.kevindickey.kdb.kdb.sql;

import java.lang.reflect.Field;
import java.util.Optional;

import com.kevindickey.kdb.kdb.row.DataRowProperties;
import com.kevindickey.kdb.kdb.sql.createTable.CreateTablePostgreSqlBuilder;
import com.kevindickey.kdb.kdb.sql.dropTable.DropTablePostgreSqlBuilder;
import com.kevindickey.kdb.kdb.table.DataTable;

public class PostgreSqlProvider implements SqlProvider {

    private final CreateTablePostgreSqlBuilder createTableSqlBuilder = new CreateTablePostgreSqlBuilder();
    private final DropTablePostgreSqlBuilder dropTableSqlBuilder = new DropTablePostgreSqlBuilder();

    @Override
    public String createTableSql(DataTable table) throws Exception {
        Field[] fields = getFieldsAndValidate(table).get();

        return createTableSqlBuilder.build(table.getName(), fields);
    }

    @Override
    public String dropTableSql(DataTable table, boolean ifExists, boolean shouldCascade) throws Exception {
        getFieldsAndValidate(table);

        return this.dropTableSqlBuilder.build(table.getName(), ifExists, shouldCascade);
    }

    private Optional<Field[]> getFieldsAndValidate(DataTable table) throws Exception {
        Optional<Field[]> fields = findDataRow(table);
        validateFieldsAndTable(table, fields);

        return fields;
    }

    private void validateFieldsAndTable(DataTable table, Optional<Field[]> fields) throws Exception {
        if (table.getName() == null || table.getName().isEmpty() || !fields.isPresent() && fields.get().length <= 0) {
            throw new Exception("Table is not valid! " + table.getName());
        }
    }

    private Optional<Field[]> findDataRow(DataTable table) {
        for (Field field : table.getClass().getFields()) {
            if (field.isAnnotationPresent(DataRowProperties.class)) {
                return Optional.of(field.getType().getFields());
            }
        }
        return Optional.empty();
    }
}