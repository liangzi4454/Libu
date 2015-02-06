package com.firstleap.action.firstyuertype;

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
import com.firstleap.entity.po.FirstChildinfoType;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.entity.po.FirstType;
import com.firstleap.entity.po.FirstYuerArticle;
import com.firstleap.entity.po.FirstYuerType;
import com.firstleap.service.firstchildinfotype.IFirstChildinfoTypeService;
import com.firstleap.service.firsttype.IFirstTypeService;
import com.firstleap.service.firstyuertype.IFirstYuerTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstYuerTypeAction")
@Scope("prototype")
public class FirstYuerTypeAction extends BaseAction {
	
	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private  IFirstYuerTypeService firstYuerTypeService;
	
	private FirstYuerType firstYuerType;
	
	private List<FirstYuerType> firstYuerfoList;
	
	
	

	/**
	 * @return
	 * @throws Exception
	 * 网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstYuerTypeService.findAllOrQuery(this.getPage(), firstYuerType);
		this.pagination = ltakLoginPagin;
		firstYuerfoList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page",this.getPage());
		if (firstYuerfoList != null) {
			return "list";
		}
		return INPUT;
		
	}
	
	/**
	 * @return
	 * @throws Exception
	 * 网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("listi")
	public String listi() throws Exception {
		ltakLoginPagin = firstYuerTypeService.findAllOrQueryi(this.getPage(), firstYuerType);
		this.pagination = ltakLoginPagin;
		firstYuerfoList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page",this.getPage());
		if (firstYuerfoList != null) {
			return "listi";
		}
		return INPUT;
		
	}
	
	
	/**
	 * 跳到增加
	 * @return
	 * @throws Exception
	 */
	@Action("createi")
	public String createi() throws Exception{
		FirstLogin ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//��ȡsession��¼ֵ
		firstYuerfoList = firstYuerTypeService.list("1");
		return "createi";
	}
	
	
	/**
	 * 跳到增加
	 * @return
	 * @throws Exception
	 */
	@Action("create")
	public String create() throws Exception{
		FirstLogin ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//��ȡsession��¼ֵ
		
		return "create";
	}
	
	/**
	 * @return
	 * @throws Exception
	 * 增加
	 */
	@SuppressWarnings("unchecked")
	@Action("savei")
	public String savei() throws Exception {
		String qubie = "2";
		boolean retBoolean  = firstYuerTypeService.save(firstYuerType,qubie);
		if (retBoolean) {
			return "savei";
		}
		return "input";
		
		
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
		boolean retBoolean  = firstYuerTypeService.save(firstYuerType,qubie);
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
		FirstLogin ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//��ȡsession��¼ֵ
		firstYuerType = firstYuerTypeService.getByid(this.getId());
		
		return "edit";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	@Action("update")
	public String update() throws Exception {
		boolean retBoolean = firstYuerTypeService.update(firstYuerType);
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
		msgname = firstYuerTypeService.delete(this.getId());
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

	public List<FirstYuerType> getFirstYuerfoList() {
		return firstYuerfoList;
	}

	public void setFirstYuerfoList(List<FirstYuerType> firstYuerfoList) {
		this.firstYuerfoList = firstYuerfoList;
	}

	

	
	
	
}
