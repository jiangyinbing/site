package com.hb.framework.superhelp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//import com.hb.framework.system.entity.User;

/**
 * md5 加密
 * 
 * @author 产品组 Dec 7, 2015
 *
 */
public class PasswordFacility {

//	private Logger logger = LoggerFactory.getLogger(getClass());

//	/**
//	 * 验证支付密码
//	 * 
//	 * @param ccsXjPassword
//	 * @param newBuyPassword
//	 * @return
//	 */
//	public boolean matchesBuyPassword(User user,
//			String newBuyPassword) {
//		return user.getUserPwdBlock().equals(
//				encryptPassword(user.getMobileNumber(),
//						newBuyPassword, ccsXjPassword.getSalt()));
//	}
//
//	/**
//	 * 验证登入密码
//	 * 
//	 * @param ccsXjPassword
//	 * @param loginPassword
//	 * @return
//	 */
//	public boolean matchesLoginPassword(CcsXjPassword ccsXjPassword,
//			String loginPassword) {
//		return ccsXjPassword.getPin().equals(
//				encryptPassword(ccsXjPassword.getMobileNumber(), loginPassword,
//						ccsXjPassword.getSalt()));
//	}
//
//	/**
//	 * 生成密码
//	 * 
//	 * @param username
//	 *            用户名
//	 * @param password密码
//	 * @param salt佐料
//	 * @return
//	 */
//	public String encryptPassword(String username, String password, String salt) {
//		return Md5Utils.hash(username + password + salt);
//	}
//
//	/**
//	 * 判断是否为6为数字
//	 * 
//	 * @param str
//	 * @return true Or false
//	 */
//	public  boolean isNumeric(String str) {
//		if (StringUtils.isBlank(str) || str.length() != 6) {
//			return false;
//		}
//		try {
//			Integer.parseInt(str);
//			return true;
//		} catch (Exception ex) {
//			return false;
//		}
//	}

	/*
	 * 手机号验证
	 * 
	 * @param str
	 * 
	 * @return 验证通过返回true
	 */
	public   boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,8,6,7][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	

}
