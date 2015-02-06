package com.firstleap.dao.firstpregnanttype;

import org.springframework.stereotype.Repository;

import com.firstleap.common.hibernate.BaseDaoImpl;
import com.firstleap.common.hibernate.Finder;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstPregnantType;

/**
 * dao��
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
@Repository("FirstPregnantTypeDaoImpl")
public class FirstPregnantTypeDaoImpl extends BaseDaoImpl<FirstPregnantType> implements IFirstPregnantTypeDao  {

	/* (non-Javadoc)
	 * @see net.bjstd.entity.system.commdatadict.dao.ICommdataDictDao#queryByPagination(int, int, java.lang.String)
	 * 
	 */
	public Pagination queryByPagination(int pageNo, int pageSize, String aid) {
		String hql = "from FirstPregnantType where id='"+aid+"'";
		hql += " ORDER BY id asc";
		Finder finder = Finder.create(hql);
		return find(finder, pageNo, pageSize);
	}
	
}
