package com.firstleap.dao.login;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.firstleap.common.hibernate.BaseDaoImpl;
import com.firstleap.common.util.MD5;
import com.firstleap.entity.po.FirstLogin;

/**
 * dao��
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
@Repository("FirstLoginDaoImpl")
public class FirstLoginDaoImpl extends BaseDaoImpl<FirstLogin> implements IFirstLoginDao  {
	
	
	/* (non-Javadoc)
	 * @see net.ltak.dao.login.ILtakLoginDao#findUser(net.ltak.entity.po.LtakLogin)
	 */
	public List<FirstLogin> findUser(FirstLogin ltakLogin) {
		MD5 md5 = new MD5();
		String hql = "from FirstLogin where loginName=? and password=?";
//		String pwd = md5.getMD5ofStr(ltakLogin.getPassword());
		List<FirstLogin> list = super.find(hql, ltakLogin.getLoginName(),ltakLogin.getPassword());
		return list;
	}
	
	/* (non-Javadoc)
	 * @see net.ltak.dao.login.ILtakLoginDao#checkUser(net.ltak.entity.po.LtakLogin)
	 */
	public List<FirstLogin> checkUser(FirstLogin ltakLogin) {
		String hql = "from FirstLogin where loginName=? ";
		List<FirstLogin> list = super.find(hql, ltakLogin.getLoginName());
		return list;
	}
	
	
}
