package com.chapter2.dao;

import com.chapter2.domain.User;

public class UserDao {

	public static User findUserByAll(String username) {
		User user = new User();
		if("zhangsan".equals(username)){
			user.setUsername(username);
			user.setPassword("123");
		}else if("18712345678".equals(username)){
			user.setPhone(username);
			user.setPassword("123");
		}else if("123456@163.com".equals(username)){
			user.setEmail(username);
			user.setPassword("123");
		}
		return user;
	}

}
