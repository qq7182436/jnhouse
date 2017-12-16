package com.jnhouse.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jnhouse.app.bean.Role;

public interface RoleDao extends BaseDao<Role>{

    /** 
     * 删除 
     *  
     * @param id 
     */  
    int deleteByids(@Param("ids") String[] ids); 
    
    /** 
     * 模糊查询角色 
     *  
     * @param id 
     */  
    List<Role> findByRoleName(@Param("role_name") String role_name); 
}