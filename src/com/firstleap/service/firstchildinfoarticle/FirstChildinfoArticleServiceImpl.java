package com.firstleap.service.firstchildinfoarticle;


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
import com.firstleap.dao.firstchildinfoarticle.IFirstChildinfoArticleDao;
import com.firstleap.entity.po.FirstChildinfoArticle;

@Transactional
@Service("FirstChildinfoArticleServiceImpl")
public class FirstChildinfoArticleServiceImpl extends BaseServiceImpl implements
IFirstChildinfoArticleService {

	@Autowired
	private IFirstChildinfoArticleDao dao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstChildinfoArticle childinfoArticle;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	
	public boolean save(FirstChildinfoArticle firstChildinfoArticle,File file,String fileFileName ,String fileContentType) {
		firstChildinfoArticle.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
		if(null!=file&&file.length()>0){
			Date date = new Date();
			String uploadPath = ServletActionContext.getServletContext().getRealPath(UploadPaths.getSharePath()+"/")+File.separator;
			Long currentTime=System.currentTimeMillis();
        	String fileNameByTime =  currentTime.toString()+fileFileName;
        	Upload.uploadAttach(file, fileNameByTime, uploadPath);
        	firstChildinfoArticle.setChildinfoImage("\\"+UploadPaths.getSharePath()+"\\"+fileNameByTime);
		}
		firstChildinfoArticle.setCreatedDate(new Date());
		firstChildinfoArticle = dao.save(firstChildinfoArticle);
		if(null == firstChildinfoArticle){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	
	public boolean update(FirstChildinfoArticle firstChildinfoArticle) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		childinfoArticle = dao.get(firstChildinfoArticle.getId());//
		EntityTool.copyWithOutNull(childinfoArticle,firstChildinfoArticle);  //
		FirstChildinfoArticle retLtakChildinfo = (FirstChildinfoArticle) dao.update(childinfoArticle);
		if(retLtakChildinfo != null) {
			return true;
		}
			return false;
	}

	
	/* (non-Javadoc)
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	
	public FirstChildinfoArticle getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			childinfoArticle = dao.get(id);
		}
		return childinfoArticle;
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
				FirstChildinfoArticle mt = dao.get(id);
				if(mt.getChildinfoImage() != null){
					String syspath=ServletActionContext.getServletContext().getRealPath("/");//获取路径
					String hhe = mt.getChildinfoImage().substring(mt.getChildinfoImage().indexOf("\\")+1); 
					String he = syspath+mt.getChildinfoImage().substring(0,mt.getChildinfoImage().indexOf("\\"))+"\\"+hhe;//获取文件的绝对路径 
					DeleteFileUtil.delete(he); //删除文件
				}
				
				flag = dao.delete(id);
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
	
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoArticle firstChildinfoArticle) {
			String hql = "from FirstChildinfoArticle l where 1 = 1 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	
	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoArticle firstChildinfoArticle) {
			String hql = "from FirstChildinfoArticle l where l = 1 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	
	public List<FirstChildinfoArticle> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstChildinfoArticle l where 1 = 1 ";
		return dao.findByListHql(hql, hosid);
		
	}

	

	
	
	/**************************封装get set***************************/

	public IFirstChildinfoArticleDao getDao() {
		return dao;
	}


	public void setDao(IFirstChildinfoArticleDao dao) {
		this.dao = dao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstChildinfoArticle getChildinfoArticle() {
		return childinfoArticle;
	}


	public void setChildinfoArticle(FirstChildinfoArticle childinfoArticle) {
		this.childinfoArticle = childinfoArticle;
	}



	
	
}
