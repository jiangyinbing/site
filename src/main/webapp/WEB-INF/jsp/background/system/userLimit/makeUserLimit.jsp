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
					现在的位置: <a href="#">额度查询</a> >> <a href="#">创建信用额度</a>
				</div>
				<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td height="30" colspan="4">
								<h2>创建额度</h2>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">手机号码：</div>
							</td>
							<td><div align="left" style="padding-left: 10px;">
									<input id="MOBILE_NO" style="height: 20px; width: 200px"
									name="mobile_No"  />
								</div>
							</td> 
							<td height="30" width="10%">
								<div align="right">剩余额度 ：</div>
							</td>
							<td><div align="left" style="padding-left: 10px;">
								<input id="REMAIN_LIMIT" style="height: 20px; width: 200px"
									name="remainLimt"  />
							</div></td>
						</tr>

						<td height="30" width="10%">
							<div align="right">客户授信额度：</div>
						</td>
						<td>
							<div align="left" style="padding-left: 10px;">
								<input id="CUSTOMER_LIMIT" style="height: 20px; width: 200px"
									name="customerLimit"  />
							</div>
						</td>

						<td height="30" width="10%">
							<div align="right">客户已用额度：</div>
						</td>
						<td>
							<div align="left" style="padding-left: 10px;">
								<input id="USE_LIMIT" style="height: 20px; width: 200px"
									name="useLimit"  />
							</div>
						</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">客户类型：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="CUSTOMER_NAME" style="height: 20px; width: 200px"
										name="customerName" />
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">生效时间：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
								<input type="text" id="EFFECT_DATE"  name="effectDate"  class="date" value="2005-3-22" style="height: 20px; width: 200px"/> 
								<!-- <button onclick="time();">当前值</button> -->
							

							</div>
							</td>

						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">失效时间：</div>
							</td>
							<td>
								
								<div align="left" style="padding-left: 10px;">
								<input type="text" id="INVALID_DATE" name="invalidDate" class="date" value="2005-3-22" style="height: 20px; width: 200px"/> 
								<!-- <button onclick="time();">当前值</button> -->
							</div>
							</td>
							
							<td height="30" width="10%">
								<div align="right">状态 ：</div>
							</td>
							<td><div align="left" style="padding-left: 10px;">
								<select id="STATUS" style="height: 20px; width: 200px"
									name="status" >
										
										<option value="1">无效</option>
										<option value="0">有效</option>
									</select>
							    </div>
							</td>
						</tr>
						<tr>
							<td height="30" colspan="4">
								<div class="choose" >
									<!-- <p>备注：&nbsp;(选填)</p> -->
	<input type="text" value="备注：" onfocus="if(value=='备注：') {value=''}" id="REMARK" name="remark" 
	onblur="if (value=='') {value='请输入备注信息'}"  style="height: 50px; width: 1000px">							
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
		var mobile_no=$("#MOBILE_NO").val();
		var use_limit = $("#USE_LIMIT").val();
		var remain_limt = $("#REMAIN_LIMIT").val();
		var customer_limit=$("#CUSTOMER_LIMIT").val();
		var customer_name=$("#CUSTOMER_NAME").val();
		var effect_date=$("#EFFECT_DATE").val();
		var invalid_date=$("#INVALID_DATE").val();
		var status=$("#STATUS option:selected").val();
		var remark=$("#REMARK").val();
		
		/* var product_name = $("#PRODUCT_NAME option:selected").text();
		
		
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
		}  */
		
		
		
		$.ajax({
			type:'post',
			url:'${pageContext.servletContext.contextPath }/background/biz/userLimit/mkorder.html',
			data:{mobile_no:mobile_no,remain_limt:remain_limt,customer_limit:customer_limit,use_limit:use_limit,
				customer_name:customer_name,effect_date:effect_date,invalid_date:invalid_date,status:status,remark:remark},
			dataType:'json',
			success:function(data){
				$("#msg").html("<font color='black'>"+data+"</font>");
				document.getElementById("msg").style.display = 'block';
				alert(use_limit);
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
	
	
	/* function time(){
	        var d, s = "";           
	           d = new Date();                           
	          $(#EFFECT_DATE)= (d.getMonth() + 1) + "/"+d.getDate() + "/"+d.getYear();            
	        
	           document.all.date.value = s;
	
	} */
	// 获取产品参数
	/* function changepname(){
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
	} */
	
</script>
</html>