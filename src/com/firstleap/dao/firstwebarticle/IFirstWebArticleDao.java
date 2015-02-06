package com.firstleap.dao.firstwebarticle;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstWebArticle;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstWebArticleDao extends BaseDao<FirstWebArticle> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
