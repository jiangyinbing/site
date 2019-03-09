package com.hb.framework.system.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.hb.framework.superhelp.base.BaseDao;
import com.hb.framework.system.entity.Roles;
import com.hb.framework.system.entity.UserRoles;


@Repository("rolesDao")
public class RolesDao extends BaseDao<Roles>{

	public List<Roles> findAll() {
		return getSqlSession().selectList("roles.findAll");
	}

	public void saveUserRole(UserRoles userRoles ) {
		getSqlSession().insert("roles.saveUserRole", userRoles);
	}

	public void deleteUserRole(String userId) {
		getSqlSession().delete("roles.deleteUserRole", userId);
	}
}
