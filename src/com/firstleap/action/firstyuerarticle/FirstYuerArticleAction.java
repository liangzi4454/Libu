package com.firstleap.action.firstyuerarticle;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.common.util.Constant;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.entity.po.FirstYuerArticle;
import com.firstleap.entity.po.FirstYuerType;
import com.firstleap.service.firstyuerarticle.IFirstYuerArticleService;
import com.firstleap.service.firstyuertype.IFirstYuerTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstYuerArticleAction")
@Scope("prototype")
public class FirstYuerArticleAction extends BaseAction {
	
	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private IFirstYuerTypeService firstYuerTypeService;
	
	private FirstYuerType firstYuerType;
	
	private List<FirstYuerType> typeList;
	
	@Autowired
	private IFirstYuerArticleService firstYuerArticleService;
	
	private FirstYuerArticle firstYuerArticle;
	
	private List<FirstYuerArticle> yuerList;
	
	private File file;//附件
	private String fileFileName;//附件名
	private String fileContentType;//附件类型
	
	
	

	/**
	 * @return
	 * @throws Exception
	 * 网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstYuerArticleService.findAllOrQuery(this.getPage(), firstYuerArticle);
		this.pagination = ltakLoginPagin;
		yuerList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page",this.getPage());
		if (yuerList != null) {
			return "list";
		}
		return INPUT;
		
	}
	
	
	
	/**
	 * 跳到增加
	 * @return
	 * @throws Exception
	 */
	@Action("create")
	public String create() throws Exception{
		FirstLogin ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//��ȡsession��¼ֵ
		typeList = firstYuerTypeService.list("2");
		
		return "create";
	}
	
	
	
	/**
	 * @return
	 * @throws Exception
	 * 增加
	 */
	@SuppressWarnings("unchecked")
	@Action("save")
	public String save() throws Exception {
		String qubie = "1";
		boolean retBoolean  = firstYuerArticleService.save(firstYuerArticle, file,fileFileName,fileContentType);
		if (retBoolean) {
			return "save";
		}
		return "input";
		
		
	}

	/**
	 * 跳到修改
	 * @return
	 * @throws Exception
	 */
	@Action("edit")
	public String edit() throws Exception{
		FirstLogin ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//
		typeList = firstYuerTypeService.list("2");
		firstYuerArticle = firstYuerArticleService.getByid(this.getId());
		return "edit";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	@Action("update")
	public String update() throws Exception {
		boolean retBoolean = firstYuerArticleService.update(firstYuerArticle);
		if (retBoolean) {
			return "update";
		}
			return "input";
	}

	
	
	/**
	 * ɾ��
	 * @return
	 * @throws Exception
	 */
	@Action("delete")
	public String delete() throws Exception{
		msgname = firstYuerArticleService.delete(this.getId());
		JSONObject json = new JSONObject();
		json.put("msgname", msgname);
		this.getResponse().setCharacterEncoding("utf-8");
		this.getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out = this.getResponse().getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
		return null;
	}


	
	

	public Pagination getLtakLoginPagin() {
		return ltakLoginPagin;
	}



	public void setLtakLoginPagin(Pagination ltakLoginPagin) {
		this.ltakLoginPagin = ltakLoginPagin;
	}



	public FirstLogin getFirstLogin() {
		return firstLogin;
	}



	public void setFirstLogin(FirstLogin firstLogin) {
		this.firstLogin = firstLogin;
	}



	public Map getReq() {
		return req;
	}



	public void setReq(Map req) {
		this.req = req;
	}



	public String getAreaid() {
		return areaid;
	}



	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}



	public String getMsgname() {
		return msgname;
	}



	public void setMsgname(String msgname) {
		this.msgname = msgname;
	}



	public IFirstYuerTypeService getFirstYuerTypeService() {
		return firstYuerTypeService;
	}



	public void setFirstYuerTypeService(IFirstYuerTypeService firstYuerTypeService) {
		this.firstYuerTypeService = firstYuerTypeService;
	}



	public FirstYuerType getFirstYuerType() {
		return firstYuerType;
	}



	public void setFirstYuerType(FirstYuerType firstYuerType) {
		this.firstYuerType = firstYuerType;
	}



	public List<FirstYuerType> getTypeList() {
		return typeList;
	}



	public void setTypeList(List<FirstYuerType> typeList) {
		this.typeList = typeList;
	}



	public IFirstYuerArticleService getFirstYuerArticleService() {
		return firstYuerArticleService;
	}



	public void setFirstYuerArticleService(
			IFirstYuerArticleService firstYuerArticleService) {
		this.firstYuerArticleService = firstYuerArticleService;
	}



	public FirstYuerArticle getFirstYuerArticle() {
		return firstYuerArticle;
	}



	public void setFirstYuerArticle(FirstYuerArticle firstYuerArticle) {
		this.firstYuerArticle = firstYuerArticle;
	}



	public List<FirstYuerArticle> getYuerList() {
		return yuerList;
	}



	public void setYuerList(List<FirstYuerArticle> yuerList) {
		this.yuerList = yuerList;
	}



	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}



	public String getFileFileName() {
		return fileFileName;
	}



	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}



	public String getFileContentType() {
		return fileContentType;
	}



	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
}
