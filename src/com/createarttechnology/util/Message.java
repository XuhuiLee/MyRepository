package com.createarttechnology.util;

import com.opensymphony.xwork2.ActionContext;

public enum Message {
	
	REGIST_SUCCESS {
		public String getTitle() {
			return "ע��ɹ�";
		}
		public String getMessage() {
			return "ע��ɹ���3���Ϊ����ת����¼ҳ��...";
		}
		public String getTarget() {
			return "login";
		}
	},
	
	LOGIN_SUCCESS {
		public String getTitle() {
			return "��¼�ɹ�";
		}
		public String getMessage() {
			return "��ӭ�ص�C.A.T��" + CookieManager.get("u_username") + "��3���Ϊ����ת����¼ǰҳ��...";
		}
		public String getTarget() {
			String target = (String) ActionContext.getContext().getSession().get("from_url");
			ActionContext.getContext().getSession().remove("from_url");
			return target;
		}
	},
	
	LOGOUT_SUCCESS {
		public String getTitle() {
			return "�ǳ��ɹ�";
		}
		public String getMessage() {
			return "�ǳ��ɹ���3���Ϊ����ת����ҳ...";
		}
		public String getTarget() {
			return "index";
		}
	},
	
	ALREADY_LOGIN {
		public String getTitle() {
			return "��������";
		}
		public String getMessage() {
			return CookieManager.get("u_username") + "�����ѵ�¼�����ܽ��иò�����3���Ϊ����ת����ҳ...";
		}
		public String getTarget() {
			return "index";
		}
	},
	
	REQUIRE_LOGIN {
		public String getTitle() {
			return "��������";
		}
		public String getMessage() {
			return "���¼����иò�����3���Ϊ����ת����¼ҳ��...";
		}
		public String getTarget() {
			return "login";
		}
	},
	
	PAGE_NOT_FOUND {
		public String getTitle() {
			return "ҳ�治����";
		}
		public String getMessage() {
			return "�����ʵ�ҳ�治���ڣ�3���Ϊ����ת����ҳ...";
		}
		public String getTarget() {
			return "index";
		}
	},
	
	MODIFY_SUCCESS {
		public String getTitle() {
			return "�����ɹ�";
		}
		public String getMessage() {
			return "��Ϣ�޸ĳɹ���3���Ϊ����ת���û�����...";
		}
		public String getTarget() {
			return "account";
		}
	},
	
	MODIFY_ERROR {
		public String getTitle() {
			return "����ʧ��";
		}
		public String getMessage() {
			return "ԭ����������Ϣ�޸�ʧ�ܣ�3���Ϊ����ת���û�����...";
		}
		public String getTarget() {
			return "account";
		}
	},
	
	UPLOAD_OUTOFRANGE {
		public String getTitle() {
			return "�ϴ�ʧ��";
		}
		public String getMessage() {
			return "�ļ���С�������ƣ��ϴ�ʧ�ܣ�3���Ϊ����ת��֮ǰҳ��...";
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
