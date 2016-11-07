package com.createarttechnology.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	//根据ID加载实体
	T get(Class<T> entityType, Serializable id);
	//保存实体
	Serializable save(T entity);
	//更新实体
	void update(T entity);
	//删除实体
	void delete(T entity);
	//根据ID删除实体
	void delete(Class<T> entityType, Serializable id);
	//获取所有实体
	List<T> getAll(Class<T> entityType);
	//获取实体总数
	Long getCount(Class<T> entityType);
	
}
