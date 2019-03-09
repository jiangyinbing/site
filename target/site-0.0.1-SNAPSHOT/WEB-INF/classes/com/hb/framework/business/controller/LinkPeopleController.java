package com.hb.framework.business.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.framework.business.entity.LinkPeople;
import com.hb.framework.business.entity.Linkman;
import com.hb.framework.business.service.LinkPeopleService;
import com.hb.framework.system.entity.User;

/**
 * 紧急联系人的类
 * @author lym
 *
 */
@Controller
@RequestMapping ("/biz/bussiness/linkpeople/")
public class LinkPeopleController {
	
	@Autowired
	private LinkPeopleService linkPeopleService;
	
	private String tip;

	/**
	 * 查询相关联系人信息
	 * @param request
	 * @return
	 * @throws JSONException
	 */
	@RequestMapping(value="queryLinkPeople",produces="text/plain;charset=utf-8")
	public String queryLinkpeople(HttpServletRequest request) throws JSONException{
		User users = (User) request.getSession().getAttribute("userSession");
		
		Map<String, Object> maps = linkPeopleService.queryLinkPeople(users, null);
		List<Linkman> lst = new ArrayList<Linkman>();
		
		if(maps!=null){
			String error = (String) maps.get("S");
		    if(!"0".equals(error)){
		    	lst = (List<Linkman>) maps.get("linkmanLst");
		    }
		}
		request.setAttribute("lst", lst);
		request.setAttribute("customerType", users.getCustomerType());
		request.setAttribute("tip", tip);
		tip = "";//传输完之后清空
		return "/background/biz/linkPeople/list";
	}
	
	@RequestMapping("addLinkpeople")
	public String addLinkpeople(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("userSession");
		request.setAttribute("customerType", user.getCustomerType());
		return "/background/biz/linkPeople/add";
	}

	/**
	  * 添加联系人
	 * @param customer
	 * @param link1				联系人1名字
	 * @param link2				联系人2名字
	 * @param linkrelation1		与联系人1的关系
	 * @param linkrelation2		与联系人1的关系
	 * @param linkmobile1		联系人1移动号码
	 * @param linkmobile2		联系人2移动号码
	 * @param idNo1				联系人1身份证号
	 * @param idNo2				联系人2身份证号
	 * @param unitName1			联系人1单位名称
	 * @param unitName2			联系人2单位名称
	 * @param unitPhone1		联系人1单位电话
	 * @param unitPhone2		联系人2单位电话
	 * @return
	 * @throws JSONException
	 */
	@RequestMapping(value="doAddLinkpeople",produces="text/plain;charset=utf-8")
	public String doAddLinkpeople(String link1, String link2,
						String linkrelation1, String linkrelation2,
						String linkmobile1, String linkmobile2,
						String idNo1, String idNo2,
						String unitName1, String unitName2,
						String unitPhone1, String unitPhone2,
						HttpServletRequest request) throws JSONException{
		
		String return_str = linkPeopleService.addLinkPeople(request,  link1,  link2,
				 linkrelation1,  linkrelation2,
				 linkmobile1,  linkmobile2,
				 idNo1, idNo2,
				 unitName1, unitName2,
				 unitPhone1, unitPhone2);
		
		if(return_str.equals("S")){
			tip = "添加成功！";
			return "redirect:queryLinkPeople.html";
		}else{
			request.setAttribute("tip", "添加失败，" + return_str);
			return "/background/biz/linkPeople/add";
		}
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
	
}
