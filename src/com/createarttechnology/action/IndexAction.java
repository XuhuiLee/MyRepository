package com.createarttechnology.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.createarttechnology.dao.IArticleCommentDao;
import com.createarttechnology.dao.IArticleContentDao;
import com.createarttechnology.dao.IArticleThumbDao;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private IArticleCommentDao acmDao;
	private IArticleThumbDao atDao;
	private IArticleContentDao actDao;
	private List<ArticleInfo> articleInfos_C;
	private List<ArticleInfo> articleInfos_A;
	private List<ArticleInfo> articleInfos_T;
	
	public void setAcmDao(IArticleCommentDao acmDao) {
		this.acmDao = acmDao;
	}
	public void setAtDao(IArticleThumbDao atDao) {
		this.atDao = atDao;
	}
	public void setActDao(IArticleContentDao actDao) {
		this.actDao = actDao;
	}
	public List<ArticleInfo> getArticleInfos_C() {
		return articleInfos_C;
	}
	public List<ArticleInfo> getArticleInfos_A() {
		return articleInfos_A;
	}
	public List<ArticleInfo> getArticleInfos_T() {
		return articleInfos_T;
	}

	public class ArticleInfo {
		Integer id;
		String title;
		Integer userId;
		String date;
		String directory1;
		Integer comments;
		Long thumbs;
		public Integer getId() {
			return id;
		}
		public String getTitle() {
			return title;
		}
		public Integer getUserId() {
			return userId;
		}
		public String getDate() {
			return date;
		}
		public String getDirectory1() {
			return directory1;
		}
		public Integer getComments() {
			return comments;
		}
		public Long getThumbs() {
			return thumbs;
		}
		public ArticleInfo(Integer id, String title, Integer userId, String date, String directory1, Integer comments,
				Long thumbs) {
			super();
			this.id = id;
			this.title = title;
			this.userId = userId;
			this.date = date;
			this.directory1 = directory1;
			this.comments = comments;
			this.thumbs = thumbs;
		}
	}
	
	public String execute() throws Exception {
		executeSupport("CAT");
		return SUCCESS;
	}

	public String createExecute() throws Exception {
		executeSupport("C");
		
		return SUCCESS;
	}
	
	public String artExecute() throws Exception {
		executeSupport("A");
		return SUCCESS;
	}
	
	public String technologyExecute() throws Exception {
		executeSupport("T");
		return SUCCESS;
	}
	
	public void executeSupport(String type) {
		articleInfos_C = new ArrayList<ArticleInfo>();
		articleInfos_A = new ArrayList<ArticleInfo>();
		articleInfos_T = new ArrayList<ArticleInfo>();
		List<Integer> articleIds = actDao.getArticleIds();
		List<Object[]> results = actDao.getArticleInfos(articleIds);
		Object[] result;
		String articleTitle;
		Integer articleUserId;
		Timestamp articleDate;
		String articleDirectory;
		Integer articleComments;
		Long articleThumbs;
		for(int i = 0; i < articleIds.size(); i++) {
			result = results.get(i);
			articleTitle = (String)result[0];
			articleUserId = (Integer)result[1];
			articleDate = (Timestamp)result[2];
			articleDirectory = (String)result[3];
			articleComments = acmDao.getMaxFloor(articleIds.get(i));
			articleThumbs = atDao.countArticleThumb(articleIds.get(i));
			ArticleInfo articleInfo = new ArticleInfo(articleIds.get(i), articleTitle, articleUserId, articleDate.toString().substring(0, 10), articleDirectory, articleComments, articleThumbs);
			if(articleDirectory.equals("C") && (type.equals("CAT") || type.equals("C")))
				articleInfos_C.add(articleInfo);
			else if(articleDirectory.equals("A") && (type.equals("CAT") || type.equals("A")))
				articleInfos_A.add(articleInfo);
			else if(articleDirectory.equals("T") && (type.equals("CAT") || type.equals("T")))
				articleInfos_T.add(articleInfo);
		}
	}
}
