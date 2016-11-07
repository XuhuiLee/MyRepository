package com.createarttechnology.dao.impl;

import java.util.List;
import com.createarttechnology.dao.IArticleThumbDao;
import com.createarttechnology.domain.ArticleThumb;

public class ArticleThumbDaoImpl extends BaseDaoImpl<ArticleThumb> implements IArticleThumbDao {

	@SuppressWarnings("unchecked")
	@Override
	public Boolean existThumb(ArticleThumb articleThumb) {
		String hql = "FROM ArticleThumb WHERE articleId = ?0 AND userId = ?1";
		List<ArticleThumb> list = (List<ArticleThumb>) this.find(hql, articleThumb.getArticleId(), articleThumb.getUserId());
		if(list.isEmpty()) return false;
		else return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long countThumbByArticleId(Integer articleId) {
		String hql = "SELECT COUNT(userId) FROM ArticleThumb WHERE articleId = ?0";
		List<Long> list = (List<Long>) this.find(hql, articleId);
		if(list == null) return 0L;
		else return list.get(0);
	}
	
}
