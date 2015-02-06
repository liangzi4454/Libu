package com.firstleap.service.firstpregnanttype;


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
import com.firstleap.dao.firstpregnanttype.IFirstPregnantTypeDao;
import com.firstleap.entity.po.FirstPregnantType;

@Transactional
@Service("FirstPregnantTypeServiceImpl")
public class FirstPregnantTypeServiceImpl extends BaseServiceImpl implements
IFirstPregnantTypeService {

	@Autowired
	private IFirstPregnantTypeDao firstPregnantTypeDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstPregnantType firstPregnantType;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean saveFirstPregnantType(FirstPregnantType firstPregnantType,String qubie) {
		firstPregnantType.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
		if(qubie.equals("1")){
			firstPregnantType.setLibuPregnantType("1");
		}
		if(qubie.equals("2")){
			firstPregnantType.setLibuPregnantType("2");
		}
		firstPregnantType.setCreatedDate(new Date());
		firstPregnantType = firstPregnantTypeDao.save(firstPregnantType);
		if(null == firstPregnantType){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean updateFirstPregnantType(FirstPregnantType firstPregnantTypei) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		firstPregnantType = firstPregnantTypeDao.get(firstPregnantType.getId());//
		EntityTool.copyWithOutNull(firstPregnantType,firstPregnantTypei);  //
		FirstPregnantType retLtakChildinfo = (FirstPregnantType) firstPregnantTypeDao.update(firstPregnantType);
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
	public FirstPregnantType getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			firstPregnantType = firstPregnantTypeDao.get(id);
		}
		return firstPregnantType;
	}
	
	/* (non-Javadoc)
	 * ɾ��
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#deleteChildinfo(java.lang.String)
	 */
	@Override
	public String deleteFirstPregnantType(String id) {
		// TODO Auto-generated method stub
		String message = "";
		boolean flag = true;
		if(!(null == id || "".equals(id))){
			try {
				flag = firstPregnantTypeDao.delete(id);
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
	public Pagination findAllOrQuery(int pageNo, FirstPregnantType firstPregnantType) {
			String hql = "from FirstPregnantType l where l.libuPregnantType = 1 ";
			return firstPregnantTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public Pagination findAllOrQueryi(int pageNo, FirstPregnantType firstPregnantType) {
			String hql = "from FirstPregnantType l where l.libuPregnantType = 2 ";
			return firstPregnantTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	@Override
	public List<FirstPregnantType> listFirstPregnantType(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstPregnantType l where l.libuPregnantType = ? ";
		return firstPregnantTypeDao.findByListHql(hql, hosid);
		
	}

	
	/**************************封装get set***************************/
	public IFirstPregnantTypeDao getFirstPregnantTypeDao() {
		return firstPregnantTypeDao;
	}


	public void setFirstPregnantTypeDao(IFirstPregnantTypeDao firstPregnantTypeDao) {
		this.firstPregnantTypeDao = firstPregnantTypeDao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstPregnantType getFirstPregnantType() {
		return firstPregnantType;
	}


	public void setFirstPregnantType(FirstPregnantType firstPregnantType) {
		this.firstPregnantType = firstPregnantType;
	}


	
	

	
	
	
	

	
	
	
	
	
}
