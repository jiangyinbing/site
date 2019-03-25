package com.hb.framework.superhelp.task;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletContext;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TargetJob implements Job {
	public static String TARGET_OBJECT = "targetObject";
	public static String TARGET_METHOD = "targetMethod";
	
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		JobDataMap jobDataMap = jobContext.getJobDetail().getJobDataMap();
		String targetObject = (String)jobDataMap.get(TARGET_OBJECT);
		String targetMethod = (String)jobDataMap.get(TARGET_METHOD);
		
		ServletContext context = ModelLocator.getInstance().getContext();
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(context);
		Object obj = null;
		if(ctx != null){
			obj = ctx.getBean(targetObject);
		}
		if(obj == null){
			return;
		}
		try {
			Method method = obj.getClass().getMethod(targetMethod);
			if(method != null){
				method.invoke(obj);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}