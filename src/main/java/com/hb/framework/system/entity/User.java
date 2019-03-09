package com.hb.framework.system.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体表
 */
@SuppressWarnings("serial")
public class User implements java.io.Serializable {
	private int userId;

	private String userName;//用户名

	private String roleName;//角色名

	private String userPassword;//登录密码
	
	private String userPwdBlock;//支付密码

	private String userNickname;//昵称

	private String userRealname;//真实名称

	private Integer userAge;//年龄

	private String userSex;//性别

	private String userAddress;//用户地址

	private String userPhone;//电话

	private String userMail;//电子邮箱

	private String userQQ;//qq

	private Timestamp regTime;//注册时间

	private Timestamp lastLogintime;//最后登录时间

	private Integer level;//级别

	private String mark;//备注

	private String status;//状态

	private String parentNumber;//上级代理用户编号
	
	private String style;//皮肤样式

	private String idType;//证件类型
	
	private String idNo;//证件号码
	
	private String idValidity;//证件有效期
	
	private String openBankId;//开户行号
	
	private String cardNo;//卡号
	
	private String bankReservePhone;//预留手机号
	
	private String contrNbr;//合同号
	
	private String state;//省份
	
	private String city;//城市
	
	private String district;//区县
	
	private String custLimtAmt;//客户授信额度
	
	private String custLmtAmtDate;//客户授信额度有效期
	
	private String lastUdpTime;//最后更新时间
	
	private String custId;//客户编号（顺序号，如未来需要校验位，可在后面补充
	
	private String custCertContainer;//代理证书容器号
	
	private String custElesignProtocolPath;//电子签章委托协议存放路径
	
	private String jpaVersion;//jpaVersion
	
	private String marrageStatus;//婚姻状况
	
	private String education;//最高学历
	
	private String profession;//职业
	
	private String monthlywages;//个人月收入
	
	private String monthRepay;//月还贷总额
	
	private String totalLoan;//未结清贷款总额
	
	private String unitName;//单位名称
	
	private String unitType;//单位类别
	
	private String post;//公司职务
	
	private String department;//任职部门
	
	private String unitPhone;//单位电话
	
	private String homePhone;//住宅电话
	
	private String workYear;//工作年限
	
	private String personalProtocolPath;//个人信息查询授权书保存路径
	
	private String personalProtocolName;//个人信息查询授权书名字
	
	private String corporationNation;//法人民族
	
	private String corporationNative;//法人民族
	
	private String customerType;//客户类型
	
	private String scale;//企业规模
	
	private String industNo;//组织机构代码证
	
	private String registerNo;//公司注册登记号
	
	private String registerOrg;//工商注册登记机关
	
	private String registerDate;//工商注册登记日期
	
	private String countryTaxNo;//国税税务登记号
	
	private String cityTaxNo;//地税税务登记号
	
	private String propertyId;//企业性质
	
	private String employees;//从业人数
	
	private String foundedDate;//成立日期
	
	private String realGovern;//实际控制人
	
	private String businessLicense;//营业执照号
	
	private String businessDate;//营业执照截止日期
	
	private String registeredCapital;//注册资本
	
	private String busiarea;//经营范围
	
	private String registAddress;//公司注册地址
	
	private String realAddress;//公司通讯地址
	
	private String postCode;//公司邮政编码
	
	private String linkMan;//联系人
	
	private String fax;//公司传真
	
	private String companyEmail;//公司邮箱
	
	private String webUrl;//公司网址
	
	private String floorSpace;//场地面积
	
	private String annualTurnover;//年营业额
	
	private String institutionalRating;//是否有业务来往
	
	private String customerSource;//客户来源
	
	private String conditionState;//客户状态(0为冻结,1为正常)

	
	// 一个集合roles，初始容量为0
	private Set<Roles> roles = new HashSet<Roles>(0);

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwdBlock() {
		return userPwdBlock;
	}

