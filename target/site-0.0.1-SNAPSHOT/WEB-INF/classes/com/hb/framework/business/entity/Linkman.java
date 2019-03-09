package com.hb.framework.business.entity;

import java.io.Serializable;

public class Linkman implements Serializable {

	/**
	 * 联系人ID
	 */
	private String linkmanId;
	
	/**
	 * 顺序号，如未来需要校验位，可在后面补充
	 */
	private String userId;
	
	/**
	 * 与联系人的关系
	 * C|配偶
	 * F|父亲
	 * M|母亲
	 * B|兄弟
	 * S|姐妹
	 * L|亲属
	 * W|同事
	 */
	private String relationship;
	
	/**
	 * 机构号
	 */
	private String org;
	
	/**
	 * 客户姓名 - 冗余字段，从客户表复制过来，这样批量处理时可以不用关联客户信息
	 */
	private String name;
	
	/**
	 * 性别
	 * M|男
	 * F|女
	 */
	private String gender;
	
	/**
	 * 移动电话
	 */
	private String mobileNo;
	
	/**
	 * 生日
	 */
	private String birth;
	
	/**
	 * 公司名称
	 */
	private String corpName;
	
	/**
	 * 证件类型
	 */
	private String idType;
	
	/**
	 * 证件号码
	 */
	private String idNo;
	
	/**
	 * 公司电话
	 */
	private String corpTelephNbr;
	
	/**
	 * 公司传真
	 */
	private String corpFax;
	
	/**
	 * 公司职务
	 */
	private String corpPosition;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 创建人
	 */
	private String createUser;
	
	/**
	 * 最后一次更新时间
	 */
	private String lstUpdTime;
	
	/**
	 * 最后一次更新人
	 */
	private String lstUpdUser;
	
	private String jpaVersion;

	public String getLinkmanId() {
		return linkmanId;
	}

	public void setLinkmanId(String linkmanId) {
		this.linkmanId = linkmanId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
