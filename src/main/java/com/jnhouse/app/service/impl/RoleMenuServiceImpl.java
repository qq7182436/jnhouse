package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.RoleMenu;
import com.jnhouse.app.dao.RoleMenuDao;
import com.jnhouse.app.service.RoleMenuService;

@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService{

	@Resource
	private RoleMenuDao roleMenuDao;
	
	@Override
	public int save(RoleMenu entity) {
		// TODO Auto-generated method stub
		return roleMenuDao.save(entity);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return roleMenuDao.delete(id);
	}

	@Override
	public int update(RoleMenu entity) {
		// TODO Auto-generated method stub
		return roleMenuDao.update(entity);
	}

	@Override
	public RoleMenu getById(Integer id) {
		// TODO Auto-generated method stub
		return roleMenuDao.getById(id);
	}

	@Override
	public List<RoleMenu> findAll() {
		// TODO Auto-generated method stub
		return roleMenuDao.findAll();
	}

	@Override
	public List<Integer> findByRoleId(Integer role_id) {
		// TODO Auto-generated method stub
		return roleMenuDao.findByRoleId(role_id);
	}

	@Override
	public int insertBatchMenus(Integer role_id, List<String> menuList) {
		// TODO Auto-generated method stub
		return roleMenuDao.insertBatchMenus(role_id, menuList);
	}

	@Override
	public void deleteByRoleId(Integer role_id) {
		// TODO Auto-generated method stub
		roleMenuDao.deleteByRoleId(role_id);
	}

	
}
