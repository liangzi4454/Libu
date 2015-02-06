package com.firstleap.entity.po;

import java.util.Date;

/**
 * javabean��
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
@SuppressWarnings("serial")
public class FirstWebType implements java.io.Serializable {

	private String id;    //
	private String name;  //
	private String parentId;   //
	private String libuWebType;  //
	private FirstType firstType; //
	private String isDelete; //
	private Date createdDate;  //
	private Date updatedDate;  //
	private long paixu;  //排序
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public long getPaixu() {
		return paixu;
	}
	public void setPaixu(long paixu) {
		this.paixu = paixu;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getLibuWebType() {
		return libuWebType;
	}
	public void setLibuWebType(String libuWebType) {
		this.libuWebType = libuWebType;
	}
	public FirstType getFirstType() {
		return firstType;
	}
	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
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
	
	

	
}
