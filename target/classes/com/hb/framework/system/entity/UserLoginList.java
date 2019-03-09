package com.hb.framework.system.entity;

import java.util.Date;

import com.hb.framework.superhelp.base.ExcelAnnotation;

/**
 * 登陆信息实体类
 * @author Dylan
 *
 */
@SuppressWarnings("serial")
public class UserLoginList implements java.io.Serializable {
	private int loginId;
	@ExcelAnnotation(exportName="登录人ID")
	private int userId;
	@ExcelAnnotation(exportName="登录人")
	private String userName;
	@ExcelAnnotation(exportName="登录时间")
	private Date loginTime;
	@ExcelAnnotation(exportName="登录IP")
	private String loginIp;
	public UserLoginList(){}
	public UserLoginList(int loginId,int userId,Date loginTime,String loginIp,String userName){
		this.loginId = loginId;
		this.userId = userId;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
		this.userName = userName;
	}
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
