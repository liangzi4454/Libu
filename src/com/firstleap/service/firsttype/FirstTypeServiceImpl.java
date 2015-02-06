package com.firstleap.service.firsttype;


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
import com.firstleap.dao.firsttype.IFirstTypeDao;
import com.firstleap.entity.po.FirstType;

@Transactional
@Service("FirstTypeServiceImpl")
public class FirstTypeServiceImpl extends BaseServiceImpl implements
IFirstTypeService {

	@Autowired
	private IFirstTypeDao firstTypeDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstType firstType;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean saveFirstType(FirstType firstType,String qubie) {
		firstType.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
	
		if(qubie.equals("1")){
			firstType.setLibuTypeType("1");
		}
		if(qubie.equals("2")){
			firstType.setLibuTypeType("2");
		}
		firstType.setCreatedDate(new Date());
		firstType = firstTypeDao.save(firstType);
		if(null == firstType){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean updateFirstType(FirstType firstTypei) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		firstType = firstTypeDao.get(firstTypei.getId());//
		EntityTool.copyWithOutNull(firstType,firstTypei);  //
		FirstType retLtakChildinfo = (FirstType) firstTypeDao.update(firstType);
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
	public FirstType getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			firstType = firstTypeDao.get(id);
		}
		return firstType;
	}
	
	/* (non-Javadoc)
	 * ɾ��
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#deleteChildinfo(java.lang.String)
	 */
	@Override
	public String deleteFirstType(String id) {
		// TODO Auto-generated method stub
		String message = "";
		boolean flag = true;
		if(!(null == id || "".equals(id))){
			try {
				flag = firstTypeDao.delete(id);
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
	public Pagination findAllOrQuery(int pageNo, FirstType firstType) {
			String hql = "from FirstType l where l.libuTypeType = 1 ";
			return firstTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public Pagination findAllOrQueryi(int pageNo, FirstType firstType) {
			String hql = "from FirstType l where l.libuTypeType = 2 ";
			return firstTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	@Override
	public List<FirstType> listFirstBumen(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstType where libuTypeType = ? ";
		return firstTypeDao.findByListHql(hql, hosid);
		
	}

	
	
	
	
	/**************************封装get set***************************/
	public IFirstTypeDao getFirstTypeDao() {
		return firstTypeDao;
	}


	public void setFirstTypeDao(IFirstTypeDao firstTypeDao) {
		this.firstTypeDao = firstTypeDao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstType getFirstType() {
		return firstType;
	}


	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}


	
	
}
