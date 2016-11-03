package com.createarttechnology.dao;

import java.util.List;

import com.createarttechnology.domain.ArticleContent;

public interface IArticleContentDao {
	boolean saveArticleContent(ArticleContent act);
	void deleteArticleContent(ArticleContent act);
	void updateArticleContent(ArticleContent act);
	ArticleContent getArticleContent(Integer id);
	List<Integer> getArticleIds();
	List<Object[]> getArticleInfos(List<Integer> ids);
}
