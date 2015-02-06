package com.firstleap.service.firstchildinfoarticle;


import java.io.File;
import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstChildinfoArticle;

/**
 * @author zsc
 * 
 */
public interface IFirstChildinfoArticleService extends BaseService {
	
	 /**
	 * @param firstChildinfo
	 * @return boolean
	 * 增加
	 */
	boolean save(FirstChildinfoArticle firstChildinfoArticle,File file,String fileFileName ,String fileContentType);
	
	/**
	 * @param firstChildinfo
	 * @return boolean
	 * 修改
	 */
	boolean update(FirstChildinfoArticle firstChildinfoArticle);
	
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
	FirstChildinfoArticle getByid(String id);

	
	/**
	 * @param pageNo
	 * @return
	 * 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoArticle firstChildinfoArticle);
	
	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoArticle firstChildinfoArticle);
	
	
	List<FirstChildinfoArticle> list(String hosid);
	
}
