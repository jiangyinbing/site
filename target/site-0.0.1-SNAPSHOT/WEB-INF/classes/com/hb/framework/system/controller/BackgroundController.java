package com.hb.framework.system.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.superhelp.util.HttpClient;
import com.hb.framework.superhelp.util.HttpClientUtils;
import com.hb.framework.superhelp.util.JsonSerializeUtil;
import com.hb.framework.superhelp.util.Md5Tool;
import com.hb.framework.system.entity.Resources;
import com.hb.framework.system.entity.User;
import com.hb.framework.system.entity.UserLoginList;
import com.hb.framework.system.service.ResourcesService;
import com.hb.framework.system.service.UserLoginListService;
import com.hb.framework.system.service.UserService;

/**
 * 进行管理后台框架界面的类
 * @author h
 * 
 * @Email: 
 * @version 1.0v
 */
@Controller
@RequestMapping ("/background/system/")
public class BackgroundController
{
	
	private final static Logger logger = Logger.getLogger(BackgroundController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginListService userLoginListService;
	@Autowired
	private ResourcesService resourcesService;
	@Autowired
	private AuthenticationManager myAuthenticationManager;
	
	/**
	 * @return
	 */
	@RequestMapping ("login")
	public String login(Model model,HttpServletRequest request)
	{
		//重新登录时销毁该用户的Session
		Object o = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		if(null != o){
			request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
		}
		return "/background/system/framework/login";
	}
	
	@RequestMapping ("register")
	public String register(Model model,HttpServletRequest request)
	{
		return "/background/system/framework/register";
	}
	
	@RequestMapping("registerCheck")
	public String registerCheck(String mobileNo, String password, String customerType, HttpServletRequest request) throws HttpException, IOException, JSONException{
		// 判空验证
		if(StringUtils.isBlank(mobileNo) || StringUtils.isBlank(password)){
			request.setAttribute("error", "必输项不能为空");
			return "/background/system/framework/login";   //查得即已注册
		}
		// 检验改手机号是否注册过
		String sql = "SELECT custId FROM sys_user where userName='"+ mobileNo +"'";
		ResultSet queryrs = DBConnectionUtils.executeQuery(sql);
		try {
			if (queryrs.next()) {                          
				int count = queryrs.getInt(1); 
				System.out.print("该手机号已经注册！");
				request.setAttribute("error", "该手机号已经注册！");
				return "/background/system/framework/login";   //查得即已注册
			}
		} catch (Exception e) {
			logger.error("系统异常，请联系管理员", e);
			request.setAttribute("error", "系统异常，请联系管理员");
			return "/background/system/framework/login";   
		}	
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql = "INSERT INTO hb_application.sys_user(userName, userPhone, userPassword, customerType, "
			+ "regTime, lastLogintime, conditionState) VALUES('"+mobileNo+"', '"+mobileNo+"', "
			+ "'"+password+"', '"+customerType+"', '"+fmt.format(new Date())+"', '"+fmt.format(new Date())+"', '1') ";
		DBConnectionUtils.executeUpdate(sql);
		sql = "select userid from sys_user where userName = '" + mobileNo + "'";
		ResultSet rs = DBConnectionUtils.executeQuery(sql);
		try {
			if(rs.next()){
				String userid = rs.getString(1);
				sql = "INSERT INTO sys_user_role VALUES ('"+userid+"', '2')";
				DBConnectionUtils.executeUpdate(sql);
			}
		} catch (SQLException e) {
			logger.error("系统异常，请联系管理员", e);
			request.setAttribute("error", "系统异常，请联系管理员");
			return "/background/system/framework/login";  
		}	
		request.setAttribute("error", "注册成功！");
		
		return "/background/system/framework/register";
		
	}
	
	public static void main(String[] args){
		String sql = "INSERT INTO sys_user_role VALUES ('139', '2')";
		DBConnectionUtils.executeUpdate(sql);
		
	}
	
	
	@RequestMapping ("loginCheck")
	public String loginCheck(String username,String password,String authCode,HttpServletRequest request){
		try {
			if (!request.getMethod().equals("POST")) {
				request.setAttribute("error","支持POST方法提交！");
			}
			// 判空验证
			if (Common.isEmpty(username) || Common.isEmpty(password)) {
				request.setAttribute("error","用户名或密码不能为空！");
				return "/background/system/framework/login";
			}
			User users = new User();
		
//			 验证用户账号与密码是否正确
			if("admin".equals(username)){
				users = this.userService.querySingleUser(username);
				if (users == null || !users.getUserPassword().equals(password)) {
					request.setAttribute("error", "用户或密码不正确！");
				    return "/background/system/framework/login";
				}
			}else{
				String sql = "select userid,userNickname,userRealname,userPhone,customerType,idNo from sys_user where userName = '"
						   + username + "' and userPassword='" + password + "'";
				ResultSet rs = DBConnectionUtils.executeQuery(sql);
				if(rs.next()){
					users.setUserId(Integer.parseInt(rs.getString("userid")));
					users.setUserName(username);
					users.setUserNickname(rs.getString("userNickname"));
					users.setUserRealname(rs.getString("userRealname"));
					users.setUserPhone(rs.getString("userPhone"));
					users.setIdNo(rs.getString("idNo"));
					users.setCustomerType(rs.getString("customerType"));
					SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					sql = "UPDATE sys_user SET lastLogintime='"+fmt.format(new Date())+"' WHERE userId='"+users.getUserId()+"'";
					DBConnectionUtils.executeUpdate(sql);
				}
			}
			Authentication authentication = myAuthenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			HttpSession session = request.getSession(true);  
		    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);  
		    // 当验证都通过后，把用户信息放在session里
		    users.setStyle("1");
			request.getSession().setAttribute("userSession", users);
			// 记录登录信息
			UserLoginList userLoginList = new UserLoginList();
			userLoginList.setUserId(users.getUserId());
			userLoginList.setLoginIp(Common.toIpAddr(request));
			userLoginListService.add(userLoginList);
		} catch (Exception e) {  
			request.setAttribute("error", "登录异常，请联系管理员！");
			e.printStackTrace();
			return "/background/system/framework/login";
		}
		return "redirect:index.html";
	}
	
