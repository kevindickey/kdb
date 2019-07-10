package com.kevindickey.kdb.tables;

import com.kevindickey.kdb.field.DataField;
import com.kevindickey.kdb.field.DataFieldProperties;
import com.kevindickey.kdb.field.PostgreSqlDataType;
import com.kevindickey.kdb.row.DataRow;

public class CompanyTableRow extends DataRow {
    @DataFieldProperties(Name = "ID", Type = PostgreSqlDataType.SERIAL, IsNullable = false, IsPrimaryKey = true)
    public DataField<Integer> id = new DataField<>();

    @DataFieldProperties(Name = "NAME", Type = PostgreSqlDataType.TEXT, IsNullable = false)
    public DataField<String> name = new DataField<>();

    @DataFieldProperties(Name = "AGE", Type = PostgreSqlDataType.INTEGER, IsNullable = false)
    public DataField<Integer> age = new DataField<>();

    @DataFieldProperties(Name = "ADDRESS", Type = PostgreSqlDataType.CHARACTER_VARYING, Length = 250)
    public DataField<String> address = new DataField<>();

    @DataFieldProperties(Name = "SALARY", Type = PostgreSqlDataType.REAL, IsNullable = false)
    public DataField<Float> salary = new DataField<>();
}