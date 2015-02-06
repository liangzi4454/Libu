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
public class FirstType implements java.io.Serializable {

	private String id;    //主键ID
	private String name;  //菜单名称
	private String parentId;   //上级ID
	private String libuTypeType;  //类型 1：一级菜单  2： 二级菜单
	private String isDelete; //是否删除
	private Date createdDate;  //增加时间
	private Date updatedDate;  //修改时间
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
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getLibuTypeType() {
		return libuTypeType;
	}
	public void setLibuTypeType(String libuTypeType) {
		this.libuTypeType = libuTypeType;
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
	public long getPaixu() {
		return paixu;
	}
	public void setPaixu(long paixu) {
		this.paixu = paixu;
	}
	
	

	
	
	

	
}
