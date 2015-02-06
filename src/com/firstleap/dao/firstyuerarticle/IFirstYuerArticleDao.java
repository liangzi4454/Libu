package com.firstleap.dao.firstyuerarticle;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstYuerArticle;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstYuerArticleDao extends BaseDao<FirstYuerArticle> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
