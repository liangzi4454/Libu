package com.firstleap.service.firstyuertype;


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
import com.firstleap.dao.firstyuertype.IFirstYuerTypeDao;
import com.firstleap.entity.po.FirstYuerType;

@Transactional
@Service("FirstYuerTypeServiceImpl")
public class FirstYuerTypeServiceImpl extends BaseServiceImpl implements
IFirstYuerTypeService {

	@Autowired
	private IFirstYuerTypeDao dao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstYuerType yuerType;
	
	/* (non-Javadoc)
	 * 增加
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#saveChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean save(FirstYuerType firstYuerType,String qubie) {
		firstYuerType.setId(Tools.UUID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String da = sdf.format(new Date());
		if(qubie.equals("1")){
			firstYuerType.setLibuChildinfoType("1");
		}
		if(qubie.equals("2")){
			firstYuerType.setLibuChildinfoType("2");
		}
		firstYuerType.setCreatedDate(new Date());
		firstYuerType = dao.save(firstYuerType);
		if(null == firstYuerType){
			return false;
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * 修改
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#updateChildinfo(net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public boolean update(FirstYuerType firstYuerType) {
		Timestamp dateTime = new Timestamp(new Date().getTime());
		yuerType = dao.get(firstYuerType.getId());//
		EntityTool.copyWithOutNull(yuerType,firstYuerType);  //
		FirstYuerType retLtakChildinfo = (FirstYuerType) dao.update(yuerType);
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
	public FirstYuerType getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			yuerType = dao.get(id);
		}
		return yuerType;
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
	public Pagination findAllOrQuery(int pageNo, FirstYuerType firstYuerType) {
			String hql = "from FirstYuerType l where l.libuChildinfoType = 1 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	@Override
	public Pagination findAllOrQueryi(int pageNo, FirstYuerType firstYuerType ) {
			String hql = "from FirstYuerType l where l.libuChildinfoType = 2 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	@Override
	public List<FirstYuerType> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstYuerType l where l.libuChildinfoType = ? ";
		return dao.findByListHql(hql, hosid);
		
	}


	public IFirstYuerTypeDao getDao() {
		return dao;
	}


	public void setDao(IFirstYuerTypeDao dao) {
		this.dao = dao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstYuerType getYuerType() {
		return yuerType;
	}


	public void setYuerType(FirstYuerType yuerType) {
		this.yuerType = yuerType;
	}




	
	
}
