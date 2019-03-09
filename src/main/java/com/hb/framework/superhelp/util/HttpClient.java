package com.hb.framework.superhelp.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.json.JSONException;

import com.hb.framework.business.service.UserService;
import com.hb.framework.system.entity.User;

public class HttpClient {
	private int connectionTimeout = 1000 * 60;
	private int waitTimeout = 3000;
	private int maxConnectionsPerHost = 10;
	private int maxTotalConnections = 5;
	private static final String charSet = "UTF-8";
//	private static final String url = "";
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
			// 默认每个Host最多10个连接
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
		org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient(connectionManager);
		String url ="http://10.0.0.234:8888/frontend/CallJsonProcess";//默认一个，不然当配置文件里面没有时报错
		Properties props = PropertiesUtils.getProperties("/jdbc.properties");
		if (null != props) {
			url = props.getProperty("rmpsUrl");
		} 
		System.out.println(url);
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


	public static void main(String[] args) throws IOException, ParseException, JSONException {

		Map<String, Object> serviceDoc = new HashMap<String, Object>();
		Map<String, Object> service = new HashMap<String, Object>();
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		serviceDoc.put("SERVICE", service);
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		genHeader(serviceHeader);
		UserService userService = new UserService();
		User user=userService.findOne(139, null);
		genBody(serviceBody,user);
		String json = JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		new HttpClient().send(json);
		
	}

