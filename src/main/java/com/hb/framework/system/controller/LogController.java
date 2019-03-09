package com.hb.framework.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.entity.Log;
import com.hb.framework.system.service.LogService;

/**
 * 
 * @author h
 * 
 * @Email: 
 * @version 1.0v
 */
@Controller
@RequestMapping(value="/background/system/log/")
public class LogController {
	@Autowired
	private LogService logService;
	
	/**
	 * 查询客户登陆信息
	 * @param model
	 * @param log
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value="query")
	public String queryUserLogin(Model model, Log log, String pageNow){
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		logService.query(pageView, log);
		model.addAttribute("pageView", pageView);
		return "/background/system/log/list";
	}

}
