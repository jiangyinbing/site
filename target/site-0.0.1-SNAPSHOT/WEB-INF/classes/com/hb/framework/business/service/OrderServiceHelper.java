package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hb.framework.superhelp.util.DBConnectionUtils;

public class OrderServiceHelper {

	
	public String getOrderByOrder(Integer hbOrderId){
		String sql = "SELECT count(*) FROM hb_order WHERE hb_orderId=" + hbOrderId;
		ResultSet rs = DBConnectionUtils.executeQuery(sql);
		try {
			if(rs.next()){
				return "yes";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		OrderServiceHelper osh = new OrderServiceHelper();
		String a = osh.getOrderByOrder(183);
		System.out.println(a);
	}
	
}
