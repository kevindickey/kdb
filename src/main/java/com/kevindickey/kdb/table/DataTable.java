package com.kevindickey.kdb.table;

import java.sql.SQLException;
import java.sql.Statement;

import com.kevindickey.kdb.connections.ConnectionProvider;
import com.kevindickey.kdb.sql.SqlProvider;


public class DataTable {
    private SqlProvider provider;
    protected String name;
    private ConnectionProvider connectionProvider;

    public DataTable(SqlProvider sqlProvider, ConnectionProvider connectionProvider) throws Exception {
        if(sqlProvider ==  null ) {
            throw new Exception("SqlProvider is null!");
        }

        if(connectionProvider == null) {
            throw new Exception("ConnectionProvider is null!");
        }
        
        this.provider = sqlProvider;
        this.connectionProvider = connectionProvider;
        
        for(DataTableProperties properties : this.getClass().getAnnotationsByType(DataTableProperties.class)) {
            if(properties.Name() == null) {
                throw new Exception("No name set on table!");
            }

            this.name = properties.Name();
        }
    }

    public void create() throws Exception {
        if(this.name == null) {
            throw new Exception("No table name specified");
        }

        String sql = this.provider.createTableSql(this);
        executeSql(sql);
    }

    public void drop(boolean ifExists, boolean shouldCascade) throws Exception {

        String sql = this.provider.dropTableSql(this, ifExists, shouldCascade);
        executeSql(sql);
    }

    private void executeSql(String sql) throws SQLException {
        try (Statement createTableStatement = this.connectionProvider.getConnection().createStatement()) {
            createTableStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String getName() {
        return this.name;
    }
}