package com.firstleap.service.login;


import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstLogin;

/**
 * @author zsc
 * 
 */
public interface IFirstLoginService extends BaseService {
	
	
	/**
	 * 
	 * @param ltakLogin
	 * @return
	 */
	FirstLogin savaLogin(FirstLogin ltakLogin);
	
	
	/**
	 * 
	 * @param ltakLogin
	 * @return
	 */
	Boolean delecteLogin(String id);
	
	
	/**
	 * ȫ��
	 * @param ltakLogin
	 * @return
	 */
	List<FirstLogin> queryAllLogin(FirstLogin ltakLogin);
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	FirstLogin getByid(String id);
	
	
	/**
	 * ����
	 * @param ltakLogin
	 * @return
	 */
	Boolean updateLogin(FirstLogin ltakLogin);
	
	
	/**
	 * @param pageNo ҳ��
	 * @param DicType
	 * @return Pagination
	 * ��ҳ��ѯ���϶���
	 */
	Pagination findAllOrQuery(int pageNo);
	
	
	/**
	 * @param ltakLogin
	 * @return
	 * ��½
	 */
	FirstLogin userLogin(FirstLogin ltakLogin);
	
	/**
	 * @param ltakLogin
	 * @return
	 * ��֤��¼��
	 */
	FirstLogin checkUser(FirstLogin ltakLogin);	
	
	
	
}
