package com.hb.framework.business.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 抵/质押信息实体类
 * @author lym
 *
 */
public class Pledge implements Serializable {

	/**
	 * 订单id
	 */
	private String xj_order_id;
	/**
	 * 物品类型
	 * "H|房子",
	 * "C|车子",
	 * "O|其他"
	 */
	private String good_type;
	/**
	 * 产权人
	 */
	private String owner_name;
	/**
	 * 产权证号
	 */
	private String cert_no;
	/**
	 * 抵质押物名称
	 */
	private String pledge_name;
	/**
	 * 数量
	 */
	private String area_amount;
	/**
	 * 抵质押类型
	 * "P|质押",
	 * "M|抵押"
	 */
	private String pledge_flag;
	
	/**
	 * 产权人身份证号
	 */
	private String cert_user_id_no;
	
	/**
	 * 评估值(元)--资产金额
	 */
    private BigDecimal oth_imp_amt;
    
	/**
	 * 资产位置
	 */
    private String mortgage_addres;
	
	/**
	 * 备注
	 */
    private String remark;
    
    /**
	 * 抵押合同文件名称
	 */
    private String fileName;

	/**
	 * 文件路径
	 */
    private String filePath;
	
	
	public Pledge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pledge(String xjOrderId, String goodType, String ownerName,
			String certNo, String pledgeName, String areaAmount,
			String pledgeFlag) {
		super();
		xj_order_id = xjOrderId;
		good_type = goodType;
		owner_name = ownerName;
		cert_no = certNo;
		pledge_name = pledgeName;
		area_amount = areaAmount;
		pledge_flag = pledgeFlag;
	}

	public String getXj_order_id() {
		return xj_order_id;
	}

	public void setXj_order_id(String xjOrderId) {
		xj_order_id = xjOrderId;
	}

	public String getGood_type() {
		return good_type;
	}

	public void setGood_type(String goodType) {
		good_type = goodType;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String ownerName) {
		owner_name = ownerName;
	}

	public String getCert_no() {
		return cert_no;
	}

	public void setCert_no(String certNo) {
		cert_no = certNo;
	}

	public String getPledge_name() {
		return pledge_name;
	}

	public void setPledge_name(String pledgeName) {
		pledge_name = pledgeName;
	}

	public String getArea_amount() {
		return area_amount;
	}

	public void setArea_amount(String areaAmount) {
		area_amount = areaAmount;
	}

	public String getPledge_flag() {
		return pledge_flag;
	}

	public void setPledge_flag(String pledgeFlag) {
		pledge_flag = pledgeFlag;
	}

	public String getCert_user_id_no() {
		return cert_user_id_no;
	}

	public void setCert_user_id_no(String certUserIdNo) {
		cert_user_id_no = certUserIdNo;
	}

	public BigDecimal getOth_imp_amt() {
		return oth_imp_amt;
	}

	public void setOth_imp_amt(BigDecimal othImpAmt) {
		oth_imp_amt = othImpAmt;
	}

	public String getMortgage_addres() {
		return mortgage_addres;
	}

	public void setMortgage_addres(String mortgageAddres) {
		mortgage_addres = mortgageAddres;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	
}
