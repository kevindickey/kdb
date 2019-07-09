package com.kevindickey.kdb;

import java.sql.SQLException;

import com.kevindickey.kdb.connections.PostgresSqlConnectionProvider;
import com.kevindickey.kdb.sql.PostgreSqlProvider;
import com.kevindickey.kdb.tables.CompanyTable;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgreSqlTests {
	private static PostgresSqlConnectionProvider connectionProvider;
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

	@BeforeClass
	public static void connect() throws ClassNotFoundException, SQLException {
		PostgreSqlTests.sqlProvider = new PostgreSqlProvider();
		PostgreSqlTests.connectionProvider = new PostgresSqlConnectionProvider();
		connectionProvider.connect("jdbc:postgresql://localhost:5432/postgres", "postgres", "password123");

		
	}
}
