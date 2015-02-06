package com.firstleap.dao.firstwebtype;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstType;
import com.firstleap.entity.po.FirstWebType;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstWebTypeDao extends BaseDao<FirstWebType> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
