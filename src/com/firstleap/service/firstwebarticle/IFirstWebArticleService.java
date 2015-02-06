package com.firstleap.service.firstwebarticle;


import java.io.File;
import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstWebArticle;
import com.firstleap.entity.po.FirstWebType;

/**
 * @author zsc
 * 
 */
public interface IFirstWebArticleService extends BaseService {
	
	 /**
	 * @param firstChildinfo
	 * @return boolean
	 * 增加
	 */
	boolean save(FirstWebArticle firstWebArticle,File file,String fileFileName ,String fileContentType);
	
	/**
	 * @param firstChildinfo
	 * @return boolean
	 * 修改
	 */
	boolean update(FirstWebArticle firstWebArticle);
	
	/**
	 * @param id
	 * @return boolean
	 * 删除
	 */
	String delete(String id);
	
	/**
	 * @param id
	 * @return
	 */
	FirstWebArticle getByid(String id);

	
	/**
	 * @param pageNo
	 * @return
	 * 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstWebArticle firstWebArticle);
	
	public Pagination findAllOrQueryi(int pageNo, FirstWebArticle firstWebArticle);
	
	
	List<FirstWebArticle> list(String hosid);
	
}
