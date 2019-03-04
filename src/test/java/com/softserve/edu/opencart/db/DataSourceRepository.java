package com.softserve.edu.opencart.db;

import java.sql.Driver;
import java.sql.SQLException;

public final class DataSourceRepository {
	private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";

	private DataSourceRepository() {
	}

	public static DataSource getDefault() {
		return getMySqlVM();
	}

	public static DataSource getMySqlVM() {
		Driver sqlDriver;
		try {
			sqlDriver = new com.mysql.jdbc.Driver();
			//sqlDriver = new com.mysql.cj.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Develop Custom Exceptions
			throw new RuntimeException(FAILED_JDBC_DRIVER);
		}
		return new DataSource(sqlDriver,
				"jdbc:mysql://http://10.26.34.245:3306/lv374?useSSL=false",
				"lv374", "Lv374_Taqc");
				//System.getenv().get("MY_SQL_LOGIN"),
				//System.getenv().get("MY_SQL_PASSWORD"));
	}

	public static DataSource getSybaseLocalHost() {
		return new DataSource(new net.sourceforge.jtds.jdbc.Driver(),
				"jdbc:jtds:sqlserver://CLASS02/lv326;instance=SQLEXPRESS;",
				"login", "password");
	}
}
