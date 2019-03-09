package com.hb.framework.business.entity;

/**与支付密码设置，修改，忘记，验证相关的JavaBean
 * @author sjl
 *
 */
public class PayPassword {

	//用户编码
	private String customerbasic_id;
	//业务系统类型
	private String source_biz_type;
	//身份证号码
	private String id_no;
	//手机验证码
	private String mobile_code;
	//原支付密码
	private String pin_block;
	//支付密码
	private String new_pin_block;
	
	public String getCustomerbasic_id() {
		return customerbasic_id;
	}
	public void setCustomerbasic_id(String customerbasicId) {
		customerbasic_id = customerbasicId;
	}
	public String getSource_biz_type() {
		return source_biz_type;
	}
	public void setSource_biz_type(String sourceBizType) {
		source_biz_type = sourceBizType;
	}
	public String getId_no() {
		return id_no;
	}
	public void setId_no(String idNo) {
		id_no = idNo;
	}
	public String getMobile_code() {
		return mobile_code;
	}
	public void setMobile_code(String mobileCode) {
		mobile_code = mobileCode;
	}
	public String getPin_block() {
		return pin_block;
	}
	public void setPin_block(String pinBlock) {
		pin_block = pinBlock;
	}
	public String getNew_pin_block() {
		return new_pin_block;
	}
	public void setNew_pin_block(String newPinBlock) {
		new_pin_block = newPinBlock;
	}

	
	
}
