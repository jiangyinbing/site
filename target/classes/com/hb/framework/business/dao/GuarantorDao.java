package com.hb.framework.business.dao;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.hb.framework.business.entity.Guarantor;
import com.hb.framework.superhelp.base.BaseDao;


@Repository("guarantorDao")
public class GuarantorDao extends BaseDao<Guarantor>{


	public List<Guarantor> queryByOrderId(String orderId) {
		return getSqlSession().selectList("guarantor.queryByOrderId", orderId);
	}
	
	
}
