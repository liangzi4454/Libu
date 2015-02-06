package com.firstleap.dao.firstuserrole;

import org.springframework.stereotype.Repository;

import com.firstleap.common.hibernate.BaseDaoImpl;
import com.firstleap.common.hibernate.Finder;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstUserRole;

/**
 * dao。
 * 
 * 孕妇
 * 
 * @author 张世超
 * 
 * @param <T>
 */
@Repository("FirstUserRoleDaoImpl")
public class FirstUserRoleDaoImpl extends BaseDaoImpl<FirstUserRole> implements IFirstUserRoleDao  {

	/* (non-Javadoc)
	 * @see net.bjstd.entity.system.commdatadict.dao.ICommdataDictDao#queryByPagination(int, int, java.lang.String)
	 * 根据ID分页查新
	 */
	public Pagination queryByPagination(int pageNo, int pageSize, String aid) {
		String hql = "from FirstHospital where hospitalId='"+aid+"'";
		hql += " ORDER BY hospitalId asc";
		Finder finder = Finder.create(hql);
		return find(finder, pageNo, pageSize);
	}
	
}
