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

import com.hb.framework.business.entity.AttachmentType;
import com.hb.framework.business.entity.CustomerInfo;
import com.hb.framework.business.entity.Linkman;
import com.hb.framework.business.entity.Merchant;
import com.hb.framework.business.entity.Order;
import com.hb.framework.business.entity.UploadFileInfo;
import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.superhelp.util.HttpClientUtils;
import com.hb.framework.system.entity.User;

@Service
public class OrderService {


	private static final String NULL = null;

	/**创建订单
	 * @param order
	 * @return
	 */
	public String  makeOrder(Order order, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		// 自动生成的订单编号(OrderContrlloer)、产品名称、产品代码、首付金额、贷款金额不能为空
		if (StringUtils.isBlank(order.getHb_orderId().toString()) ||
			StringUtils.isBlank(order.getProductName()) ||
			StringUtils.isBlank(order.getProductCd()) || 
			StringUtils.isBlank(order.getOriOrderAmt())) {
			return "必输项不能为空";
		}
		
		//已有登录会话，获取信息，创建订单信息
		User users = (User) request.getSession().getAttribute("userSession");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("1111112222");
		String sql = " INSERT INTO hb_order(hb_orderId, userId, orderStatu, productCd, productName, "
				   + " userMobile, createTime, lastModifyTime, repayType, jpaVersion, coreEntId, coreEntName, "
				   + " merId, merName, merBusSn, merTaxationSn, merAddress, merRegCapital, "
				   + " merOpenBank, merCardNo, merUserName, merLegal, merLegalSn, merLegalTel, "
				   + " merTel, merContactName, merZip, prdSubCd, prdSubDsc, oriOrderAmt, term, "
				   + " interestRate, procDefKey, isNeedGuarantee, isNeedMortgaged, productObj) "
				   + " VALUES('"+order.getHb_orderId()+"','"+users.getUserId()+"',"
				   + " 'N','"+order.getProductCd()+"','"+order.getProductName()+"',"
				   + " '"+order.getUserMobile()+"','"+sdf.format(new Date())+"',"
				   + " '"+sdf.format(new Date())+"','"+order.getRepayType()+"','1','"+order.getCoreEntId()+"',"
				   + " '"+order.getCoreEntName()+"','"+order.getMerId()+"',"
				   + " '"+order.getMerName()+"','"+order.getMerBusSn()+"','"+order.getMerTaxationSn()+"',"
				   + " '"+order.getMerAddress()+"','"+order.getMerRegCapital()+"',"
				   + " '"+order.getMerOpenBank()+"', '"+order.getMerCardNo()+"',"
				   + " '"+order.getMerUserName()+"', '"+order.getMerLegal()+"',"
				   + " '"+order.getMerLegalSn()+"', '"+order.getMerLegalTel()+"',"
				   + " '"+order.getMerTel()+"', '"+order.getMerContactName()+"',"
				   + " '"+order.getMerZip()+"', '"+order.getPrdSubCd()+"', '"+order.getPrdSubDsc()+"',"
				   + " '"+order.getOriOrderAmt()+"', '"+order.getTerm()+"', '"+order.getInterestRate()+"',"
				   + " '"+order.getProcDefKey()+"', '"+order.getIsNeedGuarantee()+"',"
				   + " '"+order.getIsNeedMortgaged()+"', '"+order.getProductObj()+"') ";
		DBConnectionUtils.executeInsert(sql);
		return "S";
	}
	
