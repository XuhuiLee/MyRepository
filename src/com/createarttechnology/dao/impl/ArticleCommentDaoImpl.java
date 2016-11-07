package com.createarttechnology.dao.impl;

import java.util.List;

import com.createarttechnology.dao.IArticleCommentDao;
import com.createarttechnology.domain.ArticleComment;

public class ArticleCommentDaoImpl extends BaseDaoImpl<ArticleComment>  implements IArticleCommentDao {
	
	@Override
	public Long getMaxFloorByArticleId(Integer articleId) {
		String hql = "SELECT MAX(floor) FROM ArticleComment WHERE articleId = ?0";
		List<?> list = this.find(hql, articleId);
		if(list == null) return 0L;
		return (Long) list.get(0);
	}

	@Override
	public Long countCommentsByArticleId(Integer articleId) {
		String hql = "SELECT COUNT(floor) FROM ArticleComment WHERE articleId = ?0";
		List<?> list = this.find(hql, articleId);
		if(list == null) return 0L;
		return (Long) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleComment> getAllCommentsByArticleId(Integer articleId) {
		String hql = "FROM ArticleComment WHERE articleId = ?0 ORDER BE floor";
		List<ArticleComment> list = (List<ArticleComment>) this.find(hql, articleId);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleComment> getAllCommentsByUserId(Integer userId) {
		String hql = "FROM ArticleComment WHERE userId = ?0";
		List<ArticleComment> list = (List<ArticleComment>) this.find(hql, userId);
		return list;
	}

}
