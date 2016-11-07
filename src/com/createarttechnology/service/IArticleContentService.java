package com.createarttechnology.service;

import java.util.List;

import com.createarttechnology.domain.ArticleContent;

public interface IArticleContentService {
	//保存文章
	Boolean saveArticleContent(ArticleContent articleContent);
	//删除文章
	void deleteArticleContent(ArticleContent articleContent);
	//根据ID删除文章
	void deleteArticleContentById(int articleId);
	//更新文章
	void updateArticleContent(ArticleContent articleContent);
	//根据ID获取文章内容
	ArticleContent getArticleContent(int articleId);
	//获取全部文章的ID
	List<Integer> getAllArticleId();
	//根据ID获取除内容外的信息
	List<Object[]> getArticleInfo(List<Integer> articleIds);
	
}
