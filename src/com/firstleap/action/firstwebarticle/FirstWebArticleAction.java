package com.firstleap.action.firstwebarticle;

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
import com.firstleap.entity.po.FirstWebArticle;
import com.firstleap.entity.po.FirstWebType;
import com.firstleap.service.firstwebarticle.IFirstWebArticleService;
import com.firstleap.service.firstwebtype.IFirstWebTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstWebArticleAction")
@Scope("prototype")
public class FirstWebArticleAction extends BaseAction {
	
	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private IFirstWebTypeService firstWebTypeService;
	
	private FirstWebType firstWebType;
	
	private List<FirstWebType> typeList;
	
	@Autowired
	private IFirstWebArticleService firstWebArticleService;
	
	private FirstWebArticle firstWebArticle;
	
	private List<FirstWebArticle> tyList;
	
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
		ltakLoginPagin = firstWebArticleService.findAllOrQuery(this.getPage(), firstWebArticle);
		this.pagination = ltakLoginPagin;
		typeList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page",this.getPage());
		if (typeList != null) {
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
		typeList = firstWebTypeService.listFirstWebType("1");
		
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
		boolean retBoolean  = firstWebArticleService.save(firstWebArticle, file,fileFileName,fileContentType);
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
		typeList = firstWebTypeService.listFirstWebType("1");
		firstWebArticle = firstWebArticleService.getByid(this.getId());
		return "edit";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	@Action("update")
	public String update() throws Exception {
		boolean retBoolean = firstWebArticleService.update(firstWebArticle);
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
		msgname = firstWebArticleService.delete(this.getId());
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



	public IFirstWebTypeService getFirstWebTypeService() {
		return firstWebTypeService;
	}



	public void setFirstWebTypeService(IFirstWebTypeService firstWebTypeService) {
		this.firstWebTypeService = firstWebTypeService;
	}



	public FirstWebType getFirstWebType() {
		return firstWebType;
	}



	public void setFirstWebType(FirstWebType firstWebType) {
		this.firstWebType = firstWebType;
	}



	public List<FirstWebType> getTypeList() {
		return typeList;
	}



	public void setTypeList(List<FirstWebType> typeList) {
		this.typeList = typeList;
	}



	public IFirstWebArticleService getFirstWebArticleService() {
		return firstWebArticleService;
	}



	public void setFirstWebArticleService(
			IFirstWebArticleService firstWebArticleService) {
		this.firstWebArticleService = firstWebArticleService;
	}



	public FirstWebArticle getFirstWebArticle() {
		return firstWebArticle;
	}



	public void setFirstWebArticle(FirstWebArticle firstWebArticle) {
		this.firstWebArticle = firstWebArticle;
	}



	public List<FirstWebArticle> getTyList() {
		return tyList;
	}



	public void setTyList(List<FirstWebArticle> tyList) {
		this.tyList = tyList;
	}

	

	
	
	
	
}