	/**
	 * @return
	 */
	@RequestMapping ("styleChange")
	public void styleChange(String style,HttpServletRequest request)
	{
		User user=(User)request.getSession().getAttribute("userSession");
		user.setStyle(style==null?"1":style.trim());
		userService.modify(user);
		request.getSession().setAttribute("userSession", user);
	}
	
	/**
	 * @return
	 */
	@RequestMapping ("index")
	public String index(Model model)
	{
		return "/background/system/framework/main";
	}
	
	@RequestMapping ("top")
	public String top(Model model)
	{
		return "/background/system/framework/top";
	}
	
	@RequestMapping ("left")
	public String left(Model model,HttpServletRequest request)
	{
		try {
			String username = request.getUserPrincipal().getName();
			List<Resources> resources = resourcesService.getResourcesByUserName(username);
			model.addAttribute("resources", resources);
		} catch (Exception e) {
			//重新登录时销毁该用户的Session
			request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
		}
		return "/background/system/framework/left";
	}
	
	@RequestMapping ("tab")
	public String tab(Model model)
	{
		return "/background/system/framework/tab/tab";
	}
	
	@RequestMapping ("center")
	public String center(Model model)
	{
		return "/background/system/framework/center";
	}
	
	@RequestMapping ("toEditPassword")
	public String toEditPassword(Model model)
	{	
		return "/background/system/user/editPassword";
	}
	
	@RequestMapping ("editPassword")
	public String editPassword(String oldpassword,String newPassword ,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("userSession");
		oldpassword = Md5Tool.getMd5(oldpassword.trim());
		if (user != null && user.getUserPassword().equals(oldpassword)) {
			user.setUserPassword(Md5Tool.getMd5(newPassword.trim()));
			userService.modify(user);
			request.getSession().setAttribute("userSession", user);
			request.setAttribute("msg", "密码修改成功！");
			return "/background/system/user/editPassword";
		} else {
			request.setAttribute("msg", "旧密码不对！");
			return "/background/system/user/editPassword";
		}
	}
	@ResponseBody
	@RequestMapping(value="getPassword")
	public String getPassword(String password){
			password=Md5Tool.getMd5(password.trim());
		return password;
	}
	
}
