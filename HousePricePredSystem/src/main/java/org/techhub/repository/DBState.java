package org.techhub.repository;

import java.sql.*;

//Using this class we can create all detabase Objects 
//and we can reuse this referece veriable by extending this class

public class DBState {
	DBConfig config = DBConfig.getInstance();
	protected Connection conn = config.getConn();
	protected PreparedStatement stmt = config.getStatment();
	protected ResultSet rd = config.getResult();
}
