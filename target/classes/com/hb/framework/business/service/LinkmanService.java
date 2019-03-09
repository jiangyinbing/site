package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.framework.business.entity.Linkman;
import com.hb.framework.superhelp.util.DBConnectionUtils;

public class LinkmanService {

	public List<Linkman> getContentBycustId(Integer custId){
		List<Linkman> lst = new ArrayList<Linkman>();
		String sql = " SELECT linkmanId,relationship,`name`,gender,mobileNo,birth, "
				   + " corpName,idType,idNo,corpTelephNbr FROM hb_linkman "
				   + " WHERE userId='" + custId + "' ORDER BY linkmanId ASC";
		ResultSet rs = DBConnectionUtils.executeQuery(sql);
		try {
			while(rs.next()){
				Linkman linkman = new Linkman();
				linkman.setLinkmanId(rs.getString("linkmanId"));
				linkman.setUserId(custId.toString());
				linkman.setRelationship(rs.getString("relationship"));
				linkman.setName(rs.getString("name"));
				linkman.setGender(rs.getString("gender"));
				linkman.setMobileNo(rs.getString("mobileNo"));
				linkman.setBirth(rs.getString("birth"));
				linkman.setIdType(rs.getString("idType"));
				linkman.setIdNo(rs.getString("idNo"));
				linkman.setCorpName(rs.getString("corpName"));
				linkman.setCorpTelephNbr(rs.getString("corpTelephNbr"));
				lst.add(linkman);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
}
