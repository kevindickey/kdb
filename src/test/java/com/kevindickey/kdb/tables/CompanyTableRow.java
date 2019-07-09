package com.kevindickey.kdb.tables;

import com.kevindickey.kdb.field.DataField;
import com.kevindickey.kdb.field.DataFieldProperties;
import com.kevindickey.kdb.row.DataRow;

public class CompanyTableRow extends DataRow {
    @DataFieldProperties(Name = "ID", Type = "INT", IsNullable = false, IsPrimaryKey = true)
    public DataField<Integer> id = new DataField<>();

    @DataFieldProperties(Name = "NAME", Type = "TEXT", IsNullable = false)
    public DataField<String> name = new DataField<>();

    @DataFieldProperties(Name = "AGE", Type = "INT", IsNullable = false)
    public DataField<Integer> age = new DataField<>();

    @DataFieldProperties(Name = "ADDRESS", Type = "CHAR", Length = 250)
    public DataField<String> address = new DataField<>();

    @DataFieldProperties(Name = "SALARY", Type = "REAL", IsNullable = false)
    public DataField<Float> salary = new DataField<>();
}