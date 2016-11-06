package com.createarttechnology.dao.impl;

import java.io.Serializable;
import java.util.List;
import com.createarttechnology.dao.IArticleCommentDao;
import com.createarttechnology.domain.ArticleComment;

public class ArticleCommentDaoImpl extends BaseDaoImpl<ArticleComment>  implements IArticleCommentDao {
	
	@Override
	public Serializable save(ArticleComment acm) {
		Integer new_floor = getMaxFloorByArticleId(acm.getArticleId()) + 1;
		acm.setFloor(new_floor);
		return super.save(acm);
	}

	@Override
	public Integer getMaxFloorByArticleId(Integer id) {
		String hql = "SELECT MAX(floor) FROM ArticleComment WHERE articleId = ?0";
		List<?> list = this.find(hql, id);
		if(list == null) return 0;
		return (Integer) list.get(0);
	}

	@Override
	public Integer countCommentsByArticleId(Integer id) {
		String hql = "SELECT COUNT(floor) FROM ArticleComment WHERE articleId = ?0";
		List<?> list = this.find(hql, id);
		if(list == null) return 0;
		return (Integer) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleComment> getAllCommentsByArticleId(Integer id) {
		String hql = "FROM ArticleComment WHERE articleId = ?0 ORDER BE floor";
		List<ArticleComment> list = (List<ArticleComment>) this.find(hql, id);
		return list;
	}

}
