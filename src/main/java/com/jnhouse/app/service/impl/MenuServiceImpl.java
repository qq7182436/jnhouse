package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.Menu;
import com.jnhouse.app.dao.MenuDao;
import com.jnhouse.app.service.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

	@Resource
	private MenuDao menuDao;
	
	@Override
	public int save(Menu entity) {
		// TODO Auto-generated method stub
		return menuDao.save(entity);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return menuDao.delete(id);
	}

	@Override
	public int update(Menu entity) {
		// TODO Auto-generated method stub
		return menuDao.update(entity);
	}

	@Override
	public Menu getById(Integer id) {
		// TODO Auto-generated method stub
		return menuDao.getById(id);
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return menuDao.findAll();
	}

	@Override
	public Integer findMaxValue(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.findMaxValue(menu);
	}

	@Override
	public List<Menu> getMenuByUserId(Integer id) {
		// TODO Auto-generated method stub
		return menuDao.getMenuByUserId(id);
	}

}
