package com.jnhouse.app.service;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.Dept;

public interface DeptService extends BaseService<Dept> {

	   
	   /** 
	    * 取得该等级下最大排序号
	    *  
	    * @return 
	    */  
	Integer findMaxValue(Dept dept);
	
	//获取部门及子部门
	List<Integer> getDeptById(String dept_id);
}
