package com.newslive.actions.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	protected Connection getJDDBCConn() throws Exception {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/mytest";
		String userName = "mytest";
		String password = "Password123";
		Class.forName( driver ).newInstance();
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}
	
	protected void closrStmtConn(Statement stmt, Connection con) throws SQLException
	{
		if(stmt != null)
		{
			stmt.close();
		}
		if(con !=null)
		{
		con.close();
		}
	}

}
