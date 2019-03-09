package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hb.framework.business.entity.CustomerInfo;
import com.hb.framework.business.entity.Linkman;
import com.hb.framework.business.entity.Merchant;
import com.hb.framework.business.entity.Order;
import com.hb.framework.business.entity.UploadFileInfo;
import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.superhelp.util.HttpClient;
import com.hb.framework.superhelp.util.HttpClientUtils;
import com.hb.framework.superhelp.util.JsonSerializeUtil;
import com.hb.framework.system.entity.User;

@Service
public class SignOnService {


	private static final String NULL = null;

	
	
	/**查询订单
	 * @param phone
	 * @return
	 */
	public String querySignOn(String phone,String idCard,String frist,String last) {
		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		getHeader(serviceHeader);
		getQueryBody(serviceBody,phone,idCard,frist,last);
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		serviceDoc.put("SERVICE", service);
		String json=JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		String result = new HttpClient().send(json);
		return result;
	}
	
	
	/**添加报文的头信息
	 * @param serviceHeader
	 */
	private void getHeader(Map<String, Object> serviceHeader) {
	
		serviceHeader.put("SERVICE_ID","RmpsQuerySignOnList");   
    	serviceHeader.put("ORG","000000000001");   
		serviceHeader.put("CHANNEL_ID","BANK");   
		serviceHeader.put("ACQ_ID","00230000");
		serviceHeader.put("SUB_TERMINAL_TYPE","APP");
		serviceHeader.put("SERVICESN","YG20150825112132123464");      
		serviceHeader.put("OP_ID",null);           
		serviceHeader.put("REQUEST_TIME","20151002161241");    
		serviceHeader.put("VERSION_ID","01");      
		serviceHeader.put("MAC",null); 		
		serviceHeader.put("SERV_RESPONSE",null); 
	}
	
	/**创建查询征审报文的body信息
	 * @param serviceBody
	 * @param phone
	 */
	private void getQueryBody(Map<String, Object> serviceBody, String phone,String idCard,String frist,String last) {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("PHONE", phone);
		request.put("ID_CARD", idCard);
		request.put("FIRSTROW", frist);
		request.put("LASTROW", last);
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
	}
}
