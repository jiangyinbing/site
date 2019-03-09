package com.hb.framework.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.framework.superhelp.base.BusinessException;
import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.entity.SysFile;
import com.hb.framework.system.entity.User;
import com.hb.framework.system.service.SysFileService;


@Controller  
@RequestMapping(value = "/background/system/back/")  
public class BackController {
	@Autowired
	private SysFileService sysFileService;
    /**
	 * 分页查询
	 * @param model
	 * @param role
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,SysFile file,String pageNow){
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		file.setType(100);
		pageView = sysFileService.query(pageView, file);
		model.addAttribute("pageView", pageView);
		return "/background/system/backdata/list";
	}
	
	/**
	 * 备份
	 * @param model
	 * @param roleId
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value="back")
	public String back(HttpServletRequest request) throws BusinessException{
		 User user=(User)request.getSession().getAttribute("userSession");
	        sysFileService.back(request, user==null?1:user.getUserId());  
	        return "redirect:query.html";
	}
	
	/**
	 * 恢复
	 * @param model
	 * @param roleId
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value="regain")
	public String regain(HttpServletRequest request,String sysname) throws BusinessException{
	        sysFileService.regain(request, sysname); 
	        return "redirect:query.html";
	}
	/**
	 * 根据id删除
	 * @param model
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="deleteById")
	public String deleteById(HttpServletRequest request,String id,String sysname){
		sysFileService.delete(request,id,sysname,"Mysqlback\\");
		return "redirect:query.html";
	}
	
    /** 
     * 下载 
     *  
     * @param attachment 
     * @param request 
     * @param response 
     * @return 
     * @throws BusinessException 
     * @throws Exception 
     * @throws Exception 
     */  
    @RequestMapping(value = "download")  
    public void download(HttpServletRequest request,HttpServletResponse response,String sysname,String name) throws BusinessException{  
			sysFileService.download(request, response, sysname,name,"Mysqlback\\");
    } 
}
