package com.jnhouse.app.dao;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.Dept;

public interface DeptDao extends BaseDao<Dept>{
	
    /** 
     * 取得改登记下最大排序号
     *  
     * @return 
     */  
	Integer findMaxValue(Dept dept);
	
	//获取部门下子部门
	
	List<Integer> getDeptById(String dept_id);
}