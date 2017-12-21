package com.jnhouse.app.service;

import java.util.List;

import com.jnhouse.app.bean.RoleMenu;

public interface RoleMenuService extends BaseService<RoleMenu> {

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
  int insertBatchMenus(Integer role_id,List<String> menuList); 
  
  /**
   * 删除该角色下所有菜单
   * @param role_id
   */
  void deleteByRoleId(Integer role_id);
}
