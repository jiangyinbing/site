package com.hb.framework.superhelp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hb.framework.superhelp.task.ModelLocator;
import com.hb.framework.superhelp.util.Md5Tool;
import com.hb.framework.system.dao.UserDao;
import com.hb.framework.system.entity.User;
/**
 * 
*  webservise统一验证管理
*  接口访问用户名和密码 通过系统管理的用户管理模块管理
* 项目名称：wuhan_power   
* 类名称：WebserviceAccess   
* 类描述：   
* 创建人：h  
* 创建时间：2014-9-26 下午04:32:16   
* 修改人：Administrator   
* 修改时间：2014-9-26 下午04:32:16   
* 修改备注：   
* @version    
*
 */
@Service
public class WebserviceAccess extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        	/**
        	 * apiName本系统提供的账户，apiPwd本系统提供的密码
        	 */
        	String name=request.getParameter("apiName");
        	String pwd=request.getParameter("apiPwd");
        	if(null!=name && pwd!=null && !"".equals(name)){
				ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(ModelLocator.getInstance().getContext());
				UserDao userDao=(UserDao)ctx.getBean("userDao");
				User user=userDao.querySingleUser(name);
		        //验证通过
		        if (user!=null && name.equals(user.getUserName()) && Md5Tool.getMd5(pwd).equals(user.getUserPassword())) {
		            filterChain.doFilter(request, response);
		        } else {
		        	  //用户名或密码验证失败
		            response.getWriter().print("{\"state\":2}");
		        }
        	}else {
	        	  //参数错误
	            response.getWriter().print("{\"state\":1}");
	        }
    }
}