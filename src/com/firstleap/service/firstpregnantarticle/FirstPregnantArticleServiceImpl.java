package com.firstleap.service.firstpregnantarticle;


import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.common.util.DeleteFileUtil;
import com.firstleap.common.util.EntityTool;
import com.firstleap.common.util.Tools;
import com.firstleap.common.util.Upload;
import com.firstleap.common.util.UploadPaths;
import com.firstleap.dao.firstpregnantarticle.IFirstPregnantArticleDao;
import com.firstleap.entity.po.FirstPregnantArticle;

@Transactional
@Service("FirstPregnantArticleServiceImpl")
public class FirstPregnantArticleServiceImpl extends BaseServiceImpl implements
IFirstPregnantArticleService {

	@Autowired
	private IFirstPregnantArticleDao firstPregnantArticleDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstPregnantArticle firstPregnantArticle;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	
	public boolean save(FirstPregnantArticle firstPregnantArticle,File file,String fileFileName ,String fileContentType) {
		firstPregnantArticle.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
		if(null!=file&&file.length()>0){
			Date date = new Date();
			String uploadPath = ServletActionContext.getServletContext().getRealPath(UploadPaths.getSharePath()+"/")+File.separator;
			Long currentTime=System.currentTimeMillis();
        	String fileNameByTime =  currentTime.toString()+fileFileName;
        	Upload.uploadAttach(file, fileNameByTime, uploadPath);
        	firstPregnantArticle.setPregnantImage("\\"+UploadPaths.getSharePath()+"\\"+fileNameByTime);
		}
		firstPregnantArticle.setCreatedDate(new Date());
		firstPregnantArticle = firstPregnantArticleDao.save(firstPregnantArticle);
		if(null == firstPregnantArticle){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	
	public boolean update(FirstPregnantArticle firstPregnantArticlei) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		firstPregnantArticle = firstPregnantArticleDao.get(firstPregnantArticlei.getId());//
		EntityTool.copyWithOutNull(firstPregnantArticle,firstPregnantArticlei);  //
		FirstPregnantArticle retLtakChildinfo = (FirstPregnantArticle) firstPregnantArticleDao.update(firstPregnantArticle);
		if(retLtakChildinfo != null) {
			return true;
		}
			return false;
	}

	
	/* (non-Javadoc)
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	
	public FirstPregnantArticle getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			firstPregnantArticle = firstPregnantArticleDao.get(id);
		}
		return firstPregnantArticle;
	}
	
	/* (non-Javadoc)
	 * ɾ��
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#deleteChildinfo(java.lang.String)
	 */
	
	public String delete(String id) {
		// TODO Auto-generated method stub
		String message = "";
		boolean flag = true;
		if(!(null == id || "".equals(id))){
			try {
				FirstPregnantArticle mt = firstPregnantArticleDao.get(id);
				String syspath=ServletActionContext.getServletContext().getRealPath("/");//获取路径
				String hhe = mt.getPregnantImage().substring(mt.getPregnantImage().indexOf("\\")+1); 
				String he = syspath+mt.getPregnantImage().substring(0,mt.getPregnantImage().indexOf("\\"))+"\\"+hhe;//获取文件的绝对路径 
				DeleteFileUtil.delete(he); //删除文件
				flag = firstPregnantArticleDao.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 message ="sccg";
		}
		return message;
	}
	
	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	
	public Pagination findAllOrQuery(int pageNo, FirstPregnantArticle firstPregnantArticle) {
			String hql = "from FirstPregnantArticle l where 1 = 1";
			return firstPregnantArticleDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	
	public Pagination findAllOrQueryi(int pageNo, FirstPregnantArticle firstPregnantArticle) {
			String hql = "from FirstPregnantArticle l where l = 1 ";
			return firstPregnantArticleDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	
	public List<FirstPregnantArticle> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstPregnantArticle l where 1 = 1 ";
		return firstPregnantArticleDao.findByListHql(hql, hosid);
		
	}


	/**************************封装get set***************************/
	public IFirstPregnantArticleDao getFirstPregnantArticleDao() {
		return firstPregnantArticleDao;
	}


	public void setFirstPregnantArticleDao(
			IFirstPregnantArticleDao firstPregnantArticleDao) {
		this.firstPregnantArticleDao = firstPregnantArticleDao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstPregnantArticle getFirstPregnantArticle() {
		return firstPregnantArticle;
	}


	public void setFirstPregnantArticle(FirstPregnantArticle firstPregnantArticle) {
		this.firstPregnantArticle = firstPregnantArticle;
	}



	

	
	
	
	

	
	
}
