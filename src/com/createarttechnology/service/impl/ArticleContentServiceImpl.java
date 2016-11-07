package com.createarttechnology.service.impl;

import java.util.List;

import com.createarttechnology.dao.IArticleContentDao;
import com.createarttechnology.domain.ArticleContent;
import com.createarttechnology.service.IArticleContentService;

public class ArticleContentServiceImpl implements IArticleContentService {

	private IArticleContentDao articleContentDao;
	
	public IArticleContentDao getArticleContentDao() {
		return articleContentDao;
	}
	public void setArticleContentDao(IArticleContentDao articleContentDao) {
		this.articleContentDao = articleContentDao;
	}

	@Override
	public Boolean saveArticleContent(ArticleContent articleContent) {
		return this.getArticleContentDao()
			.save(articleContent) == null;
	}

	@Override
	public void deleteArticleContent(ArticleContent articleContent) {
		this.getArticleContentDao()
			.delete(articleContent);
	}

	@Override
	public void deleteArticleContentById(int articleId) {
		this.getArticleContentDao()
			.delete(ArticleContent.class, articleId);
	}

	@Override
	public void updateArticleContent(ArticleContent articleContent) {
		this.getArticleContentDao()
			.update(articleContent);
	}

	@Override
	public ArticleContent getArticleContent(int articleId) {
		return this.getArticleContentDao()
			.get(ArticleContent.class, articleId);
	}

	@Override
	public List<Integer> getAllArticleId() {
		return this.getArticleContentDao()
			.getArticleIds();
	}

	@Override
	public List<Object[]> getArticleInfo(List<Integer> articleIds) {
		return this.getArticleContentDao()
			.getArticleInfosById(articleIds);
	}

}
