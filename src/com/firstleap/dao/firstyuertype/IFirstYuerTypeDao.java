package com.firstleap.dao.firstyuertype;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstYuerType;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstYuerTypeDao extends BaseDao<FirstYuerType> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
