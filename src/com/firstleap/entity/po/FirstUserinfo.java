package com.firstleap.entity.po;

import java.util.Date;

/**
 * javabean。
 * 
 * 医院表
 * 
 * @author 张世超
 * 
 * @param <T>
 */
@SuppressWarnings("serial")
public class FirstUserinfo implements java.io.Serializable {

	private String id;    //主键ID
	private String name;  //用户名称
	private String emli; //邮箱
	private String isDelete; //是否删除
	private Date createdDate;  //增加时间
	private Date updatedDate;  //修改时间
	private FirstLogin firstLogin; //登录表外键
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
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public FirstLogin getFirstLogin() {
		return firstLogin;
	}
	public void setFirstLogin(FirstLogin firstLogin) {
		this.firstLogin = firstLogin;
	}
	public String getEmli() {
		return emli;
	}
	public void setEmli(String emli) {
		this.emli = emli;
	}
	

	
	
	
	
	

	
}
