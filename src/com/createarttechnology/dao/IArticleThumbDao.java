package com.createarttechnology.dao;

import com.createarttechnology.domain.ArticleThumb;

public interface IArticleThumbDao extends IBaseDao<ArticleThumb> {
	boolean existArticleThumb(ArticleThumb at);
	Long countArticleThumb(Integer articleId);
}
