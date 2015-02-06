package com.firstleap.dao.firstpregnantarticle;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstPregnantArticle;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstPregnantArticleDao extends BaseDao<FirstPregnantArticle> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
