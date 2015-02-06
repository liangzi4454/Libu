package com.firstleap.service.firstwebarticle;


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
import com.firstleap.dao.firstwebarticle.IFirstWebArticleDao;
import com.firstleap.entity.po.FirstWebArticle;

@Transactional
@Service("FirstWebArticleServiceImpl")
public class FirstWebArticleServiceImpl extends BaseServiceImpl implements
IFirstWebArticleService {

	@Autowired
	private IFirstWebArticleDao firstWebTypeDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstWebArticle firstWebType;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean save(FirstWebArticle firstWebArticle,File file,String fileFileName ,String fileContentType) {
		firstWebArticle.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
		if(null!=file&&file.length()>0){
			Date date = new Date();
			String uploadPath = ServletActionContext.getServletContext().getRealPath(UploadPaths.getSharePath()+"/")+File.separator;
			Long currentTime=System.currentTimeMillis();
        	String fileNameByTime =  currentTime.toString()+fileFileName;
        	Upload.uploadAttach(file, fileNameByTime, uploadPath);
        	firstWebArticle.setWebImage("\\"+UploadPaths.getSharePath()+"\\"+fileNameByTime);
		}
		firstWebArticle.setCreatedDate(new Date());
		firstWebArticle = firstWebTypeDao.save(firstWebArticle);
		if(null == firstWebArticle){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean update(FirstWebArticle firstWebArticle) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		firstWebType = firstWebTypeDao.get(firstWebArticle.getId());//
		EntityTool.copyWithOutNull(firstWebType,firstWebArticle);  //
		FirstWebArticle retLtakChildinfo = (FirstWebArticle) firstWebTypeDao.update(firstWebType);
		if(retLtakChildinfo != null) {
			return true;
		}
			return false;
	}

	
	/* (non-Javadoc)
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	@Override
	public FirstWebArticle getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			firstWebType = firstWebTypeDao.get(id);
		}
		return firstWebType;
	}
	
	/* (non-Javadoc)
	 * ɾ��
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#deleteChildinfo(java.lang.String)
	 */
	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		String message = "";
		boolean flag = true;
		if(!(null == id || "".equals(id))){
			try {
				FirstWebArticle mt = firstWebTypeDao.get(id);
				System.out.println(mt.getWebImage());
				if(mt.getWebImage() != null ){
					String syspath=ServletActionContext.getServletContext().getRealPath("/");//获取路径
					String hhe = mt.getWebImage().substring(mt.getWebImage().indexOf("\\")+1); 
					String he = syspath+mt.getWebImage().substring(0,mt.getWebImage().indexOf("\\"))+"\\"+hhe;//获取文件的绝对路径 
					DeleteFileUtil.delete(he); //删除文件
				}
				
				flag = firstWebTypeDao.delete(id);
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
	@Override
	public Pagination findAllOrQuery(int pageNo, FirstWebArticle firstWebArticle) {
			String hql = "from FirstWebArticle l where 1 = 1 ";
			return firstWebTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public Pagination findAllOrQueryi(int pageNo, FirstWebArticle firstWebArticle) {
			String hql = "from FirstWebArticle l where l = 1 ";
			return firstWebTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	@Override
	public List<FirstWebArticle> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstWebArticle l where 1 = 1 ";
		return firstWebTypeDao.findByListHql(hql, hosid);
		
	}



	

	
	
	/**************************封装get set***************************/
	public IFirstWebArticleDao getFirstWebTypeDao() {
		return firstWebTypeDao;
	}


	public void setFirstWebTypeDao(IFirstWebArticleDao firstWebTypeDao) {
		this.firstWebTypeDao = firstWebTypeDao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstWebArticle getFirstWebType() {
		return firstWebType;
	}


	public void setFirstWebType(FirstWebArticle firstWebType) {
		this.firstWebType = firstWebType;
	}


	
	
}
