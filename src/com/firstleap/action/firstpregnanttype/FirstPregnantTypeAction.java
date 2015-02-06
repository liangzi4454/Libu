package com.firstleap.action.firstpregnanttype;

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
import com.firstleap.entity.po.FirstPregnantType;
import com.firstleap.service.firsttype.IFirstTypeService;
import com.firstleap.service.firstpregnanttype.IFirstPregnantTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstPregnantTypeAction")
@Scope("prototype")
public class FirstPregnantTypeAction extends BaseAction {
	
	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private IFirstPregnantTypeService firstPregnantTypeService;
	
	private FirstPregnantType firstPregnantType;
	
	private List<FirstPregnantType> typeList;
	
	@Autowired
	private IFirstTypeService firstTypeService;
	
	private FirstType firstType;
	
	private List<FirstType> tyList;
	
	
	

	/**
	 * @return
	 * @throws Exception
	 * 网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstPregnantTypeService.findAllOrQuery(this.getPage(), firstPregnantType);
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
	 * 网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("listi")
	public String listi() throws Exception {
		ltakLoginPagin = firstPregnantTypeService.findAllOrQueryi(this.getPage(), firstPregnantType);
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
		typeList = firstPregnantTypeService.listFirstPregnantType("1");
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
		boolean retBoolean  = firstPregnantTypeService.saveFirstPregnantType(firstPregnantType,qubie);
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
		boolean retBoolean  = firstPregnantTypeService.saveFirstPregnantType(firstPregnantType,qubie);
		if (retBoolean) {
			return "save";
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
		tyList = firstTypeService.listFirstBumen("2");
		
		return "create";
	}
	
	/**
	 * 跳到修改
	 * @return
	 * @throws Exception
	 */
	@Action("edit")
	public String edit() throws Exception{
		FirstLogin ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//��ȡsession��¼ֵ
		firstPregnantType = firstPregnantTypeService.getByid(this.getId());
		tyList = firstTypeService.listFirstBumen("2");
		return "edit";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	@Action("update")
	public String update() throws Exception {
		boolean retBoolean = firstPregnantTypeService.updateFirstPregnantType(firstPregnantType);
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
		msgname = firstPregnantTypeService.deleteFirstPregnantType(this.getId());
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



	


	public IFirstPregnantTypeService getFirstPregnantTypeService() {
		return firstPregnantTypeService;
	}

	public void setFirstPregnantTypeService(
			IFirstPregnantTypeService firstPregnantTypeService) {
		this.firstPregnantTypeService = firstPregnantTypeService;
	}

	public FirstPregnantType getFirstPregnantType() {
		return firstPregnantType;
	}

	public void setFirstPregnantType(FirstPregnantType firstPregnantType) {
		this.firstPregnantType = firstPregnantType;
	}

	public List<FirstPregnantType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<FirstPregnantType> typeList) {
		this.typeList = typeList;
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



	public List<FirstType> getTyList() {
		return tyList;
	}



	public void setTyList(List<FirstType> tyList) {
		this.tyList = tyList;
	}

	
	
	
	
	
	
}
