package com.jnhouse.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.File;
import com.jnhouse.app.dao.FileDao;
import com.jnhouse.app.service.FileService;

@Service
public class FileServiceImpl extends BaseServiceImpl<File> implements FileService{

	@Resource
	private FileDao fileDao;
	

	@Override
	public int save(File entity) {
		// TODO Auto-generated method stub
		
		int c = fileDao.save(entity);
		return c;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return fileDao.delete(id);
	}

	@Override
	public int update(File entity) {
		// TODO Auto-generated method stub
		return fileDao.update(entity);
	}

	@Override
	public File getById(Integer id) {
		// TODO Auto-generated method stub
		return fileDao.getById(id);
	}

	@Override
	public List<File> findAll() {
		// TODO Auto-generated method stub
		return fileDao.findAll();
	}

	

}
