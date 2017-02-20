package com.bo.mvcapp.dao;

import java.util.List;

/*
 * 封装了基本的CRUD方法，以供子类继承使用
 * 当前dao直接在方法中获取数据库连接
 * @param<T>：当前DAO处理的实体类类型
 */
public class DAO<T> {
	
	private Class<T> clazz;
	/*
	 * 返回某个字段的值：如返回customerName,或返回数据表中有多少条记录等
	 * @param sql
	 * @param args
	 * @return
	private List<T> getForValue(String sql,Object ...args){
		return null;
	}
	/*
	 * 放回T所对应的List
	 * @param sql
	 * @args
	 * @return
	private List<T> getForList(String sql,Object ...args){
		return null;
	}
	
	/*
	 * 返回对应的T的一个实例类的对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object ...args){
		return null;
	}
	/*
	 * 该方法封装了 insert,delete,update方法的操作
	 * @param sql:SQL语句
	 * @param args:填充sql语句占位符
	 */
	public void update(String sql,Object ...args){
		
	}
}
