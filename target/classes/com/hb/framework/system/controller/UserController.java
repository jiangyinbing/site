package com.hb.framework.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.Md5Tool;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.entity.Roles;
import com.hb.framework.system.entity.User;
import com.hb.framework.system.entity.UserRoles;
import com.hb.framework.system.service.RolesService;
import com.hb.framework.system.service.UserService;

/**
 * 
 * @author h
 * 
 * @Email: 
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/system/user/")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RolesService rolesService;
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, User user, String pageNow) {
		PageView pageView = null;
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = userService.query(pageView, user);
		model.addAttribute("pageView", pageView);
		return "/background/system/user/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @param videoType
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, User user) {
		userService.add(user);
		return "redirect:query.html";
	}

	/**
	 * 跑到新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return "/background/system/user/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @param videoTypeId
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String userId) {
		userService.delete(userId);
		return "redirect:query.html";
	}
	
	/**
	 * 初始化密码
	 * 
	 * @param String userId,HttpServletRequest request
	 * @return
	 */
	@RequestMapping("reset")
	public String reset(Model model,String userId) {
		User user=new User();
		user.setUserId(Integer.parseInt(userId));
		user.setUserPassword(Md5Tool.getMd5("666666"));
		userService.modify(user);
		return "redirect:query.html";
	}
	
	/**
	 * 修改界面
	 * 
	 * @param model
	 * @param videoTypeIds
	 * @return
	 */
	@RequestMapping("getById")
	public String getById(Model model, String userId, int type) {
		User user = userService.getById(userId);
		model.addAttribute("user", user);
		 List<Roles> roles=rolesService.findAll();
		 model.addAttribute("roles", roles);
		if (type == 1) {
			return "/background/system/user/edit";
		} else {
			return "/background/system/user/show";
		}
	}

	/**
	 * 更新类型
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String update(Model model, User user,UserRoles userRoles) {
		userService.modify(user);
		if(userRoles.getRoleId()!=null)
		rolesService.saveUserRole(userRoles);
		return "redirect:query.html";
	}

	/**
	 * 删除所选的
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteAll")
	public String deleteAll(Model model, String[] check) {
		for (String string : check) {
			userService.delete(string);
		}
		return "redirect:query.html";
	}
	
	/**
	 * 给用户分配角色界面
	 * @return
	 */
	@RequestMapping("userRole")
	public String userRole(Model model,String userId){
		User user = userService.getById(userId);
		model.addAttribute("user", user);
		List<Roles> roles = rolesService.findAll();
		model.addAttribute("roles", roles);
		return "/background/system/user/userRole";
	}
	/**
	 * 保存用户分配角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("allocation")
	public String allocation(Model model,UserRoles userRoles){
		String errorCode = "1000";
		try {
			rolesService.saveUserRole(userRoles);
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="1001";
		}
		return errorCode;
	}
}