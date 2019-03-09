package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hb.framework.business.entity.LinkmanHst;
import com.hb.framework.superhelp.util.DBConnectionUtils;

//@Service
public class LinkmanHstService {

	public List<LinkmanHst> getContentHstBycustId(Integer custId, String orderId){
		List<LinkmanHst> lst = new ArrayList<LinkmanHst>();
		String sql = " SELECT linkmanId,relationship,`name`,gender,mobileNo,birth, "
				   + " corpName,idType,idNo,corpTelephNbr FROM hb_linkman_hst "
				   + " WHERE custId='" + custId + "' and orderId='" + orderId +"' ORDER BY linkmanId ASC ";
		ResultSet rs = DBConnectionUtils.executeQuery(sql);
		try {
			if(rs.next()){
				LinkmanHst linkmanHst = new LinkmanHst();
				linkmanHst.setLinkmanId(rs.getString("linkmanId"));
				linkmanHst.setOrderId(orderId);
				linkmanHst.setCustId(rs.getString("custId"));
				linkmanHst.setRelationship(rs.getString("relationship"));
				linkmanHst.setName(rs.getString("name"));
				linkmanHst.setGender(rs.getString("gender"));
				linkmanHst.setMobileNo(rs.getString("mobileNo"));
				linkmanHst.setBirth(rs.getString("birth"));
				linkmanHst.setIdType(rs.getString("idType"));
				linkmanHst.setIdNo(rs.getString("idNo"));
				linkmanHst.setCorpName(rs.getString("corpName"));
				linkmanHst.setCorpTelephNbr(rs.getString("corpTelephNbr"));
				lst.add(linkmanHst);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
}
