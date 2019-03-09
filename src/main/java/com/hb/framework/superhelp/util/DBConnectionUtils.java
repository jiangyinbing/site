package com.hb.framework.superhelp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBConnectionUtils {

	public static Connection conn = null;

	private static String getDBConnection() {
		String msg = "";
		try {
			Properties props = PropertiesUtils.getProperties("/jdbc.properties");
			if (null != props) {
				String driver = props.getProperty("driverClassName");
				String url = props.getProperty("url");
				String password = props.getProperty("password");
				String username = props.getProperty("username");
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url, username, password);
			} else {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager
						.getConnection("jdbc:mysql://10.0.0.231:3306/hb_application?user=root&password=roooot&useUnicode=true&characterEncoding=gb2312");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public static ResultSet executeQuery(String sql) {
		ResultSet dbResult = null;
		getDBConnection();
		try {
			PreparedStatement dbStat = conn.prepareStatement(sql);
			dbResult = (ResultSet) dbStat.executeQuery();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
		}
		return dbResult;
	}

	public static String executeInsert(String sql) {
		String msg = "";
		getDBConnection();
		try {
			PreparedStatement dbStat = conn.prepareStatement(sql);
			dbStat.executeUpdate(sql);
		} catch (Exception ex) {
			msg = ex.getMessage();
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
		}
		return msg;
	}

	public static String executeUpdate(String sql) {
		String msg = "";
		getDBConnection();
		try {
			PreparedStatement dbStat = conn.prepareStatement(sql);
			dbStat.executeUpdate(sql);
		} catch (Exception ex) {
			msg = ex.getMessage();
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
		}
		return msg;
	}

	public static String executeDelete(String sql){
		String msg = "";
		getDBConnection();
		try {
			PreparedStatement dbStat = conn.prepareStatement(sql);
			dbStat.execute(sql);
		} catch (Exception ex){
			msg = ex.getMessage();
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		} finally {}
		return msg;
	}
	
}
