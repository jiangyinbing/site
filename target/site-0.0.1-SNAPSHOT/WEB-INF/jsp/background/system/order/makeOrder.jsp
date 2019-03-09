<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../../../common/common-js.jsp"%>
<%@include file="../../../common/validator.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link id="cssMiddle" type="text/css" rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css"
	media="all" />

<title>资源管理</title>
</head>
<body>
	<form
		action="${pageContext.servletContext.contextPath }/background/system/user/add.html"
		method="post">
		<div class="main_page">
			<div class="main_con">
				<div class="position">
					现在的位置: <a href="#">订单查询</a> >> <a href="#">创建订单</a>
				</div>
				<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td height="30" colspan="4">
								<h2>创建订单</h2>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">手机号码：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MOBILE_NO" disabled="disabled"
										value="${userSession.userPhone }"
										data-validator-group="customValidatorGroupName"
										data-validator-required="请输入用户名."
										style="height: 20px; width: 200px" name="userMobile" />
								</div>
							</td><td height="30" width="10%"></td><td></td>
						</tr>

						<td height="30" width="10%">
							<div align="right">产品名称：</div>
						</td>
						<td>
							<div align="left" style="padding-left: 10px;">
								<select id="PRODUCT_NAME" style="height: 20px; width: 200px"
									onchange="changepname()" name="productName">
									<option value="0">请选择</option>
								</select>
							</div>
						</td>

						<td height="30" width="10%">
							<div align="right">产品代码：</div>
						</td>
						<td>
							<div align="left" style="padding-left: 10px;">
								<input id="PRODUCT_ID" style="height: 20px; width: 200px"
									name="productCd"  />
								<!-- 流程定义key -->
								<input type="hidden" name="proc_def_key" id="proc_def_key" />
								<!-- 是否担保 -->
								<input type="hidden" name="is_need_guarantee" id="is_need_guarantee" />
								<!-- 是否抵质押 -->
								<input type="hidden" name="is_need_mortgaged" id="is_need_mortgaged" />
								<!-- 产品发行对象 -->
								<input type="hidden" name="product_obj" id="product_obj" />
							</div>
						</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">基础利率：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="INTERESTRATE" style="height: 20px; width: 200px"
										name="interestRate" />
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">核心企业：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<select id="COREENTID" style="height: 20px; width: 200px" name="coreEntId">
										<option value="0">无</option>
									</select>
								</div>
							</td>

						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">还款方式：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<select id="REPAYTYPE" style="height: 20px; width: 200px" name="repayType">
										<option value="0">请选择</option>
										<option value="MCAT">随借随还</option>
										<option value="MCEP">等额本金</option>
										<option value="MCEI">等额本息</option>
										<option value="MPD">按月付息到期还本 </option>
										<option value="OTDS">一次性还本付息</option>
									</select>
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">商品描述：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="PRD_SUB_DSC" style="height: 20px; width: 200px"
										name="prdSubDsc" />
								</div>
							</td>

						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">贷款金额：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="ORI_ORDERAMT" style="height: 20px; width: 200px"
										name="oriOrderAmt" />
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">期数：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="TERM" style="height: 20px; width: 200px"
										name="term" />
								</div> 
							</td>

						</tr>

						<tr>
							<td height="30" colspan="4">
								<div class="choose">
									<p>商户信息&nbsp;(选填)</p>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">商户编号：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_ID" style="height: 20px; width: 200px"
										name="merId" />
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">商户名称：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_NAME" style="height: 20px; width: 200px"
										name="merName" />
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">营业执照号：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_BUSSN" style="height: 20px; width: 200px"
										name="merBusSn">
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">税务登记号：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_TAXATIONSN" style="height: 20px; width: 200px"
										name="merTaxationSn" />
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">商户详细地址：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_ADDRESS" style="height: 20px; width: 200px"
										name="merAddress" />
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">注册资本：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_REGCAPITAL" style="height: 20px; width: 200px"
										name="merRegCapital" />
								</div>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">开户行：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_OPENBANK" style="height: 20px; width: 200px"
										name="merOpenBank">
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">银行卡号：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_CARDNO" style="height: 20px; width: 200px"
										name="merCardNo" />
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">持卡人姓名：</div>
							</td>
							<td colspan="3">
								<div align="left" style="padding-left: 10px;">
									<input id="MER_USERNAME" style="height: 20px; width: 200px"
										name="merUserName" />
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">法人代表：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_LEGAL" style="height: 20px; width: 200px"
										name="merLegal" />
								</div>
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">法人代表身份证号码：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_LEGALSN" style="height: 20px; width: 200px"
										name="merLegalSn" />
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">法人代表联系电话：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_LEGALTEL" style="height: 20px; width: 200px"
										name="merLegalTel" />
								</div>
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">商户电话：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_TEL" style="height: 20px; width: 200px"
										name="merTel" />
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">商户联系人 ：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="MER_CONTACTNAME" style="height: 20px; width: 200px"
										name="merContactName" />

								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">商户邮编：</div>
							</td>
							<td >
								<div align="left" style="padding-left: 10px;">
									<input id="MER_ZIP" style="height: 20px; width: 200px"
										name="merZip" />
								</div>
							</td>
							
						</tr>


						<tr>
							<tr>
								<td colspan="4" style="padding: 10px">
									<div align="center">
										<input type="button" value="　保　存　" class="btn"
											onclick="checksubmit();javascript:window.location.href='javascript:history.go(-1)'" /> <input id="backBt" type="button"
											value="　返　回　" class="btn"
											onclick="javascript:window.location.href='javascript:history.go(-1)'" />
									</div>
								</td>
							</tr>
					</tbody>
				</table>
			</div>
			<div align="center" style="margin-bottom: 50px;">
				<b id="msg"></b>${msg}
			</div>
		</div>
	</form>
