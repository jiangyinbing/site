package com.hb.framework.system.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hb.framework.superhelp.base.BusinessException;
import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.entity.UserLoginList;
import com.hb.framework.system.service.UserLoginListService;

/**
 * 
 * @author h
 * 
 * @Email: 
 * @version 1.0v
 */
@Controller
@RequestMapping(value="/background/system/userLoginList/")
public class UserLoginListController {
	@Autowired
	private UserLoginListService userLoginListService;
	
	/**
	 * 查询客户登陆信息
	 * @param model
	 * @param userLoginList
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value="query")
	public String queryUserLogin(Model model, UserLoginList userLoginList, String pageNow){
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		userLoginListService.query(pageView, userLoginList);
		model.addAttribute("pageView", pageView);
		return "/background/system/userLoginList/loginList";
	}
	
	/**
	 * 导出登录信息
	 * @param response
	 * @return
	 */
    @RequestMapping(value="exportExcel")  
    public String exportExcel(HttpServletRequest request,HttpServletResponse response,UserLoginList userLoginList,String expPageSize)throws Exception  
    {  
    	PageView pageView = null;
		if(Common.isEmpty(expPageSize)){
			pageView = new PageView(10,1);
		}else{
			pageView = new PageView(Integer.parseInt(expPageSize),1);
		}
            String fileName="登录信息列表";
            response=Common.setResponse(response,fileName);
            ServletOutputStream outputStream = response.getOutputStream();
            userLoginListService.exportExcel(fileName, outputStream,pageView, userLoginList);
        return null;
    }
    
    /** 
     * 读取excel表 
     * @throws IOException 
     * @throws BusinessException 
     */  
    @RequestMapping(value = "readExcel", method = RequestMethod.POST)  
    public String readExcel(@RequestParam MultipartFile file,HttpServletRequest request) throws BusinessException, IOException{
			userLoginListService.readExcel(file.getInputStream(),file.getOriginalFilename());
       return "redirect:query.html";
    }  

}
