package com.jnhouse.app.dao;

import java.util.List;


public interface BaseDao<T> {

	 /** 
     * 保存 
     *  
     * @param entity 
     */  
    int save(T entity);  

    /** 
     * 删除 
     *  
     * @param id 
     */  
    int delete(Integer id);  
  
    /** 
     * 更新
     *  
     * @param entity 
     */  
    int update(T entity);  

    /** 
     * 通过id查询
     *  
     * @param id 
     * @return 
     */  
    T getById(Integer id);  

    /** 
     * 根据id集合查询
     *  
     * @param ids 
     * @return 
     */  
    List<T> getByIds(Integer[] ids);  

    /** 
     * 查询所有
     *  
     * @return 
     */  
    List<T> findAll(); 
}
