package com.bo.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.lang.reflect.*;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.bo.mvcapp.db.JdbcUtils;
import com.mysql.jdbc.Connection;
import com.sun.org.apache.bcel.internal.generic.Type;

/*
 * 封装了基本的CRUD方法，以供子类继承使用
 * 当前dao直接在方法中获取数据库连接
 * @param<T>：当前DAO处理的实体类类型
 */
public class DAO<T> {
	
	private QueryRunner querRunner = new QueryRunner();
	
	
	//运用反射
	private Class<T> clazz;
	
	public DAO() {
		java.lang.reflect.Type superClass =   getClass().getGenericSuperclass();  //父类带泛型的类型
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) superClass;
			java.lang.reflect.Type[]typeArgs =  parameterizedType.getActualTypeArguments();
			if(typeArgs!=null && typeArgs.length>0){
				if(typeArgs[0] instanceof Class){
					clazz = (Class<T>) typeArgs[0];
				}
			}
		}
 	}
	
	/*
	 * 返回某个字段的值：如返回customerName,或返回数据表中有多少条记录等
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E>E getForValue(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return (E)querRunner.query(connection, sql,new ScalarHandler<T>(),args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
 	}
	/*
	 * 放回T所对应的List
	 * @param sql
	 * @args
	 * @return
	 */
	public List<T> getForList(String sql,Object ...args){
		Connection connection = null;
	    try {
			connection = JdbcUtils.getConnection();
			return  querRunner.query(connection, sql,new BeanListHandler<>(clazz),args);
		} catch (Exception e) {
			e.printStackTrace();
 		}
	    return null;
 	}
	
	/*
	 * 返回对应的T的一个实例类的对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return querRunner.query(connection,sql, new BeanHandler<>(clazz),args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
 	}
	/*
	 * 该方法封装了 insert,delete,update方法的操作
	 * @param sql:SQL语句
	 * @param args:填充sql语句占位符
	 */
	public void update(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			querRunner.update(connection,sql,args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
