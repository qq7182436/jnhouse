package com.jnhouse.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jnhouse.app.bean.DeptUser;
import com.jnhouse.app.dto.DeptUserDto;

public interface DeptUserService extends BaseService<DeptUser>{

	/**
	 * 通过部门id获取该部门下所有的用户
	 * @param dept_id
	 * @return
	 */
	List<DeptUserDto> selectUserByDeptId(DeptUserDto deptUserDto);
	
	
	/**
	 * 通过部门id获取该部门下所有的用户的id集合
	 * @param dept_id
	 * @return
	 */
	List<Integer> selectByDeptId(Integer dept_id);
	
	/**
	 * 批量插入部门用户
	 * @param dept_id
	 * @return
	 */
	void insertBatchUsers(@Param("deptUserList") List<DeptUser> deptUserList);
	
	/**
	 * 批量删除部门用户
	 * @param dept_id
	 * @return
	 */
	void deleteByPrimaryKeys(@Param("ids") String[] ids);
}
