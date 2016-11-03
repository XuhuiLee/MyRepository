package com.createarttechnology.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article_thumb")
public class ArticleThumb {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "t_id")
	private Integer thumbId;
	@Column(name = "a_id", nullable = false)
	private Integer articleId;
	@Column(name = "u_id", nullable = false)
	private Integer userId;
	
	public Integer getThumbId() {
		return thumbId;
	}
	public void setThumbId(Integer thumbId) {
		this.thumbId = thumbId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
