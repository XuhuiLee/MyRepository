package com.createarttechnology.util;

import com.opensymphony.xwork2.ActionContext;

public enum Message {
	
	REGIST_SUCCESS {
		public String getTitle() {
			return "注册成功";
		}
		public String getMessage() {
			return "注册成功，3秒后将为您跳转到登录页面...";
		}
		public String getTarget() {
			return "login";
		}
	},
	
	LOGIN_SUCCESS {
		public String getTitle() {
			return "登录成功";
		}
		public String getMessage() {
			return "欢迎回到C.A.T，" + CookieManager.get("u_username") + "，3秒后将为您跳转到登录前页面...";
		}
		public String getTarget() {
			String target = (String) ActionContext.getContext().getSession().get("from_url");
			ActionContext.getContext().getSession().remove("from_url");
			return target;
		}
	},
	
	LOGOUT_SUCCESS {
		public String getTitle() {
			return "登出成功";
		}
		public String getMessage() {
			return "登出成功，3秒后将为您跳转到首页...";
		}
		public String getTarget() {
			return "index";
		}
	},
	
	ALREADY_LOGIN {
		public String getTitle() {
			return "操作出错";
		}
		public String getMessage() {
			return CookieManager.get("u_username") + "，您已登录，不能进行该操作，3秒后将为您跳转到首页...";
		}
		public String getTarget() {
			return "index";
		}
	},
	
	REQUIRE_LOGIN {
		public String getTitle() {
			return "操作出错";
		}
		public String getMessage() {
			return "请登录后进行该操作，3秒后将为您跳转到登录页面...";
		}
		public String getTarget() {
			return "login";
		}
	},
	
	PAGE_NOT_FOUND {
		public String getTitle() {
			return "页面不存在";
		}
		public String getMessage() {
			return "您访问的页面不存在，3秒后将为您跳转到首页...";
		}
		public String getTarget() {
			return "index";
		}
	},
	
	MODIFY_SUCCESS {
		public String getTitle() {
			return "操作成功";
		}
		public String getMessage() {
			return "信息修改成功，3秒后将为您跳转到用户中心...";
		}
		public String getTarget() {
			return "account";
		}
	},
	
	MODIFY_ERROR {
		public String getTitle() {
			return "操作失败";
		}
		public String getMessage() {
			return "原密码有误，信息修改失败，3秒后将为您跳转到用户中心...";
		}
		public String getTarget() {
			return "account";
		}
	},
	
	UPLOAD_OUTOFRANGE {
		public String getTitle() {
			return "上传失败";
		}
		public String getMessage() {
			return "文件大小超过限制，上传失败，3秒后将为您跳转到之前页面...";
		}
		public String getTarget() {
			String target = (String) ActionContext.getContext().getSession().get("from_url");
			ActionContext.getContext().getSession().remove("from_url");
			return target;
		}
	};
	
	public abstract String getTitle();
	public abstract String getMessage();
	public abstract String getTarget();
	
}
