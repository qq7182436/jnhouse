package com.jnhouse.app.service.impl;




import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.dao.SupAnswerHeaderDao;
import com.jnhouse.app.dao.SupAnswerLineDao;

import com.jnhouse.app.service.SupAnswerLineService;

@Service
public class SupAnswerLineServiceImpl extends BaseServiceImpl<SupAnswerLine> implements SupAnswerLineService {

	@Resource
	SupAnswerLineDao supAnswerLineDao;
	

	@Resource
	SupAnswerHeaderDao supAnswerHeaderDao;
	
	@Override
	public int save(SupAnswerLine entity) {
		// TODO Auto-generated method stub
		return supAnswerLineDao.save(entity);
	}
	

	public int insert(SupAnswerLine entity) {
		// TODO Auto-generated method stub
		return supAnswerLineDao.save(entity);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return supAnswerLineDao.delete(id);
	}

	@Override
	public int update(SupAnswerLine entity) {
		// TODO Auto-generated method stub
		return supAnswerLineDao.update(entity);
	}

	@Override
	public SupAnswerLine getById(Integer id) {
		// TODO Auto-generated method stub
		return supAnswerLineDao.getById(id);
	}

	
	@Override
	public List<SupAnswerLine> findAll() {
		// TODO Auto-generated method stub
		return supAnswerLineDao.findAll();
	}


	@Override
	public int updateByPrimaryKeySelective(SupAnswerLine supAnswerLine) {
		// TODO Auto-generated method stub
		//批量跟新
		return 0;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateBatchLineAndSaveHeaderInfo(List<SupAnswerLine> supAnswerLineList,SupAnswerHeader supAnswerHeader) {
		// TODO Auto-generated method stub
		
		SupAnswerLine supAnswerLine2 = new SupAnswerLine();
		supAnswerLine2.setId(supAnswerLineList.get(0).getId());	

		SupAnswerLine newSuAnsLine = supAnswerLineDao.findByHeaderId(supAnswerLine2);
		int c =0;
		if(newSuAnsLine != null){
			supAnswerHeader.setId(newSuAnsLine.getHeader_id());
			
			c = supAnswerHeaderDao.update(supAnswerHeader);
			if(c == 1){
				supAnswerLineDao.updateBatch(supAnswerLineList);
			}
		}
		return c;
	}
	
}
