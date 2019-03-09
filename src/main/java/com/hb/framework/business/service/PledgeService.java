package com.hb.framework.business.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.hb.framework.business.entity.Pledge;
import com.hb.framework.superhelp.util.HttpClient;
import com.hb.framework.superhelp.util.JsonSerializeUtil;

/**
 * 担保和抵押信息业务类
 * @author lym
 *
 */
@Service
public class PledgeService {

	/**
	 * 查询担保和抵押信息
	 * @param xj_order_id	订单id
	 * @return
	 * @throws JSONException 
	 */
	public Map<String, Object> getPGList(String xj_order_id) throws JSONException{
		// TODO Auto-generated method stub
		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> maps = new HashMap<String, Object>();
		serviceDoc.put("SERVICE", service);
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		
		genHeader(serviceHeader, "XJQueryGuarantorAndPledge");
		queryBody(serviceBody, xj_order_id);
		
		String json=JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		String return_str = new HttpClient().send(json);
		
		JSONObject dataJson=new JSONObject(return_str);
		JSONObject service2=dataJson.getJSONObject("SERVICE");
		JSONObject ser_body=service2.getJSONObject("SERVICE_BODY");
		JSONObject response = ser_body.getJSONObject("RESPONSE");
		
		//JSONArray array = (JSONArray) response.get("GUARANTEE_LIST");
		JSONArray array2 =  (JSONArray) response.get("PLEDGE_LIST");
//		List<Guarantor> glst = new ArrayList<Guarantor>();
		List<Pledge> plst = new ArrayList<Pledge>();
//		for (int i = 0; i < array.length(); i++) {
//			Guarantor g = new Guarantor();
//			JSONObject jo = array.getJSONObject(i);  
//			g.setId_no(jo.get("ID_NO").toString());				// 身份证号
//			g.setMobile_no(jo.get("MOBILE_NO").toString());		// 手机号码
//			g.setName(jo.get("NAME").toString());				// 姓名
//			g.setRelationship(jo.get("RELATIONSHIP").toString());//关系
//			g.setXj_order_id(xj_order_id);						// 订单id
//			g.setGuarantee_status(jo.get("GUARANTEE_STATUS").toString());		// 担保状态
//			glst.add(g);
//		}
//		maps.put("glst", glst);
		for (int i = 0; i < array2.length(); i++) {
			Pledge p = new Pledge();
			JSONObject jo = array2.getJSONObject(i);
			p.setArea_amount(jo.get("AREA_AMOUNT").toString());	// 数量
			p.setGood_type(jo.get("GOOD_TYPE").toString());		// 物品类型"H|房子","C|车子","O|其他"
			p.setOwner_name(jo.get("OWNER_NAME").toString());	// 产权人
			p.setPledge_name(jo.get("PLEDGE_NAME").toString());	// 抵质押物名称
			p.setXj_order_id(xj_order_id);						// 订单id
			p.setCert_no(jo.get("PLEDGE_ID").toString());		// 产权证号
			p.setPledge_flag(jo.get("TYPE").toString());		// 抵质押类型"P|质押","M|抵押"
			plst.add(p);
		}
		maps.put("plst", plst);
		return maps;
	}
	
	/**
	 * 添加抵质押信息
	 * @param pledge
	 * @return
	 * @throws JSONException
	 */
	public Map<String, Object> addPledge(Pledge pledge) throws JSONException{
		// TODO Auto-generated method stub
		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> maps = new HashMap<String, Object>();
		serviceDoc.put("SERVICE", service);
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		
		genHeader(serviceHeader, "XJAddPledgeInfo");
		addBody(serviceBody, pledge);
		
		String json=JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		String return_str = new HttpClient().send(json);
		
		JSONObject dataJson=new JSONObject(return_str);
		JSONObject service2=dataJson.getJSONObject("SERVICE");
		JSONObject ser_header=service2.getJSONObject("SERVICE_HEADER");
		JSONObject head_response = ser_header.getJSONObject("SERV_RESPONSE");
		JSONObject ser_body=service2.getJSONObject("SERVICE_BODY");
		JSONObject body_response = ser_body.getJSONObject("RESPONSE");
		
		maps.put("status", head_response.get("STATUS"));
		maps.put("desc", head_response.get("DESC"));
		maps.put("pledgeId", body_response.get("PLEDGE_ID"));
		return maps;
	}
	
	/**
	 * 对应添加担保和抵押信息报文body
	 */
	private void addBody(Map<String, Object> serviceHeader, Pledge pledge){
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("XJ_ORDER_ID", pledge.getXj_order_id());	// 订单id
		request.put("GOOD_TYPE", pledge.getGood_type());		// 物品类型
		request.put("OWNER_NAME", pledge.getOwner_name());		// 产权人
		request.put("CERT_NO", pledge.getCert_no());			// 产权证号
		request.put("PLEDGE_NAME", pledge.getPledge_name());	// 抵质押物名称
		request.put("AREA_AMOUNT", pledge.getArea_amount());	// 数量
		request.put("PLEDGE_FLAG", pledge.getPledge_flag());	// 抵质押类型
		
		request.put("PLEDGE_NAME", pledge.getPledge_name());		// 抵质押物名称
		request.put("CERT_USER_ID_NO", pledge.getCert_user_id_no());// 产权人身份证号
		request.put("OTH_IMP_AMT",pledge.getOth_imp_amt());			// 评估值(元)--资产金额
		request.put("MORTGAGE_ADDRES", pledge.getMortgage_addres());// 资产位置
		request.put("REMARK", pledge.getRemark());					// 备注
		request.put("FILE_NAME", pledge.getFileName());				// 文件名	
		request.put("FILE_PATH", pledge.getFilePath());				// 文件路径	
		serviceHeader.put("REQUEST", request);
		serviceHeader.put("RESPONSE", null);
	}
	
	/**
	 * 对应查询担保和抵押信息报文body
	 */
	private void queryBody(Map<String, Object> serviceHeader, String xj_order_id){
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("XJ_ORDER_ID", xj_order_id);		// 订单id
		serviceHeader.put("REQUEST", request);
		serviceHeader.put("RESPONSE", null);
	}
	
	/**
	 * 报文的Header信息(公用)
	 * @param serviceHeader
	 * @param type
	 */
	private void genHeader(Map<String, Object> serviceHeader, String type) {
		
		serviceHeader.put("SERVICE_ID", type);   
    	serviceHeader.put("ORG","000000000001");   
		serviceHeader.put("CHANNEL_ID","MC");   
		serviceHeader.put("ACQ_ID","00230000");
		serviceHeader.put("SUB_TERMINAL_TYPE","APP");
		serviceHeader.put("SERVICESN","YG20150825112132123464");      
		serviceHeader.put("OP_ID",null);           
		serviceHeader.put("REQUEST_TIME","20151002161241");    
		serviceHeader.put("VERSION_ID","01");      
		serviceHeader.put("MAC",null); 		
		serviceHeader.put("SERV_RESPONSE",null); 
	}
	
}
