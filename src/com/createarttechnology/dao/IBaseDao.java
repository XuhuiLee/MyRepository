package com.createarttechnology.dao;

import java.util.List;
import org.hibernate.Session;

public interface IBaseDao {
	public Session getSession();
	public void closeSession();
	public List query(String hql);
	public Object unique(String hql);
}
