package com.kevindickey.kdb.kdb.tables;

import com.kevindickey.kdb.kdb.field.DataField;
import com.kevindickey.kdb.kdb.field.DataFieldProperties;
import com.kevindickey.kdb.kdb.row.DataRow;

public class CompanyTableRow extends DataRow {
    @DataFieldProperties(Name = "ID", Type = "INT", IsNullable = false, IsPrimaryKey = true)
    public DataField<Integer> id;

    @DataFieldProperties(Name = "NAME", Type = "TEXT", IsNullable = false)
    public DataField<String> name;

    @DataFieldProperties(Name = "AGE", Type = "INT", IsNullable = false)
    public DataField<Integer> age;

    @DataFieldProperties(Name = "ADDRESS", Type = "CHAR", Length = 250)
    public DataField<String> address;

    @DataFieldProperties(Name = "SALARY", Type = "REAL", IsNullable = false)
    public DataField<Float> salary;
}