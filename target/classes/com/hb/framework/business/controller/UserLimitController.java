package com.hb.framework.business.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.framework.business.entity.Order;
import com.hb.framework.business.service.CustomerInfoService;
import com.hb.framework.business.service.OrderService;
import com.hb.framework.business.service.UserLimitService;

import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.PageIndex;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.entity.User;
import com.hb.framework.system.entity.UserLimit;

	@Controller
	@RequestMapping("/background/biz/userLimit")
	public class UserLimitController { 	
		@Autowired 
		private UserLimitService userLimitService;
		@Autowired
		private CustomerInfoService customerInfoService;
		private String msg;
		
		/**
		 * 删除
		 * 
		 * @param model
		 * @param videoTypeId
		 * @return
		 */
		@RequestMapping("deleteById")
		public String deleteById(Model model,UserLimit userLimit,String mobile_no) {
			userLimitService.delete(userLimit,mobile_no);
			System.out.println("delete++controller");
			return "redirect:list.html";
		}

	@RequestMapping(value="/list",produces="text/plain;charset=utf-8")
	public String queryOrder1(HttpServletRequest request ,String customer_name,String pageNow, Model model){
		if (Common.isEmpty(pageNow)) {
			pageNow="1";
		} 
		int currpage = Integer.parseInt(pageNow);
		if(currpage<=0){
			currpage=1;
		}
		/*User user = (User) request.getSession().getAttribute("userSession");
		int userId = user.getUserId();*/
		//List<Order> lst = orderService.queryOrder(userId,orderId,currpage);
	
		List<UserLimit> lst = userLimitService.queryOrder1(customer_name,currpage);
		
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView.setRecords(lst);
		pageView.setRowCount(userLimitService.getOrderTotalCount(customer_name));
		pageView.setPageCount((long) Math.ceil(Double.valueOf(pageView.getRowCount()/2.0)));
		pageView.setPageNow(currpage);
		pageView.setPageSize(2);
		PageIndex pageIndex=new PageIndex(1, pageView.getPageCount());
		model.addAttribute("pageView", pageView);
		model.addAttribute("msg", msg);
 		return "/background/biz/userLimit/userLimit";
		
	} 
	
	
	@RequestMapping(value="/mkorder",produces="text/plain;charset=utf-8")
	public String makeOrder(UserLimit userLimit,HttpServletRequest request, Model model) throws JSONException{
		//int CUSTOMER_id=1;
		Random random = new Random();
		int nextInt = random.nextInt(1000000000);
		userLimit.setCustomer_Id(nextInt);
		userLimit.setLimitId(nextInt);
		String callback = userLimitService.makeOrder(userLimit, request);
		
		
 
		if(callback.equals("S")){
			msg = "成功创建订单";
			return "redirect:list.html";
		}
		msg = callback;
		model.addAttribute("msg", callback);
		return null;
	}
	
	/**跳转到创建
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/gotoUserLimitMake")
	public String gotoOrderMake(HttpServletRequest request){
		return "/background/system/userLimit/makeUserLimit";
	}
	/**跳转到修改
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/gotoUserLimitMod")
		public String gotoOrderMod(HttpServletRequest request ,String customer_name,UserLimit userLimit,String pageNow, Model model){
			if (Common.isEmpty(pageNow)) {
				pageNow="1";
			} 
			int currpage = Integer.parseInt(pageNow);
			if(currpage<=0){
				currpage=1;
			}
			/*User user = (User) request.getSession().getAttribute("userSession");
			int userId = user.getUserId();*/
			//List<Order> lst = orderService.queryOrder(userId,orderId,currpage);
		
			List<UserLimit> lst = userLimitService.queryOrder1(customer_name,currpage);
			
			PageView pageView = null;
			if(Common.isEmpty(pageNow)){
				pageView = new PageView(1);
			}else{
				pageView = new PageView(Integer.parseInt(pageNow));
			}
			pageView.setRecords(lst);
			pageView.setRowCount(userLimitService.getOrderTotalCount(customer_name));
			pageView.setPageCount((long) Math.ceil(Double.valueOf(pageView.getRowCount()/2.0)));
			pageView.setPageNow(currpage);
			pageView.setPageSize(2);
			PageIndex pageIndex=new PageIndex(1, pageView.getPageCount());
			model.addAttribute("pageView", pageView);
			model.addAttribute("msg", msg);
			
			/*Random random = new Random();
			int nextInt = random.nextInt(1000000000);
			userLimit.setCustomer_Id(nextInt);*/
			
			String callback = userLimitService.makeOrder(userLimit, request);
			
			if(callback.equals("S")){
				msg = "成功创建订单";
				return "redirect:list.html";
			}
			msg = callback;
			model.addAttribute("msg", callback);
		return "/background/system/userLimit/useLimitMod";
		
	}
	
	@RequestMapping(value="/modUserLimit")
	/*public String modUserLimit(String mobile_no,String remain_limt,String customer_limit,String use_limit,
			String customer_name,String effect_date,String invalid_date,String status,String remark){*/
	public String modUserLimit(UserLimit userLimit){
	userLimitService.modify(userLimit);
		System.out.println(userLimit.getCustomer_name()+""+userLimit.getMobile_no()+"mod++controller"+userLimit.getInvalid_date());
		
		return "redirect:list.html";
	}
	
}
	

