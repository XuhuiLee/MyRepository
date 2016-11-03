package com.createarttechnology.dao.impl;

import java.util.List;
import com.createarttechnology.dao.IArticleThumbDao;
import com.createarttechnology.dao.IBaseDao;
import com.createarttechnology.domain.ArticleThumb;
import com.createarttechnology.domain.UserInfo;

public class ArticleThumbDaoImpl implements IArticleThumbDao {

	private IBaseDao base;
	
	public void setBase(IBaseDao base) {
		this.base = base;
	}

	@Override
	public boolean saveArticleThumb(ArticleThumb at) {
		boolean success = false;
		if(base.getSession().save(at) != null) {
			success = true;
		}
		base.closeSession();
		return success;
	}

	@Override
	public void deleteArticleThumb(ArticleThumb at) {
		base.getSession().delete(at);
		base.closeSession();
	}

	@Override
	public void updateArticleThumb(ArticleThumb at) {
		base.getSession().update(at);
		base.closeSession();
	}

	@Override
	public boolean existArticleThumb(ArticleThumb at) {
		List<UserInfo> list = base.query("FROM ArticleThumb WHERE articleId =" + at.getArticleId() + " AND userId = " + at.getUserId());
		if(list.isEmpty()) return false;
		else return true;
	}

	@Override
	public Long countArticleThumb(Integer articleId) {
		List result = base.query("SELECT COUNT(userId) FROM ArticleThumb WHERE articleId =" + articleId);
		Long count;
		if(result == null) count = (long) 0;
		else count = (Long) (result.get(0));
		return count;
	}
	
}
