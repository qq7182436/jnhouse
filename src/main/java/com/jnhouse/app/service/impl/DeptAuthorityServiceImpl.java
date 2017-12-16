package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.DeptAuthority;
import com.jnhouse.app.bean.Role;
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
		return deptAuthorityDao.delete(id);
	}

	@Override
	public int update(DeptAuthority entity) {
		// TODO Auto-generated method stub
		return deptAuthorityDao.update(entity);
	}

	@Override
	public DeptAuthority getById(Integer id) {
		// TODO Auto-generated method stub
		return deptAuthorityDao.getById(id);
	}

	@Override
	public List<DeptAuthority> findAll() {
		// TODO Auto-generated method stub
		return deptAuthorityDao.findAll();
	}

	@Override
	public int insertBatchRole(String dept_id,List<Role> roleList) {
		// TODO Auto-generated method stub
		return deptAuthorityDao.insertBatchRole(dept_id, roleList);
	}

	@Override
	public List<Integer> findByDeptId(Integer dept_id) {
		// TODO Auto-generated method stub
		return deptAuthorityDao.findByDeptId(dept_id);
	}

	@Override
	public int deleteAll(Integer dept_id) {
		// TODO Auto-generated method stub
		return deptAuthorityDao.deleteAll(dept_id);
	}

}
