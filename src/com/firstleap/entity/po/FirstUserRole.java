package com.firstleap.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class FirstUserRole implements java.io.Serializable {

	// Fields

	private String roleId; //
	private String name; //
	private String describe; //
	private String alias; //
	private String rolevalue;
	private Date createdDate;  //
	private Date updatedDate;  //
	private Set<FirstLogin> firstUserLoginRoles;
	private List<FirstUserRegister>  firstUserRegisters = new ArrayList<FirstUserRegister>();


	// Property accessors


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getRolevalue() {
		return rolevalue;
	}

	public void setRolevalue(String rolevalue) {
		this.rolevalue = rolevalue;
	}


	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public Set<FirstLogin> getFirstUserLoginRoles() {
		return firstUserLoginRoles;
	}

	public void setFirstUserLoginRoles(Set<FirstLogin> firstUserLoginRoles) {
		this.firstUserLoginRoles = firstUserLoginRoles;
	}

	public List<FirstUserRegister> getFirstUserRegisters() {
		return firstUserRegisters;
	}

	public void setFirstUserRegisters(List<FirstUserRegister> firstUserRegisters) {
		this.firstUserRegisters = firstUserRegisters;
	}

	
	
}