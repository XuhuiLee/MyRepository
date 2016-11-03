package com.createarttechnology.dao.impl;

import java.util.List;
import com.createarttechnology.dao.IArticleCommentDao;
import com.createarttechnology.dao.IBaseDao;
import com.createarttechnology.domain.ArticleComment;

public class ArticleCommentDaoImpl implements IArticleCommentDao {
	
	private IBaseDao base;
	
	public void setBase(IBaseDao base) {
		this.base = base;
	}

	@Override
	public boolean saveArticleComment(ArticleComment acm) {
		boolean success = false;
		Integer floor = getMaxFloor(acm.getArticleId()) + 1;
		acm.setFloor(floor);
		if(base.getSession().save(acm) != null) {
			success = true;
		}
		base.closeSession();
		return success;
	}

	@Override
	public void deleteArticleComment(ArticleComment acm) {
		base.getSession().delete(acm);
		base.closeSession();
	}

	@Override
	public void updateArticleComment(ArticleComment acm) {
		base.getSession().update(acm);
		base.closeSession();
	}

	@Override
	public ArticleComment getArticleComment(Integer id) {
		ArticleComment acm = base.getSession().get(ArticleComment.class, id);
		base.closeSession();
		return acm;
	}

	@Override
	public List<ArticleComment> getAllArticleComments(Integer id) {
		List<ArticleComment> list = base.query("FROM ArticleComment WHERE articleId = " + id + " ORDER BY floor");
		return list;
	}

	@Override
	public Integer getMaxFloor(Integer id) {
		Integer count = (Integer) base.unique("SELECT MAX(floor) FROM ArticleComment WHERE articleId = " + id);
		if(count == null) count = 0;
		return count;
	}
	
}
