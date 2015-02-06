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
public class SysLog implements java.io.Serializable {

	/**  */
	private String logId;
	
	/**  */
	private String operator;
	
	/**  */
	private String operatFunc;
	
	/**  */
	private String operatObject;
	
	/**  */
	private String operatContent;
	
	/**  */
	private Date operatTime;

	
	/**************************װget set *******************/

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatFunc() {
		return operatFunc;
	}

	public void setOperatFunc(String operatFunc) {
		this.operatFunc = operatFunc;
	}

	public String getOperatObject() {
		return operatObject;
	}

	public void setOperatObject(String operatObject) {
		this.operatObject = operatObject;
	}

	public Date getOperatTime() {
		return operatTime;
	}

	public String getOperatContent() {
		return operatContent;
	}

	public void setOperatContent(String operatContent) {
		this.operatContent = operatContent;
	}

	public void setOperatTime(Date operatTime) {
		this.operatTime = operatTime;
	}
}
