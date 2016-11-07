package com.createarttechnology.service.impl;

import java.util.List;

import com.createarttechnology.dao.IArticleCommentDao;
import com.createarttechnology.domain.ArticleComment;
import com.createarttechnology.service.IArticleCommentService;

public class ArticleCommentServiceImpl implements IArticleCommentService {

	private IArticleCommentDao articleCommentDao;
	
	public IArticleCommentDao getArticleCommentDao() {
		return articleCommentDao;
	}
	public void setArticleCommentDao(IArticleCommentDao articleCommentDao) {
		this.articleCommentDao = articleCommentDao;
	}
	@Override
	public Boolean saveArticleComment(ArticleComment articleComment) {
		Long new_floor = this.getArticleCommentDao()
			.getMaxFloorByArticleId(articleComment.getArticleId()) + 1;
		articleComment.setFloor(new_floor);
		return this.getArticleCommentDao()
			.save(articleComment) == null;
	}
	@Override
	public void deleteArticleComment(ArticleComment articleComment) {
		this.getArticleCommentDao()
			.delete(articleComment);
	}
	@Override
	public void deleteArticleCommentById(int articleId) {
		this.getArticleCommentDao()
			.delete(ArticleComment.class, articleId);
	}
	@Override
	public void updateArticleComment(ArticleComment articleComment) {
		this.getArticleCommentDao()
			.update(articleComment);
	}
	@Override
	public List<ArticleComment> getAllArticleCommentsByArticleId(int articleId) {
		return this.getArticleCommentDao()
			.getAllCommentsByArticleId(articleId);
	}
	@Override
	public List<ArticleComment> getAllArticleCommentsByUserId(int userId) {
		return this.getArticleCommentDao()
			.getAllCommentsByUserId(userId);
	}
	@Override
	public Long countArticleCommentsByArticleId(int articleId) {
		return this.getArticleCommentDao()
			.countCommentsByArticleId(articleId);
	}

}
