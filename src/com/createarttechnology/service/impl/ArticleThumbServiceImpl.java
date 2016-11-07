package com.createarttechnology.service.impl;

import com.createarttechnology.dao.IArticleThumbDao;
import com.createarttechnology.domain.ArticleThumb;
import com.createarttechnology.service.IArticleThumbService;

public class ArticleThumbServiceImpl implements IArticleThumbService {

	private IArticleThumbDao articleThumbDao;
	
	public IArticleThumbDao getArticleThumbDao() {
		return articleThumbDao;
	}
	public void setArticleThumbDao(IArticleThumbDao articleThumbDao) {
		this.articleThumbDao = articleThumbDao;
	}

	@Override
	public Boolean saveArticleThumb(ArticleThumb articleThumb) {
		return this.getArticleThumbDao()
			.save(articleThumb) == null;
	}

	@Override
	public Boolean existThumb(ArticleThumb articleThumb) {
		return this.getArticleThumbDao()
			.existThumb(articleThumb);
	}

	@Override
	public Long countThumb(int articleId) {
		return this.getArticleThumbDao()
			.countThumbByArticleId(articleId);
	}

}
