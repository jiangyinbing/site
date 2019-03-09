package com.hb.framework.business.entity;

import java.math.BigDecimal;
import java.util.Date;
/**个人/企业信息查询
 * @author lx
 * 
 */

public class CustomerInfo {
	
	/**
	 * 会员编号
	 */
	private int CUSTOMER_BASIC_ID;
	/**
	 * 姓名
	 */
	private String NAME;
	/**
	 * 性别
	 */
	private String GENDER;
	/**
	 * 证件类型
	 */
	private String ID_TYPE;
	/**
	 * 证件号
	 */
	private String ID_NO;
	/**
	 * 开户行号
	 */
	private String OPEN_BANK_ID;
	/**
	 * 卡号
	 */
	private String CARD_NO;
	/**
	 * 预留手机号
	 */
	private String BANK_RESERVE_PHONE;
	/**
	 * 合同号
	 */
	private String CONTR_NBR;
	/**
	 * 邮箱
	 */
	private String EMAIL;
	/**
	 * 省份
	 */
	private String STATE;

	/**
	 * 城市
	 */
	private String CITY;
	/**
	 * 区县
	 */
	private String DISTRICT;
	/**
	 * 地址
	 */
	private String ADDRESS;

	/**
	 * 手机号码
	 */
	private String MOBILE_NO;
	
	/**
	 * 职业
	 */
	private String PROFESSION;
	
	/**
	 * 单位类型
	 * "A|机关事业单位",
	 * "B|国有企业",
	 * "C|集体企业",
	 * "D|有限责任公司",
	 * "E|股份有限公司",
	 * "F|私营企业",
	 * "G|外商投资企业（含港、澳、台）",
	 * "H|中外合资经营企业（含港、澳、台）",
	 * "I|中外合作经营企业（含港、澳、台）",
	 * "J|外资企业（含港、澳、台）",
	 * "K|外商投资股份有限公司（含港、澳、台）",
	 * "L|个体经营",
	 * "M|其他"
	 */
	private String UNIT_TYPE;
	
	/**
	 * 单位名称
	 */
	private String UNIT_NAME;
	
	/**
	 * 任职部门
	 */
	private String DEPARTMENT;
	
	/**
	 * 职位
	 */
	private String POST;
	
	/**
	 * 单位电话
	 */
	private String UNIT_PHONE;
	
	/**
	 * 学历
	 * "A|博士及其以上",
	 * "B|硕士",
	 * "C|大学本科",
	 * "D|大学专科/专科学校",
	 * "E|高中/中专/技校",
	 * "F|初中",
	 * "G|初中以下"
	 */
	private String EDUCATION;
	
	/**
	 * 住宅电话
	 */
	private String HOME_PHONE;
	
	private Date ID_VALIDITY;
	
	/**
	 * 工作年限
	 */
	private Integer WORK_YEAR;
	
	/**
	 * 月收入
	 */
	private BigDecimal MONTH_AMT;
	/**
	 * 未结清贷款总额
	 */
	private BigDecimal TOTAL_LOAN;
	/**
	 * 月还贷总额
	 */
	private BigDecimal MONTH_REPAY;
	/**
	 * 婚姻状况
	 * "A|已婚",
	 * "B|未婚",
	 * "C|其他"
	 */
	private String MARRAGE_STATUS;
	/**
	 * 法人民族
	 */
	private String CORPORATION_NATION;
	
	/**
	 * 法人籍贯
	 */
	private String CORPORATION_NATIVE;
	
	/**
	 * 客户类型
	 */
	private String CUSTOMER_TYPE;
	
	/**
	 * 企业规模
	 */
	private String SCALE;
	/**
	 * 企业性质
	 */
	private String PROPERTY_ID;
	/**
	 * 从业人数 
	 */
	private String EMPLOYEES;
	/**
	 * 组织机构代码证
	 */
	private String INDUST_NO;
	
