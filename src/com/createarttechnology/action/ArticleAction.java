package com.createarttechnology.action;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.createarttechnology.dao.IArticleCommentDao;
import com.createarttechnology.dao.IArticleContentDao;
import com.createarttechnology.dao.IArticleThumbDao;
import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.dao.IUserInfoDao;
import com.createarttechnology.domain.ArticleComment;
import com.createarttechnology.domain.ArticleContent;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {
	
	private Integer id;
	private ArticleContent act;
	private String name;
	private List<ArticleComment> comments;
	private Long thumb;
	private IArticleCommentDao acmDao;
	private IArticleThumbDao atDao;
	private IArticleContentDao actDao;
	private IUserInfoDao uiDao;
	private IUserAccountDao uaDao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setActDao(IArticleContentDao actDao) {
		this.actDao = actDao;
	}
	public ArticleContent getAct() {
		return act;
	}
	public String getName() {
		return name;
	}
	public Long getThumb() {
		return thumb;
	}
	public void setUiDao(IUserInfoDao uiDao) {
		this.uiDao = uiDao;
	}
	public void setUaDao(IUserAccountDao uaDao) {
		this.uaDao = uaDao;
	}
	public List<ArticleComment> getComments() {
		return comments;
	}
	public void setAcmDao(IArticleCommentDao acmDao) {
		this.acmDao = acmDao;
	}
	public void setAtDao(IArticleThumbDao atDao) {
		this.atDao = atDao;
	}
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(id == null) {
			session.put("message", Message.PAGE_NOT_FOUND);
			return ERROR;
		}
		act = actDao.getArticleContent(id);
		if(act == null){
			session.put("message", Message.PAGE_NOT_FOUND);
			return ERROR;
		}
		name = getNameById(act.getUserId());
		comments = acmDao.getAllArticleComments(id);
		if(comments != null) {
			for(ArticleComment c : comments) {
				c.setName(getNameById(c.getUserInfo().getId()));
			}
		}
		thumb = atDao.countArticleThumb(id);
		return SUCCESS;
	}
	
	private String getNameById(Integer uid) {
		UserAccount ua = uaDao.getUserAccount(uid);
		String uname;
		if(ua == null || ua.getName() == null) {
			UserInfo ui = uiDao.getUserInfo(uid);
			uname = ui.getUsername();
		}
		else {
			uname = ua.getName();
		}
		return uname;
	}
	
	public String getRandomText() {
		String[] text = {
				"这么好的文章竟然没人评论(ノಠ益ಠ)ノ彡┻━┻",
				"沙发才不是给你留的呢，哼(〃｀ 3′〃)",
				"看少侠骨骼惊奇，我这珍藏多年的沙发就送给你了o(*￣▽￣*)ブ",
				"没人跟我抢沙发吧(ﾟДﾟ≡ﾟДﾟ)",
				"难道这就是传说中的沙发ε = = (づ′▽`)づ",
				"听说抢到这个沙发的人都被送去了德国骨科(。・＿・。)",
				"抢我沙发者，虽远必诛(*Φ皿Φ*)",
				"其实沙发已经被抢了，不信你试试┑(￣Д ￣)┍",
				"没人评论不开心(｡˘•ε•˘｡)",
				"别走，你忍心看着这死一般的寂静吗(￣┰￣*)",
				"没人陪我玩┭┮﹏┭┮</div>",
				"没关系，下次再评论也行(≧∇≦)ﾉ",
				"终于有人要评论了，我们下篇文章见哦(づ｡◕‿‿◕｡)づ",
		};
		int i = new Random().nextInt(text.length);
		return text[i];
	}
	
	public int getCommentsLength() {
		return comments.size();
	}
	
}