	public void setUserPwdBlock(String userPwdBlock) {
		this.userPwdBlock = userPwdBlock;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Timestamp getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(Timestamp lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdValidity() {
		return idValidity;
	}

	public void setIdValidity(String idValidity) {
		this.idValidity = idValidity;
	}

	public String getOpenBankId() {
		return openBankId;
	}

	public void setOpenBankId(String openBankId) {
		this.openBankId = openBankId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getBankReservePhone() {
		return bankReservePhone;
	}

	public void setBankReservePhone(String bankReservePhone) {
		this.bankReservePhone = bankReservePhone;
	}

	public String getContrNbr() {
		return contrNbr;
	}

	public void setContrNbr(String contrNbr) {
		this.contrNbr = contrNbr;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCustLimtAmt() {
		return custLimtAmt;
	}

	public void setCustLimtAmt(String custLimtAmt) {
		this.custLimtAmt = custLimtAmt;
	}

	public String getCustLmtAmtDate() {
		return custLmtAmtDate;
	}

	public void setCustLmtAmtDate(String custLmtAmtDate) {
		this.custLmtAmtDate = custLmtAmtDate;
	}

	public String getLastUdpTime() {
		return lastUdpTime;
	}

	public void setLastUdpTime(String lastUdpTime) {
		this.lastUdpTime = lastUdpTime;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustCertContainer() {
		return custCertContainer;
	}

	public void setCustCertContainer(String custCertContainer) {
		this.custCertContainer = custCertContainer;
	}

	public String getCustElesignProtocolPath() {
		return custElesignProtocolPath;
	}

	public void setCustElesignProtocolPath(String custElesignProtocolPath) {
		this.custElesignProtocolPath = custElesignProtocolPath;
	}

	public String getJpaVersion() {
		return jpaVersion;
	}

	public void setJpaVersion(String jpaVersion) {
		this.jpaVersion = jpaVersion;
	}

	public String getMarrageStatus() {
		return marrageStatus;
	}

	public void setMarrageStatus(String marrageStatus) {
		this.marrageStatus = marrageStatus;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMonthlywages() {
		return monthlywages;
	}

	public void setMonthlywages(String monthlywages) {
		this.monthlywages = monthlywages;
	}

	public String getMonthRepay() {
		return monthRepay;
	}

	public void setMonthRepay(String monthRepay) {
		this.monthRepay = monthRepay;
	}

	public String getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(String totalLoan) {
		this.totalLoan = totalLoan;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUnitPhone() {
		return unitPhone;
	}

	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getPersonalProtocolPath() {
		return personalProtocolPath;
	}

	public void setPersonalProtocolPath(String personalProtocolPath) {
		this.personalProtocolPath = personalProtocolPath;
	}

	public String getPersonalProtocolName() {
		return personalProtocolName;
	}

	public void setPersonalProtocolName(String personalProtocolName) {
		this.personalProtocolName = personalProtocolName;
	}

	public String getCorporationNation() {
		return corporationNation;
	}

	public void setCorporationNation(String corporationNation) {
		this.corporationNation = corporationNation;
	}

	public String getCorporationNative() {
		return corporationNative;
	}

	public void setCorporationNative(String corporationNative) {
		this.corporationNative = corporationNative;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getIndustNo() {
		return industNo;
	}

	public void setIndustNo(String industNo) {
		this.industNo = industNo;
	}

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getRegisterOrg() {
		return registerOrg;
	}

	public void setRegisterOrg(String registerOrg) {
		this.registerOrg = registerOrg;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getCountryTaxNo() {
		return countryTaxNo;
	}

	public void setCountryTaxNo(String countryTaxNo) {
		this.countryTaxNo = countryTaxNo;
	}

	public String getCityTaxNo() {
		return cityTaxNo;
	}

	public void setCityTaxNo(String cityTaxNo) {
		this.cityTaxNo = cityTaxNo;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getEmployees() {
		return employees;
	}

	public void setEmployees(String employees) {
		this.employees = employees;
	}

	public String getFoundedDate() {
		return foundedDate;
	}

	public void setFoundedDate(String foundedDate) {
		this.foundedDate = foundedDate;
	}

	public String getRealGovern() {
		return realGovern;
	}

	public void setRealGovern(String realGovern) {
		this.realGovern = realGovern;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String getBusiarea() {
		return busiarea;
	}

	public void setBusiarea(String busiarea) {
		this.busiarea = busiarea;
	}

	public String getRegistAddress() {
		return registAddress;
	}

	public void setRegistAddress(String registAddress) {
		this.registAddress = registAddress;
	}

	public String getRealAddress() {
		return realAddress;
	}

	public void setRealAddress(String realAddress) {
		this.realAddress = realAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getFloorSpace() {
		return floorSpace;
	}

	public void setFloorSpace(String floorSpace) {
		this.floorSpace = floorSpace;
	}

	public String getAnnualTurnover() {
		return annualTurnover;
	}

	public void setAnnualTurnover(String annualTurnover) {
		this.annualTurnover = annualTurnover;
	}

	public String getInstitutionalRating() {
		return institutionalRating;
	}

	public void setInstitutionalRating(String institutionalRating) {
		this.institutionalRating = institutionalRating;
	}

	public String getCustomerSource() {
		return customerSource;
	}

	public void setCustomerSource(String customerSource) {
		this.customerSource = customerSource;
	}

	public String getConditionState() {
		return conditionState;
	}

	public void setConditionState(String conditionState) {
		this.conditionState = conditionState;
	}
	
	
}
