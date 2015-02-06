package com.firstleap.dao.firstuserrole;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstUserRole;

/**
 * dao°£
 * 
 * ‘–∏æ
 * 
 * @author ’≈ ¿≥¨
 * 
 * @param <T>
 */
public interface IFirstUserRoleDao extends BaseDao<FirstUserRole> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
