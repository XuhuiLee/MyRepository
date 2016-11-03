package com.createarttechnology.dao;

import java.util.List;
import com.createarttechnology.domain.ArticleComment;

public interface IArticleCommentDao {
	boolean saveArticleComment(ArticleComment acm);
	void deleteArticleComment(ArticleComment acm);
	void updateArticleComment(ArticleComment acm);
	ArticleComment getArticleComment(Integer id);
	List<ArticleComment> getAllArticleComments(Integer id);
	Integer getMaxFloor(Integer id);
}
