package com.createarttechnology.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import com.createarttechnology.dao.IBaseDao;

public class BaseDaoImpl<T> implements IBaseDao<T> {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//����ʵ��
	@Override
	public T get(Class<T> entityType, Serializable id) {
		return (T) getSessionFactory().getCurrentSession()
			.get(entityType, id);
	}

	//����ʵ��
	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession()
			.save(entity);
	}

	//����ʵ��
	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession()
			.saveOrUpdate(entity);
	}

	//ɾ��ʵ��
	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession()
			.delete(entity);
	}

	//����IDɾ��ʵ��
	@Override
	public void delete(Class<T> entityType, Serializable id) {
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityType.getSimpleName() + " en where en.id = ?0")
			.setParameter("0", id)
			.executeUpdate();
	}

	//��ȡ����ʵ��
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> entityType) {
		return (List<T>) find("select en from " + entityType.getSimpleName() + " en");
	}

	//��ȡʵ������
	@Override
	public Long getCount(Class<T> entityType) {
		List<?> l = find("select count(*) from " + entityType.getSimpleName());
		if(l != null && l.size() == 1)
			return (Long)l.get(0);
		return 0L;
	}

	//����HQL����ѯʵ��
	protected List<?> find(String hql) {
		return (List<?>) getSessionFactory().getCurrentSession()
			.createQuery(hql)
			.getResultList();
	}
	
	//���ݴ�ռλ��������HQL����ѯʵ��
	protected List<?> find(String hql, Object ... params) {
		Query query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<?>) query.getResultList();
	}
	
}
