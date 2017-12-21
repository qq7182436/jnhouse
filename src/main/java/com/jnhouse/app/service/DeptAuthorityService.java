package com.jnhouse.app.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jnhouse.app.bean.DeptAuthority;
import com.jnhouse.app.bean.Role;

public interface DeptAuthorityService extends BaseService<DeptAuthority>{
 
	/**
	 * 批量添加部门角色
	 * @param dept_id
	 * @param role_id
	 * @return
	 */
	int insertBatchRole(String dept_id,List<Role> roleList);
	
	/**
	 * 通过部门id查找
	 * @param dept_id
	 * @return
	 */
	List<Integer> findByDeptId(Integer dept_id);
	
	/**
	 * 删除该部门下所有的角色
	 * @param dept_id
	 * @return
	 */
	int deleteAll(Integer dept_id);
}
