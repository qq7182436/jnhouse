package com.jnhouse.app.service;

import com.jnhouse.app.bean.Dept;

public interface DeptService extends BaseService<Dept> {

	   
	   /** 
	    * 取得该等级下最大排序号
	    *  
	    * @return 
	    */  
	Integer findMaxValue(Dept dept);
}
