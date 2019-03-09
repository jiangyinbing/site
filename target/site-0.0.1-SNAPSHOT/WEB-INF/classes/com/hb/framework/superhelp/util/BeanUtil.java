package com.hb.framework.superhelp.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * JavaBean 工具类
 * 用途：从JSON中的值包装成Java bean对象
 * @author h
 * @version 1.0 
 */
public class BeanUtil {

	/**
	 * 根据类的字节码获取实体类属性信息
	 * @param entityClass 任何实体类字节码
	 * @return HashMap(key,value)：key是属性名,value是属性对象PropertyDescriptor
	 */
	private HashMap<String,PropertyDescriptor> getBeanInfo(Class<?> entityClass)throws Exception{
		HashMap<String,PropertyDescriptor> beanMap = new HashMap<String,PropertyDescriptor>();
		//根据类的字节码获取JavaBean对象(Introspector:内省,是对JavaBean的操作类,英文名是视察之意)
		BeanInfo beanInfo =  Introspector.getBeanInfo(entityClass);
		//获取JavaBean的属性描述项
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		//取出每一个属性对象
		for(PropertyDescriptor pd : pds){
			//属性名称
			String fieldName = pd.getName();
			if(fieldName.equals("class")){
				continue;
			}
			beanMap.put(fieldName,pd);
		}
		return beanMap;
	}
	
	/**
	 * 将JSON中的数据封装到实体类属性中
	 * @param entityClass 要封装的实体类
	 * @param json 封装有键值对的json数据
	 * @throws JSONException 
	 * @throws Exception
	 */
	public Object convertJsonDataToJavaBean(Class<?> entityClass,JSONObject json) throws JSONException {
		// 构造Java Bean 对象
		Object entity = null;
		try {
			entity = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		// 封装有JavaBean信息的HashMap
		HashMap<String, PropertyDescriptor> beanInfoMap = null;
		try {
			beanInfoMap = getBeanInfo(entityClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Set<String> keys = beanInfoMap.keySet();
		for (String key : keys) {
			
			if(json.has(key)){
				// 封装在json中的值
				Object jsonValue = json.get(key);
				if (jsonValue == null || jsonValue.equals("null")|| jsonValue.equals("")) {
					continue;
				}else{
					// 获取属性对象
					PropertyDescriptor pd = beanInfoMap.get(key);
					// 属性数据类型(名称)
					String fieldType = pd.getPropertyType().getName();
					// 获取set方法对象
					Method writeMethod = pd.getWriteMethod();
					// 获取调用set方法需要传的值
					if("0.0".equals(jsonValue.toString())){
						jsonValue = "0";
					}
					Object args = typeConvert(jsonValue, fieldType);
					// 动态调用实体类的set方法,将值保存到实体类对象中
					try {
						writeMethod.invoke(entity, args);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			
			}
			
			
		}
		return entity;
	}
	
	/**
	 * 获取调用set方法需要传的值
	 * columnValue 从数据库中获取的数
	 * 据要封装到实体类属性中的字段值
	 * fieldType 属性的类型(数据类型)
	 * @return Object
	 * @throws ParseException 
	 */
	public Object typeConvert(Object fieldValue,String fieldType){
		Object args = new Object();
		//判断属性类型是否是string类型
		if(fieldType.trim().toLowerCase().indexOf("string") >= 0) {
			args =  fieldValue.toString();
		}
		//判断属性类型是否是int、Integer类型 
		else if(fieldType.trim().toLowerCase().indexOf("int")>=0 || 
				fieldType.trim().toLowerCase().indexOf("integer") >= 0) {
			args = new Integer(fieldValue.toString());
		} 
		//时间类型
		else if(fieldType.trim().toLowerCase().indexOf("double") >= 0) {
			args = new Double(fieldValue.toString());
		} 
		//将字符串转化为时间(Date)类型
		else if(fieldType.trim().toLowerCase().indexOf("date") >= 0) {
			args = transferStringToDate(String.valueOf(fieldValue));
		} 
		//long类型
		else if(fieldType.trim().toLowerCase().indexOf("long") >= 0) {
			args = new Long(fieldValue.toString());
		}
		//float类型
		else if(fieldType.trim().toLowerCase().indexOf("float") >= 0) {
			args = new Float(fieldValue.toString());
		}
		//BigDecimal类型
		else if(fieldType.trim().toLowerCase().indexOf("bigdecimal") >= 0){
			args =  new BigDecimal(fieldValue.toString());
		}
		return args;
	}
	
	
	/**
	 * 字符转换成日期类型
	 * @param source要转换的日期字符串
	 * @return Date对象
	 * @throws ParseException 
	 */
	public java.util.Date transferStringToDate(String source) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date = null;
		try {
			date = sf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
