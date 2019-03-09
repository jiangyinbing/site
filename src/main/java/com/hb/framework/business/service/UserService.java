package com.hb.framework.business.service;

import java.sql.ResultSet;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.system.entity.User;

public class UserService {

	public User findOne(Integer userid, Integer userPhone){
		String sql = "select userId,userName,"
				+ "	(select r.name from sys_role r where id in (SELECT ur.role_id FROM sys_user_role ur "
				+ " WHERE ur.user_id=userId)) roleName,"
				+ "	userPassword,userPwdBlock,userNickname,userRealname,userAge,userSex,userAddress,userPhone,userMail,userQQ,regTime, "
				+ "	(select ul.loginTime from sys_userloginlist ul where ul.userId=userId order By ul.loginTime desc limit 1,1) lastLogintime, "
				+ "	status,idType,idNo,idValidity,openBankId,cardNo,bankReservePhone,contrNbr,state,city,district,custLimtAmt,custLmtAmtDate,"
				+ "	lastUdpTime,custId,custCertContainer,custElesignProtocolPath,jpaVersion,marrageStatus,education,profession,"
		+ "	monthlywages,monthRepay,totalLoan,unitName,unitType,post,department,unitPhone,homePhone,workYear,"
		+ "	corporationNation,corporationNative,customerType,scale,industNo,registerNo,registerOrg,registerDate,"
		+ "	countryTaxNo,cityTaxNo,propertyId,employees,foundedDate,realGovern,businessLicense,businessDate,registeredCapital,busiarea,"
		+ "	registAddress,realAddress,postCode,linkMan,fax,companyEmail,webUrl,floorSpace,annualTurnover,customerSource,"
		+ "	conditionState from hb_application.sys_user where 1=1 ";
			if(userid!=null){
				sql += " and userId = '"+userid+"'";
			}
			if(userPhone!=null){
				sql += " and userPhone = '"+userPhone+"'";
			}
			ResultSet queryrs = DBConnectionUtils.executeQuery(sql);
			User user = new User();
		try {
			if (queryrs.next()) {
				user.setUserId(Integer.parseInt(queryrs.getString("userid")));
				user.setUserName(queryrs.getString("userName"));
				user.setRoleName(queryrs.getString("roleName"));
				user.setUserPassword(queryrs.getString("userPassword"));
				user.setUserPwdBlock(queryrs.getString("userPwdBlock"));
				user.setUserNickname(queryrs.getString("userNickname"));
				user.setUserRealname(queryrs.getString("userRealname"));
//				if(queryrs.getString("userAge")==null){
//					user.setUserAge(null);
//				}else{
//					user.setUserAge(Integer.parseInt(queryrs.getString("userAge")));
//				}
				user.setUserSex(queryrs.getString("userSex"));
				user.setUserAddress(queryrs.getString("userAddress"));
				user.setUserPhone(queryrs.getString("userPhone"));
				user.setUserMail(queryrs.getString("userMail"));
				user.setUserQQ(queryrs.getString("userQQ"));
				user.setStatus(queryrs.getString("status"));
				user.setIdType(queryrs.getString("idType"));
				user.setIdNo(queryrs.getString("idNo"));
				user.setIdValidity(queryrs.getString("idValidity"));
				user.setOpenBankId(queryrs.getString("openBankId"));
				user.setCardNo(queryrs.getString("cardNo"));
				user.setBankReservePhone(queryrs.getString("bankReservePhone"));
				user.setContrNbr(queryrs.getString("contrNbr"));
				user.setState(queryrs.getString("state"));
				user.setCity(queryrs.getString("city"));
				user.setDistrict(queryrs.getString("district"));
				user.setCustLimtAmt(queryrs.getString("custLimtAmt"));
				user.setCustLmtAmtDate(queryrs.getString("custLmtAmtDate"));
				user.setLastUdpTime(queryrs.getString("lastUdpTime"));
				user.setCustId(queryrs.getString("custId"));
				user.setCustCertContainer(queryrs.getString("custCertContainer"));
				user.setCustElesignProtocolPath(queryrs.getString("custElesignProtocolPath"));
				user.setJpaVersion(queryrs.getString("jpaVersion"));
				user.setMarrageStatus(queryrs.getString("marrageStatus"));
				user.setEducation(queryrs.getString("education"));
				user.setProfession(queryrs.getString("profession"));
				user.setMonthlywages(queryrs.getString("monthlywages"));
				user.setMonthRepay(queryrs.getString("monthRepay"));
				user.setTotalLoan(queryrs.getString("totalLoan"));
				user.setUnitName(queryrs.getString("unitName"));
				user.setUnitType(queryrs.getString("unitType"));
				user.setPost(queryrs.getString("post"));
				user.setDepartment(queryrs.getString("department"));
				user.setUnitPhone(queryrs.getString("unitPhone"));
				user.setWorkYear(queryrs.getString("workYear"));
				user.setCorporationNation(queryrs.getString("corporationNation"));
				user.setCorporationNative(queryrs.getString("corporationNative"));
				user.setCustomerType(queryrs.getString("customerType"));
				user.setScale(queryrs.getString("scale"));
				user.setIndustNo(queryrs.getString("industNo"));
				user.setRegisterNo(queryrs.getString("registerNo"));
				user.setRegisterOrg(queryrs.getString("registerOrg"));
				user.setRegisterDate(queryrs.getString("registerDate"));
				user.setCountryTaxNo(queryrs.getString("countryTaxNo"));
				user.setCityTaxNo(queryrs.getString("cityTaxNo"));
				user.setPropertyId(queryrs.getString("propertyId"));
				user.setEmployees(queryrs.getString("employees"));
				user.setFoundedDate(queryrs.getString("foundedDate"));
				user.setRealGovern(queryrs.getString("realGovern"));
				user.setBusinessLicense(queryrs.getString("businessLicense"));
				user.setBusinessDate(queryrs.getString("businessDate"));
				user.setRegisteredCapital(queryrs.getString("registeredCapital"));
				user.setBusiarea(queryrs.getString("busiarea"));
				user.setRegistAddress(queryrs.getString("registAddress"));
				user.setRealAddress(queryrs.getString("realAddress"));
				user.setPostCode(queryrs.getString("postCode"));
				user.setLinkMan(queryrs.getString("linkMan"));
				user.setFax(queryrs.getString("fax"));
				user.setCompanyEmail(queryrs.getString("companyEmail"));
				user.setWebUrl(queryrs.getString("webUrl"));
				user.setFloorSpace(queryrs.getString("floorSpace"));
				user.setAnnualTurnover(queryrs.getString("annualTurnover"));
				user.setCustomerSource(queryrs.getString("customerSource"));
				user.setConditionState(queryrs.getString("conditionState"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return user;
	}
	
	
	
}
