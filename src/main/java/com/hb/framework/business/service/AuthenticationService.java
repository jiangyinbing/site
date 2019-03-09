package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hb.framework.business.entity.Authentication;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.superhelp.util.IdCardValidator;
import com.hb.framework.superhelp.util.Luhn;
import com.hb.framework.system.entity.User;

@Service
public class AuthenticationService {
	//实名验证
	public String setAuthentication(Authentication auth,HttpServletRequest request) {
		User users = new User();
		users = (User) request.getSession().getAttribute("userSession");
		int userid = users.getUserId();

		// 验证是否实名过了
		String status = users.getStatus();
		if (status != null && status.equals("A00")) {
			System.out.println("已经实名验证，无需再验证");
			return "已经实名验证成功，请勿重复提交";
		}

		// 字段非空验证
		if (StringUtils.isBlank(auth.getName()) || StringUtils.isBlank(auth.getId_no())
				|| StringUtils.isBlank(auth.getCard_no())) {
			System.out.println("必输项不能为空");
			return "必输项不能为空";
		}
		
		// 验证身份证的合法性
		IdCardValidator cardValidator = new IdCardValidator();
		if (!cardValidator.isValidate18Idcard(auth.getId_no())) {
			return "无效身份证号码，请重新输入";
		}
		
		// 查询已存在身份证号的用户
		String sql = "SELECT userId FROM sys_user WHERE idNo='" + auth.getId_no() + "'";
		ResultSet rs = DBConnectionUtils.executeQuery(sql);
		try {
			if(rs.next()){
				System.out.println("身份证信息已经存在，被他人使用了");
				return "此身份证号已经认证，请核实信息，如有疑问，请联系客服";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 验证银行卡有效性
		String checkCardNo = auth.getCard_no().substring(0, auth.getCard_no().length() - 1) + "0";
		if (!auth.getCard_no().equals(Luhn.getLuhnIdStr(checkCardNo))) {
			System.out.println("银行卡无效");
			return "请输入本人银行卡";
		}
		// 根据卡号查询卡是否被绑定，被绑定提示“卡已被绑定”
		String sql2 = "SELECT userId FROM sys_user WHERE cardNo='" + auth.getCard_no() + "'";
		ResultSet rs2 = DBConnectionUtils.executeQuery(sql);
		try {
			if(rs2.next()){
				System.out.println("银行卡信息已经存在，被他人使用了");
				return "此银行卡号已经被绑定，请核实信息，如有疑问，请联系客服";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql3 =   "UPDATE hb_application.sys_user SET "
					 + "userRealname='"+auth.getName()+"', idNo='"+auth.getId_no()+"',  "
					 + "cardNo='"+auth.getCard_no()+"', openBankId='"+auth.getOpen_bank_id()+"', "
					 + "userSex='"+ getGenderById(auth.getId_no()) +"' "
					 + "WHERE userId='"+users.getUserId()+"'";
		DBConnectionUtils.executeUpdate(sql3);
		request.getSession().setAttribute("userSession", users);
		System.out.println("SUCCESS");
		return "S";
	}
	
	/**
	 * 
	 * @param idNo
	 *            身份证号码分18位跟15位，18位身份证取第17位，15位身份证取第15位判断性别
	 * @return 返回性别
	 */
	private String getGenderById(String idNo) {
		try {
			//当身份证不是15位或者是18位
			if (idNo.length() != 15 && idNo.length() != 18) {
				return "M";
			}
			String sex = "";
			if (idNo.length() == 18) {
				sex = idNo.substring(16, 17);
			} else {
				// 15位
				sex = idNo.substring(14, 15);
			}
			if (Integer.parseInt(sex) % 2 == 0) {
				// 女
				return "f";
			} else {
				// 男
				return "M";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "M";
	}
	
}