</body>

<script type="text/javascript">
	function checksubmit(){
		cleanDiv('msg');
		var interestrate=$("#INTERESTRATE").val();
		var coreentid = $("#COREENTID").val();
		var coreEntName = $("#coreEntName").val();
		var oriorderamt=$("#ORI_ORDERAMT").val();//贷款金额
		var merid=$("#MER_ID").val();
		var mername=$("#MER_NAME").val();
		var merbussn=$("#MER_BUSSN").val();
		var mertaxationsn=$("#MER_TAXATIONSN").val();
		var meraddress=$("#MER_ADDRESS").val();
		var merregcapital=$("#MER_REGCAPITAL").val();
		var meropenbank=$("#MER_OPENBANK").val();
		var mercardno=$("#MER_CARDNO").val();
		var mer_username=$("#MER_USERNAME").val();
		var merlegal=$("#MER_LEGAL").val();
		var mer_legalsn=$("#MER_LEGALSN").val();
		var merlegaltel=$("#MER_LEGALTEL").val();
		var mertel=$("#MER_TEL").val();
		var mercontactname=$("#MER_CONTACTNAME").val();
		var merzip=$("#MER_ZIP").val();
		var repaytype=$("#REPAYTYPE").val();
        
		var mobile_no = $("#MOBILE_NO").val();
		var down_payment = $("#DOWN_PAYMENT").val();
		var mechan_id = $("#MECHAN_ID").val();
		var loan_amount = $("#LOAN_AMOUNT").val();
		var term = $("#TERM").val();
		var product_id = $("#PRODUCT_ID").val();
		var product_name = $("#PRODUCT_NAME option:selected").text();
		var loan_code = $("#LOAN_CODE").val();
		var prd_sub_cd = $("#PRD_SUB_CD").val();
		var prd_sub_dsc = $("#PRD_SUB_DSC").val();
		
		// 流程定义key
		var proc_def_key = $("#proc_def_key").val();
		// 是否担保 
		var is_need_guarantee = $("#is_need_guarantee").val();
		// 是否抵质押
		var is_need_mortgaged = $("#is_need_mortgaged").val();
		// 产品发行对象
		var product_obj = $("#product_obj").val();
		
		if (product_name == "0") {
			$("#msg").html("<font color='black'>请选择产品！</font>");
			document.getElementById("msg").style.display = 'block';
			$("#product_name").focus();
			return;
		}
		
		if (down_payment == "") {
			$("#msg").html("<font color='black'>请输入首付金额！</font>");
			document.getElementById("msg").style.display = 'block';
			$("#down_payment").focus();
			return;
		}
		
		if (loan_amount == "") {
			$("#msg").html("<font color='black'>请输入贷款金额！</font>");
			document.getElementById("msg").style.display = 'block';
			$("#loan_amount").focus();
			return;
		} 
		
		$.ajax({
			type:'post',
			url:'${pageContext.servletContext.contextPath }/background/system/order/mkorder.html',
			data:{userMobile:mobile_no,productName:product_name,productCd:product_id,interestRate:interestrate,
				coreEntId:coreentid,prdSubCd:prd_sub_cd,prdSubDsc:prd_sub_dsc,oriOrderAmt:oriorderamt,term:term,
				merId:merid,merName:mername,merBusSn:merbussn,merTaxationSn:mertaxationsn,merAddress:meraddress,
				merRegCapital:merregcapital,merRegCapital:merregcapital,merOpenBank:meropenbank,merCardNo:mercardno,
				merUserName:mer_username,merLegal:merlegal,merLegalSn:mer_legalsn,merLegalTel:merlegaltel,
				merTel:mertel,merContactName:mercontactname,merZip:merzip,procDefKey:proc_def_key,repayType:repaytype,
				isNeedGuarantee:is_need_guarantee,isNeedMortgaged:is_need_mortgaged,productObj:product_obj},
			dataType:'json',
			success:function(data){
				$("#msg").html("<font color='black'>"+data+"</font>");
				document.getElementById("msg").style.display = 'block';
			}
		});
	}
	
	// 提示显示
	function cleanDiv(div) {
		$("#" + div).html("");
		if (div == 'showerrorDiv') {
			$("#msg").html("");
		}
	}
	
	// 一进页面就查
	$(function(){
		// 查产品参数
		$.ajax({
			type:'post',
			url:'${pageContext.servletContext.contextPath }/background/system/product/query.html',
			dataType:'json',
			success:function(data){
				for(var i=0;i<data.length;i++){
					var str = "<option value='"+data[i].productCd+"'>"+data[i].productName+"</option>";
					$("#PRODUCT_NAME").append(str);
				}
			}
		});
		// 查核心企业
		$.ajax({
			type:'get',
			url:'${pageContext.servletContext.contextPath }/background/system/product/queryMer.html',
			success:function(data){
				console.log(data);
				for(var i=0;i<data.length;i++){
					var str = "<option value='"+data[i].coreEntId+"'>"+data[i].coreEntName+"</option>";
					$("#COREENTID").append(str);
				}
			}
		});
	});
	
	// 获取产品参数
	function changepname(){
		var product_name = $("#PRODUCT_NAME").val();
		$("#PRODUCT_ID").removeAttr("disabled")
		$("#PRODUCT_ID").val("")
		$.ajax({
			type:'post',
			url:'${pageContext.servletContext.contextPath }/background/system/product/query.html',
			data:{param:product_name},
			success:function(data){
				for(var i=0;i<data.length;i++){
					if(product_name==data[i].productCd){
						$("#PRODUCT_ID").attr("disabled","disabled");
						$("#PRODUCT_ID").val(data[i].productCd);
						$("#proc_def_key").val(data[i].procDefKey); // 流程定义key
						$("#is_need_guarantee").val(data[i].isNeedGuarantee); // 是否担保
						$("#is_need_mortgaged").val(data[i].isNeedMortgaged); // 是否抵质押
						$("#product_obj").val(data[i].productObj); // 产品发行对象
					}
				}
			}
		});
	}
	
</script>
</html>