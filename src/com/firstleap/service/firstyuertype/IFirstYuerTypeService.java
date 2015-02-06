package com.firstleap.service.firstyuertype;


import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstChildinfoType;
import com.firstleap.entity.po.FirstYuerType;

/**
 * @author zsc
 * 
 */
public interface IFirstYuerTypeService extends BaseService {
	
	 /**
	 * @param firstChildinfo
	 * @return boolean
	 * 增加
	 */
	boolean save(FirstYuerType firstYuerType,String qubie);
	
	/**
	 * @param firstChildinfo
	 * @return boolean
	 * 修改
	 */
	boolean update(FirstYuerType firstYuerType);
	
	/**
	 * @param id
	 * @return boolean
	 * 删除
	 */
	String delete(String id);
	
	/**
	 * @param id
	 * @return
	 */
	FirstYuerType getByid(String id);

	
	/**
	 * @param pageNo
	 * @return
	 * 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstYuerType firstYuerType);
	
	public Pagination findAllOrQueryi(int pageNo, FirstYuerType firstYuerType);
	
	
	List<FirstYuerType> list(String hosid);
	
}
