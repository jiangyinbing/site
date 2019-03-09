package com.hb.framework.superhelp.util;

/**
 * 序列化或者反序列化异常
 * 
 * @author 产品组
 *
 */
public class SerializerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SerializerException(String exceptionInfo) {
		super(exceptionInfo);
	}
	
	public SerializerException(String exceptionInfo, Throwable throwable) {
		super(exceptionInfo, throwable);
	}

}
