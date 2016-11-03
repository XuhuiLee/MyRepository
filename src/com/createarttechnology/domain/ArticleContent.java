package com.createarttechnology.domain;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article_content")
public class ArticleContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private Integer articleId;
	@Column(name = "a_title", nullable = false, length = 50)
	private String title;
	@Column(name = "a_annotation", length = 50)
	private String annotation;
	@Column(name = "u_id", nullable = false)
	private Integer userId;
	@Column(name = "a_date", nullable = false)
	private Timestamp date = new Timestamp(System.currentTimeMillis());
	@Column(name = "a_data", nullable = false, length = 10000)
	private String data;
	@Column(name = "a_directory1", nullable = false, length = 5)
	private String directory1;
	@Column(name = "a_directory2", length = 5)
	private String directory2;
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDirectory1() {
		return directory1;
	}
	public void setDirectory1(String directory1) {
		this.directory1 = directory1;
	}
	public String getDirectory2() {
		return directory2;
	}
	public void setDirectory2(String directory2) {
		this.directory2 = directory2;
	}
	
}
