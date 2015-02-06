package com.firstleap.service.firsttype;


import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstType;

/**
 * @author zsc
 * 
 */
public interface IFirstTypeService extends BaseService {
	
	 /**
	 * @param firstChildinfo
	 * @return booleanxcbbbbbbbbbbbbbbbb
	 * 增加
	 */
	boolean saveFirstType(FirstType firstType,String qubie);
	
	/**
	 * @param firstChildinfo
	 * @return boolean
	 * 修改
	 */
	boolean updateFirstType(FirstType firstType);
	
	/**
	 * @param id
	 * @return boolean
	 * 删除
	 */
	String deleteFirstType(String id);
	
	/**
	 * @param id
	 * @return
	 */
	FirstType getByid(String id);

	
	/**
	 * @param pageNo
	 * @return
	 * 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstType firstType);
	
	public Pagination findAllOrQueryi(int pageNo, FirstType firstType);
	
	
	List<FirstType> listFirstBumen(String hosid);
	
}
