package com.jnhouse.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jnhouse.app.bean.RoleMenu;

public interface RoleMenuDao extends BaseDao<RoleMenu>{
 
	/**
	 * 通过角色id查询该角色下所有菜单
	 * @param entity
	 * @param xml
	 * @return
	 */ 
   List<Integer> findByRoleId(Integer role_id); 
   
 	/**
	 * 批量插入
	 * @param entity
	 * @param xml
	 * @return
	 */ 
   int insertBatchMenus(@Param("role_id") Integer role_id,@Param("menuList") List<String> menuList); 
   
   /**
    * 删除该角色下所有菜单
    * @param role_id
    */
   void deleteByRoleId(Integer role_id);
}