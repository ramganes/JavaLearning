package com.learning;

import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.util.H2DBConnection;
import com.learning.util.LoginDTO;

@Service
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private H2DBConnection dbConnection;

	@Override
	public void updateLoginDetails(String loginDetails) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginDaoImpl***");
		ObjectMapper mapper = new ObjectMapper();
		LoginDTO loginDTO = mapper.readValue(loginDetails, LoginDTO.class);
		Statement statement = dbConnection.getConnection();
		//statement.execute("create table login (username varchar(255), password varchar(255))");
		statement.execute("insert into login (username, password) values ('"+loginDTO.getUserName()+"','"+loginDTO.getPassword()+"')");
		ResultSet rs = statement.executeQuery("select * from login");
		while (rs.next()) {
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
		}
	}

	public H2DBConnection getDbConnection() {
		return dbConnection;
	}

}
