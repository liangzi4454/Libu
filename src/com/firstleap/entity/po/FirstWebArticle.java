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
public class FirstWebArticle implements java.io.Serializable {

	private String id;    //
	private String name;  //
	private String webContent;  //
	private String webTitle; //
	private String webAbstract; //
	private String webImage;  //
	private FirstWebType firstWebType; //
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
	public long getPaixu() {
		return paixu;
	}
	public void setPaixu(long paixu) {
		this.paixu = paixu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebContent() {
		return webContent;
	}
	public void setWebContent(String webContent) {
		this.webContent = webContent;
	}
	public String getWebTitle() {
		return webTitle;
	}
	public void setWebTitle(String webTitle) {
		this.webTitle = webTitle;
	}
	public String getWebAbstract() {
		return webAbstract;
	}
	public void setWebAbstract(String webAbstract) {
		this.webAbstract = webAbstract;
	}
	public String getWebImage() {
		return webImage;
	}
	public void setWebImage(String webImage) {
		this.webImage = webImage;
	}
	public FirstWebType getFirstWebType() {
		return firstWebType;
	}
	public void setFirstWebType(FirstWebType firstWebType) {
		this.firstWebType = firstWebType;
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
