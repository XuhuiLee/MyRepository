package com.createarttechnology.action;

import com.createarttechnology.dao.IArticleThumbDao;
import com.createarttechnology.domain.ArticleThumb;
import com.opensymphony.xwork2.ActionSupport;

public class ThumbAction extends ActionSupport {
	
	private Integer articleId;
	private Integer userId;
	private IArticleThumbDao atDao;
	private String result;
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setAtDao(IArticleThumbDao atDao) {
		this.atDao = atDao;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String execute() throws Exception {
        if(articleId == null) {
        	setResult("ERROR");
			return SUCCESS;
		}
        if(userId == null) {
        	setResult("ERROR");
			return SUCCESS;
		}
        ArticleThumb at = new ArticleThumb();
        at.setArticleId(articleId);
        at.setUserId(userId);
        if(atDao.existThumb(at)) {
        	setResult("INPUT");
        	return SUCCESS;
        }
        Long c = atDao.countThumbByArticleId(articleId) + 1;
    	setResult(c.toString());
    	atDao.save(at);
    	return SUCCESS;
	}
	
}
