package com.hb.framework.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hb.framework.superhelp.base.BaseDao;
import com.hb.framework.system.entity.BaseData;

@Repository("baseDataDao")
public class BaseDataDao extends BaseDao<BaseData>{
	
	public List<BaseData> findType(String type) {
	  return getSqlSession().selectList("basedata.findtype",type);
	}
	public List<BaseData> findTask() {
		  return getSqlSession().selectList("basedata.findTask");
	}
	public BaseData findByAlias(String alias) {
		  return getSqlSession().selectOne("basedata.findByAlias",alias);
	}
}
