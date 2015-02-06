package com.firstleap.dao.firstpregnanttype;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstPregnantType;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstPregnantTypeDao extends BaseDao<FirstPregnantType> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
