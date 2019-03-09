package com.hb.framework.business.entity;

public class Authentication {
	//用户编码
	private String customerbasic_id;
	//真实姓名
	private String name;
	//身份证号码
	private String id_no;
	//银行卡号
	private String card_no;
	//开户行号
	private String open_bank_id;
	public String getCustomerbasic_id() {
		return customerbasic_id;
	}
	public void setCustomerbasic_id(String customerbasicId) {
		customerbasic_id = customerbasicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_no() {
		return id_no;
	}
	public void setId_no(String idNo) {
		id_no = idNo;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String cardNo) {
		card_no = cardNo;
	}
	public String getOpen_bank_id() {
		return open_bank_id;
	}
	public void setOpen_bank_id(String openBankId) {
		open_bank_id = openBankId;
	}
	
}
