package com.bo.mvcapp.db;

import javax.sql.*;

import java.sql.*;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;

public class JdbcUtils {

	public static void releaseConnection(Connection connection){
		try{
			if(connection != null){
				connection.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//数据源只有一个
	private static DataSource dataSource = null;
	
	static{
		//数据源只能被创建一次
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	public static Connection getConnection() throws SQLException{
		return  (Connection) dataSource.getConnection();
	}
}
