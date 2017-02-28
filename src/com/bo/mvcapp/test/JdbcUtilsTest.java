package com.bo.mvcapp.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.bo.mvcapp.db.JdbcUtils;
import com.mysql.jdbc.Connection;

public class JdbcUtilsTest {

	@Test
	public void testGetConnection() throws SQLException {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
 	}

}
