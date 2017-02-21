package com.bo.mvcapp.dao;

import java.util.List;

import com.bo.mvcapp.domain.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	/*
	 * 返回和name相等的名字的个数
	 */
	public long getCountWithName(String name);
}
