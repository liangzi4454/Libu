package com.firstleap.dao.firsttype;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstType;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstTypeDao extends BaseDao<FirstType> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
