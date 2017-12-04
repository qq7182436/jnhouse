package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.Role;
import com.jnhouse.app.dao.RoleDao;
import com.jnhouse.app.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	@Override
	public int save(Role entity) {
		// TODO Auto-generated method stub
		return roleDao.save(entity);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.delete(id);
	}

	@Override
	public int update(Role entity) {
		// TODO Auto-generated method stub
		return roleDao.update(entity);
	}

	@Override
	public Role getById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.getById(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}
