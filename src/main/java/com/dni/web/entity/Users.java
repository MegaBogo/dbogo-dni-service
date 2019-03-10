package com.dni.web.entity;
import java.util.Date;

public class Users {
	private String id;
	private String name;
	private String email;
	private String pwd;
	private Date regDate;
	private String photo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", regDate=" + regDate
				+ ", photo=" + photo + "]";
	}
}
