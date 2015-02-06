package com.firstleap.service.firstyuerarticle;


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
import com.firstleap.dao.firstyuerarticle.IFirstYuerArticleDao;
import com.firstleap.entity.po.FirstYuerArticle;

@Transactional
@Service("FirstYuerArticleServiceImpl")
public class FirstYuerArticleServiceImpl extends BaseServiceImpl implements
IFirstYuerArticleService {

	@Autowired
	private IFirstYuerArticleDao dao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstYuerArticle yuerArticle;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean save(FirstYuerArticle firstYuerArticle,File file,String fileFileName ,String fileContentType) {
		firstYuerArticle.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
		if(null!=file&&file.length()>0){
			Date date = new Date();
			String uploadPath = ServletActionContext.getServletContext().getRealPath(UploadPaths.getSharePath()+"/")+File.separator;
			Long currentTime=System.currentTimeMillis();
        	String fileNameByTime =  currentTime.toString()+fileFileName;
        	Upload.uploadAttach(file, fileNameByTime, uploadPath);
        	firstYuerArticle.setChildinfoImage("\\"+UploadPaths.getSharePath()+"\\"+fileNameByTime);
		}
		firstYuerArticle.setCreatedDate(new Date());
		firstYuerArticle = dao.save(firstYuerArticle);
		if(null == firstYuerArticle){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean update(FirstYuerArticle firstYuerArticle) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		yuerArticle = dao.get(firstYuerArticle.getId());//
		EntityTool.copyWithOutNull(yuerArticle,firstYuerArticle);  //
		FirstYuerArticle retLtakChildinfo = (FirstYuerArticle) dao.update(yuerArticle);
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
	public FirstYuerArticle getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			yuerArticle = dao.get(id);
		}
		return yuerArticle;
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
				FirstYuerArticle mt = dao.get(id);
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
	@Override
	public Pagination findAllOrQuery(int pageNo, FirstYuerArticle firstYuerArticle) {
			String hql = "from FirstYuerArticle l where 1 = 1 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public Pagination findAllOrQueryi(int pageNo, FirstYuerArticle firstYuerArticle) {
			String hql = "from FirstYuerArticle l where l = 1 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	@Override
	public List<FirstYuerArticle> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstYuerArticle l where 1 = 1 ";
		return dao.findByListHql(hql, hosid);
		
	}


	public IFirstYuerArticleDao getDao() {
		return dao;
	}


	public void setDao(IFirstYuerArticleDao dao) {
		this.dao = dao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstYuerArticle getYuerArticle() {
		return yuerArticle;
	}


	public void setYuerArticle(FirstYuerArticle yuerArticle) {
		this.yuerArticle = yuerArticle;
	}

	

	
	
	
	
}
