package com.createarttechnology.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	//����ID����ʵ��
	T get(Class<T> entityType, Serializable id);
	//����ʵ��
	Serializable save(T entity);
	//����ʵ��
	void update(T entity);
	//ɾ��ʵ��
	void delete(T entity);
	//����IDɾ��ʵ��
	void delete(Class<T> entityType, Serializable id);
	//��ȡ����ʵ��
	List<T> getAll(Class<T> entityType);
	//��ȡʵ������
	Long getCount(Class<T> entityType);
	
}
