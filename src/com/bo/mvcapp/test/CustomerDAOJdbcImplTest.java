package com.bo.mvcapp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bo.mvcapp.dao.CustomerDAO;
import com.bo.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.bo.mvcapp.domain.Customer;

public class CustomerDAOJdbcImplTest {
	
	CustomerDAO customerDao = new CustomerDAOJdbcImpl(); 
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInteger() {
		Customer cust = customerDao.get(1);
		System.out.println(cust);
 	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCountWithName() {
		fail("Not yet implemented");
	}

}
