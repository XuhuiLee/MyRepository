package com.createarttechnology.dao;

import java.util.List;
import com.createarttechnology.domain.ArticleComment;

public interface IArticleCommentDao extends IBaseDao<ArticleComment> {
	List<ArticleComment> getAllArticleComments(Integer id);
	Integer getMaxFloor(Integer id);
}
