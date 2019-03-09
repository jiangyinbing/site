package com.hb.framework.business.entity;

/**
 * 创建订单的实体bean
 * @author sjl
 *
 */
public class Order {
//	xj_order_id:id,product_id:product_id,product_name:product_name,loan_amount:la,term:term,DOWN_PAYMENT:dp
	
	private Integer orderId; // 订单编号
	private Integer hb_orderId;// 弘贝订单号
	private Integer userId; // 用户ID
	private String orderAmt; // 订单本金	
	private Integer term; // 分期期数
	/**
	 * "N|订单已提交",
	 * "L|订单已确认",
	 * "A|放款已成功",
	 * "U|订单已撤销",
	 * "B|添加担保人",
	 * "E|征审不通过",
	 * "S|订单征审中",
	 * "C|合同审核中",
	 * "R|合同不通过",
	 * "G|合同已审核",
	 * "P|结清未入账",
	 * "D|结清已入账",
	 * "T|订单已终止",
	 * "X|订单已过期",
	 * "W|担保签署中",
	 * "H|待签划扣书",
	 * "K|合同已审核(银行)",
	 * "F|银行已放款",
	 * "I|待签委托担保协议"
	 */
	private String orderStatu; // 订单状态
	private String termStartDate; // 订单开始日期（分期开始日期）
	private String termEndDate; // 分期结束时间
	private String productCd; // 产品代码
	private String productName; // 产品名称
	private String prdSubCd; // 商品类别
	private String prdSubDsc; // 商品描述
	private String userMobile; // 用户手机号
	private String downPayment; // 首付金额
	private String createTime; // 创建时间
	private String lastModifyTime; // 最后一次修改时间
	private String repayType;	// 还款方式
	private String jpaVersion; // jpaVersion
	private String coreEntId; // 核心企业id
	private String coreEntName; // 核心企业名称
	private String merId; // 商户ID
	private String merName; // 商户名称
	private String merBusSn; // 营业执照号
	private String merTaxationSn; // 税务登记号
	private String merAddress; // 商户详细地址
	private String merRegCapital; // 注册资本
	private String merOpenBank; // 开户行
	private String merCardNo;  // 银行卡号	 
	private String merUserName;// 持卡人姓名	 
	private String merLegal;   // 法人代表	 
	private String merLegalSn; // 法人代表身份证号码
	private String merLegalTel	 ; // 法人代表联系电话	 
	private String merTel	     ; // 商户电话 
	private String merContactName; // 商户联系人 
	private String merZip	     ; // 商户邮编
	private String contrNbr	       ; // 合同号	     
	private String contrNbrTime	   ; // 合同号创建日期		
	private String dueBillNo	   ; // 借据号	     
	private String finalConfirmTerm; // 终审
	private String finalConfrimTime; // 终审时间		
	private String applicationN    ; // 申请单编号	 
	private String orderLmtAmt	   ; // 单笔授信额度		
	private String loanCode	       ; // 贷款产品代码	 
	private String appliyformEncPath	; // 申请单加密包保存路径	      
	private String protocolEncPath	    ; // 委托划扣协议加密包保存路	
	private String contractEncPath	    ; // 合同加密包保存路径		
	private String applyFormFileName	; // 申请文件名称	          
	private String rejectReason		    ; // 征审失败原因	          
	private String cashAcctNo			; // 资金池编号             
	private String applyTime			; // 申请征审时间	          	
	private String oriOrderAmt			; // 原贷款金额		       
	private String bankLoanTime	        ; // 银行放款时间		                
	private String bankLoanAmount	    ; // 银行放款金额		           	
	private String orderLmtDate	        ; // 订单有效期			       
	private String remark1		        ; // 备注1	                    
	private String remark2		        ; // 备注2	                    
	private String remark3		        ; // 备注3	                   
	private String applyFormPath	    ; // 申请单保存路径	                	
	private String protocolPath	        ; // 委托划扣协议保存路径	           
	private String protocolName	        ; // 委托划扣协议名字                    
	private String loanBank		        ; // 放款银行	               	
	private String loanBranchBank	    ; // 放款支行	               
	private String loanSubBranchBank	; // 放款分行	                
	private String installmentFeeRate	; // 贷款手续费率                  
	private String interestRate		    ; // 基础利率	               
	private String contrPath			; // 放款银行	                	
	private String contrName			; // 借据合同名字	               
	private String refuseCode			; // 因为拒绝原因为多选，这里把多条用“|”拼接存放
	private String procDefKey			; // 流程定义key
	private String isNeedGuarantee		; // 是否担保
	private String isNeedMortgaged		; // 是否抵质押
	private String productObj			; // 产品发行对象
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getHb_orderId() {
		return hb_orderId;
	}
	public void setHb_orderId(Integer hb_orderId) {
		this.hb_orderId = hb_orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(String orderAmt) {
		this.orderAmt = orderAmt;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public String getOrderStatu() {
		return orderStatu;
	}
	public void setOrderStatu(String orderStatu) {
		this.orderStatu = orderStatu;
	}
	public String getTermStartDate() {
		return termStartDate;
	}
	public void setTermStartDate(String termStartDate) {
		this.termStartDate = termStartDate;
	}
	public String getTermEndDate() {
		return termEndDate;
	}
	public void setTermEndDate(String termEndDate) {
		this.termEndDate = termEndDate;
	}
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrdSubCd() {
		return prdSubCd;
	}
	public void setPrdSubCd(String prdSubCd) {
		this.prdSubCd = prdSubCd;
	}
	public String getPrdSubDsc() {
		return prdSubDsc;
	}
	public void setPrdSubDsc(String prdSubDsc) {
		this.prdSubDsc = prdSubDsc;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(String downPayment) {
		this.downPayment = downPayment;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public String getRepayType() {
		return repayType;
	}
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	public String getJpaVersion() {
		return jpaVersion;
	}
	public void setJpaVersion(String jpaVersion) {
		this.jpaVersion = jpaVersion;
	}
	public String getCoreEntId() {
		return coreEntId;
	}
	public void setCoreEntId(String coreEntId) {
		this.coreEntId = coreEntId;
	}
	public String getCoreEntName() {
		return coreEntName;
	}
	public void setCoreEntName(String coreEntName) {
		this.coreEntName = coreEntName;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public String getMerBusSn() {
		return merBusSn;
	}
	public void setMerBusSn(String merBusSn) {
		this.merBusSn = merBusSn;
	}
	public String getMerTaxationSn() {
		return merTaxationSn;
	}
	public void setMerTaxationSn(String merTaxationSn) {
		this.merTaxationSn = merTaxationSn;
	}
	public String getMerAddress() {
		return merAddress;
	}
	public void setMerAddress(String merAddress) {
		this.merAddress = merAddress;
	}
	public String getMerRegCapital() {
		return merRegCapital;
	}
	public void setMerRegCapital(String merRegCapital) {
		this.merRegCapital = merRegCapital;
	}
	public String getMerOpenBank() {
		return merOpenBank;
	}
	public void setMerOpenBank(String merOpenBank) {
		this.merOpenBank = merOpenBank;
	}
	public String getMerCardNo() {
		return merCardNo;
	}
	public void setMerCardNo(String merCardNo) {
		this.merCardNo = merCardNo;
	}
	public String getMerUserName() {
		return merUserName;
	}
	public void setMerUserName(String merUserName) {
		this.merUserName = merUserName;
	}
	public String getMerLegal() {
		return merLegal;
	}
	public void setMerLegal(String merLegal) {
		this.merLegal = merLegal;
	}
	public String getMerLegalSn() {
		return merLegalSn;
	}
	public void setMerLegalSn(String merLegalSn) {
		this.merLegalSn = merLegalSn;
	}
	public String getMerLegalTel() {
		return merLegalTel;
	}
	public void setMerLegalTel(String merLegalTel) {
		this.merLegalTel = merLegalTel;
	}
	public String getMerTel() {
		return merTel;
	}
	public void setMerTel(String merTel) {
		this.merTel = merTel;
	}
	public String getMerContactName() {
		return merContactName;
	}
	public void setMerContactName(String merContactName) {
		this.merContactName = merContactName;
	}
	public String getMerZip() {
		return merZip;
	}
	public void setMerZip(String merZip) {
		this.merZip = merZip;
	}
	public String getContrNbr() {
		return contrNbr;
	}
	public void setContrNbr(String contrNbr) {
		this.contrNbr = contrNbr;
	}
	public String getContrNbrTime() {
		return contrNbrTime;
	}
	public void setContrNbrTime(String contrNbrTime) {
		this.contrNbrTime = contrNbrTime;
	}
	public String getDueBillNo() {
		return dueBillNo;
	}
	public void setDueBillNo(String dueBillNo) {
		this.dueBillNo = dueBillNo;
	}
	public String getFinalConfirmTerm() {
		return finalConfirmTerm;
	}
	public void setFinalConfirmTerm(String finalConfirmTerm) {
		this.finalConfirmTerm = finalConfirmTerm;
	}
	public String getFinalConfrimTime() {
		return finalConfrimTime;
	}
	public void setFinalConfrimTime(String finalConfrimTime) {
		this.finalConfrimTime = finalConfrimTime;
	}
	public String getApplicationN() {
		return applicationN;
	}
	public void setApplicationN(String applicationN) {
		this.applicationN = applicationN;
	}
	public String getOrderLmtAmt() {
		return orderLmtAmt;
	}
	public void setOrderLmtAmt(String orderLmtAmt) {
		this.orderLmtAmt = orderLmtAmt;
	}
	public String getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}
	public String getAppliyformEncPath() {
		return appliyformEncPath;
	}
	public void setAppliyformEncPath(String appliyformEncPath) {
		this.appliyformEncPath = appliyformEncPath;
	}
	public String getProtocolEncPath() {
		return protocolEncPath;
	}
	public void setProtocolEncPath(String protocolEncPath) {
		this.protocolEncPath = protocolEncPath;
	}
	public String getContractEncPath() {
		return contractEncPath;
	}
	public void setContractEncPath(String contractEncPath) {
		this.contractEncPath = contractEncPath;
	}
	public String getApplyFormFileName() {
		return applyFormFileName;
	}
	public void setApplyFormFileName(String applyFormFileName) {
		this.applyFormFileName = applyFormFileName;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getCashAcctNo() {
		return cashAcctNo;
	}
	public void setCashAcctNo(String cashAcctNo) {
		this.cashAcctNo = cashAcctNo;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getOriOrderAmt() {
		return oriOrderAmt;
	}
	public void setOriOrderAmt(String oriOrderAmt) {
		this.oriOrderAmt = oriOrderAmt;
	}
	public String getBankLoanTime() {
		return bankLoanTime;
	}
	public void setBankLoanTime(String bankLoanTime) {
		this.bankLoanTime = bankLoanTime;
	}
	public String getBankLoanAmount() {
		return bankLoanAmount;
	}
	public void setBankLoanAmount(String bankLoanAmount) {
		this.bankLoanAmount = bankLoanAmount;
	}
	public String getOrderLmtDate() {
		return orderLmtDate;
	}
	public void setOrderLmtDate(String orderLmtDate) {
		this.orderLmtDate = orderLmtDate;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getApplyFormPath() {
		return applyFormPath;
	}
	public void setApplyFormPath(String applyFormPath) {
		this.applyFormPath = applyFormPath;
	}
	public String getProtocolPath() {
		return protocolPath;
	}
	public void setProtocolPath(String protocolPath) {
		this.protocolPath = protocolPath;
	}
	public String getProtocolName() {
		return protocolName;
	}
	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}
	public String getLoanBank() {
		return loanBank;
	}
	public void setLoanBank(String loanBank) {
		this.loanBank = loanBank;
	}
	public String getLoanBranchBank() {
		return loanBranchBank;
	}
	public void setLoanBranchBank(String loanBranchBank) {
		this.loanBranchBank = loanBranchBank;
	}
	public String getLoanSubBranchBank() {
		return loanSubBranchBank;
	}
	public void setLoanSubBranchBank(String loanSubBranchBank) {
		this.loanSubBranchBank = loanSubBranchBank;
	}
	public String getInstallmentFeeRate() {
		return installmentFeeRate;
	}
	public void setInstallmentFeeRate(String installmentFeeRate) {
		this.installmentFeeRate = installmentFeeRate;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getContrPath() {
		return contrPath;
	}
	public void setContrPath(String contrPath) {
		this.contrPath = contrPath;
	}
	public String getContrName() {
		return contrName;
	}
	public void setContrName(String contrName) {
		this.contrName = contrName;
	}
	public String getRefuseCode() {
		return refuseCode;
	}
	public void setRefuseCode(String refuseCode) {
		this.refuseCode = refuseCode;
	}
	public String getProcDefKey() {
		return procDefKey;
	}
	public void setProcDefKey(String procDefKey) {
		this.procDefKey = procDefKey;
	}
	public String getIsNeedGuarantee() {
		return isNeedGuarantee;
	}
	public void setIsNeedGuarantee(String isNeedGuarantee) {
		this.isNeedGuarantee = isNeedGuarantee;
	}
	public String getIsNeedMortgaged() {
		return isNeedMortgaged;
	}
	public void setIsNeedMortgaged(String isNeedMortgaged) {
		this.isNeedMortgaged = isNeedMortgaged;
	}
	public String getProductObj() {
		return productObj;
	}
	public void setProductObj(String productObj) {
		this.productObj = productObj;
	}
	
	
	
}
