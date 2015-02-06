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
public class FirstPregnantArticle implements java.io.Serializable {

	private String id;    //主键
	private String name;  // 名称
	private String pregnantContent;  // 内容
	private String pregnantTitle; // 标题
	private String pregnantAbstract; // 摘要
	private String pregnantImage;  // 图片
	private FirstPregnantType firstPregnantType; // 孕妇大类
	private String isDelete; //
	private Date createdDate;  //
	private Date updatedDate;  //
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
	public String getPregnantContent() {
		return pregnantContent;
	}
	public void setPregnantContent(String pregnantContent) {
		this.pregnantContent = pregnantContent;
	}
	public String getPregnantTitle() {
		return pregnantTitle;
	}
	public void setPregnantTitle(String pregnantTitle) {
		this.pregnantTitle = pregnantTitle;
	}
	public String getPregnantAbstract() {
		return pregnantAbstract;
	}
	public void setPregnantAbstract(String pregnantAbstract) {
		this.pregnantAbstract = pregnantAbstract;
	}
	public String getPregnantImage() {
		return pregnantImage;
	}
	public void setPregnantImage(String pregnantImage) {
		this.pregnantImage = pregnantImage;
	}
	
	public FirstPregnantType getFirstPregnantType() {
		return firstPregnantType;
	}
	public void setFirstPregnantType(FirstPregnantType firstPregnantType) {
		this.firstPregnantType = firstPregnantType;
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
