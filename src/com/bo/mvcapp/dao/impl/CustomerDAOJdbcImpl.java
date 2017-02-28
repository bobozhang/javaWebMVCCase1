package com.bo.mvcapp.dao.impl;

import java.util.List;

import com.bo.mvcapp.dao.CustomerDAO;
import com.bo.mvcapp.dao.DAO;
import com.bo.mvcapp.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String sql = "select id,name,address ,phone from customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql = "insert into customers(name,address,phone) values(?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		String sql = "select id,name,address ,phone from customers where id = ?";
 		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from customers where id = ?";
		update(sql,id);
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		String sql = "select id,name,address ,phone from customers where name = ?";
 		return getForValue(sql,name);

 	}

}
