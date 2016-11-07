package com.createarttechnology.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="article_comment")
public class ArticleComment {
	@Column(name = "a_id", nullable = false)
	private Integer articleId;
	@ManyToOne(targetEntity = UserInfo.class)
	@JoinColumn(name = "u_id", referencedColumnName = "u_id", nullable = false)
	private UserInfo userInfo;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private Integer commentId;
	@Column(name = "r_rid")
	private Integer replyId;
	@Column(name = "r_date", nullable = false)
	private Timestamp date = new Timestamp(System.currentTimeMillis());
	@Column(name = "r_data", nullable = false, length = 400)
	private String data;
	@Column(name = "r_floor", nullable = false)
	private Long floor;
	@Transient
	private String name;
	@ManyToOne(targetEntity = UserAccount.class)
	@JoinTable(name = "acomment_uaccount",
			joinColumns = @JoinColumn(name = "r_id", referencedColumnName = "r_id", unique = true),
			inverseJoinColumns = @JoinColumn(name = "u_id", referencedColumnName = "u_id")
	)
	private UserAccount userAccount;
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public Timestamp getDate() {
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
	public Long getFloor() {
		return floor;
	}
	public void setFloor(Long floor) {
		this.floor = floor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
}
