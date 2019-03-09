package com.hb.framework.system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.entity.BaseData;
import com.hb.framework.system.service.BaseDataService;

/**
 * 
 * @author h
 *
 * @Email: 
 * @version 1.0v
 */
@Controller
@RequestMapping(value="/background/system/basedata/")
public class BaseDataController {
	@Autowired
	private BaseDataService baseDataService;
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		List<BaseData> basedatas=baseDataService.findType("0");
		model.addAttribute("basedatas", basedatas);
		return "/background/system/basedata/add";
	} 
	
	/**
	 * 保存新增
	 * @param model
	 * @param role
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,BaseData baseData){
		baseDataService.add(baseData);
		return "redirect:query.html";
	}
	
	/**
	 * 分页查询
	 * @param model
	 * @param role
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,BaseData baseData,String pageNow){
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = baseDataService.query(pageView, baseData);
		model.addAttribute("pageView", pageView);
		return "/background/system/basedata/list";
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="deleteById")
	public String deleteById(Model model,String basedataId){
		baseDataService.delete(basedataId);
		return "redirect:query.html";
	}
	
	/**
	 * 查询单条记录
	 * @param model
	 * @param roleId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String basedataId,int typeKey){
		BaseData basedata = baseDataService.getById(basedataId);
		model.addAttribute("basedata", basedata);
		List<BaseData> basedatas=baseDataService.findType("0");
		model.addAttribute("basedatas", basedatas);
		if(typeKey == 1){
			return "/background/system/basedata/edit";
		}else{
			return "/background/system/basedata/show";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param role
	 * @return
	 */
	@RequestMapping(value="update")
	public String update(Model model,BaseData baseData){
		baseDataService.modify(baseData);
		return "redirect:query.html";
	}
	
	/**
	 * 验证系统名称是否可用
	 * @param model
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findByAlias")
	public int findByAlias(Model model,String alias){
		int errorCode = 1;
		try {
			BaseData baseData=baseDataService.findByAlias(alias);
			if(null==baseData){
				errorCode=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorCode=1;
		}
		return errorCode;
	}
}
