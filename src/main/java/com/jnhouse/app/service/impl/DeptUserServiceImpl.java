package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.DeptUser;
import com.jnhouse.app.dao.DeptUserDao;
import com.jnhouse.app.dto.DeptUserDto;
import com.jnhouse.app.service.DeptUserService;

@Service
public class DeptUserServiceImpl extends BaseServiceImpl<DeptUser> implements DeptUserService {

	@Resource
	private DeptUserDao deptUserDao;
	
	@Override
	public int save(DeptUser entity) {
		// TODO Auto-generated method stub
		return deptUserDao.save(entity);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return deptUserDao.delete(id);
	}

	@Override
	public int update(DeptUser entity) {
		// TODO Auto-generated method stub
		return deptUserDao.update(entity);
	}

	@Override
	public DeptUser getById(Integer id) {
		// TODO Auto-generated method stub
		return deptUserDao.getById(id);
	}

	@Override
	public List<DeptUser> findAll() {
		// TODO Auto-generated method stub
		return deptUserDao.findAll();
	}

	@Override
	public List<DeptUserDto> selectUserByDeptId(DeptUserDto deptUserDto) {
		// TODO Auto-generated method stub
		return deptUserDao.selectUserByDeptId(deptUserDto);
	}

	@Override
	public List<Integer> selectByDeptId(Integer dept_id) {
		// TODO Auto-generated method stub
		return deptUserDao.selectByDeptId(dept_id);
	}

	@Override
	public void insertBatchUsers(List<DeptUser> deptUserList) {
		// TODO Auto-generated method stub
		deptUserDao.insertBatchUsers(deptUserList);
	}

	@Override
	public void deleteByPrimaryKeys(String[] ids) {
		// TODO Auto-generated method stub
		deptUserDao.deleteByPrimaryKeys(ids);
	}

}
