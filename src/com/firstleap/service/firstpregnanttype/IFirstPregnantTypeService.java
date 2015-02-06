package com.firstleap.service.firstpregnanttype;


import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstPregnantType;

/**
 * @author zsc
 * 
 */
public interface IFirstPregnantTypeService extends BaseService {
	
	 /**
	 * @param firstChildinfo
	 * @return boolean
	 * 增加
	 */
	boolean saveFirstPregnantType(FirstPregnantType firstPregnantType,String qubie);
	
	/**
	 * @param firstChildinfo
	 * @return boolean
	 * 修改
	 */
	boolean updateFirstPregnantType(FirstPregnantType firstPregnantType);
	
	/**
	 * @param id
	 * @return boolean
	 * 删除
	 */
	String deleteFirstPregnantType(String id);
	
	/**
	 * @param id
	 * @return
	 */
	FirstPregnantType getByid(String id);

	
	/**
	 * @param pageNo
	 * @return
	 * 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstPregnantType firstPregnantType);
	
	public Pagination findAllOrQueryi(int pageNo, FirstPregnantType firstPregnantType);
	
	
	List<FirstPregnantType> listFirstPregnantType(String hosid);
	
}
