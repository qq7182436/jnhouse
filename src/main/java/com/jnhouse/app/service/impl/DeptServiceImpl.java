package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.Dept;
import com.jnhouse.app.dao.DeptDao;
import com.jnhouse.app.service.DeptService;

@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

	@Resource
	private DeptDao deptDao;
	
	@Override
	public int save(Dept entity) {
		// TODO Auto-generated method stub
		return deptDao.save(entity);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return deptDao.delete(id);
	}

	@Override
	public int update(Dept entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dept getById(Integer id) {
		// TODO Auto-generated method stub
		return deptDao.getById(id);
	}

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

	@Override
	public Integer findMaxValue(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.findMaxValue(dept);
	}

}
