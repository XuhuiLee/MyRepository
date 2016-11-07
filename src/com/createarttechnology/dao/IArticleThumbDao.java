package com.createarttechnology.dao;

import com.createarttechnology.domain.ArticleThumb;

public interface IArticleThumbDao extends IBaseDao<ArticleThumb> {
	//判断用户对某篇文章是否已点赞
	Boolean existThumb(ArticleThumb articleThumb);
	//获得某文章的点赞总数
	Long countThumbByArticleId(Integer articleId);
	
}
