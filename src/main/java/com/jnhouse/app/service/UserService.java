package com.jnhouse.app.service;

import com.jnhouse.app.bean.User;

public interface UserService extends BaseService<User> {

	User findUser(User user);
}
