package com.kevindickey.kdb.sql.insertRow;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;

import com.kevindickey.kdb.connections.ConnectionProvider;
import com.kevindickey.kdb.connections.PostgreSqlConnectionProvider;
import com.kevindickey.kdb.field.DataField;
import com.kevindickey.kdb.field.DataFieldProperties;
import com.kevindickey.kdb.field.PostgreSqlDataType;
import com.kevindickey.kdb.row.DataRow;

public class InsertRowPostgreSqlBuilder implements InsertRowSqlBuilder {

    @Override
    public PreparedStatement build(String tableName, DataRow data, ConnectionProvider connectionProvider)
            throws Exception {
        StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
        sqlBuilder.append(tableName);
        Field[] fields = data.getClass()
                .getFields(); /* Each of these fields is a column in the row we want to insert */

        StringBuilder columnSqlBuilder = new StringBuilder("(");
        StringBuilder valuesSqlBuilder = new StringBuilder("VALUES(");
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            for (DataFieldProperties fldProperties : field.getAnnotationsByType(DataFieldProperties.class)) {
                if (fldProperties.Type().equals(PostgreSqlDataType.BIG_SERIAL)
                        || fldProperties.Type().equals(PostgreSqlDataType.SERIAL)
                        || fldProperties.Type().equals(PostgreSqlDataType.SMALL_SERIAL)) {
                    continue;
                }
                columnSqlBuilder.append(fldProperties.Name());
                valuesSqlBuilder.append("?");

                if (i != fields.length - 1) {
                    columnSqlBuilder.append(", ");
                    valuesSqlBuilder.append(", ");
                }
            }

        }
        columnSqlBuilder.append(")");
        valuesSqlBuilder.append(")");

        sqlBuilder.append(columnSqlBuilder.toString()).append(" ").append(valuesSqlBuilder.toString()).append(";");

        PreparedStatement insertStatement = connectionProvider.getConnection().prepareStatement(sqlBuilder.toString());

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            for (DataFieldProperties fldProperties : field.getAnnotationsByType(DataFieldProperties.class)) {
                /*
                 * If the field value is null and the field is not nullable, don't include it!
                 */
                switch (fldProperties.Type()) {
                case BIG_INT:
                    DataField<Long> bigInt = (DataField<Long>) field.get(data);
                    insertStatement.setLong(i, bigInt.getValue());
                    break;
                case BIG_SERIAL:
                    /* skip this */
                    break;
                case BIT:
                    DataField<Boolean> bit = (DataField<Boolean>) field.get(data);
                    insertStatement.setBoolean(i, bit.getValue());
                    break;
                case BIT_VARYING:
                    DataField<Object> bitVar = (DataField<Object>) field.get(data);
                    insertStatement.setObject(i, bitVar.getValue());
                    break;
                case BOOLEAN:
                    DataField<Boolean> boolVal = (DataField<Boolean>) field.get(data);
                    insertStatement.setBoolean(i, boolVal.getValue());
                case BOX:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case BYTEA:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case CHARACTER:
                case CHARACTER_VARYING:
                    DataField<String> charVal = (DataField<String>) field.get(data);
                    insertStatement.setString(i, charVal.getValue());
                    break;
                case CIDR:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case CIRCLE:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case DATE:
                    DataField<Date> dateVal = (DataField<Date>) field.get(data);
                    insertStatement.setDate(i, dateVal.getValue());
                    break;
                case DOUBLE_PRECISION:
                    DataField<Double> doublePrecVal = (DataField<Double>) field.get(data);
                    insertStatement.setDouble(i, doublePrecVal.getValue());
                case INET:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case INTEGER:
                    DataField<Integer> intVal = (DataField<Integer>) field.get(data);
                    insertStatement.setInt(i, intVal.getValue());
                    break;
                case INTERVAL:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case JSON:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case JSONB:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case LINE:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case LSEG:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case MACADRR:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case MACADRR8:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case MONEY:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case NUMERIC:
                    DataField<BigDecimal> bigDecVal = (DataField<BigDecimal>) field.get(data);
                    insertStatement.setBigDecimal(i, bigDecVal.getValue());
                    break;
                case PATH:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case PG_LSN:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case POINT:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case POLYGON:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case REAL:
                    DataField<Float> floatVal = (DataField<Float>) field.get(data);
                    insertStatement.setFloat(i, floatVal.getValue());
                    break;
                case SMALL_INT:
                    DataField<Integer> smallIntVal = (DataField<Integer>) field.get(data);
                    insertStatement.setFloat(i, smallIntVal.getValue());
                    break;
                case SMALL_SERIAL:
                case SERIAL:
                    break;
                case TEXT:
                    DataField<String> textVal = (DataField<String>) field.get(data);
                    insertStatement.setString(i, textVal.getValue());
                    break;
                case TIME:
                case TIME_Z:
                    DataField<Time> timeVal = (DataField<Time>) field.get(data);
                    insertStatement.setTime(i, timeVal.getValue());
                    break;
                case TIMESTAMP:
                case TIMESTAMP_Z:
                    DataField<Timestamp> timestampVal = (DataField<Timestamp>) field.get(data);
                    insertStatement.setTimestamp(i, timestampVal.getValue());
                    break;
                case TSQUERY:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case TSVECTOR:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case TXID_SNAPSHOT:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case UUID:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                case XML:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                default:
                    throw new Exception(fldProperties.Type().getDataType() + " has not yet been implemented!");
                }
            }
        }

        
        return insertStatement;
    }

}