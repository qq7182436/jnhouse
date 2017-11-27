package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.DeptAuthority;
import com.jnhouse.app.dao.DeptAuthorityDao;
import com.jnhouse.app.service.DeptAuthorityService;

@Service
public class DeptAuthorityServiceImpl extends BaseServiceImpl<DeptAuthority> implements DeptAuthorityService {

	@Resource
	private DeptAuthorityDao deptAuthorityDao;
	
	@Override
	public int save(DeptAuthority entity) {
		System.err.println("---2222222");
		return deptAuthorityDao.save(entity);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(DeptAuthority entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DeptAuthority getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeptAuthority> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
