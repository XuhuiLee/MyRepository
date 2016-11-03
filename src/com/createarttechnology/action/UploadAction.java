package com.createarttechnology.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.Message;

public class UploadAction extends ActionSupport {
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String prefix;
	private IUserAccountDao uaDao;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setUaDao(IUserAccountDao uaDao) {
		this.uaDao = uaDao;
	}
	
	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Integer uid = ((UserInfo)ctx.getSession().get("userinfo")).getId();
		String rootPath = ServletActionContext.getServletContext().getRealPath("");
		if (!new File(rootPath + "user/" + uid.toString()).exists()) {
			new File(rootPath + "user/" + uid.toString()).mkdir();
		}
		UUID uuid = UUID.nameUUIDFromBytes(uploadFileName.getBytes());
		String[] name = uploadFileName.split("\\.");
		String suffix = name[name.length - 1];
		String iconPath = "user/" + uid.toString() + "/" + prefix + uuid.toString() + "." + suffix;
		FileOutputStream fos = new FileOutputStream(rootPath + iconPath);
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = fis.read(buffer)) > 0) {
			
			fos.write(buffer, 0, len);
		}
		fos.close();
		uaDao.getUserAccount(uid).setIcon(iconPath);
		return SUCCESS;
	}
	
	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		if(errorMessage.startsWith("File upload is too large to be uploaded.")) {
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("from_url", "account");
			ctx.getSession().put("message", Message.UPLOAD_OUTOFRANGE);
		}
        super.addFieldError(fieldName, errorMessage);
    }
	
}
