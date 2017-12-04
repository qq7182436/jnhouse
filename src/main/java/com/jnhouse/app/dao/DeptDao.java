package com.jnhouse.app.dao;

import com.jnhouse.app.bean.Dept;

public interface DeptDao extends BaseDao<Dept>{
	
    /** 
     * 取得改登记下最大排序号
     *  
     * @return 
     */  
	Integer findMaxValue(Dept dept); 
}