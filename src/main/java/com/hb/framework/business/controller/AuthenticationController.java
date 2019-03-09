package com.hb.framework.business.controller;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.framework.business.entity.Authentication;
import com.hb.framework.business.service.AuthenticationService;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.system.entity.User;

@Controller
@RequestMapping("/background/business/authentication")
public class AuthenticationController {
	@RequestMapping(value="authentication")
	public String gotoAuthenticationPage(HttpServletRequest request){
		String url = "";
		url = "/background/business/authentication";	
		User users = new User();
		users = (User) request.getSession().getAttribute("userSession");
		int userid = users.getUserId();
		String sql = "select userRealname from hb_application.sys_user where userId = '"+Integer.toString(userid)+"'";
		ResultSet queryrs = DBConnectionUtils.executeQuery(sql);
		try {
			if (queryrs.next()) {
				String userRealname = queryrs.getString(1);
				if (userRealname == null || userRealname.isEmpty()
						|| userRealname.equals("null")) {					
				} else {
					url = "/background/business/realNameValidated";
					System.out.print(url);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return url;
	}
	
	@Autowired
	private AuthenticationService authenticationService;
	@RequestMapping(value="realNameAuthentication")
	public String setPayPassword(Authentication authentication,HttpServletRequest request){	
		String ret = authenticationService.setAuthentication(authentication,request);
		if(!ret.equals("S")){
			return ret; 
		}else{
			return "您已实名！";
		}
	}
	
}
