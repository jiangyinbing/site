package com.hb.framework.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.framework.business.entity.CustomerInfo;
import com.hb.framework.business.service.CustomerInfoService;

/**个人信息
 * @author lx
 *
 */
@Controller
@RequestMapping("/background/business/customerinfo")
public class CustomerInfoController {
	
	@Autowired
	private CustomerInfoService customerInfoService;
	private String retMes;
	private CustomerInfo updateInfo;//保存用户修改时输入的对象值
	
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 * @throws JSONException 
	 */
	@RequestMapping("query")
	public String query(Model model, CustomerInfo info,HttpServletRequest request) throws JSONException {
		CustomerInfo customerinfo = customerInfoService.queryInfo(request);
		if(updateInfo!=null){//修改时保存的实体，假如修改不成功，则需要回显修改时填的数据。
			model.addAttribute("customerinfo", updateInfo);
		}else{
			model.addAttribute("customerinfo", customerinfo);
		}
		request.setAttribute("msg",retMes);
		retMes = "";//传输完之后清空
		updateInfo = null;
		return "/background/biz/customer/message";
	}
	
	
	@RequestMapping("update")
	public String update(Model model, CustomerInfo info,HttpServletRequest request) throws JSONException {
		String retMessage = customerInfoService.updateInfo(info, request);
		if(retMessage.equals("ERROR")){//修改失败时，需要回显所填数据
			 updateInfo = info;
			 retMes = "修改失败";
		}else{
			retMes = "修改成功";
		}
		return "redirect:query.html";
	}

	public String getRetMes() {
		return retMes;
	}
	public void setRetMes(String retMes) {
		this.retMes = retMes;
	}


	public CustomerInfo getUpdateInfo() {
		return updateInfo;
	}
	public void setUpdateInfo(CustomerInfo updateInfo) {
		this.updateInfo = updateInfo;
	}
	
	
}
