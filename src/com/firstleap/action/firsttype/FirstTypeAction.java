package com.firstleap.action.firsttype;

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
import com.firstleap.entity.po.FirstType;
import com.firstleap.service.firsttype.IFirstTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstTypeAction")
@Scope("prototype")
public class FirstTypeAction extends BaseAction {
	
	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private IFirstTypeService firstTypeService;
	
	private FirstType firstType;
	
	private List<FirstType> typeList;
	
	
	

	/**
	 * @return
	 * @throws Exception
	 * 网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstTypeService.findAllOrQuery(this.getPage(), firstType);
		this.pagination = ltakLoginPagin;
		typeList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page",this.getPage());
		if (typeList != null) {
			return "list";
		}
		return INPUT;
		
	}
	
	/**
	 * @return
	 * @throws Exception
	 * 网站二类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("listi")
	public String listi() throws Exception {
		ltakLoginPagin = firstTypeService.findAllOrQueryi(this.getPage(), firstType);
		this.pagination = ltakLoginPagin;
		typeList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page",this.getPage());
		if (typeList != null) {
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
		typeList = firstTypeService.listFirstBumen("1");
		return "createi";
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
		boolean retBoolean  = firstTypeService.saveFirstType(firstType,qubie);
		if (retBoolean) {
			return "savei";
		}
		return "input";
		
		
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
	@Action("save")
	public String save() throws Exception {
		String qubie = "1";
		boolean retBoolean  = firstTypeService.saveFirstType(firstType,qubie);
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
		firstType = firstTypeService.getByid(this.getId());
		return "edit";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	@Action("update")
	public String update() throws Exception {
		boolean retBoolean = firstTypeService.updateFirstType(firstType);
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
		msgname = firstTypeService.deleteFirstType(this.getId());
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

	/**
	 * ɾ��
	 * @return
	 * @throws Exception
	 */
	@Action("deletei")
	public String deletei() throws Exception{
		msgname = firstTypeService.deleteFirstType(this.getId());
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

	public IFirstTypeService getFirstTypeService() {
		return firstTypeService;
	}

	public void setFirstTypeService(IFirstTypeService firstTypeService) {
		this.firstTypeService = firstTypeService;
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}

	public List<FirstType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<FirstType> typeList) {
		this.typeList = typeList;
	}
	
	
	
	
	
}