	public static void genHeader(Map<String, Object> serviceHeader) {
		serviceHeader.put("SERVICE_ID", "RmpsApply");
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void genBody(Map<String, Object> serviceHeader, User user) {
//		public static void genBody(Map<String, Object> serviceHeader, Order order, User user) {
		Map<String, Object> request = new HashMap<String, Object>();
		
//		request.put("PRODUCT_CD", order.getProductCd());// 产品编号
//		request.put("PRODUCT_TYPE", null);// 产品类型
//		request.put("NAME", user.getUserRealname());// 姓名
//		request.put("GENDER", user.getUserSex());// 性别
//		request.put("ID_TYPE", user.getIdType());// 证件类型
//		request.put("ID_NO", user.getIdNo());// 证件号码
//		request.put("CELLPHONE", order.getUserMobile());// 移动电话
//		request.put("BANK_CODE",user.getOpenBankId());// 银行行号
//		request.put("BANK_CARD_NO", user.getCardNo());// 银行卡号
//		request.put("EMAIL", user.getUserMail());// 常用邮箱
//		request.put("XJ_ORDER_ID", order.getHb_orderId());// 订单号
//		request.put("ABODE_STATE", user.getState());// 居住地址（省code）
//		request.put("ABODE_CITY", user.getCity());// 居住地址（市code）
//		request.put("ABODE_ZONE", user.getDistrict());// 居住地址（区/县）
//		request.put("ABODE_DETAIL", user.getUserAddress());// 详细地址
//		request.put("APP_LMT", order.getOriOrderAmt());// 申请额度
//		request.put("LOAN_TERM", order.getOriOrderAmt());// 贷款期数
//		request.put("APP_LMT", order.getOriOrderAmt());// 申请额度
//		request.put("IS_GUARANTEE", "N");// 是否担保人
//		
//		List<Map> CONTACT_INFO = new ArrayList();
//		
//	    Map a = new HashMap();
//		a.put("CONTACT_NAME","1111");
//		a.put("CONTACT_GENDER","1111");
//		a.put("CONTACT_RELATION","1111");
//		a.put("CONTACT_MOBILE","1111");
//		a.put("CONTACT_ADDRESS","1111");
//		a.put("IF_SAME_ADDRESS","1111");
//		
//		Map b = new HashMap();
//		b.put("CONTACT_NAME","1111");
//		b.put("CONTACT_GENDER","1111");
//		b.put("CONTACT_RELATION","1111");
//		b.put("CONTACT_MOBILE","1111");
//		b.put("CONTACT_ADDRESS","1111");
//		b.put("IF_SAME_ADDRESS","1111");
//
//		
//		CONTACT_INFO.add(a);
//		CONTACT_INFO.add(b);
//		request.put("CONTACT_INFO",CONTACT_INFO);// 联系人
//		
//		request.put("PRODUCT_NAME", order.getProductName());// 产品名称
//		request.put("MERNAME", order.getMerName());// 商户名称
//		request.put("REPAY_TYPE", "MCIE");// 还款方式
//		request.put("loanRate", order.getInterestRate());// 利率
//		request.put("BANK_RESERVE_PHONE", user.getBankReservePhone());// 银行预留手机号码
//		request.put("PROFESSION", user.getProfession());// 职位类别
//		request.put("COMPANY_TYPE", user.getUnitType());// 单位类别
//		request.put("COMPANY_POST", user.getPost());// 公司职位
//		request.put("COMPANY_PHONE", user.getUnitPhone());// 单位电话
//		request.put("EDUCATION", user.getEducation());// 最高学历
//		request.put("HOME_PHONE", user.getHomePhone());// 住宅电话
//		request.put("COMPANY_NAME", user.getUnitName());// 单位名称
//		request.put("COMPANY_DEPT", user.getDepartment());// 职位部门
//		request.put("WORK_YEAR", user.getWorkYear());// 工作年限
//		request.put("MONTH_WAGES", user.getMonthlywages());// 个人月收入
//		request.put("TOTAL_LOAN", user.getTotalLoan());// 未结清的贷款总额
//		request.put("MONTH_REPAY", user.getMonthRepay());// 月还贷总额
//		request.put("CORPORATION_NATION", user.getCorporationNation());// 民族
//		request.put("CORPORATION_NATIVE", user.getCorporationNative());// 籍貫
//		request.put("CUSTOMER_TYPE", user.getCustomerType());// 客户类型
//		request.put("SCALE", user.getScale());// 企业规模
//		request.put("INDUST_NO", user.getIndustNo());// 组织机构代码证
//		request.put("REGISTER_NO", user.getRegisterNo());// 公司注册登记号
//		request.put("REGISTER_ORG", user.getRegisterOrg());// 工商注册登记机关
//		request.put("REGISTER_DATE", user.getRegisterDate());// 工商注册登记日期
//		request.put("COUNTRY_TAX_NO", user.getCountryTaxNo());// 国税税务登记号
//		request.put("CITY_TAX_NO", user.getCityTaxNo());// 地税税务登记号
//		request.put("PROPERTY_ID", user.getPropertyId());// 企业性质
//		request.put("EMPLOYEES", user.getEmployees());// 从业人数
//		request.put("FOUNDED_DATE", user.getFoundedDate());// 成立日期
//		request.put("REAL_GOVERN", user.getRealGovern());// 实际控制人
//		request.put("BUSINESS_LICENSE", user.getBusinessLicense());// 营业执照号
//		request.put("BUSINESS_DATE", user.getBusinessDate());// 营业执照截止日期
//		request.put("REGISTERED_CAPITAL", user.getRegisteredCapital());// 注册资本
//		request.put("BUSIAREA", user.getBusiarea());// 经营范围
//		request.put("REGIST_ADDRESS", user.getRegistAddress());// 公司注册地址
//		request.put("REAL_ADDRESS", user.getRealAddress());// 公司通讯地址
//		request.put("POST_CODE", user.getPostCode());// 公司邮政编码
//		request.put("LINK_MAN", user.getLinkMan());// 联系人
//		request.put("FAX", user.getFax());// 公司传真
//		request.put("COMPANY_EMAIL", user.getCompanyEmail());// 公司邮箱
//		request.put("WEB_URL", user.getWebUrl());// 网址
//		request.put("FLOOR_SPACE", user.getFloorSpace());// 场地面积
//		request.put("ANNUAL_TURNOVER", user.getAnnualTurnover());// 年营业额
//		request.put("INSTITUTIONAL_RATING", "100");// 机构评级
		
		
		request.put("CHANNEL", "1");
//		request.put("WORKFLOW_FLAG", "application_jkd");// 流程规则标识
		request.put("PRODUCT_CD", "000405");// 产品编号
		request.put("PRODUCT_TYPE", "J");// 产品类型
		request.put("NAME", user.getUserRealname());// 姓名
		request.put("GENDER", user.getUserSex());// 性别
		request.put("ID_TYPE", user.getIdType());// 证件类型
		request.put("ID_NO", user.getIdNo());// 证件号码
		request.put("CELLPHONE", user.getUserPhone());// 移动电话
		request.put("BANK_CODE",user.getOpenBankId());// 银行行号
		request.put("BANK_CARD_NO", user.getCardNo());// 银行卡号
		request.put("EMAIL", user.getUserMail());// 常用邮箱
		request.put("XJ_ORDER_ID", "1911");// 订单号
		request.put("ABODE_STATE", user.getState());// 居住地址（省code）
		request.put("ABODE_CITY", user.getCity());// 居住地址（市code）
		request.put("ABODE_ZONE", user.getDistrict());// 居住地址（区/县）
		request.put("ABODE_DETAIL", user.getUserAddress());// 详细地址
		request.put("APP_LMT", "10000");// 申请额度
		request.put("LOAN_TERM", "3");// 贷款期数
		request.put("IS_GUARANTEE", "N");// 是否担保人
		
		List<Map> CONTACT_INFO = new ArrayList();
		
	    Map a = new HashMap();
		a.put("CONTACT_NAME","1111");
		a.put("CONTACT_GENDER","M");
		a.put("CONTACT_RELATION","1111");
		a.put("CONTACT_MOBILE","1111");
		a.put("CONTACT_ADDRESS","1111");
		a.put("IF_SAME_ADDRESS","1111");
		
		Map b = new HashMap();
		b.put("CONTACT_NAME","1111");
		b.put("CONTACT_GENDER","M");
		b.put("CONTACT_RELATION","1111");
		b.put("CONTACT_MOBILE","1111");
		b.put("CONTACT_ADDRESS","1111");
		b.put("IF_SAME_ADDRESS","1111");

		
		CONTACT_INFO.add(a);
		CONTACT_INFO.add(b);
		request.put("CONTACT_INFO",CONTACT_INFO);// 联系人
		
		request.put("PRODUCT_NAME", "企业贷款流程");// 产品名称
//		request.put("MERNAME", order.getMerName());// 商户名称
		request.put("REPAY_TYPE", "MCEI");// 还款方式
		request.put("LOAN_RATE", "1.2");// 利率
		request.put("BANK_RESERVE_PHONE", user.getBankReservePhone());// 银行预留手机号码
		request.put("PROFESSION", user.getProfession());// 职位类别
		request.put("COMPANY_TYPE", user.getUnitType());// 单位类别
		request.put("COMPANY_POST", user.getPost());// 公司职位
		request.put("COMPANY_PHONE", user.getUnitPhone());// 单位电话
		request.put("EDUCATION", user.getEducation());// 最高学历
		request.put("HOME_PHONE", user.getHomePhone());// 住宅电话
		request.put("COMPANY_NAME", user.getUnitName());// 单位名称
		request.put("COMPANY_DEPT", user.getDepartment());// 职位部门
		request.put("WORK_YEAR", user.getWorkYear());// 工作年限
		request.put("MONTH_WAGES", user.getMonthlywages());// 个人月收入
		request.put("TOTAL_LOAN", user.getTotalLoan());// 未结清的贷款总额
		request.put("MONTH_REPAY", user.getMonthRepay());// 月还贷总额
		request.put("CORPORATION_NATION", user.getCorporationNation());// 民族
		request.put("CORPORATION_NATIVE", user.getCorporationNative());// 籍貫
		request.put("CUSTOMER_TYPE", user.getCustomerType());// 客户类型
		request.put("SCALE", user.getScale());// 企业规模
		request.put("INDUST_NO", user.getIndustNo());// 组织机构代码证
		request.put("REGISTER_NO", user.getRegisterNo());// 公司注册登记号
		request.put("REGISTER_ORG", user.getRegisterOrg());// 工商注册登记机关
		request.put("REGISTER_DATE", user.getRegisterDate());// 工商注册登记日期
		request.put("COUNTRY_TAX_NO", user.getCountryTaxNo());// 国税税务登记号
		request.put("CITY_TAX_NO", user.getCityTaxNo());// 地税税务登记号
		request.put("PROPERTY_ID", user.getPropertyId());// 企业性质
		request.put("EMPLOYEES", user.getEmployees());// 从业人数
		request.put("FOUNDED_DATE", user.getFoundedDate());// 成立日期
		request.put("REAL_GOVERN", user.getRealGovern());// 实际控制人
		request.put("BUSINESS_LICENSE", user.getBusinessLicense());// 营业执照号
		request.put("BUSINESS_DATE", user.getBusinessDate());// 营业执照截止日期
		request.put("REGISTERED_CAPITAL", user.getRegisteredCapital());// 注册资本
		request.put("BUSIAREA", user.getBusiarea());// 经营范围
		request.put("REGIST_ADDRESS", user.getRegistAddress());// 公司注册地址
		request.put("REAL_ADDRESS", user.getRealAddress());// 公司通讯地址
		request.put("POST_CODE", user.getPostCode());// 公司邮政编码
		request.put("LINK_MAN", user.getLinkMan());// 联系人
		request.put("FAX", user.getFax());// 公司传真
		request.put("COMPANY_EMAIL", user.getCompanyEmail());// 公司邮箱
		request.put("WEB_URL", user.getWebUrl());// 网址
		request.put("FLOOR_SPACE", user.getFloorSpace());// 场地面积
		request.put("ANNUAL_TURNOVER", user.getAnnualTurnover());// 年营业额
		request.put("INSTITUTIONAL_RATING", "100");// 机构评级
		
		serviceHeader.put("REQUEST", request);
		serviceHeader.put("RESPONSE", null);
	}

	
		
}
