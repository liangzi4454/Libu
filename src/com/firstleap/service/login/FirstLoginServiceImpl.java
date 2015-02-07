package com.firstleap.service.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.hibernate.OrderBy;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.common.util.Tools;
import com.firstleap.dao.login.IFirstLoginDao;
import com.firstleap.entity.po.FirstLogin;

@Transactional
@Service("LtakLoginServiceImpl")
public class FirstLoginServiceImpl extends BaseServiceImpl implements
IFirstLoginService {

	@Autowired
	private IFirstLoginDao ltakLoginDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstLogin ltakLogin;


	/* (non-Javadoc)
	 * ��½
	 * @see net.ltak.service.login.ILtakLoginService#userLogin(net.ltak.entity.po.LtakLogin)
	 */
	
	public FirstLogin userLogin(FirstLogin ltakLogin) {
		// TODO Auto-generated method stub
		List<FirstLogin> list = ltakLoginDao.findUser(ltakLogin);
		FirstLogin login = null;
		if(null != list && list.size() > 0){
			login = list.get(0);
		}
			return login;
	}
	
	/* (non-Javadoc)
	 * ��֤��¼��
	 * @see net.ltak.service.login.ILtakLoginService#checkUser(net.ltak.entity.po.LtakLogin)
	 */
	
	public FirstLogin checkUser(FirstLogin ltakLogin) {
		// TODO Auto-generated method stub
		List<FirstLogin> list = ltakLoginDao.checkUser(ltakLogin);
		FirstLogin login = null;
		if(null != list && list.size() > 0){
			login = list.get(0);
		}
			return login;
	}
	
	/* (non-Javadoc)
	 * ���ӵ�¼�û�
	 * @see net.ltak.service.login.ILtakLoginService#savaLogin(net.ltak.entity.po.LtakLogin)
	 */
	
	public FirstLogin savaLogin(FirstLogin ltakLogin) {
		ltakLogin.setLoginId(Tools.UUID());
		ltakLogin = ltakLoginDao.save(ltakLogin);
		return ltakLogin;
	}
	
	
	/* (non-Javadoc)��ѯ
	 * @see net.ltak.service.login.ILtakLoginService#queryLogin(net.ltak.entity.po.LtakLogin)
	 */
	
	public List<FirstLogin> queryAllLogin(FirstLogin ltakLogin){
		ArrayList<FirstLogin> list = (ArrayList<FirstLogin>)ltakLoginDao.findAll();
		return list;

	}
	
	
	/* (non-Javadoc)ɾ��
	 * @see net.ltak.service.login.ILtakLoginService#delecteLogin(java.lang.String)
	 */
	
	public Boolean delecteLogin(String id) {
		// TODO Auto-generated method stub
		Boolean flag = null;
		if(!(null == id || "".equals(id))){
		   ltakLogin = ltakLoginDao.deleteById(id);
		}
		if(null == ltakLogin){
			flag =true;
		}else{
			flag =false;
		}
		return flag;
	}
	
	
	/* (non-Javadoc)���id��ѯ
	 * @see net.ltak.service.login.ILtakLoginService#getByid(java.lang.String)
	 */
	
	public FirstLogin getByid(String id) {
		ltakLogin = ltakLoginDao.get(id);
		// TODO Auto-generated method stub
		return ltakLogin;
	}

	
	/* (non-Javadoc)����
	 * @see net.ltak.service.login.ILtakLoginService#updateLogin(net.ltak.entity.po.LtakLogin)
	 */
	
	public Boolean updateLogin(FirstLogin ltakLogin) {
		FirstLogin rtLtakLogin = (FirstLogin)ltakLoginDao.update(ltakLogin);
		if(null != rtLtakLogin) {
			return true;
		}
		return false;
	}
	
	
	/* (non-Javadoc) ��ҳ
	 * @see net.ltak.service.login.ILtakLoginService#findAllOrQuery(int)
	 */
	
	public Pagination findAllOrQuery(int pageNo) {
		return ltakLoginDao.findAll(pageNo, PaginationConstants.PAGE_DEFAULT,new OrderBy[]{OrderBy.asc("loginId")});
	}
	
	
	/* (non-Javadoc)���������ѯһ������
	 * @see net.bjstd.service.system.userrole.IUserRoleSvr#findAllUserRole(int)
	 */
	public Pagination findAllQueryLogin(int pageNo , FirstLogin ltakLogin) {
		contextPvdImpl.getRequestAttr("");
		return ltakLoginDao.findAllQuery(pageNo, PaginationConstants.PAGE_DEFAULT, true , new String[]{"loginName"}, new String[]{ltakLogin.getLoginName()} , new OrderBy[]{OrderBy.asc("loginId")});
	}

	
	/***************************��װ**********************************/
	public IFirstLoginDao getLtakLoginDao() {
		return ltakLoginDao;
	}
	public void setLtakLoginDao(IFirstLoginDao ltakLoginDao) {
		this.ltakLoginDao = ltakLoginDao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstLogin getLtakLogin() {
		return ltakLogin;
	}

	public void setLtakLogin(FirstLogin ltakLogin) {
		this.ltakLogin = ltakLogin;
	}




}
