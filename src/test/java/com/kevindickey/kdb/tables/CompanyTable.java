package com.kevindickey.kdb.tables;

import com.kevindickey.kdb.connections.ConnectionProvider;
import com.kevindickey.kdb.row.DataRowProperties;
import com.kevindickey.kdb.sql.SqlProvider;
import com.kevindickey.kdb.table.DataTable;
import com.kevindickey.kdb.table.DataTableProperties;

@DataTableProperties(Name = "COMPANY")
public class CompanyTable extends DataTable {

    public CompanyTable(SqlProvider provider, ConnectionProvider connectionProvider) throws Exception {
        super(provider, connectionProvider);
    }

    @DataRowProperties
    public CompanyTableRow row;
}