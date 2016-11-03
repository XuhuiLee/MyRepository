package com.createarttechnology.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class UserAccount {
	@Id
	@Column(name = "u_id", nullable = false)
	private Integer id;
	@Column(name= "u_email", length = 50, unique = true)
	private String email;
	@Column(name = "u_name", length = 30)
	private String name;
	@Column(name = "u_icon", length = 100)
	private String icon = "img/User/icon.png";
	@Column(name = "u_sex")
	private Integer sex;
	@Column(name = "u_sign", length = 100)
	private String sign;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
