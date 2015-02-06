package com.firstleap.dao.firstchildinfotype;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstChildinfoType;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstChildinfoTypeDao extends BaseDao<FirstChildinfoType> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
