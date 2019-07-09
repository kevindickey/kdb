package com.kevindickey.kdb;

import java.sql.SQLException;

import com.kevindickey.kdb.connections.PostgreSqlConnectionProvider;
import com.kevindickey.kdb.sql.PostgreSqlProvider;
import com.kevindickey.kdb.tables.CompanyTable;
import com.kevindickey.kdb.tables.CompanyTableRow;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgreSqlTests {
	private static PostgreSqlConnectionProvider connectionProvider;
	private static PostgreSqlProvider sqlProvider;

	@Test
	public void createTableTest() throws Exception {
		CompanyTable table = new CompanyTable(sqlProvider, connectionProvider);
		table.create();
	}


	@Test
	public void dropTableTableTest() throws Exception {
		CompanyTable table = new CompanyTable(sqlProvider, connectionProvider);
		table.drop(true, false);
	}

	@Test
	public void insertIntoTableTest() throws Exception {
		CompanyTable table = new CompanyTable(sqlProvider, connectionProvider);
		CompanyTableRow insertRowData = new CompanyTableRow();
		insertRowData.id.setValue(123);
		
	}


	@BeforeClass
	public static void connect() throws ClassNotFoundException, SQLException {
		PostgreSqlTests.sqlProvider = new PostgreSqlProvider();
		PostgreSqlTests.connectionProvider = new PostgreSqlConnectionProvider();
		connectionProvider.connect("jdbc:postgresql://localhost:5432/postgres", "postgres", "password123");
	}
}
