package com.firstleap.service.firstchildinfotype;


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
import com.firstleap.dao.firstchildinfotype.IFirstChildinfoTypeDao;
import com.firstleap.entity.po.FirstChildinfoType;

@Transactional
@Service("FirstChildinfoTypeServiceImpl")
public class FirstChildinfoTypeServiceImpl extends BaseServiceImpl implements
IFirstChildinfoTypeService {

	@Autowired
	private IFirstChildinfoTypeDao dao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstChildinfoType childinfoType;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	
	public boolean save(FirstChildinfoType firstChildinfoType,String qubie) {
		firstChildinfoType.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
		if(qubie.equals("1")){
			firstChildinfoType.setLibuChildinfoType("1");
		}
		if(qubie.equals("2")){
			firstChildinfoType.setLibuChildinfoType("2");
		}
		firstChildinfoType.setCreatedDate(new Date());
		firstChildinfoType = dao.save(firstChildinfoType);
		if(null == firstChildinfoType){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	
	public boolean update(FirstChildinfoType firstChildinfoType) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		childinfoType = dao.get(firstChildinfoType.getId());//
		EntityTool.copyWithOutNull(childinfoType,firstChildinfoType);  //
		FirstChildinfoType retLtakChildinfo = (FirstChildinfoType) dao.update(childinfoType);
		if(retLtakChildinfo != null) {
			return true;
		}
			return false;
	}

	
	/* (non-Javadoc)
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	
	public FirstChildinfoType getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			childinfoType = dao.get(id);
		}
		return childinfoType;
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
	
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoType firstChildinfoType) {
			String hql = "from FirstChildinfoType l where l.libuChildinfoType = 1 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	
	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoType firstChildinfoType) {
			String hql = "from FirstChildinfoType l where l.libuChildinfoType = 2 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	
	public List<FirstChildinfoType> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstChildinfoType l where l.libuChildinfoType = ? ";
		return dao.findByListHql(hql, hosid);
		
	}




	

	
	
	/**************************封装get set***************************/
	
	public IFirstChildinfoTypeDao getDao() {
		return dao;
	}


	public void setDao(IFirstChildinfoTypeDao dao) {
		this.dao = dao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstChildinfoType getChildinfoType() {
		return childinfoType;
	}


	public void setChildinfoType(FirstChildinfoType childinfoType) {
		this.childinfoType = childinfoType;
	}


	
	
}
