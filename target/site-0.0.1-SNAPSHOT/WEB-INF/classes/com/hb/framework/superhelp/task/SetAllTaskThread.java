package com.hb.framework.superhelp.task;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hb.framework.system.service.BaseDataService;

public class SetAllTaskThread extends Thread {
	public void run(){
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServletContext context = ModelLocator.getInstance().getContext();
		// 初始化自动任务
		WebApplicationContext webContext = null;
		Object obj = null;
		while(obj == null){
			if(webContext == null){
				webContext = WebApplicationContextUtils.getWebApplicationContext(context);
			}
			if(webContext != null){
				try{
					obj = webContext.getBean("baseDataService");
				}catch(Exception e){
				}
			}
			if(obj == null){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		BaseDataService taskService = (BaseDataService)obj;
		taskService.setAllTask();
	}
}

