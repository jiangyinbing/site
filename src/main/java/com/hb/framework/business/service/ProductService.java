package com.hb.framework.business.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.hb.framework.business.entity.Order;
import com.hb.framework.superhelp.util.HttpClient;
import com.hb.framework.superhelp.util.JsonSerializeUtil;
import com.hb.framework.system.entity.User;

@Service
public class ProductService {

	/**
	 * 获取产品信息
	 * @param order
	 * @return
	 * @throws JSONException 
	 */
	public List<Order> getProducts(HttpServletRequest request, String productCd) throws JSONException {
		// TODO Auto-generated method stub
		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		genHeader(serviceHeader, "RmpsQueryProduct");
		genProductBody(serviceBody, request, productCd);
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		serviceDoc.put("SERVICE", service);
		String json=JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		String result = new HttpClient().send(json);
		
		JSONObject dataJson=new JSONObject(result);
		JSONObject service2=dataJson.getJSONObject("SERVICE");
		JSONObject serviceBody2=service2.getJSONObject("SERVICE_BODY");
		JSONObject response = serviceBody2.getJSONObject("RESPONSE");
		JSONArray jsonArray = response.getJSONArray("PRODUCT_CD_LIST");
		
		List<Order> lst = new ArrayList<Order>();
		for(int i = 0; i<jsonArray.length(); i++){
			Order order = new Order();
			JSONObject ja = jsonArray.getJSONObject(i);
			order.setProductName(ja.get("BIZ_NAME").toString()); // 产品名称
			order.setProductCd(ja.get("PRODUCT_CD").toString()); // 产品代码
			order.setProcDefKey(ja.get("PROC_DEF_KEY").toString());// 流程定义key
			order.setIsNeedGuarantee(ja.get("IS_NEED_GUARANTEE").toString()); // 是否担保 
			order.setIsNeedMortgaged(ja.get("IS_NEED_MORTGAGED").toString()); // 是否抵质押
			order.setProductObj(ja.get("PRODUCT_OBJ").toString()); // 产品发行对象
			lst.add(order);
		}
		return lst;
	}
	
	/**
	 * 获取产品信息
	 * @param serviceHeader
	 * @param request
	 */
	public void genProductBody(Map<String, Object> serviceHeader, HttpServletRequest request, String productCd) {
		Map<String, Object> maps = new HashMap<String, Object>();
		User user = (User) request.getSession().getAttribute("userSession");
		String userType = "P";
		if(user.getCustomerType().equals("1"))
			userType = "C";
		maps.put("PRODUCT_OBJ", userType);
		
		if(productCd != null && productCd.length()!=0 && !productCd.equals("0")){
			maps.put("PRODUCT_CD", productCd);
		}
		
		serviceHeader.put("REQUEST", maps);
		serviceHeader.put("RESPONSE", null);
	}
	
	/**
	 * 获取核心企业信息
	 * @return
	 * @throws JSONException 
	 */
	public List<Order> getMerchant() throws JSONException {
		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		genHeader(serviceHeader, "RmpsCoreEnterprise");
		genCoreBody(serviceBody);
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		serviceDoc.put("SERVICE", service);
		String json=JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		String result = new HttpClient().send(json);
		
		JSONObject dataJson=new JSONObject(result);
		JSONObject service2=dataJson.getJSONObject("SERVICE");
		JSONObject serviceBody2=service2.getJSONObject("SERVICE_BODY");
		JSONObject response = serviceBody2.getJSONObject("RESPONSE");
		JSONArray jsonArray = response.getJSONArray("CORE_ENTERPRISE_LIST");
		
		List<Order> lst = new ArrayList<Order>();
		for(int i = 0; i<jsonArray.length(); i++){
			Order order = new Order();
			JSONObject ja = jsonArray.getJSONObject(i);
			order.setCoreEntId(ja.get("ENTERPRISE_ID").toString());
			order.setCoreEntName(ja.get("ENTERPRISE_NAME").toString());
			lst.add(order);
		}
		
		return lst;
	}

	/**
	 * 获取核心企业信息
	 * @param serviceHeader
	 */
	public void genCoreBody(Map<String, Object> serviceHeader) {
		Map<String, Object> maps = new HashMap<String, Object>();
		serviceHeader.put("REQUEST", maps);
		serviceHeader.put("RESPONSE", null);
	}
	
	/**
	 * 获取头报文信息
	 * @param serviceHeader
	 * @param type
	 */
	public void genHeader(Map<String, Object> serviceHeader, String type) {
		serviceHeader.put("SERVICE_ID", type);
		serviceHeader.put("ORG", "000000000001");
		serviceHeader.put("CHANNEL_ID", "BANK");
		serviceHeader.put("ACQ_ID", "00230000");
		serviceHeader.put("SUB_TERMINAL_TYPE", "APP");
		serviceHeader.put("SERVICESN", "YG20150825112132123464");
		serviceHeader.put("OP_ID", null);
		serviceHeader.put("REQUEST_TIME", "20170102161241");
		serviceHeader.put("VERSION_ID", "01");
		serviceHeader.put("MAC", null);
		serviceHeader.put("SERV_RESPONSE", null);

	}

}
