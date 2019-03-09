package com.hb.framework.system.entity;

import java.sql.Timestamp;
/**
 * 用户实体表
 */

public class UserLimit implements java.io.Serializable {
	private int limitId;
	
	private int customer_Id; //客户ID

	private String customer_limit;//客户授信额度

	private String use_limit;//客户已用额度

	private String remain_limt;//剩余额度
	
	private String customer_name;//客户类型（1企业，2个人）

	private String customer_type;//客户类型（1企业，2个人）

	private String effect_date;//生效时间

	private String invalid_date;//失效时间

	private String mobile_no;//手机号

	private String status;//状态（1有效，0无效）
  
	private String remark;



	public int getLimitId() {
		return limitId;
	}

	public void setLimitId(int limitId) {
		this.limitId = limitId;
	}



	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_limit() {
		return customer_limit;
	}

	public void setCustomer_limit(String customer_limit) {
		this.customer_limit = customer_limit;
	}

	public String getUse_limit() {
		return use_limit;
	}

	public void setUse_limit(String use_limit) {
		this.use_limit = use_limit;
	}

	public String getRemain_limt() {
		return remain_limt;
	}

	public void setRemain_limt(String remain_limt) {
		this.remain_limt = remain_limt;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public String getEffect_date() {
		return effect_date;
	}

	public void setEffect_date(String effect_date) {
		this.effect_date = effect_date;
	}

	public String getInvalid_date() {
		return invalid_date;
	}

	public void setInvalid_date(String invalid_date) {
		this.invalid_date = invalid_date;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
