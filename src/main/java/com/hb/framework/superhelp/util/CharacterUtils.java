package com.hb.framework.superhelp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CharacterUtils{

	/**
	 * 产生随机字符串
	 * @param length
	 * @return
	 */
	/*public static String getRandomString(int length){
		Random random = new Random();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; ++i){
			int number = random.nextInt(3);
			long result = 0;

			switch (number){
				case 0:
					result = Math.round(Math.random() * 25 + 65);
					sb.append(String.valueOf((char) result));
					break;
				case 1:
					result = Math.round(Math.random() * 25 + 97);
					sb.append(String.valueOf((char) result));
					break;
				case 2:
					sb.append(String.valueOf(new Random().nextInt(10)));
					break;
			}
		}
		return sb.toString();
	}*/
	/**
	 * 产生随机整数
	 * @param length
	 * @return
	 */
	public static Integer getRandomInteger(int num){
		Random random = new Random();
	
		return random.nextInt(num);
	}
	
	/*
	 * 固定位数随机数 (位数 1~ 9)
	 */
	public static String getNumberFromRandom(int num) {
		if (num < 1) {
			num = 1;
		} else if (num > 9) {
			num = 9;
		}
		String str1 = "1";
		String str2 = "9";
		if (num == 1) {
			str1 = "0";
			str2 = "9";			
		} else {
			for (int i = 1; i < num; i++) {
				str1 += "0";
				str2 += "9";
			}
		}		
		
		int lo1 = Integer.parseInt(str1);
		int lo2 = Integer.parseInt(str2);
		
		Random r = new Random();
		long xx = r.nextInt(lo2);
		while (xx < lo1) {
			xx = r.nextInt(lo2);
		}
		return String.valueOf(xx);
	}
	
	/**
	 * 产生随机流水号
	 * 
	 * @param length
	 * @return
	 */
	public static synchronized String getSerialNum() {
		synchronized(CharacterUtils.class) {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式					
			//String id = df.format(new Date()) + "-" + getNumberFromRandom(4);
			String id = df.format(new Date()) + getNumberFromRandom(4);
			//String id = df.format(new Date());
			//String id =  getNumberFromRandom(0);
			return id;
		}
		 
	}
 
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			System.out.println(getSerialNum());
			
		}
		
		
		
	}
	
	/**
	 * 获取后前缀
	 * @param strs
	 * @return
	 */
	public static String  getPrefix(String strs){
		if (strs==null){
			return null;
		}
		int index=strs.lastIndexOf(".");
		return strs.substring(0, index);
	}
	/**
	 * 获取后缀
	 * @param strs
	 * @return
	 */
	public static String  getSuffix(String strs){
		if (strs==null){
			return null;
		}
		int index=strs.lastIndexOf(".");
		return strs.substring(index);
	}
}
