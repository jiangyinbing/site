package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hb.framework.business.dao.GuarantorDao;
import com.hb.framework.business.entity.Guarantor;
import com.hb.framework.business.entity.Pledge;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.superhelp.util.HttpClient;
import com.hb.framework.superhelp.util.JsonSerializeUtil;
import com.hb.framework.system.entity.User;

/**
 * 担保人业务类
 * @author lym
 *
 */
@Transactional
@Service("guarantorService")
public class GuarantorService {
	
	@Autowired
	private GuarantorDao guarantorDao;
	
	/**
	 * 查询担保
	 * @param xj_order_id	订单id
	 * @return
	 * @throws JSONException 
	 */
//	public Map<String, Object> getGuarantorList(String xj_order_id) throws JSONException{
//		// TODO Auto-generated method stub
//		Map<String, Object> serviceDoc = new HashMap<String, Object>();
//		Map<String, Object> service = new HashMap<String, Object>();
//		Map<String, Object> serviceHeader = new HashMap<String, Object>();
//		Map<String, Object> serviceBody = new HashMap<String, Object>();
//		Map<String, Object> maps = new HashMap<String, Object>();
//		serviceDoc.put("SERVICE", service);
//		service.put("SERVICE_HEADER", serviceHeader);
//		service.put("SERVICE_BODY", serviceBody);
//		
//		genHeader(serviceHeader, "XJQueryGuarantorAndPledge");
//		queryBody(serviceBody, xj_order_id);
//		
//		String json=JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
//		String return_str = new HttpClient().send(json);
//		
//		JSONObject dataJson=new JSONObject(return_str);
//		JSONObject service2=dataJson.getJSONObject("SERVICE");
//		JSONObject ser_body=service2.getJSONObject("SERVICE_BODY");
//		JSONObject response = ser_body.getJSONObject("RESPONSE");
//		
//		JSONArray array = (JSONArray) response.get("GUARANTEE_LIST");
//		//JSONArray array2 =  (JSONArray) response.get("PLEDGE_LIST");
//		List<Guarantor> glst = new ArrayList<Guarantor>();
////		List<Pledge> plst = new ArrayList<Pledge>();
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
////		for (int i = 0; i < array2.length(); i++) {
////			Pledge p = new Pledge();
////			JSONObject jo = array2.getJSONObject(i);
////			p.setArea_amount(jo.get("AREA_AMOUNT").toString());	// 数量
////			p.setGood_type(jo.get("GOOD_TYPE").toString());		// 物品类型"H|房子","C|车子","O|其他"
////			p.setOwner_name(jo.get("OWNER_NAME").toString());	// 产权人
////			p.setPledge_name(jo.get("PLEDGE_NAME").toString());	// 抵质押物名称
////			p.setXj_order_id(xj_order_id);						// 订单id
////			p.setCert_no(jo.get("PLEDGE_ID").toString());		// 产权证号
////			p.setPledge_flag(jo.get("TYPE").toString());		// 抵质押类型"P|质押","M|抵押"
////			plst.add(p);
////		}
////		maps.put("plst", plst);
//		return maps;
//	}
	/**
	 * 查询担保
	 * @param xj_order_id	订单id
	 * @return
	 * @throws JSONException 
	 */
	public Map<String, Object> getGuarantorList(String order_id) throws JSONException{
		Map<String, Object> maps = new HashMap<String, Object>();
//		String sql = "SELECT * from hb_guarantee"
//				+" where orderId='"+order_id+"'";
//		ResultSet resultset=DBConnectionUtils.executeQuery(sql);
//		List<Guarantor> gs = new ArrayList<>();
//		try {
//			if(resultset.next()){
//				Guarantor g = new Guarantor();
//				g.setIdNo(resultset.getString("idNo"));				// 身份证号
//				g.setMobileNumber(resultset.getString("mobileNumber"));		// 手机号码
//				g.setGuarantName(resultset.getString("guarantName"));				// 姓名
//				g.setRelationship(resultset.getString("relationship"));//关系
//				g.setXj_order_id(order_id);						// 订单id
//				g.setGuaranteeStatus(resultset.getString("guaranteeStatus"));		// 担保状态
//				gs.add(g);
//			}
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		List<Guarantor> gs = guarantorDao.queryByOrderId(order_id);
		
		maps.put("glst", gs);
		return maps;
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
	 * 添加担保人
	 * @param xj_order_id	订单id
	 * @param guarantor		担保人对象
	 * @return
	 */
//	public String addGuarantor(String xj_order_id, Guarantor guarantor){
//		// TODO Auto-generated method stub
//		Map<String, Object> serviceDoc = new HashMap<String, Object>();
//		Map<String, Object> service = new HashMap<String, Object>();
//		Map<String, Object> serviceHeader = new HashMap<String, Object>();
//		Map<String, Object> serviceBody = new HashMap<String, Object>();
//		serviceDoc.put("SERVICE", service);
//		service.put("SERVICE_HEADER", serviceHeader);
//		service.put("SERVICE_BODY", serviceBody);
//		
//		guarantor.setXj_order_id(xj_order_id);
//		genHeader(serviceHeader, "XJAddGuarantor");
//		addBody(serviceBody, guarantor);
//		
//		String json = JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
//		String return_str = new HttpClient().send(json);
//		
//		return return_str;
//	}
	/**
	 * 添加担保人
	 * @param xj_order_id	订单id
	 * @param guarantor		担保人对象
	 * @return
	 */
	public String addGuarantor(String order_id, Guarantor guarantor){
		// TODO Auto-generated method stub
		String return_str = "success";
		String sql = "SELECT * from sys_user"
				+" where userPhone='"+guarantor.getMobileNumber()+"'";
		ResultSet resultset=DBConnectionUtils.executeQuery(sql);
		System.out.println(sql);
		User users = new User();
		try {
			if(resultset.next()){
				users.setUserId(Integer.parseInt(resultset.getString("userid")));
				users.setUserRealname(resultset.getString("userRealname"));
				users.setUnitPhone(resultset.getString("userPhone"));
				users.setIdType(resultset.getString("idType"));
				users.setIdNo(resultset.getString("idNo"));
				System.out.println(resultset.getString("idNo"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		guarantor.setOrderId(Integer.parseInt(order_id));
		guarantor.setUserId(users.getUserId());
		guarantor.setIdType("I");
		//判断用户是否注册
		if(users.getIdNo()!=null && users.getIdNo()!=""){
			//判断输入信息是否正确
			if(users.getIdNo().equals(guarantor.getIdNo())){
				if(!users.getUserRealname().equals(guarantor.getGuarantName())){
					return_str = "担保人姓名不匹配！";
				}else{
//					String sql2 = " INSERT INTO hb_guarantee(userId, orderId, relationship, guarantName, "
//							   + " idNo, idType, mobileNumber, guaranteeStatus) "
//							   + " VALUES('"+users.getUserId()+"','"+order_id+"',"
//							   + " '"+guarantor.getRelationship()+"','"+guarantor.getGuarantName()+"',"
//							   + " '"+guarantor.getIdNo()+"', 'I' ,'"+guarantor.getMobileNumber()+"','A' ) ";
//					DBConnectionUtils.executeInsert(sql2);
					//判断是否重复输入同一担保人
					List<Guarantor> gs = guarantorDao.queryByOrderId(order_id);
					for(Guarantor g:gs){
						if(g.getMobileNumber().equals(guarantor.getMobileNumber())){
							return_str = "不能重复添加担保人！";
						}
					}
					if(return_str != "不能重复添加担保人！"){
						guarantor.setGuaranteeStatus("A");
						guarantorDao.add(guarantor);
					}
				}
			}else{
				return_str = "身份证不匹配！";
			}
			
		}else{
			return_str = "手机号码未注册！";
		}
		
		
		return return_str;
	}
	
	/**
	 * 确认担保人
	 * @param xj_order_id	订单id
	 * @param guarantor		担保人对象
	 * @return
	 */
	public String comfortGuarantor(String order_id){
		List<Guarantor> gs = guarantorDao.queryByOrderId(order_id);
		String back = "";
		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		serviceDoc.put("SERVICE", service);
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		
		genHeader(serviceHeader, "RmpsAddGuarantor");
		addRmpsBody(serviceBody, gs, order_id);
		
		String json = JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		String return_str = new HttpClient().send(json);
		JSONObject dataJson;
		try {
			dataJson = new JSONObject(return_str);
			JSONObject service2=dataJson.getJSONObject("SERVICE");
			JSONObject ser_body=service2.getJSONObject("SERVICE_HEADER");
			JSONObject response = ser_body.getJSONObject("SERV_RESPONSE");
			back = response.get("STATUS").toString();
			System.out.println(back);
			if(back.equals("S")){
				for(Guarantor g:gs){
					g.setGuaranteeStatus("G");
					guarantorDao.modify(g);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return back;
		
		
	}
	
	public static void main(String[] args){
//		GuarantorService gs = new GuarantorService();
//		Guarantor guarantor = new Guarantor("蔡超林","530324198910011718","13800000006","W");
//		gs.addGuarantor("1114", guarantor);
	}
	
	/**
	 * 对应添加担保人报文body
	 */
	private void addBody(Map<String, Object> serviceHeader, Guarantor guarantor){
//		Map<String, Object> request = new HashMap<String, Object>();
//		request.put("NAME", guarantor.getName());
//		request.put("ID_NO", guarantor.getId_no());
//		request.put("MOBILE_NO", guarantor.getMobile_no());
//		request.put("XJ_ORDER_ID", guarantor.getXj_order_id());
//		request.put("RELATIONSHIP", guarantor.getRelationship());
//		serviceHeader.put("REQUEST", request);
//		serviceHeader.put("RESPONSE", null);
	 }
	private void addRmpsBody(Map<String, Object> serviceHeader, List<Guarantor> guarantor,String orderId){
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("ORDER_ID", orderId);
		List<Map<String, Object>> list = new ArrayList<>();
		for(Guarantor g:guarantor){
			Map<String, Object> req = new HashMap<String, Object>();
			req.put("CUSTOMER_BASIC_ID", g.getGuaranteeId());
			req.put("GUARANT_NAME", g.getGuarantName());
			req.put("ID_NO", g.getIdNo());
			req.put("ID_TYPE", g.getIdType());
			req.put("MOBILE_NUMBER", g.getMobileNumber());
			req.put("GUARANTEE_STATUS", g.getGuaranteeStatus());
			req.put("RELATIONSHIP", g.getRelationship());
			list.add(req);
		}
		request.put("GUARANTEE_INFO", list);
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
	
	/**
	 * 删除担保人
	 * @param guaranteeId 担保信息id
	 * @return
	 */
	public String deleteGuarantor(String guaranteeId){
		
		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		serviceDoc.put("SERVICE", service);
		
		// 报文SERVICE_HEADER部分
		genHeader(serviceHeader, "XJDeleteGuarantor");
		service.put("SERVICE_HEADER", serviceHeader);
		// 报文SERVICE_BODY部分
		addBodyByDeleteGuarantor(serviceBody, guaranteeId);
		service.put("SERVICE_BODY", serviceBody);
		
		// 请求删除
		String json = JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		String return_str = new HttpClient().send(json);
		
		return return_str;
	}
	
	/**
	 * 对应删除担保人报文body
	 */
	private void addBodyByDeleteGuarantor(Map<String, Object> serviceHeader, String guaranteeId){
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("GUARANTEE_ID", guaranteeId);
		serviceHeader.put("REQUEST", request);
		serviceHeader.put("RESPONSE", null);
	 }
	
}
