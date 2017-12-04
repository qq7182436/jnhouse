package com.jnhouse.app.dao;

import com.jnhouse.app.bean.User;

public interface UserDao extends BaseDao<User>{
    
	User findUser(User user);
}