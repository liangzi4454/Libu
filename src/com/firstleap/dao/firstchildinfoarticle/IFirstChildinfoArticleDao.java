package com.firstleap.dao.firstchildinfoarticle;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstChildinfoArticle;

/**
 * 
 * 
 * 
 * 
 * @author 
 * 
 * @param <T>
 */
public interface IFirstChildinfoArticleDao extends BaseDao<FirstChildinfoArticle> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
	
	
}
