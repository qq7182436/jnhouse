package com.jnhouse.app.service.impl;

/*import static org.junit.Assert.*;*/

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupTemplate;

import com.jnhouse.app.dao.SupAnswerHeaderDao;
import com.jnhouse.app.dao.SupTemplateDao;
import com.jnhouse.app.service.SupTemplateService;


@Service
public class SupTemplateServiceImpl extends BaseServiceImpl<SupTemplate> implements SupTemplateService {

	@Resource
	SupTemplateDao supTemplateDao;
	
	@Resource
	SupAnswerHeaderDao supAnswerHeaderDao;
	
	@Override
	public int save(SupTemplate entity) {
		// TODO Auto-generated method stub
		return supTemplateDao.save(entity);
	}
	

	public int insert(SupAnswerHeader entity) {
		// TODO Auto-generated method stub
		return supAnswerHeaderDao.save(entity);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return supTemplateDao.delete(id);
	}

	@Override
	public int update(SupTemplate entity) {
		// TODO Auto-generated method stub
		return supTemplateDao.update(entity);
	}

	@Override
	public SupTemplate getById(Integer id) {
		// TODO Auto-generated method stub
		return supTemplateDao.getById(id);
	}

	
	@Override
	public List<SupTemplate> findAll() {
		// TODO Auto-generated method stub
		return supTemplateDao.findAll();
	}

	@Override
	public List<SupTemplate> findTemplateTitle(SupTemplate supTemplate) {
		// TODO Auto-generated method stub
		return supTemplateDao.findTemplateTitle(supTemplate);
	}

	@Override
	public List<SupTemplate> findAllFirstTemplateTitle(SupTemplate supTemplate) {
		// TODO Auto-generated method stub
		
		//System.out.println("获得模版标题是==========="+supTemplate.getMenu_level());
		return supTemplateDao.findAllFirstTemplateTitle(supTemplate);
		
	}


	

	
}
