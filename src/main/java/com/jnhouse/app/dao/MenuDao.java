package com.jnhouse.app.dao;

import com.jnhouse.app.bean.Menu;

public interface MenuDao extends BaseDao<Menu>{
	 
	   /** 
	    * 取得该等级下最大排序号
	    *  
	    * @return 
	    */  
	Integer findMaxValue(Menu menu);
}