	/**
	 * 公司注册登记号
	 */
	private String REGISTER_NO;
	/**
	 * 工商注册登记机关
	 */
	private String REGISTER_ORG;
	
	/**
	 * 工商注册登记日期 
	 */
	private String REGISTER_DATE;
	
	/**
	 * 国税税务登记号
	 */
	private String COUNTRY_TAX_NO;
	
	/**
	 * 地税税务登记号
	 */
	private String CITY_TAX_NO;
	
	/**
	 * 成立日期 
	 */
	private String FOUNDED_DATE;
	
	/**
	 * 实际控制人
	 */
	private String REAL_GOVERN;
	
	/**
	 * 营业执照号
	 */
	private String BUSINESS_LICENSE;
	
	/**
	 * 营业执照截止日期
	 */
	private String BUSINESS_DATE;
	
	/**
	 * 注册资本
	 */
	private Integer REGISTERED_CAPITAL;
	
	/**
	 * 经营范围 
	 */
	private String BUSIAREA;

	/**
	 * 公司注册地址
	 */
	private String REGIST_ADDRESS;
	
	/**
	 * 公司通讯地址
	 */
	private String REAL_ADDRESS;
	
	/**
	 * 公司邮政编码
	 */
	private String POST_CODE;
	
	/**
	 * 联系人
	 */
	private String LINK_MAN;
	
	/**
	 * 公司传真
	 */
	private String FAX;
	
	/**
	 * 公司邮箱
	 */
	private String COMPANY_EMAIL;
	
	/**
	 * 网址
	 */
	private String WEB_URL;
	
	
	private String FLOOR_SPACE;     //场地面积',
	private String ANNUAL_TURNOVER; //年营业额',

	public int getCUSTOMER_BASIC_ID() {
		return CUSTOMER_BASIC_ID;
	}

