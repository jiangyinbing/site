package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.framework.business.entity.PayPassword;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.system.entity.User;

@Service
public class PayPasswordService {
	
	/**设置支付密码
	 * @param password
	 * @return
	 */
	//支付密码设置(身份证，密码，不输入验证码)
	public String setPassword(PayPassword password){
		String sql = "SELECT userPwdBlock FROM sys_user WHERE userId='"+ password.getCustomerbasic_id() +"'"; 
		ResultSet rs = DBConnectionUtils.executeQuery(sql);
		try {
			if(rs.next()){
				String userPwdBlock = rs.getString(1);
				if(StringUtils.isEmpty(userPwdBlock)){
					if (StringUtils.isBlank(password.getNew_pin_block())) {
						return "必输项不能为空";
					}
					SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					sql = "UPDATE sys_user SET userPwdBlock='"+ password.getNew_pin_block() 
							+"', lastUdpTime='"+ fmt.format(new Date()) +"'  WHERE userId='"+ password.getCustomerbasic_id() +"'";
					DBConnectionUtils.executeUpdate(sql);
				} else {
					return "已设置过支付密码了";
				}
			}
			return "S";
		} catch (SQLException e) {
			e.printStackTrace();
			return "系统异常，请联系管理员";
		}
	}
	
	

	/**修改支付密码
	 * @param password
	 * @return
	 */
	public String modifyPassword(PayPassword password) {
		UserService userService = new UserService();
		User users = userService.findOne(Integer.parseInt(password.getCustomerbasic_id()), null);
		// 修改支付密码
		if (StringUtils.isBlank(password.getNew_pin_block().trim())
				|| StringUtils.isBlank(password.getPin_block().trim())) {
			return "请输入密码";
		}
		if(users.getUserPwdBlock()==null){
			return "未设置交易密码";
		}
		
		if (!password.getPin_block().equals(users.getUserPwdBlock())) {// 验证交易密码
			return "原支付密码错误";
		}
		SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		//输入密码与所查密码一致可进入修改
		String sql = "update  hb_application.sys_user set userPwdBlock= '"+password.getNew_pin_block()+"', lastUdpTime='"+ fmt.format(new Date()) +"'  where userId = '"+users.getUserId()+"'";
	    DBConnectionUtils.executeUpdate(sql);
	    return "S";
	}

	/**忘记支付密码
	 * @param password
	 * @return
	 */
	public String forgetPassword(PayPassword password) {
		
		User users = new User();
		//users = (User) request.getSession().getAttribute("userSession");
		String userPassword="";
		String userPhone="";
		String idNo="";
		String url="";
		url = "/background/business/payPassword";
		int userid = users.getUserId();
		//手机验证码（本次以手机号验证）
		String sql = "select  userPhone from sys_user where userId = '"+Integer.toString(userid)+"'";
		ResultSet msg=DBConnectionUtils.executeQuery(sql);
	    try{
			if (msg.next()) { 
				String	mobile=msg.getString(1);
				if (mobile==userPhone) {	 
					//设置新密码	
					SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					String sql2 = "update sys_user set userPassword= '"+userPassword+"', idno= '"+idNo+"', lastUdpTime='"+fmt.format(new Date())+" where userId = '"+Integer.toString(userid)+"'";
					DBConnectionUtils.executeUpdate(sql2);
					//url = "/background/business/authentication";  //����ȥ��֤		
				}else{
					//原始密码有误，重新支付
					System.out.println("密码有误，请重新输入!");
					url="/background/business/payPassword";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg.toString();
	}
	
	/**验证支付密码
	 * @param password
	 * @return
	 */
	public String checkPassword(PayPassword password) {
		UserService userService = new UserService();
		User user = userService.findOne(Integer.parseInt(password.getCustomerbasic_id()), null);
		if(StringUtils.isBlank(user.getUserPwdBlock())){
			return "您还未设置交易密码，请在我的账户中设置交易密码。";
		}
		if(!user.getUserPwdBlock().equals(password.getPin_block())){
			return "您的原始交易密码不正确，请重新输入";
		}
		return "S";
	}
	

	

	/**获取支付密码报文的serviceHeader
	 * @param serviceHeader
	 */
	private void getHeader(Map<String, Object> serviceHeader) {
		serviceHeader.put("SERVICE_ID","XJBuyPasswordBind");   
    	serviceHeader.put("ORG","000000000001");   
		serviceHeader.put("CHANNEL_ID","BANK");   
		serviceHeader.put("ACQ_ID","00230000");
		serviceHeader.put("SUB_TERMINAL_TYPE","APP");
		serviceHeader.put("SERVICESN","YG20150825112132123464");      
		serviceHeader.put("OP_ID",null);           
		serviceHeader.put("REQUEST_TIME","20151002161241");    
		serviceHeader.put("VERSION_ID","01");      
		serviceHeader.put("MAC",null); 		
		serviceHeader.put("SERV_RESPONSE",null); 
	}

	/**获取修改支付密码报文的serviceBody
	 * @param serviceBody
	 * @param password
	 */
	private void getMBody(Map<String, Object> serviceBody, PayPassword password) {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("CUSTOMERBASIC_ID", password.getCustomerbasic_id());
		request.put("SOURCE_BIZ_TYPE", password.getSource_biz_type());
		request.put("PIN_BLOCK", password.getPin_block());
		request.put("NEW_PIN_BLOCK", password.getNew_pin_block());
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
	}

	/**获取忘记支付密码报文的serviceBody
	 * @param serviceBody
	 * @param password
	 */
	private void getFBody(Map<String, Object> serviceBody, PayPassword password) {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("CUSTOMERBASIC_ID", password.getCustomerbasic_id());
		request.put("SOURCE_BIZ_TYPE", password.getSource_biz_type());
		request.put("ID_NO", password.getId_no());
		request.put("MOBILE_CODE", password.getMobile_code());
		request.put("NEW_PIN_BLOCK", password.getNew_pin_block());
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		
	}

	
}
