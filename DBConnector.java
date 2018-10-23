package com.htc.corejava.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

	private static Connection con = null;

	public static Connection getPostgreSQLConnection() throws FileNotFoundException, IOException, SQLException {

		Properties properties = new Properties();
		properties.load(new FileInputStream("DBconfig.properties"));
		con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),properties.getProperty("password"));
		return con;
	}
}
