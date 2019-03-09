package com.hb.framework.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hb.framework.superhelp.base.BaseDao;
import com.hb.framework.system.entity.UserLoginList;

@Repository("userLoginListDao")
public class UserLoginListDao extends BaseDao<UserLoginList>{
	public List<UserLoginList> queryAll(UserLoginList userLoginList) {
		return getSqlSession().selectList("userloginlist.queryAll", userLoginList);
	}
	public List<Map<String, Object>> getMap( ){
		return getSqlSession().selectList("userloginlist.getMap");
	}
}
