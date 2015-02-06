package com.firstleap.service.firstchildinfotype;


import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstChildinfoType;

/**
 * @author zsc
 * 
 */
public interface IFirstChildinfoTypeService extends BaseService {
	
	 /**
	 * @param firstChildinfo
	 * @return boolean
	 * 增加
	 */
	boolean save(FirstChildinfoType childinfoType,String qubie);
	
	/**
	 * @param firstChildinfo
	 * @return boolean
	 * 修改
	 */
	boolean update(FirstChildinfoType childinfoType);
	
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
	FirstChildinfoType getByid(String id);

	
	/**
	 * @param pageNo
	 * @return
	 * 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoType childinfoType);
	
	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoType childinfoType);
	
	
	List<FirstChildinfoType> list(String hosid);
	
}
