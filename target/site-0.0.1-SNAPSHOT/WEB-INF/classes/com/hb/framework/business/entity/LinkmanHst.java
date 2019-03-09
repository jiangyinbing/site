package com.hb.framework.business.entity;

public class LinkmanHst {
	
	private String linkmanId;
	private String orderId;
	private String custId;
	/**
	 * C|配偶
	 * F|父亲
	 * M|母亲
	 * B|兄弟
	 * S|姐妹
	 * L|亲属
	 * W|同事
	 */
	private String relationship;
	private String org;
	/**
	 * 客户姓名 - 冗余字段，从客户表复制过来，这样批量处理时可以不用关联客户信息
	 */
	private String name;
	/**
	 * M|男
	 * F|女
	 */
	private String gender;
	private String mobileNo;
	private String birth;
	private String corpName;
	private String idType;
	private String idNo;
	private String corpTelephNbr;
	private String corpFax;
	private String corpPosition;   
	private String createTime;
	private String createUser;
	private String lstUpdTime;
	private String lstUpdUser;
	private String jpaVersion;
	
	public String getLinkmanId() {
		return linkmanId;
	}
	public void setLinkmanId(String linkmanId) {
		this.linkmanId = linkmanId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
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
	public String getCorpTelephNbr() {
		return corpTelephNbr;
	}
	public void setCorpTelephNbr(String corpTelephNbr) {
		this.corpTelephNbr = corpTelephNbr;
	}
	public String getCorpFax() {
		return corpFax;
	}
	public void setCorpFax(String corpFax) {
		this.corpFax = corpFax;
	}
	public String getCorpPosition() {
		return corpPosition;
	}
	public void setCorpPosition(String corpPosition) {
		this.corpPosition = corpPosition;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getLstUpdTime() {
		return lstUpdTime;
	}
	public void setLstUpdTime(String lstUpdTime) {
		this.lstUpdTime = lstUpdTime;
	}
	public String getLstUpdUser() {
		return lstUpdUser;
	}
	public void setLstUpdUser(String lstUpdUser) {
		this.lstUpdUser = lstUpdUser;
	}
	public String getJpaVersion() {
		return jpaVersion;
	}
	public void setJpaVersion(String jpaVersion) {
		this.jpaVersion = jpaVersion;
	}

	

}
