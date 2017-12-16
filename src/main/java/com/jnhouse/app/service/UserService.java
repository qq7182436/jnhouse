package com.jnhouse.app.service;

import java.util.List;

import com.jnhouse.app.bean.User;
import com.jnhouse.app.dto.UserInfoDto;

public interface UserService extends BaseService<User> {

	/**
	 * 根据用户名密码查询用户
	 * @param user
	 * @return
	 */
	User findUser(User user);
	
	/**
	 * 根据用户真实姓名或者电话模糊查询用户
	 * @param username
	 * @return
	 */
	List<UserInfoDto> findUserByName(String username);
}
