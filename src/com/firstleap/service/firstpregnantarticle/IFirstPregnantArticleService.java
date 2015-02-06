package com.firstleap.service.firstpregnantarticle;


import java.io.File;
import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstPregnantArticle;

/**
 * @author zsc
 * 
 */
public interface IFirstPregnantArticleService extends BaseService {
	
	 /**
	 * @param firstChildinfo
	 * @return boolean
	 * 增加
	 */
	boolean save(FirstPregnantArticle firstPregnantArticle,File file,String fileFileName ,String fileContentType);
	
	/**
	 * @param firstChildinfo
	 * @return boolean
	 * 修改
	 */
	boolean update(FirstPregnantArticle firstPregnantArticle);
	
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
	FirstPregnantArticle getByid(String id);

	
	/**
	 * @param pageNo
	 * @return
	 * 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstPregnantArticle firstPregnantArticle);
	
	public Pagination findAllOrQueryi(int pageNo, FirstPregnantArticle firstPregnantArticle);
	
	
	List<FirstPregnantArticle> list(String hosid);
	
}
