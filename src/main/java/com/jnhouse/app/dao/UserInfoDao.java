package com.jnhouse.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jnhouse.app.bean.UserInfo;
import com.jnhouse.app.dto.UserInfoDto;

public interface UserInfoDao extends BaseDao<UserInfo>{
	
	/**
	 * 根据用户真实姓名或者电话模糊查询用户
	 * @param username
	 * @return
	 */
	List<UserInfoDto> findUserByName(@Param("username") String username);
}