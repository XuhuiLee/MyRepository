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
	
	//加载实体
	@Override
	public T get(Class<T> entityType, Serializable id) {
		return (T) getSessionFactory().getCurrentSession()
			.get(entityType, id);
	}

	//保存实体
	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession()
			.save(entity);
	}

	//更新实体
	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession()
			.saveOrUpdate(entity);
	}

	//删除实体
	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession()
			.delete(entity);
	}

	//根据ID删除实体
	@Override
	public void delete(Class<T> entityType, Serializable id) {
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityType.getSimpleName() + " en where en.id = ?0")
			.setParameter("0", id)
			.executeUpdate();
	}

	//获取所有实体
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> entityType) {
		return (List<T>) find("select en from " + entityType.getSimpleName() + " en");
	}

	//获取实体总数
	@Override
	public Long getCount(Class<T> entityType) {
		List<?> l = find("select count(*) from " + entityType.getSimpleName());
		if(l != null && l.size() == 1)
			return (Long)l.get(0);
		return 0L;
	}

	//根据HQL语句查询实体
	protected List<?> find(String hql) {
		return (List<?>) getSessionFactory().getCurrentSession()
			.createQuery(hql)
			.getResultList();
	}
	
	//根据带占位符参数的HQL语句查询实体
	protected List<?> find(String hql, Object ... params) {
		Query query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<?>) query.getResultList();
	}
	
}
