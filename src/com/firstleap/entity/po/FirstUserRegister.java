package com.firstleap.entity.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * javabean��
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */

public class FirstUserRegister implements java.io.Serializable {

	// Fields

	private String regId; //
	private String name; //
	private String entryaddress;  //ַ
	private String superId; //
	private String codeId; //
	private String state; //
	private String subId; //
	private String sort; //
	private String describe; //
	private Set firstUserRoleRegs = new HashSet(0);;
	private Date createdDate;  //
	private Date updatedDate;  //



	// Property accessors



	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEntryaddress() {
		return this.entryaddress;
	}

	public void setEntryaddress(String entryaddress) {
		this.entryaddress = entryaddress;
	}

	public String getSuperId() {
		return this.superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	public String getCodeId() {
		return this.codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSubId() {
		return this.subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	

	public Set getFirstUserRoleRegs() {
		return firstUserRoleRegs;
	}

	public void setFirstUserRoleRegs(Set firstUserRoleRegs) {
		this.firstUserRoleRegs = firstUserRoleRegs;
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

}