	/**查询订单
	 * @param phone
	 * @return
	 */
	public List<Order> queryOrder(int userId,String orderId,int currpage) {
		//Map<String,Object> orderMap = new HashMap<String,Object>();
		int firstrow =(currpage-1)*8;
        int lastrow=8;  
		/*Map<String, Object> request = new HashMap<String, Object>();
		Map<String, Object> msg = new HashMap<String, Object>();*/
       /* Order order=new Order();
        int orderId=order.getOrderId();*/
         String sql2 = "SELECT * from hb_order"
				+" where userId='"+Integer.toString(userId)+"'";
         if(orderId!=null&&!orderId.equals("")){
        	 sql2 += " and orderId='"+orderId+"'";
         }else{
        	 sql2+="  limit "+firstrow+","+lastrow;
         }
		ResultSet resultset=DBConnectionUtils.executeQuery(sql2);
		List<Order> list = new ArrayList<Order>();
		try {
			while(resultset.next()){
				Order order=new Order();
				order.setOrderId(resultset.getInt("orderId"));
				order.setMerContactName(resultset.getString("merContactName"));
				order.setUserMobile(resultset.getString("userMobile"));
				order.setTerm(Integer.parseInt(resultset.getString("term")));
				order.setOriOrderAmt(resultset.getString("oriOrderAmt"));
				order.setOrderStatu(resultset.getString("orderStatu"));
				order.setProductCd(resultset.getString("productCd"));
				order.setProductName(resultset.getString("productName"));
				order.setCoreEntId(resultset.getString("coreEntId"));
				order.setCoreEntName(resultset.getString("coreEntName"));
				order.setInterestRate(resultset.getString("interestRate"));
				order.setMerId(resultset.getString("merId"));
				order.setRejectReason(resultset.getString("refuseCode"));
				list.add(order);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	/**
	 * 查询订单记录总数
	 * @param userId
	 * @return
	 */
	public Integer getOrderTotalCount(int userId,String orderId){
		String sql2 = "SELECT * from hb_order where userId="+Integer.toString(userId);		
		 if(orderId!=null&&!orderId.equals("")){
        	 sql2 += " and orderId='"+orderId+"'";
         }
         System.out.println(sql2);
		ResultSet rs=DBConnectionUtils.executeQuery(sql2);
		int count = 0;
		if(rs!=null){
			try {
				while(rs.next()){
					count ++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	private void getCancelBody(Map<String, Object> serviceBody, Order order) {
		Map<String, Object> request = new HashMap<String, Object>();
//		request.put("XJ_ORDER_ID", order.getXj_order_id());
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		
	}

	/**创建查询订单报文的body信息
	 * @param serviceBody
	 * @param phone
	 */
	private void getQueryBody(Map<String, Object> serviceBody, int userId,int currpage) {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("CUSTOMERBASIC_ID", userId);
		request.put("FIRSTROW", (currpage-1)*10);
		request.put("LASTROW", currpage*10-1);
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
	}


	
	/**确认订单
	 * @param order
	 * @param request
	 * @return
	 */
	public String confirmOrder(Order order, HttpServletRequest request){
		Map<String, Object>  serviceHeader= genHeader("RmpsApply");
		Map<String, Object>  serviceBody= genConfirmOrderBody(order, request);
		String response = HttpClientUtils.callInterface(serviceHeader, serviceBody);
		return response;
	}
	
	/**
	 * 订单头报文信息
	 * @return
	 */
	public Map<String, Object> genHeader(String type){
		Map<String, Object> serviceHeader = new HashMap<String, Object>();
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
		return serviceHeader;
	}
	
	/**
	 * 确认订单body报文信息
	 * @param order
	 * @param map
	 * @return
	 */
	public Map<String, Object> genConfirmOrderBody(Order order, HttpServletRequest map) {
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>();
		User users = (User) map.getSession().getAttribute("userSession");
		UserService userService = new UserService();
		User user = userService.findOne(users.getUserId(), null);
		
		request.put("CHANNEL", "1");
		request.put("XJ_ORDER_ID", order.getOrderId());// 订单号
		request.put("MERNAME", order.getCoreEntId());// 核心企业名称
		request.put("PRODUCT_CD", order.getProductCd());// 产品编号
		request.put("PRODUCT_NAME", order.getProductName());// 产品名称
		request.put("APP_LMT", order.getOriOrderAmt());// 申请额度
		request.put("LOAN_TERM", order.getTerm());// 贷款期数
		request.put("LOAN_RATE", order.getInterestRate());// 利率
		
		request.put("NAME", user.getUserRealname());// 姓名
		request.put("GENDER", user.getUserSex());// 性别
		request.put("ID_TYPE", user.getIdType());// 证件类型
		request.put("ID_NO", user.getIdNo());// 证件号码
		request.put("CELLPHONE", user.getUserPhone());// 移动电话
		request.put("BANK_CODE",user.getOpenBankId());// 银行行号
		request.put("BANK_CARD_NO", user.getCardNo());// 银行卡号
		request.put("EMAIL", user.getUserMail());// 常用邮箱
		request.put("ABODE_STATE", user.getState());// 居住地址（省code）
		request.put("ABODE_CITY", user.getCity());// 居住地址（市code）
		request.put("ABODE_ZONE", user.getDistrict());// 居住地址（区/县）
		request.put("ABODE_DETAIL", user.getUserAddress());// 详细地址
		request.put("IS_GUARANTEE", "N");// 是否担保人
		
		List<Map> CONTACT_INFO = new ArrayList();
		LinkmanService linkmanService = new LinkmanService();
		List<Linkman> lst = new ArrayList<Linkman>();
		lst = linkmanService.getContentBycustId(user.getUserId());
		for (Linkman linkman : lst) {
			Map item = new HashMap();
			item.put("CONTACT_NAME",linkman.getName());
			item.put("CONTACT_GENDER",linkman.getGender());
			item.put("CONTACT_RELATION",linkman.getRelationship());
			item.put("CONTACT_MOBILE",linkman.getMobileNo());
			item.put("CONTACT_ADDRESS",linkman.getCorpName());
			item.put("IF_SAME_ADDRESS","1111");
			CONTACT_INFO.add(item);
		}
		request.put("CONTACT_INFO",CONTACT_INFO);// 联系人
		
		request.put("REPAY_TYPE", "MCIE");// 还款方式
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
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		
		String sql = "UPDATE hb_order SET orderStatu='S' WHERE orderId="+order.getOrderId();
		DBConnectionUtils.executeUpdate(sql);
		return serviceBody;
	}

	/**个人信息授权
	 * @param order
	 * @param request
	 * @return
	 */
	public String codeOrder(String code,String mobile,String id){
		Map<String, Object>  serviceHeader= genHeader("XJFetChCodeForApplyForm");
		Map<String, Object>  serviceBody= codeOrderBody(code,mobile,id);
		String response = HttpClientUtils.callInterface(serviceHeader, serviceBody);
		return response;
	}

	public static Map<String, Object> codeOrderBody(String code,String mobile,String id) {
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("ID", id);
		request.put("SERVER_ENC_TYPE", code);
		request.put(" MOBILE_NO ", mobile);
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		return serviceBody;
	}
	
	/**验证挑战码
	 * @param order
	 * @param request
	 * @return
	 */
	public String signOrder(String code,String mobile,String id){
		Map<String, Object>  serviceHeader= genHeader("XJCertAndSignApplyForm");
		Map<String, Object>  serviceBody= signOrderBody(code,mobile,id);
		String response = HttpClientUtils.callInterface(serviceHeader, serviceBody);
		return response;
	}
	
	public static Map<String, Object> signOrderBody(String code,String mobile,String id) {
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("ID", id);
		request.put("TRANSID", "666666");
		request.put("CHANLLENGE_CODE", "616666");
		request.put("SERVER_ENC_TYPE", code);
		request.put(" MOBILE_NO ", mobile);
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		return serviceBody;
	}
	
	/**放款
	 * @param order
	 * @param request
	 * @return
	 */
	public String acctSetup(Order order,String card,HttpServletRequest request){
		Map<String, Object>  serviceHeader= genHeader("XJLoanAcctSetupHandler");
		Map<String, Object>  serviceBody= acctSetupBody(order,card);
		String response = HttpClientUtils.callInterface(serviceHeader, serviceBody);
		return response;
	}

	public static Map<String, Object> acctSetupBody(Order order,String card) {
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>();
//		request.put("MERCHANT_Id", order.getMechan_id());
//		request.put("XJ_ORDER_ID", order.getXj_order_id());
//		request.put("XJ_CUST_ID", order.getCustomerbasic_id());
//		request.put("NAME", order.getName());
//
//		request.put("IDNO", card);
//		request.put("MOBILE_NO", order.getMobile_no());
//		request.put("LOAN_CODE", order.getLoan_code());
//		request.put("LOAN_AMT", order.getLoan_amount());
		request.put("LOAN_TERM", order.getTerm());
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		return serviceBody;
	}
	
	/**影像资料附件上传
	 * @param order
	 * @param request
	 * @return
	 */
	public String uploadFileImg(UploadFileInfo info){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = " INSERT INTO hb_attachment(ATTACHMENT_TYPE, ATTACHMENT_FK_ID, FILE_NAME, FILE_PATH, "
				   + " ADD_DATE, FILE_TITIE) "
				   + " VALUES('"+info.getType()+"','"+info.getOrder_id()+"',"
				   + " '"+info.getUpload_file_name()+"','"+info.getUpload_file_dir()+"',"
				   + " '"+sdf.format(info.getUpload_time())+"','"+info.getTitle()+"') ";
		DBConnectionUtils.executeInsert(sql);
		Map<String, Object>  serviceHeader= genHeader("UploadFile");
		Map<String, Object>  serviceBody= uploadFileBody(info);
		String response = HttpClientUtils.callInterface(serviceHeader, serviceBody);
		return response;
	}
	/**附件上传
	 * @param order
	 * @param request
	 * @return
	 */
	public String uploadFile(UploadFileInfo info){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = " INSERT INTO hb_attachment(ATTACHMENT_TYPE, ATTACHMENT_FK_ID, FILE_NAME, FILE_PATH, "
				   + " ADD_DATE, FILE_TITIE) "
				   + " VALUES('"+info.getType()+"','"+info.getCustomer_id()+"',"
				   + " '"+info.getUpload_file_name()+"','"+info.getUpload_file_dir()+"',"
				   + " '"+sdf.format(info.getUpload_time())+"','"+info.getTitle()+"') ";
		DBConnectionUtils.executeInsert(sql);
		return "S";
	}

	public static Map<String, Object> uploadFileBody(UploadFileInfo info) {
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("ORDER_ID",info.getOrder_id());
		request.put("CUSTOMER_ID", "");
		if(info.getCustomer_id() != 0){
			request.put("CUSTOMER_ID", info.getCustomer_id());
		}
		
		request.put("UPLOAD_FILE",info.getUpload_file());
		request.put("UPLOAD_FILE_NAME",info.getUpload_file_name());
		request.put("TITLE", info.getTitle());
		request.put("TYPE", "uploadimg");//上传附件
		request.put("PLEDGE_ID", info.getPledge_id());// 抵质押ID
		
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getUpload_time());
		request.put("UPLOAD_TIME", time);
		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		return serviceBody;
	}
	
	/**撤销订单 
	 * @param order
	 * @return
	 */
	public String cancelOrder(Order order) {
		//Map<String, Object> serviceDoc = new HashMap<String, Object>();
		// Map<String, Object> msg = new HashMap<String, Object>();
		// Map<String, Object> serviceHeader = new HashMap<String, Object>();
		//Map<String, Object> serviceBody = new HashMap<String, Object>();
		//getHeader(serviceHeader); 数据
		 //serviceHeader.put("SERVICE_ID", "XJOrderInfoUndo");
		/*getCancelBody(serviceBody,order);  //方法
		service.put("SERVICE_HEADER", serviceHeader);
		service.put("SERVICE_BODY", serviceBody);
		serviceDoc.put("SERVICE", service);
		String json=JsonSerializeUtil.jsonSerializerNoType(serviceDoc);
		String result = new HttpClient().send(json);
		return result;*/
		/*User users = new User();
		String userPhone = users.getUserPhone();
		int userId=users.getUserId();*/
	    /*order=new Order();
		String orderStatu=order.getOrderStatu();
		int orderId=order.getOrderId();
		//1.必输项不能为空   2.查询的状态是否已撤销  3.orderId和所查信息是否存在
		String sql = "SELECT userMoblie,productName,loanCode,prdSubCd,downPayment,merchantId,productCd,term,prdSubDsc,orderAmt from hb_order"
				+"where orderId='"+Integer.toHexString(orderId)+"'";
		ResultSet queryrs=DBConnectionUtils.executeQuery(sql);
		//msg.put("REQUEST", request);
		msg.put("RESPONSE", null);
		msg.put("ResultSet", queryrs);
		if (Common.isEmpty(Integer.toHexString(orderId))) {
			// request.setAttribute("error","用户名或密码不能为空！");
			System.out.println("必输项不能为空！");
		}if(orderStatu=="U"){
			System.out.println("该订单已撤销!");
		}else{try {
			if (queryrs.next()) {                          
				int count = queryrs.getInt(1); 
				if (count<1) {
					System.out.println("不存在该订单信息！");
				} else {
					 //getCancelBody(msg,order);  //撤销方法
				     //????撤销改哪个字段
					String sql2="update hb_order set orderStatu='U' where orderId='"+Integer.toHexString(orderId)+"'";//订单已撤销
					DBConnectionUtils.executeUpdate(sql2);
					String sql3="update hb_guarantee set guaranteeStatus='E' WHERE orderId='"+Integer.toHexString(orderId)+"'";//担保已作废
					DBConnectionUtils.executeUpdate(sql3);
					return "/background/system/order/orderlist";   
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}*/	
		//撤销订单返回，作废担保？？？？、 
		
		String sql="update hb_order set orderStatu='U' where orderId='"+Integer.toString(order.getOrderId())+"'";
		String result= DBConnectionUtils.executeUpdate(sql);
		System.out.println(order.getOrderId()+"1111"+sql);
		return  result;
	}
	
	/**查询附件
	 * @param order
	 * @param request
	 * @return
	 */
//	public String listFile(UploadFileInfo info){
//		Map<String, Object>  serviceHeader= genHeader("XJUploadFile");
//		Map<String, Object>  serviceBody= listFileBody(info);
//		String response = HttpClientUtils.callInterface(serviceHeader, serviceBody);
//		return response;
//	}
	
	/**查询附件
	 * @param order
	 * @param request
	 * @return
	 */
	public List<UploadFileInfo> listFile(String userId,String type){
		String sql = "SELECT * from hb_attachment"
				+" where ATTACHMENT_FK_ID='"+userId+"' and ATTACHMENT_TYPE = '"+type+"'";				
		ResultSet resultset=DBConnectionUtils.executeQuery(sql);
		List<UploadFileInfo> response = new ArrayList<>();
		try {
			while(resultset.next()){
				UploadFileInfo file=new UploadFileInfo();
				file.setUpload_file(resultset.getString("ATTACHMENT_ID"));
				file.setTitle(resultset.getString("FILE_TITIE"));
				file.setUpload_time(resultset.getDate("ADD_DATE"));
				file.setUpload_file_dir(resultset.getString("FILE_PATH"));
				file.setUpload_file_name(resultset.getString("FILE_NAME"));
				response.add(file);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public static Map<String, Object> listFileBody(UploadFileInfo info) {
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("CUSTOMER_ID",info.getCustomer_id() );
		request.put("TYPE", "list");//查询附件

		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		return serviceBody;
	}
	
	/**下载附件
	 * @param order
	 * @param request
	 * @return
	 */
	public String down(int id){
		Map<String, Object>  serviceHeader= genHeader("XJUploadFile");
		Map<String, Object>  serviceBody= downFileBody(id);
		String response = HttpClientUtils.callInterface(serviceHeader, serviceBody);
		return response;
	}
	
	public static Map<String, Object> downFileBody(int id) {
		Map<String, Object> serviceBody = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("ID",id );
		request.put("TYPE", "down");//查询附件

		serviceBody.put("REQUEST", request);
		serviceBody.put("RESPONSE", null);
		return serviceBody;
	}


}
