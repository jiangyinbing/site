package com.hb.framework.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.framework.business.entity.PayPassword;
import com.hb.framework.business.service.PayPasswordService;

/**支付密码维护
 * @author sjl
 *
 */
@Controller
@RequestMapping("/background/system/paypassword")
public class PayPasswordController {
	
	@Autowired
	private PayPasswordService passwordService;
	/**跳转到支付页面
	 * @return
	 */
	@RequestMapping("/payPassword")
	public String gotoPayPasswordPage(){
		return "/background/system/framework/payPassword";
	}
	
	/**设置支付密码
	 * @param password
	 * @return
	 */
	@RequestMapping("/setPassword")
	@ResponseBody
	public String setPayPassword(PayPassword password){
		String tip = passwordService.setPassword(password);
		if(tip.equals("S")){
			return "支付密码设置成功！";
		}else{
			return tip;
		}
	}
	/**修改支付密码
	 * @param password
	 * @return
	 */
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public String modifyPayPassword(PayPassword password){
		String tip = passwordService.modifyPassword(password);
		if(tip.equals("S")){
			return "修改支付密码成功！";
		}else{
			return tip;
		}
	}
	/**忘记支付密码
	 * @param password
	 * @return
	 */
	@RequestMapping("/forgetPassword")
	@ResponseBody
	public String forgetPayPassword(PayPassword password){
		
		return passwordService.forgetPassword(password);
	}
	/**验证支付密码
	 * @param password
	 * @return
	 */
	@RequestMapping("/checkPassword")
	@ResponseBody
	public String checkPayPassword(PayPassword password){
		String tip = passwordService.checkPassword(password);
		if(tip.equals("S")){
			return "验证密码正确！";
		}else{
			return tip;
		}
	}
}
