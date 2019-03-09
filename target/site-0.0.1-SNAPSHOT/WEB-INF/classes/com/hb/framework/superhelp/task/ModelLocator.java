package com.hb.framework.superhelp.task;

import javax.servlet.ServletContext;

public class ModelLocator {
	private static ModelLocator m = null;
	/**
	 * 系统级上下文
	 */
	private ServletContext context;
	
	public static synchronized ModelLocator getInstance(){
		if(m == null){
			m = new ModelLocator();
		}
		return m;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}
}