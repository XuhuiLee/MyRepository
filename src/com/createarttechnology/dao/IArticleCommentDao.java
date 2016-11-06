package com.createarttechnology.dao;

import java.util.List;

import com.createarttechnology.domain.ArticleComment;

public interface IArticleCommentDao extends IBaseDao<ArticleComment> {
	//根据文章ID找到最高楼层（可能中间楼被删除）
	Integer getMaxFloorByArticleId(Integer id);
	//根据文章ID统计评论数
	Integer countCommentsByArticleId(Integer id);
	//根据文章ID获得所有评论
	List<ArticleComment> getAllCommentsByArticleId(Integer id);
	
}
