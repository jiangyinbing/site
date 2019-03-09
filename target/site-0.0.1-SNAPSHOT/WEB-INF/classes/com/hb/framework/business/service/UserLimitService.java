package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.system.entity.User;
import com.hb.framework.system.entity.UserLimit;

@Service
public class UserLimitService {
	private static final String NULL = null;
	
	/**创建订单
	 * @param order
	 * @return
	 */
	public String  makeOrder(UserLimit userLimit, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		// 自动生成的订单编号(userLimitContrlloer)、产品名称、产品代码、首付金额、贷款金额不能为空
		if (StringUtils.isBlank(Integer.toString(userLimit.getCustomer_Id())) ||
			StringUtils.isBlank(userLimit.getUse_limit()) ||
			StringUtils.isBlank(userLimit.getRemain_limt()) || 
			StringUtils.isBlank(userLimit.getCustomer_limit())) {
			return "必输项不能为空";
		}
		
		//已有登录会话，获取信息，创建订单信息
		User users = (User) request.getSession().getAttribute("userSession");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("1111112222");
		String sql = " INSERT INTO sys_user_limit (mobile_no, customer_type,customer_id,limitId,use_limit, remain_limt, customer_limit, customer_name, "
				   + " effect_date, invalid_date, status, remark) "
				   + " VALUES('"+userLimit.getMobile_no()+"','1','"+userLimit.getCustomer_Id()+"','"+userLimit.getLimitId()+"','"
				   +userLimit.getUse_limit()+"','"+userLimit.getRemain_limt()+"','"
				   +userLimit.getCustomer_limit()+"','"+userLimit.getCustomer_name()+"','"
				  +userLimit.getEffect_date()+"','"+sdf.format(new Date())+"','"//userLimit.getInvalid_date()
				   +userLimit.getStatus()+"','"+userLimit.getRemark()+"') ";
		DBConnectionUtils.executeInsert(sql);
		System.out.println(userLimit.getStatus()+"++授信额度+"+userLimit.getCustomer_limit());
		return "S";
	}
	/**查询授信额度
	 * @param phone
	 * @return
	 */
	public   List<UserLimit> queryOrder1(String customer_name,int currpage) {
		//Map<String,Object> orderMap = new HashMap<String,Object>();
		int firstrow =(currpage-1)*2;
        int lastrow=2;  
		System.out.println(customer_name+"++service");
         String sql2 = "SELECT * from sys_user_limit ";
         System.out.println(sql2);
         if(customer_name!=null &&!customer_name.equals("")){
        	 sql2 += " where CUSTOMER_name='"+customer_name+"'";
         }else{
        	 sql2+="  limit "+firstrow+","+lastrow;
         }
		ResultSet resultset=DBConnectionUtils.executeQuery(sql2);
		
		System.out.println("result"+resultset.toString()+"授信额度service++"+sql2);
		List<UserLimit> lists = new ArrayList<UserLimit>();
		try {
			while(resultset.next()){
				UserLimit uselimit=new UserLimit();
				uselimit.setCustomer_Id(resultset.getInt("customer_Id"));
				uselimit.setLimitId(resultset.getInt("limitId"));
				uselimit.setMobile_no(resultset.getString("mobile_no"));
				uselimit.setUse_limit(resultset.getString("use_limit"));
				uselimit.setRemain_limt(resultset.getString("remain_limt"));
				uselimit.setCustomer_limit(resultset.getString("customer_limit"));
				uselimit.setCustomer_name(resultset.getString("customer_name"));
				uselimit.setEffect_date(resultset.getString("effect_date"));
				uselimit.setInvalid_date(resultset.getString("invalid_date"));
				uselimit.setStatus(resultset.getString("status"));
				uselimit.setRemark(resultset.getString("remark"));
				
				lists.add(uselimit);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
	
	/*
	 * 修改授信额度
	 */
	public String modify(UserLimit userLimit) {
		System.out.println(userLimit.getCustomer_Id()+"  "+userLimit.getLimitId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//sdf.format(new Date())
        String sql = "update sys_user_limit set mobile_no='"+userLimit.getMobile_no()+"',remain_limt='"+userLimit.getRemain_limt()+"',customer_limit='"+userLimit.getCustomer_limit()+"',use_limit='"+userLimit.getUse_limit()+"'" +
        		",customer_name='"+userLimit.getCustomer_name()+"',effect_date='"+userLimit.getEffect_date()+"',invalid_date='"+userLimit.getInvalid_date()+"',status='"+
        		userLimit.getStatus()+"',remark='"+userLimit.getRemark()+"' where limitId="+userLimit.getLimitId();
        DBConnectionUtils.executeUpdate(sql);
        System.out.println(userLimit.getLimitId()+" "+userLimit.getCustomer_Id()+" "+"修改成功"+sql);
    
		return "修改成功！";
	}
	
	/*
	 * 删除授信额度
	 */
	public String delete(UserLimit userLimit,String mobile_no) {
		 if(mobile_no==null ||mobile_no.equals("")){
      	 System.out.println("删除失败！");
       }else{
           String sql = "delete  from sys_user_limit  where limitId='"+userLimit.getLimitId()+"'";
           DBConnectionUtils.executeDelete(sql);
           System.out.println(sql+"删除成功");
       }
		return "删除成功！";
	}
	
	public Integer getOrderTotalCount(String customer_name){
		String sql2 = "SELECT * from sys_user_limit ";		
		 if(customer_name!=null&&!customer_name.equals("")){
        	 sql2 += "  where CUSTOMER_name='"+customer_name+"'";
         }
         System.out.println(sql2);
		ResultSet rs=DBConnectionUtils.executeQuery(sql2);
		int count = 0;
		if(rs!=null){
			try {
				while(rs.next()){
					count ++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
}
