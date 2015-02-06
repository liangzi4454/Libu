package com.firstleap.dao.login;

import java.util.List;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.entity.po.FirstLogin;

/**
 * dao。
 * 
 * 登录
 * 
 * @author 张世超
 * 
 * @param <T>
 */
public interface IFirstLoginDao extends BaseDao<FirstLogin> {
	/**
	 * 登录主页面
	 * 
	 * */
	 List<FirstLogin> findUser(FirstLogin ltakLogin);
	
		/**
		 * 添加用户页面
		 * 
		 * */
		 List<FirstLogin> checkUser(FirstLogin ltakLogin);
	
	
}
