package com.jnhouse.app.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.jnhouse.app.bean.User;
import com.jnhouse.app.dto.UserInfoDto;

@WebService
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
	
	/*@WebService标记表示该接口是一个WebService服务;
	 *@WebMethod表示表示以下方法为WebService服务中的方法,exclude=true表示该方法不被发布出去.
	 *@WebParam(name="username")表示方法中的参数，username属性限制了参数的名称，若没有指定该属性，参数将被重命名。*/
	@WebMethod(operationName="add")
	@WebResult(name="result")
	public String add(@WebParam(name="id") String id,@WebParam(name="name") String name);
	
	@WebMethod(operationName="add1")
	@WebResult(name="result")
	public String add1(@WebParam(name="id") String id,@WebParam(name="name") String name);

}
