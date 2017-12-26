package com.jnhouse.app.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnhouse.app.bean.FkeEast;
import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.dao.FkeEastDao;
import com.jnhouse.app.dao.SupAnswerHeaderDao;
import com.jnhouse.app.dao.SupAnswerLineDao;
import com.jnhouse.app.dao.SupTemplateDao;
import com.jnhouse.app.dto.SupAnswerHeaderDTO;
import com.jnhouse.app.dto.SupAnswerHeaderLineDTO;
import com.jnhouse.app.service.SupAnswerHeaderService;

@Service
public class SupAnswerHeaderServiceImpl extends BaseServiceImpl<SupAnswerHeader> implements SupAnswerHeaderService{

	@Resource
	private SupAnswerHeaderDao supAnswerHeaderDao;
	
	@Resource
	private SupAnswerLineDao supAnswerLineDao;
	
	@Resource
	private SupTemplateDao supTemplateDao;
	
	
	@Resource
	private FkeEastDao fkeEastDao;
	
	/**
	 * App 接口
	 * @author 许晨
	 * @param method 考核开始  保存考核信息
	 */
	@Override
	public int save(SupAnswerHeader supAnswerHeader) {
		// TODO Auto-generated method stub

	
		return supAnswerHeaderDao.save(supAnswerHeader);
	
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return supAnswerHeaderDao.delete(id);
	}

	@Override
	public int update(SupAnswerHeader entity) {
		// TODO Auto-generated method stub
		return supAnswerHeaderDao.update(entity);
	}

	@Override
	public SupAnswerHeader getById(Integer id) {
		// TODO Auto-generated method stub
		return supAnswerHeaderDao.getById(id);
	}

	@Override
	public List<SupAnswerHeader> findAll() {
		// TODO Auto-generated method stub
		return supAnswerHeaderDao.findAll();
	}


	/**
	 * App接口  考核开始
	 * @Transactional(propagation=Propagation.NOT_SUPPORTED)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<SupAnswerLine> saveAndBackLineIds(SupAnswerHeader supAnswerHeader,List<SupAnswerHeaderLineDTO> supAnswerHeaderDTOs) {
		// TODO Auto-generated method stub
		
		Timestamp ssuress = new Timestamp(System.currentTimeMillis());
		supAnswerHeader.setCreated_time(String.valueOf(ssuress));
		supAnswerHeader.setUpdated_time(ssuress);
		int c = supAnswerHeaderDao.save(supAnswerHeader);
		
		List<SupAnswerLine> supAnswerHeaderLines  =  null;
		if(c==1){
			c = supAnswerLineDao.insertBatchSupAnswerLine(supAnswerHeader.getId(), supAnswerHeaderDTOs);
			SupAnswerLine supAnswerLine = new SupAnswerLine();
			supAnswerLine.setHeader_id(supAnswerHeader.getId());
			supAnswerLine.setIs_delete(1);
			supAnswerHeaderLines = supAnswerLineDao.findAllLineId(supAnswerLine);

		}
		return supAnswerHeaderLines;
	}

	@Override
	public List<FkeEast> findStoreInfoList(SupAnswerHeader supAnswerHeader) {
		// TODO Auto-generated method stub

		return fkeEastDao.findStoreInfoList(supAnswerHeader);
	}

	/**
	 * App 接口 
	 * 
	 * method 查询订单详情信息
	 */
	@Override
	public SupAnswerHeaderDTO supAnswerHeader(SupAnswerHeader supAnswerHeader) {
		// TODO Auto-generated method stub

		
		//List<SupAnswerHeaderDTO> supAnswerHeaderDTOs = new ArrayList<SupAnswerHeaderDTO>();
		SupAnswerHeaderDTO supAnswerHeaderDTO = supAnswerHeaderDao.getByHeaderId(supAnswerHeader);

//		if(supAnswerHeaderDTO!=null){
//			
//			SupAnswerHeaderDTO supAnswerHeaderDTO2 = new SupAnswerHeaderDTO();
//			//设置模版的id
//			supAnswerHeaderDTO2.setParent_id(supAnswerHeaderDTO.getTemplate_id());
//			//设置主键的id
//			supAnswerHeaderDTO2.setHeader_id(supAnswerHeaderDTO.getId());
//			//查询所有的一级模版列表   和内容详情并列
//			//List<Integer> arrayList = new ArrayList<Integer>();
			


		return supAnswerHeaderDTO;
	}

	@Override
	public List<SupAnswerHeaderDTO> findAnswerHeaderAndLine(SupAnswerHeaderDTO supAnswerHeaderDTO) {
		// TODO Auto-generated method stub
		return supAnswerHeaderDao.findAnswerHeaderAndLine(supAnswerHeaderDTO);
	}

	@Override
	public List<SupAnswerHeaderDTO> findSecondHeader(SupAnswerHeaderDTO supAnswerHeaderDTO) {
		// TODO Auto-generated method stub
		return supAnswerHeaderDao.findSecondHeader(supAnswerHeaderDTO);
	}


}
