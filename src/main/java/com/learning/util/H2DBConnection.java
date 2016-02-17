package com.learning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class H2DBConnection {
	
	public Statement getConnection() throws Exception {
		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/h2testDB");
		Statement statement = conn.createStatement();
		return statement;
		
	}
	
	public void closeConnection(Connection conn, Statement statement) throws Exception {
		statement.close();
		conn.close();
	}
}
