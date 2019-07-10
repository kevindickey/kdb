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
	public void createAndDropTableTest() throws Exception {
		CompanyTable table = new CompanyTable(sqlProvider, connectionProvider);
		table.create();
		table.drop(true, false);

	}

	@Test
	public void insertIntoTableTest() throws Exception {
		CompanyTable table = new CompanyTable(sqlProvider, connectionProvider);
		table.create();
		CompanyTableRow insertRowData = new CompanyTableRow();
		insertRowData.id.setValue(123);
		insertRowData.address.setValue("6561 South Nod Hill Road #22, Cottonwood Heights, UT 84121; drop table company;");
		insertRowData.name.setValue("Sophia Ducroisy");
		insertRowData.salary.setValue((float)840_000);
		insertRowData.age.setValue(28);

		table.insertRow(insertRowData);
		table.drop(true, false);
	}




	@BeforeClass
	public static void connect() throws ClassNotFoundException, SQLException {
		PostgreSqlTests.sqlProvider = new PostgreSqlProvider();
		PostgreSqlTests.connectionProvider = new PostgreSqlConnectionProvider();
		connectionProvider.connect("jdbc:postgresql://localhost:5432/postgres", "postgres", "password123");
	}
}
