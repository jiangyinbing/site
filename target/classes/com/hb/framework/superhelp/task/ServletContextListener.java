package com.hb.framework.superhelp.task;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class ServletContextListener extends ContextLoaderListener {
    /**
     * 利用监听器获取上下文，并且设置到 自定义 ModelLocator类中，以供TargetJob使用
     */
	public void contextInitialized(ServletContextEvent evt) {
		ModelLocator m = ModelLocator.getInstance();
		ServletContext context = evt.getServletContext();
		m.setContext(context);
		SetAllTaskThread setAllTaskThread = new SetAllTaskThread();
		setAllTaskThread.start();
		super.contextInitialized(evt);
	}
}