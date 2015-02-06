package com.firstleap.dao.firstpregnantarticle;

import org.springframework.stereotype.Repository;

import com.firstleap.common.hibernate.BaseDaoImpl;
import com.firstleap.common.hibernate.Finder;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstPregnantArticle;

/**
 * dao��
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
@Repository("FirstPregnantArticleDaoImpl")
public class FirstPregnantArticleDaoImpl extends BaseDaoImpl<FirstPregnantArticle> implements IFirstPregnantArticleDao  {

	/* (non-Javadoc)
	 * @see net.bjstd.entity.system.commdatadict.dao.ICommdataDictDao#queryByPagination(int, int, java.lang.String)
	 * 
	 */
	public Pagination queryByPagination(int pageNo, int pageSize, String aid) {
		String hql = "from FirstPregnantArticle where id='"+aid+"'";
		hql += " ORDER BY id asc";
		Finder finder = Finder.create(hql);
		return find(finder, pageNo, pageSize);
	}
	
}
