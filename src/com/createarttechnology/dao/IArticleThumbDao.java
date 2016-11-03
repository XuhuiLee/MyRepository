package com.createarttechnology.dao;

import com.createarttechnology.domain.ArticleThumb;

public interface IArticleThumbDao {
	boolean saveArticleThumb(ArticleThumb at);
	void deleteArticleThumb(ArticleThumb at);
	void updateArticleThumb(ArticleThumb at);
	boolean existArticleThumb(ArticleThumb at);
	Long countArticleThumb(Integer articleId);
}
