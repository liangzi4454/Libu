package com.firstleap.service.firstyuerarticle;


import java.io.File;
import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstChildinfoArticle;
import com.firstleap.entity.po.FirstYuerArticle;

/**
 * @author zsc
 * 
 */
public interface IFirstYuerArticleService extends BaseService {
	
	 /**
	 * @param firstChildinfo
	 * @return boolean
	 * 增加
	 */
	boolean save(FirstYuerArticle firstYuerArticle,File file,String fileFileName ,String fileContentType);
	
	/**
	 * @param firstChildinfo
	 * @return boolean
	 * 修改
	 */
	boolean update(FirstYuerArticle firstYuerArticle);
	
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
	FirstYuerArticle getByid(String id);

	
	/**
	 * @param pageNo
	 * @return
	 * 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstYuerArticle firstYuerArticle);
	
	public Pagination findAllOrQueryi(int pageNo, FirstYuerArticle firstYuerArticle);
	
	
	List<FirstYuerArticle> list(String hosid);
	
}
