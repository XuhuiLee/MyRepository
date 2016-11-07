package com.createarttechnology.service;

import java.util.List;

import com.createarttechnology.domain.ArticleComment;

public interface IArticleCommentService {
	//发表评论
	Boolean saveArticleComment(ArticleComment articleComment);
	//删除评论
	void deleteArticleComment(ArticleComment articleComment);
	//根据评论用户ID删除评论
	void deleteArticleCommentById(int articleId);
	//更改评论
	void updateArticleComment(ArticleComment articleComment);
	//获取ID对应文章的所有评论
	List<ArticleComment> getAllArticleCommentsByArticleId(int articleId);
	//根据用户ID获取所有评论
	List<ArticleComment> getAllArticleCommentsByUserId(int userId);
	//获取总评论数
	Long countArticleCommentsByArticleId(int articleId);
	
}
