package com.firstleap.service.firstwebtype;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.common.util.EntityTool;
import com.firstleap.common.util.Tools;
import com.firstleap.dao.firstwebtype.IFirstWebTypeDao;
import com.firstleap.entity.po.FirstWebType;

@Transactional
@Service("FirstWebTypeServiceImpl")
public class FirstWebTypeServiceImpl extends BaseServiceImpl implements
IFirstWebTypeService {

	@Autowired
	private IFirstWebTypeDao firstWebTypeDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstWebType firstWebType;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	
	public boolean saveFirstWebType(FirstWebType firstWebType,String qubie) {
		firstWebType.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
		if(qubie.equals("1")){
			firstWebType.setLibuWebType("1");
		}
		if(qubie.equals("2")){
			firstWebType.setLibuWebType("2");
		}
		firstWebType.setCreatedDate(new Date());
		firstWebType = firstWebTypeDao.save(firstWebType);
		if(null == firstWebType){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	
	public boolean updateFirstWebType(FirstWebType firstWebTypei) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		firstWebType = firstWebTypeDao.get(firstWebTypei.getId());//
		EntityTool.copyWithOutNull(firstWebType,firstWebTypei);  //
		FirstWebType retLtakChildinfo = (FirstWebType) firstWebTypeDao.update(firstWebType);
		if(retLtakChildinfo != null) {
			return true;
		}
			return false;
	}

	
	/* (non-Javadoc)
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	
	public FirstWebType getByid(String id) {
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
	
	public String deleteFirstWebType(String id) {
		// TODO Auto-generated method stub
		String message = "";
		boolean flag = true;
		if(!(null == id || "".equals(id))){
			try {
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
	
	public Pagination findAllOrQuery(int pageNo, FirstWebType firstWebType) {
			String hql = "from FirstWebType l where l.libuWebType = 1 ";
			return firstWebTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	
	public Pagination findAllOrQueryi(int pageNo, FirstWebType firstWebType) {
			String hql = "from FirstWebType l where l.libuWebType = 2 ";
			return firstWebTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	
	public List<FirstWebType> listFirstWebType(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstWebType l where l.libuWebType = ? ";
		return firstWebTypeDao.findByListHql(hql, hosid);
		
	}


	
	

	
	
	/**************************封装get set***************************/
	

	
	
	public IFirstWebTypeDao getFirstWebTypeDao() {
		return firstWebTypeDao;
	}


	public void setFirstWebTypeDao(IFirstWebTypeDao firstWebTypeDao) {
		this.firstWebTypeDao = firstWebTypeDao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstWebType getFirstWebType() {
		return firstWebType;
	}


	public void setFirstWebType(FirstWebType firstWebType) {
		this.firstWebType = firstWebType;
	}

	
	
}
