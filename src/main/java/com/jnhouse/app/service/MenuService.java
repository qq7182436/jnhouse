package com.jnhouse.app.service;

import com.jnhouse.app.bean.Menu;

public interface MenuService extends BaseService<Menu>{

	   /** 
	    * 取得该等级下最大排序号
	    *  
	    * @return 
	    */  
	Integer findMaxValue(Menu menu);
}
