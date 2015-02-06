package com.firstleap.tag;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.firstleap.common.util.AppModelFactory;
import com.firstleap.entity.po.FirstType;
import com.firstleap.service.firsttype.IFirstTypeService;

public class GetTypeNameByIdTag extends TagSupport{
	private static final long serialVersionUID = 1L;
	private String areaId;

	/* 标签初始方法 */
	@SuppressWarnings("static-access")
	public int doStartTag() throws JspTagException{
		return super.EVAL_BODY_INCLUDE;
	}
	/* 标签结束方法 */
	@SuppressWarnings("static-access")
	public int doEndTag() throws JspTagException{
		JspWriter out = pageContext.getOut();
		IFirstTypeService areaservices = (IFirstTypeService)  AppModelFactory.getInstance("FirstTypeServiceImpl");
		FirstType area = areaservices.getByid(areaId);
		int sum = 0;
		if(null != area){
			try {
				out.print(area.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try{
				//标签的返回值
				out.println("");
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return super.SKIP_BODY;
	}

	/* 释放资源 */
	public void release(){
		super.release();
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}
