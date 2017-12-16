package com.jnhouse.app.dao;

import java.util.List;

import com.jnhouse.app.bean.Menu;

public interface MenuDao extends BaseDao<Menu>{
	 
	   /** 
	    * 取得该等级下最大排序号
	    *  
	    * @return 
	    */  
	Integer findMaxValue(Menu menu);
		
	/**
	 * 通过用户id获取菜单列表
	 * @param id
	 * @return
	 */
	List<Menu> getMenuByUserId(Integer id);
}