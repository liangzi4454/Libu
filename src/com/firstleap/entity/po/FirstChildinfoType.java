package com.firstleap.entity.po;

import java.util.Date;

/**
 * javabean。
 * 
 * 儿童类型表
 * 
 * @author 张世超
 * 
 * @param <T>
 */
@SuppressWarnings("serial")
public class FirstChildinfoType implements java.io.Serializable {

	private String id;    //主键ID
	private String name;  //菜单名称
	private String parentId;   //上级ID
	private String libuChildinfoType;  //类型  1：新生儿 2：0-1岁 3：1-2岁 3：2.3岁 
	private FirstType firstType; //分类表ID
	private String isDelete; //是否删除
	private Date createdDate;  //增加时间
	private Date updatedDate;  //修改时间
	private long paixu;  //排序
	
	
	public long getPaixu() {
		return paixu;
	}
	public void setPaixu(long paixu) {
		this.paixu = paixu;
	}
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
	public String getLibuChildinfoType() {
		return libuChildinfoType;
	}
	public void setLibuChildinfoType(String libuChildinfoType) {
		this.libuChildinfoType = libuChildinfoType;
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
