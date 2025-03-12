package org.techhub.repository;

import java.io.*;
import java.sql.*;
import java.util.*;

//Database Connection class

public class DBConfig {
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	protected static CallableStatement cstmt;
	private static DBConfig db;

	public DBConfig() {
		try {
			// Database Connection Logic Using Property File
			Class.forName("com.mysql.cj.jdbc.Driver");
			File f = new File("");
			String path = f.getAbsolutePath();
			FileInputStream inputStream = new FileInputStream(path + "\\src\\main\\resources\\DBConfig.properties");
			Properties p = new Properties();
			p.load(inputStream);
			String driver = p.getProperty("driver");
			String user = p.getProperty("user");
			String pass = p.getProperty("pass");
			String url = p.getProperty("url");

			conn = DriverManager.getConnection(url, user, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DBConfig getInstance() {
		if (db == null) {
			db = new DBConfig();
		}
		return db;
	}

	public static Connection getConn() {
		return conn;
	}

	public static PreparedStatement getStatment() {
		return stmt;
	}

	public static ResultSet getResult() {
		return rs;
	}
	public static CallableStatement getCallStatement()
	{
		return cstmt;
	}
}
