package com.createarttechnology.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.createarttechnology.dao.IBaseDao;

public class BaseDaoImpl implements IBaseDao {
	
	private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    public BaseDaoImpl() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public void init() {
    	if(session != null && session.isOpen()) {
    	}
    	else {
    		session = sessionFactory.openSession();
    	}
		if(transaction != null && transaction.isActive()) transaction.rollback();
		transaction = session.beginTransaction();
    }
    
	@Override
	public Session getSession() {
		init();
		return session;
	}

	@Override
	public void closeSession() {
		if(session.isOpen()) {
			transaction.commit();
		}
	}

	@Override
	public List query(String hql) {
        Session session = getSession();
        List list = session.createQuery(hql).getResultList();
        closeSession();
		return list;
	}

	@Override
	public Object unique(String hql) {
        Session session = getSession();
        Object result;
        result = session.createQuery(hql).getSingleResult();
        closeSession();
        return result;
	}
}
