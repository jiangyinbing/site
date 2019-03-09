package com.hb.framework.business.entity;

import java.io.Serializable;

/**
 * 担保人实体类
 * @author lym
 *
 */
@SuppressWarnings("serial")
public class Guarantor implements Serializable {

	/**
	 * 担保人姓名
	 */
	private String guarantName;
	/**
	 * 身份证号
	 */
	private String idNo;
	/**
	 * 证件类型
	 */
	private String idType;
	/**
	 * 手机号码
	 */
	private String mobileNumber;
	/**
	 * 订单id
	 */
	private int orderId;
	/**
	 * 与被担保人的关系
	 * "P|本人",
	 * "C|配偶",
	 * "F|父亲",
	 * "M|母亲",
	 * "B|兄弟",
	 * "S|姐妹",
	 * "L|亲属",
	 * "W|同事",
	 * "O|其他"
	 */
	private String relationship;
	
	/**
	 * 担保状态
	 * "A|担保已建立",
	 * "B|担保已确认",
	 * "C|合同已签署",
	 * "D|审批已通过",
	 * "E|担保已作废",
	 * "F|担保已结束",
	 * "G|担保已生效"
	 */
	private String guaranteeStatus;
	
	/**
	 * 担保id
	 */
	private int guaranteeId;
	
	/**
	 * 会员编号
	 */
	private int userId;

	private int noncreditId;
	private String fileName;
	private String filePath;
	private String remark;
	private int jpaVersion;
	private String guaranteeContrNbr;
	private String isSelected;
	private String applyformPath;
	private String applyformName;
	private String isElected;
	
	public String getGuarantName() {
		return guarantName;
	}
	
	public void setGuarantName(String guarantName) {
		this.guarantName = guarantName;
	}
	
	public String getIdNo() {
		return idNo;
	}
	
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	public String getIdType() {
		return idType;
	}
	
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getRelationship() {
		return relationship;
	}
	
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getGuaranteeStatus() {
		return guaranteeStatus;
	}
	
	public void setGuaranteeStatus(String guaranteeStatus) {
		this.guaranteeStatus = guaranteeStatus;
	}
	
	public int getGuaranteeId() {
		return guaranteeId;
	}
	
	public void setGuaranteeId(int guaranteeId) {
		this.guaranteeId = guaranteeId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getNoncreditId() {
		return noncreditId;
	}
	
	public void setNoncreditId(int noncreditId) {
		this.noncreditId = noncreditId;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public int getJpaVersion() {
		return jpaVersion;
	}
	
	public void setJpaVersion(int jpaVersion) {
		this.jpaVersion = jpaVersion;
	}
	
	public String getGuaranteeContrNbr() {
		return guaranteeContrNbr;
	}
	
	public void setGuaranteeContrNbr(String guaranteeContrNbr) {
		this.guaranteeContrNbr = guaranteeContrNbr;
	}
	
	public String getIsSelected() {
		return isSelected;
	}
	
	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}
	
	public String getApplyformPath() {
		return applyformPath;
	}
	
	public void setApplyformPath(String applyformPath) {
		this.applyformPath = applyformPath;
	}
	
	
	
	
	public String getApplyformName() {
		return applyformName;
	}

	
	public void setApplyformName(String applyformName) {
		this.applyformName = applyformName;
	}

	public String getIsElected() {
		return isElected;
	}
	
	public void setIsElected(String isElected) {
		this.isElected = isElected;
	}
	
}
