package com.firstleap.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * javabean��
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */

public class FirstLogin implements java.io.Serializable {

	// Fields

	private String loginId;     //
	private String loginName;   //
	private String password;    //
	private String isdelete;    //
	private String loginType;   //
	private Long sid;           //
	private Date createdDate;   //
	private Date updatedDate;   //
	private List<FirstUserRole> userRoles = new ArrayList<FirstUserRole>();
	private String yhId;        // 


	// Property accessors

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public String getYhId() {
		return yhId;
	}

	public void setYhId(String yhId) {
		this.yhId = yhId;
	}

	public List<FirstUserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<FirstUserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
}