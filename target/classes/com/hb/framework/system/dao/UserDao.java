package com.hb.framework.system.dao;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hb.framework.superhelp.base.BaseDao;
import com.hb.framework.system.entity.Roles;
import com.hb.framework.system.entity.User;


@Repository("userDao")
public class UserDao extends BaseDao<User>{

	public int countUser(String userName, String userPassword) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("userName", userName);
		map.put("userPassword", userPassword);
		return (Integer)getSqlSession().selectOne("user.countUser",map);
	}

	public User querySingleUser(String userName) {
		return (User)getSqlSession().selectOne("user.queryUserName",userName);
	}

	public Roles findbyUserRole(String userId) {
		return (Roles)getSqlSession().selectOne("roles.findbyUserRole", userId);
	}
	
}
