package com.hb.framework.business.service;
import java.math.BigDecimal;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.hb.framework.business.entity.CustomerInfo;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.system.entity.User;

@Service
public class CustomerInfoService {

	/**个人/企业信息查询
	 * @author lx
	 * @throws JSONException 
	 *
	 */
	public CustomerInfo  queryInfo(HttpServletRequest request) throws JSONException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("userSession");
		String sql = "SELECT userId, userName, userNickname, userRealname, userAge, userSex, userAddress, userPhone, userMail,"
				+ "userQQ, idType, idNo, idValidity, openBankId, cardNo, bankReservePhone, contrNbr, state, city, district,"
				+ "marrageStatus, education, profession, monthlywages, monthRepay,totalLoan, unitName, unitType, post,"
				+ "department, unitPhone, homePhone, workYear, corporationNation, corporationNative, customerType, scale,"
				+ "industNo, registerNo, registerOrg, registerDate, countryTaxNo, cityTaxNo, propertyId, employees, foundedDate,"
				+ "realGovern, businessLicense, businessDate, registeredCapital, busiarea, registAddress, realAddress, postCode,"
				+ "fax, companyEmail, webUrl, floorSpace, annualTurnover "
				+ "FROM hb_application.sys_user where userId='"+ Integer.toString(user.getUserId()) +"'";
		ResultSet queryrs = DBConnectionUtils.executeQuery(sql);
		CustomerInfo customerInfo = new CustomerInfo(); 
		try {
			if (queryrs.next()) {
				customerInfo.setCUSTOMER_BASIC_ID(Integer.parseInt(queryrs.getString("userId")));
				customerInfo.setGENDER(queryrs.getString("userSex"));
				customerInfo.setID_NO(queryrs.getString("userName"));
				customerInfo.setADDRESS(queryrs.getString("userAddress"));
				customerInfo.setEMAIL(queryrs.getString("userMail"));
				customerInfo.setMOBILE_NO(queryrs.getString("userPhone"));
				customerInfo.setSTATE(queryrs.getString("state"));
				customerInfo.setCITY(queryrs.getString("city"));
				customerInfo.setDISTRICT(queryrs.getString("district"));
				customerInfo.setID_TYPE(queryrs.getString("idType"));
				customerInfo.setID_NO(queryrs.getString("idNo"));
				customerInfo.setOPEN_BANK_ID(queryrs.getString("openBankId"));
				customerInfo.setCARD_NO(queryrs.getString("cardNo"));
				customerInfo.setBANK_RESERVE_PHONE(queryrs.getString("bankReservePhone"));
				customerInfo.setCONTR_NBR(queryrs.getString("contrNbr"));
				customerInfo.setMARRAGE_STATUS(queryrs.getString("marrageStatus"));
				customerInfo.setEDUCATION(queryrs.getString("education"));
				customerInfo.setPROFESSION(queryrs.getString("profession"));
				if(queryrs.getString("monthlywages")==null || queryrs.getString("monthlywages").trim().length()==0){
					customerInfo.setMONTH_AMT(null);
				} else {
					BigDecimal monthlywages = new BigDecimal(queryrs.getString("monthlywages"));
					customerInfo.setMONTH_AMT(monthlywages);
				}
				if(queryrs.getString("monthRepay")==null || queryrs.getString("monthRepay").trim().length()==0){
					customerInfo.setMONTH_REPAY(null);
				} else {
					BigDecimal monthRepay = new BigDecimal(queryrs.getString("monthRepay"));
					customerInfo.setMONTH_REPAY(monthRepay);
				}
				if(queryrs.getString("totalLoan")==null || queryrs.getString("totalLoan").trim().length()==0){
					customerInfo.setTOTAL_LOAN(null);
				} else {
					BigDecimal totalLoan = new BigDecimal(queryrs.getString("totalLoan"));
					customerInfo.setMONTH_REPAY(totalLoan);
				}
				customerInfo.setUNIT_NAME(queryrs.getString("unitName"));
				customerInfo.setUNIT_TYPE(queryrs.getString("unitType"));
				customerInfo.setPOST(queryrs.getString("post"));
				customerInfo.setDEPARTMENT(queryrs.getString("department"));
				customerInfo.setUNIT_PHONE(queryrs.getString("unitPhone"));
				customerInfo.setHOME_PHONE(queryrs.getString("homePhone"));
				if(queryrs.getString("workYear")==null || queryrs.getString("workYear").trim().length()==0){
					customerInfo.setWORK_YEAR(null);
				}else{
					customerInfo.setWORK_YEAR(Integer.parseInt(queryrs.getString("workYear")));
				}
				customerInfo.setCORPORATION_NATION(queryrs.getString("corporationNation"));
				customerInfo.setCORPORATION_NATIVE(queryrs.getString("corporationNative"));
				customerInfo.setCUSTOMER_TYPE(queryrs.getString("customerType"));
				customerInfo.setSCALE(queryrs.getString("scale"));
				customerInfo.setINDUST_NO(queryrs.getString("industNo"));
				customerInfo.setREGISTER_NO(queryrs.getString("registerNo"));
				customerInfo.setREGISTER_ORG(queryrs.getString("registerOrg"));
				customerInfo.setREGISTER_DATE(queryrs.getString("registerDate"));
				customerInfo.setCOUNTRY_TAX_NO(queryrs.getString("countryTaxNo"));
				customerInfo.setCITY_TAX_NO(queryrs.getString("cityTaxNo"));
				customerInfo.setPROPERTY_ID(queryrs.getString("propertyId"));
				customerInfo.setEMPLOYEES(queryrs.getString("employees"));
				customerInfo.setFOUNDED_DATE(queryrs.getString("foundedDate"));
				customerInfo.setREAL_GOVERN(queryrs.getString("realGovern"));
				customerInfo.setBUSINESS_LICENSE(queryrs.getString("businessLicense"));
				customerInfo.setBUSINESS_DATE(queryrs.getString("businessDate"));
				if(queryrs.getString("registeredCapital")==null || queryrs.getString("registeredCapital").trim().length()==0){
					customerInfo.setREGISTERED_CAPITAL(null);
				}else{
					customerInfo.setREGISTERED_CAPITAL(Integer.parseInt(queryrs.getString("registeredCapital")));
				}
				customerInfo.setBUSIAREA(queryrs.getString("busiarea"));
				customerInfo.setREGIST_ADDRESS(queryrs.getString("registAddress"));
				customerInfo.setREAL_ADDRESS(queryrs.getString("realAddress"));
				customerInfo.setPOST_CODE(queryrs.getString("postCode"));
				customerInfo.setFAX(queryrs.getString("fax"));
				customerInfo.setCOMPANY_EMAIL(queryrs.getString("companyEmail"));
				customerInfo.setWEB_URL(queryrs.getString("webUrl"));
				customerInfo.setFLOOR_SPACE(queryrs.getString("floorSpace"));
				customerInfo.setANNUAL_TURNOVER(queryrs.getString("annualTurnover"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return customerInfo;
	}
	
	@SuppressWarnings("unchecked")
	public String updateInfo(CustomerInfo info, HttpServletRequest request) throws JSONException {
		// TODO Auto-generated method stub
		User users = (User) request.getSession().getAttribute("userSession");
		String sql = "UPDATE sys_user SET "
					+ " userPhone='"+info.getMOBILE_NO()+"', "
					+ " userMail='"+info.getEMAIL()+"', state='"+info.getSTATE()+"', city='"+info.getCITY()+"', "
					+ " district='"+info.getDISTRICT()+"', userAddress='"+info.getADDRESS()+"', "
					+ " openBankId='"+info.getOPEN_BANK_ID()+"', cardNo='"+info.getCARD_NO()+"', "
					+ " bankReservePhone='"+info.getBANK_RESERVE_PHONE()+"', marrageStatus='"+info.getMARRAGE_STATUS()+"', "
					+ " education='"+info.getEDUCATION()+"',  profession='"+info.getPROFESSION()+"', "
					+ " monthlywages='"+info.getMONTH_AMT()+"', monthRepay='"+info.getMONTH_REPAY()+"', "
					+ " totalLoan='"+info.getTOTAL_LOAN()+"', unitName='"+info.getUNIT_NAME()+"', "
					+ " unitPhone='"+info.getUNIT_PHONE()+"', unitType='"+info.getUNIT_TYPE()+"', "
					+ " post='"+info.getPOST()+"', department='"+info.getDEPARTMENT()+"', "
					+ " homePhone='"+info.getHOME_PHONE()+"', workYear='"+info.getWORK_YEAR()+"', "
					+ " corporationNation='"+info.getCORPORATION_NATION()+"', corporationNative='"+info.getCORPORATION_NATIVE()+"', "
					+ " customerType='"+info.getCUSTOMER_TYPE()+"', scale='"+info.getSCALE()+"', "
					+ " industNo='"+info.getINDUST_NO()+"', registerNo='"+info.getREGISTER_NO()+"', "
					+ " registerOrg='"+info.getREGISTER_ORG()+"', registerDate='"+info.getREGISTER_DATE()+"', "
					+ " countryTaxNo='"+info.getCOUNTRY_TAX_NO()+"', cityTaxNo='"+info.getCITY_TAX_NO()+"', "
					+ " propertyId='"+info.getPROPERTY_ID()+"', employees='"+info.getEMPLOYEES()+"', "
					+ " foundedDate='"+info.getFOUNDED_DATE()+"', realGovern='"+info.getREAL_GOVERN()+"', "
					+ " businessLicense='"+info.getBUSINESS_LICENSE()+"', businessDate='"+info.getBUSINESS_DATE()+"', "
					+ " registeredCapital='"+info.getREGISTERED_CAPITAL()+"', busiarea='"+info.getBUSIAREA()+"', "
					+ " registAddress='"+info.getREGIST_ADDRESS()+"', realAddress='"+info.getREAL_ADDRESS()+"', "
					+ " postCode='"+info.getPOST_CODE()+"', linkMan='"+info.getLINK_MAN()+"', "
					+ " fax='"+info.getFAX()+"', companyEmail='"+info.getCOMPANY_EMAIL()+"', "
					+ " webUrl='"+info.getWEB_URL()+"', floorSpace='"+info.getFLOOR_SPACE()+"', "
					+ " annualTurnover='"+info.getANNUAL_TURNOVER()+"' WHERE userId='"+users.getUserId()+"' ";
		String ret = DBConnectionUtils.executeUpdate(sql);
		if(ret==null || ret.length()==0){
			return "S";
		}
		return "ERROR";
	}

}