	public void setCUSTOMER_BASIC_ID(int cUSTOMERBASICID) {
		CUSTOMER_BASIC_ID = cUSTOMERBASICID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getID_TYPE() {
		return ID_TYPE;
	}

	public void setID_TYPE(String iDTYPE) {
		ID_TYPE = iDTYPE;
	}

	public String getID_NO() {
		return ID_NO;
	}

	public void setID_NO(String iDNO) {
		ID_NO = iDNO;
	}

	public String getOPEN_BANK_ID() {
		return OPEN_BANK_ID;
	}

	public void setOPEN_BANK_ID(String oPENBANKID) {
		OPEN_BANK_ID = oPENBANKID;
	}

	public String getCARD_NO() {
		return CARD_NO;
	}

	public void setCARD_NO(String cARDNO) {
		CARD_NO = cARDNO;
	}

	public String getBANK_RESERVE_PHONE() {
		return BANK_RESERVE_PHONE;
	}

	public void setBANK_RESERVE_PHONE(String bANKRESERVEPHONE) {
		BANK_RESERVE_PHONE = bANKRESERVEPHONE;
	}

	public String getCONTR_NBR() {
		return CONTR_NBR;
	}

	public void setCONTR_NBR(String cONTRNBR) {
		CONTR_NBR = cONTRNBR;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getDISTRICT() {
		return DISTRICT;
	}

	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getMOBILE_NO() {
		return MOBILE_NO;
	}

	public void setMOBILE_NO(String mOBILENO) {
		MOBILE_NO = mOBILENO;
	}

	public String getPROFESSION() {
		return PROFESSION;
	}

	public void setPROFESSION(String pROFESSION) {
		PROFESSION = pROFESSION;
	}

	public String getUNIT_TYPE() {
		return UNIT_TYPE;
	}

	public void setUNIT_TYPE(String uNITTYPE) {
		UNIT_TYPE = uNITTYPE;
	}

	public String getUNIT_NAME() {
		return UNIT_NAME;
	}

	public void setUNIT_NAME(String uNITNAME) {
		UNIT_NAME = uNITNAME;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

	public String getPOST() {
		return POST;
	}

	public void setPOST(String pOST) {
		POST = pOST;
	}

	public String getUNIT_PHONE() {
		return UNIT_PHONE;
	}

	public void setUNIT_PHONE(String uNITPHONE) {
		UNIT_PHONE = uNITPHONE;
	}

	public String getEDUCATION() {
		return EDUCATION;
	}

	public void setEDUCATION(String eDUCATION) {
		EDUCATION = eDUCATION;
	}

	public String getHOME_PHONE() {
		return HOME_PHONE;
	}

	public void setHOME_PHONE(String hOMEPHONE) {
		HOME_PHONE = hOMEPHONE;
	}

	public Date getID_VALIDITY() {
		return ID_VALIDITY;
	}

	public void setID_VALIDITY(Date iDVALIDITY) {
		ID_VALIDITY = iDVALIDITY;
	}

	public Integer getWORK_YEAR() {
		return WORK_YEAR;
	}

	public void setWORK_YEAR(Integer wORKYEAR) {
		WORK_YEAR = wORKYEAR;
	}

	public BigDecimal getMONTH_AMT() {
		return MONTH_AMT;
	}

	public void setMONTH_AMT(BigDecimal mONTHAMT) {
		MONTH_AMT = mONTHAMT;
	}

	public BigDecimal getTOTAL_LOAN() {
		return TOTAL_LOAN;
	}

	public void setTOTAL_LOAN(BigDecimal tOTALLOAN) {
		TOTAL_LOAN = tOTALLOAN;
	}

	public BigDecimal getMONTH_REPAY() {
		return MONTH_REPAY;
	}

	public void setMONTH_REPAY(BigDecimal mONTHREPAY) {
		MONTH_REPAY = mONTHREPAY;
	}

	public String getCORPORATION_NATION() {
		return CORPORATION_NATION;
	}

	public void setCORPORATION_NATION(String cORPORATIONNATION) {
		CORPORATION_NATION = cORPORATIONNATION;
	}

	public String getCORPORATION_NATIVE() {
		return CORPORATION_NATIVE;
	}

	public void setCORPORATION_NATIVE(String cORPORATIONNATIVE) {
		CORPORATION_NATIVE = cORPORATIONNATIVE;
	}

	public String getCUSTOMER_TYPE() {
		return CUSTOMER_TYPE;
	}

	public void setCUSTOMER_TYPE(String cUSTOMERTYPE) {
		CUSTOMER_TYPE = cUSTOMERTYPE;
	}

	public String getSCALE() {
		return SCALE;
	}

	public void setSCALE(String sCALE) {
		SCALE = sCALE;
	}

	public String getINDUST_NO() {
		return INDUST_NO;
	}

	public void setINDUST_NO(String iNDUSTNO) {
		INDUST_NO = iNDUSTNO;
	}

	public String getREGISTER_NO() {
		return REGISTER_NO;
	}

	public void setREGISTER_NO(String rEGISTERNO) {
		REGISTER_NO = rEGISTERNO;
	}

	public String getREGISTER_ORG() {
		return REGISTER_ORG;
	}

	public void setREGISTER_ORG(String rEGISTERORG) {
		REGISTER_ORG = rEGISTERORG;
	}

	public String getREGISTER_DATE() {
		return REGISTER_DATE;
	}

	public void setREGISTER_DATE(String rEGISTERDATE) {
		REGISTER_DATE = rEGISTERDATE;
	}

	public String getCOUNTRY_TAX_NO() {
		return COUNTRY_TAX_NO;
	}

	public void setCOUNTRY_TAX_NO(String cOUNTRYTAXNO) {
		COUNTRY_TAX_NO = cOUNTRYTAXNO;
	}

	public String getCITY_TAX_NO() {
		return CITY_TAX_NO;
	}

	public void setCITY_TAX_NO(String cITYTAXNO) {
		CITY_TAX_NO = cITYTAXNO;
	}

	public String getPROPERTY_ID() {
		return PROPERTY_ID;
	}

	public void setPROPERTY_ID(String pROPERTYID) {
		PROPERTY_ID = pROPERTYID;
	}

	public String getEMPLOYEES() {
		return EMPLOYEES;
	}

	public void setEMPLOYEES(String eMPLOYEES) {
		EMPLOYEES = eMPLOYEES;
	}

	public String getFOUNDED_DATE() {
		return FOUNDED_DATE;
	}

	public void setFOUNDED_DATE(String fOUNDEDDATE) {
		FOUNDED_DATE = fOUNDEDDATE;
	}

	public String getREAL_GOVERN() {
		return REAL_GOVERN;
	}

	public void setREAL_GOVERN(String rEALGOVERN) {
		REAL_GOVERN = rEALGOVERN;
	}

	public String getBUSINESS_LICENSE() {
		return BUSINESS_LICENSE;
	}

	public void setBUSINESS_LICENSE(String bUSINESSLICENSE) {
		BUSINESS_LICENSE = bUSINESSLICENSE;
	}

	public String getBUSINESS_DATE() {
		return BUSINESS_DATE;
	}

	public void setBUSINESS_DATE(String bUSINESSDATE) {
		BUSINESS_DATE = bUSINESSDATE;
	}

	public Integer getREGISTERED_CAPITAL() {
		return REGISTERED_CAPITAL;
	}

	public void setREGISTERED_CAPITAL(Integer rEGISTEREDCAPITAL) {
		REGISTERED_CAPITAL = rEGISTEREDCAPITAL;
	}

	public String getBUSIAREA() {
		return BUSIAREA;
	}

	public void setBUSIAREA(String bUSIAREA) {
		BUSIAREA = bUSIAREA;
	}

	public String getREGIST_ADDRESS() {
		return REGIST_ADDRESS;
	}

	public void setREGIST_ADDRESS(String rEGISTADDRESS) {
		REGIST_ADDRESS = rEGISTADDRESS;
	}

	public String getREAL_ADDRESS() {
		return REAL_ADDRESS;
	}

	public void setREAL_ADDRESS(String rEALADDRESS) {
		REAL_ADDRESS = rEALADDRESS;
	}

	public String getPOST_CODE() {
		return POST_CODE;
	}

	public void setPOST_CODE(String pOSTCODE) {
		POST_CODE = pOSTCODE;
	}

	public String getLINK_MAN() {
		return LINK_MAN;
	}

	public void setLINK_MAN(String lINKMAN) {
		LINK_MAN = lINKMAN;
	}

	public String getFAX() {
		return FAX;
	}

	public void setFAX(String fAX) {
		FAX = fAX;
	}

	public String getCOMPANY_EMAIL() {
		return COMPANY_EMAIL;
	}

	public void setCOMPANY_EMAIL(String cOMPANYEMAIL) {
		COMPANY_EMAIL = cOMPANYEMAIL;
	}

	public String getWEB_URL() {
		return WEB_URL;
	}

	public void setWEB_URL(String wEBURL) {
		WEB_URL = wEBURL;
	}

	public String getMARRAGE_STATUS() {
		return MARRAGE_STATUS;
	}

	public void setMARRAGE_STATUS(String mARRAGESTATUS) {
		MARRAGE_STATUS = mARRAGESTATUS;
	}

	public String getFLOOR_SPACE() {
		return FLOOR_SPACE;
	}

	public void setFLOOR_SPACE(String fLOORSPACE) {
		FLOOR_SPACE = fLOORSPACE;
	}

	public String getANNUAL_TURNOVER() {
		return ANNUAL_TURNOVER;
	}

	public void setANNUAL_TURNOVER(String aNNUALTURNOVER) {
		ANNUAL_TURNOVER = aNNUALTURNOVER;
	}


	
	

}
