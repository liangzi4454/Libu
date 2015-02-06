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
public class FirstYuerArticle implements java.io.Serializable {

	private String id;    //主键ID
	private String name;  //菜单名称
	private String childinfoContent;  //内容
	private String childinfoTitle; //标题
	private String childinfoAbstract; //摘要
	private String childinfoImage;  //图片
	private FirstYuerType firstYuerType; //所属儿童类型
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
	public String getChildinfoContent() {
		return childinfoContent;
	}
	public void setChildinfoContent(String childinfoContent) {
		this.childinfoContent = childinfoContent;
	}
	public String getChildinfoTitle() {
		return childinfoTitle;
	}
	public void setChildinfoTitle(String childinfoTitle) {
		this.childinfoTitle = childinfoTitle;
	}
	public String getChildinfoAbstract() {
		return childinfoAbstract;
	}
	public void setChildinfoAbstract(String childinfoAbstract) {
		this.childinfoAbstract = childinfoAbstract;
	}
	public String getChildinfoImage() {
		return childinfoImage;
	}
	public void setChildinfoImage(String childinfoImage) {
		this.childinfoImage = childinfoImage;
	}
	
	public FirstYuerType getFirstYuerType() {
		return firstYuerType;
	}
	public void setFirstYuerType(FirstYuerType firstYuerType) {
		this.firstYuerType = firstYuerType;
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
