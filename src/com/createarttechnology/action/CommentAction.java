package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.dao.IArticleCommentDao;
import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.domain.ArticleComment;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport {
	
	private Integer articleId;
	private Integer replyId;
	private String data;
	private IArticleCommentDao dao;
	private IUserAccountDao uaDao;
	private String result;
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setDao(IArticleCommentDao dao) {
		this.dao = dao;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setUaDao(IUserAccountDao uaDao) {
		this.uaDao = uaDao;
	}
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
        if(articleId == null) {
			session.put("message", Message.PAGE_NOT_FOUND);
        	setResult("ERROR");
			return SUCCESS;
		}
        ArticleComment ac = new ArticleComment();
        UserInfo ui = (UserInfo) (session.get("userinfo"));
        UserAccount ua = uaDao.get(UserAccount.class, ui.getId());
        ac.setArticleId(articleId);
        ac.setUserInfo(ui);
        ac.setReplyId(replyId);
        ac.setData(data);
        ac.setUserAccount(ua);
    	dao.save(ac);
    	setResult("SUCCESS");
    	return SUCCESS;
	}
	
}
