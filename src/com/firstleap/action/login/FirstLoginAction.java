package com.firstleap.action.login;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.common.util.Constant;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.service.login.IFirstLoginService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstLoginAction")
@Scope("prototype")
public class FirstLoginAction extends BaseAction {
	
	@Autowired
	private IFirstLoginService ltakLoginService;

	private Pagination ltakLoginPagin;
	
	private List<FirstLogin> ltakLoginList;
	
	private FirstLogin ltakLogin;
	
	private Map req;
	
	private String rio;
	
	

	
	
	/**
	 * @return
	 * @throws Exception
	 * 分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = ltakLoginService.findAllOrQuery(this.getPage());
		this.pagination = ltakLoginPagin;
		ltakLoginList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page",this.getPage());
		if (ltakLoginList != null) {
			return "list";
		}
		return INPUT;
		
	}
	
	/**
	 * @return 
	 * @throws Exception
	 * 跳转到登陆页面
	 */
	@Action("listToLogin")
	public String listToLogin() throws Exception {
		
		return "listToLogin";
	}
	
	
	/**
	 * @return
	 * @throws Exception
	 * 登陆方法
	 */
	@Action("listLogin")
	public String listLogin() throws Exception {
		ltakLogin = ltakLoginService.userLogin(ltakLogin);
		if(null !=ltakLogin){
			System.out.println(ltakLogin.getUserRoles());
			ActionContext.getContext().getSession().put(Constant.USER_SESSION, ltakLogin);
			
			if(ltakLogin.getUserRoles().size() > 0){
				rio = ltakLogin.getUserRoles().get(0).getRolevalue();
			}
			return "adminlogin";
		}
		
		return INPUT;
	
	}
	
	
	/**
	 * @return 
	 * @throws Exception
	 * 跳转到登陆页面
	 */
	@Action("vaccToLogin")
	public String vaccToLogin() throws Exception {
		FirstLogin ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//获取session登录值
		
		return "vaccToLogin";
	}
	
	/**
	 * @return 
	 * @throws Exception
	 * 修改密码
	 */
	@Action("xgmm")
	public String xgmm() throws Exception {
		ltakLogin = ltakLoginService.getByid(this.getId());
		return "xgmm";
	}
	
	/**
	 * @return 
	 * @throws Exception
	 * 更新密码
	 */
	@Action("updatemm")
	public String updatemm() throws Exception {
		boolean retBoolean = ltakLoginService.updateLogin(ltakLogin);
		if (retBoolean) {
			return "updatemm";
		}
		    return "input";
	}
	
	
	
	/**
	 * @return 
	 * @throws Exception
	 * 根据菜单主页面
	 */
	@Action("selectMenu")
	public String selectMenu() throws Exception {
		FirstLogin ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//获取session登录值
		
		return "selectMenu";
	}
	
	/**
	 * @return 
	 * @throws Exception
	 * 根据菜单主页面
	 */
	@Action("topi")
	public String topi() throws Exception {
		
		return "topi";
	}
	
	@Action("lefti")
	public String lefti() throws Exception {
		req = (Map)ActionContext.getContext().get("request");
		ltakLogin = (FirstLogin)ActionContext.getContext().getSession().get(Constant.USER_SESSION);//获取session登录值
		System.out.println(ltakLogin.getUserRoles());
		
		if(ltakLogin.getUserRoles().size() > 0){
			rio = ltakLogin.getUserRoles().get(0).getRolevalue();
		}
		return "lefti";
	}
	
	@Action("righti")
	public String righti() throws Exception {
		
		return "righti";
	}
	
	@Action("bottomi")
	public String bottomi() throws Exception {
		
		return "bottomi";
	}
	
	
	/**注销用户
	 * @return
	 */
	@Action("logout")
	public String logout() {
		ActionContext.getContext().getSession().remove("Constant.USER_SESSION");
		this.setMessage("");
		return "logout";
	}
	
	/**
	 * @return
	 * @throws Exception
	 * 禁用用户
	 */
	@Action("disable")
	public String disable() throws Exception {
		String rtmsg = "";
		ltakLogin =  ltakLoginService.getByid(this.getId());
		ltakLogin.setIsdelete("1");
		boolean rt = (boolean)ltakLoginService.updateLogin(ltakLogin);
		
		if(rt){
			rtmsg ="用户" + ltakLogin.getLoginName() +"已被禁用！" ;
			} else {
			rtmsg = "糟糕！出错了!请联系管理员。";
			}
		JSONObject json = new JSONObject();
		json.put("rtmsg", rtmsg);
		this.getResponse().setCharacterEncoding("utf-8");
		this.getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out = this.getResponse().getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
		
		return null;
	}
	
	
	
	/*********************************封装方法开始******************************************/
	/**中间service层注入
	 * @return
	 */
	public IFirstLoginService getLtakLoginService() {
		return ltakLoginService;
	}

	public void setLtakLoginService(IFirstLoginService ltakLoginService) {
		this.ltakLoginService = ltakLoginService;
	}

	/**分页注入
	 * @return
	 */
	public Pagination getLtakLoginPagin() {
		return ltakLoginPagin;
	}

	public Map getReq() {
		return req;
	}

	public void setReq(Map req) {
		this.req = req;
	}

	public void setLtakLoginPagin(Pagination ltakLoginPagin) {
		this.ltakLoginPagin = ltakLoginPagin;
	}

	public List<FirstLogin> getLtakLoginList() {
		return ltakLoginList;
	}

	public void setLtakLoginList(List<FirstLogin> ltakLoginList) {
		this.ltakLoginList = ltakLoginList;
	}

	/**对象注入
	 * @return
	 */
	public FirstLogin getLtakLogin() {
		return ltakLogin;
	}

	public void setLtakLogin(FirstLogin ltakLogin) {
		this.ltakLogin = ltakLogin;
	}

	public String getRio() {
		return rio;
	}

	public void setRio(String rio) {
		this.rio = rio;
	}

}
