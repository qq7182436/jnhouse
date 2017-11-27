package com.jnhouse.app.service;

import java.util.List;

public interface BaseService<T> {


	/**
	 * 保存
	 * @param entity
	 * @param xml
	 * @return
	 */
   int save(T entity);  
   
   	/**
	 * 删除
	 * @param entity
	 * @param xml
	 * @return
	 */ 
   int delete(Integer id);  
   
   	/**
	 * 更新
	 * @param entity
	 * @param xml
	 * @return
	 */   
   int update(T entity);  
   
   	/**
	 * 根据id查询
	 * @param entity
	 * @param xml
	 * @return
	 */ 
   T getById(Integer id);  
   
   	/**
	 * 查询所有
	 * @param entity
	 * @param xml
	 * @return
	 */ 
   List<T> findAll(); 
}
