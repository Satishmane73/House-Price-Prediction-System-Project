package org.techhub.repository;
import java.io.*;
import java.sql.*;
import java.util.*;

//Detabase Connection class

public class DBConfig {
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	private static DBConfig db;
	public DBConfig()
	{
		try {
			//Detabase Connection Logic Using Property File
			Class.forName("com.mysql.cj.jdbc.Driver");
			File f=new File("");
			String path=f.getAbsolutePath();
			FileInputStream inputStream=new FileInputStream(path+"\\src\\main\\resources\\DBConfig.properties");
			Properties p=new Properties();
			p.load(inputStream);
			String driver=p.getProperty("driver");
			String user=p.getProperty("user");
			String pass=p.getProperty("pass");
			String url=p.getProperty("url");
			
			conn=DriverManager.getConnection(url,user,pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DBConfig getInstance()
	{
		if(db==null)
		{
			db=new DBConfig();
		}
		return db;
	}
}
