package com.hb.framework.business.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import com.hb.framework.superhelp.util.JsonSerializeUtil;

public class HttpClient {
	private int connectionTimeout = 1000 * 60;
	private int waitTimeout = 3000;
	private int maxConnectionsPerHost = 10;
	private int maxTotalConnections = 5;
	private static final String charSet = "UTF-8";
	private static final String url = "http://10.0.0.231:8888/frontend/CallJsonProcess";
	private HttpConnectionManager connectionManager;

	public void getConnection() {

		if (connectionManager == null) {
			// 创建一个线程安全的HTTP连接池
			connectionManager = new MultiThreadedHttpConnectionManager();
			HttpConnectionManagerParams params = new HttpConnectionManagerParams();
			// 连接建立超时
			params.setConnectionTimeout(connectionTimeout);
			// 数据等待超时
			params.setSoTimeout(waitTimeout);
			// 默认每个Host最多10个连接S
			params.setDefaultMaxConnectionsPerHost(maxConnectionsPerHost);
			// 最大连接数（所有Host加起来）
			params.setMaxTotalConnections(maxTotalConnections);
			connectionManager.setParams(params);
		}

	}

	public String send(String jsonReq) {
		String msg = "";
		getConnection();
		// 发送报文
		org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient(
				connectionManager);
		PostMethod method = new PostMethod(url);
		method.addRequestHeader("Content-Type", "application/json");
		try {
			System.out.println("发送报文{}" + jsonReq);
			method.setRequestEntity(new StringRequestEntity(jsonReq, null,
					charSet));
			httpClient.executeMethod(method);
			String jsonRes = method.getResponseBodyAsString();
			msg = jsonRes;
			System.out.println("响应报文{}" + msg);
			return msg;
		} catch (UnsupportedEncodingException e) {
			msg = "交易报文编码异常[{}]" + e.getMessage();
			System.out.print(msg);
			e.printStackTrace();
		} catch (HttpException e) {
			msg = "交易http连接异常[{}]" + e.getMessage();
			System.out.print(msg);
			e.printStackTrace();
		} catch (IOException e) {
			msg = "交易http读取异常[{}]" + e.getMessage();
			System.out.print(msg);
			e.printStackTrace();

		} catch (Exception e) {
			msg = "发送异常[{}]" + e.getMessage();
			System.out.print(msg);
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return msg;
	}


	public static void main(String[] args) throws IOException {

		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		serviceDoc.put("SERVICE", service);
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		genHeader(serviceHeader);
		genBody(serviceBody);
		String json = JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		new HttpClient().send(json);

	}

	public static void genHeader(Map<String, Object> serviceHeader) {
		serviceHeader.put("SERVICE_ID", "XJOrderInfoUndo");
		serviceHeader.put("ORG", "000000000001");
		serviceHeader.put("CHANNEL_ID", "BANK");
		serviceHeader.put("ACQ_ID", "00230000");
		serviceHeader.put("SUB_TERMINAL_TYPE", "APP");
		serviceHeader.put("SERVICESN", "YG20150825112132123464");
		serviceHeader.put("OP_ID", null);
		serviceHeader.put("REQUEST_TIME", "20151002161241");
		serviceHeader.put("VERSION_ID", "01");
		serviceHeader.put("MAC", null);
		serviceHeader.put("SERV_RESPONSE", null);

	}

	public static void genBody(Map<String, Object> serviceHeader) {
		Map<String, Object> request = new HashMap<String, Object>();
//		request.put("MOBILE_NO", "13500000001");
		request.put("XJ_ORDER_ID", "1053");
//		request.put("DOWN_PAYMENT", "1000.00");
//		request.put("MECHAN_ID", "89262306");
//		request.put("LOAN_AMOUNT", "9000.00");
//		request.put("TERM", "9");
//		request.put("PRODUCT_ID", "000401");
//		request.put("LOAN_CODE", "2101");
//		request.put("PRODUCT_NAME", "现金贷");
		
		serviceHeader.put("REQUEST", request);
		serviceHeader.put("RESPONSE", null);
	}

}
