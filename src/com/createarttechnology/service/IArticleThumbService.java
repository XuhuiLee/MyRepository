package com.createarttechnology.service;

import com.createarttechnology.domain.ArticleThumb;

public interface IArticleThumbService {
	//保存点赞
	Boolean saveArticleThumb(ArticleThumb articleThumb);
	//检查用户是否点过赞
	Boolean existThumb(ArticleThumb articleThumb);
	//根据文章ID统计点赞数
	Long countThumb(int articleId);
	
}
