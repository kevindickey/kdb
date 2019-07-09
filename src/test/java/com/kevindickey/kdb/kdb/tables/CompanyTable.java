package com.kevindickey.kdb.kdb.tables;

import com.kevindickey.kdb.kdb.connections.ConnectionProvider;
import com.kevindickey.kdb.kdb.row.DataRowProperties;
import com.kevindickey.kdb.kdb.sql.SqlProvider;
import com.kevindickey.kdb.kdb.table.DataTable;
import com.kevindickey.kdb.kdb.table.DataTableProperties;

@DataTableProperties(Name = "COMPANY")
public class CompanyTable extends DataTable {

    public CompanyTable(SqlProvider provider, ConnectionProvider connectionProvider) throws Exception {
        super(provider, connectionProvider);
    }

    @DataRowProperties
    public CompanyTableRow row;
}