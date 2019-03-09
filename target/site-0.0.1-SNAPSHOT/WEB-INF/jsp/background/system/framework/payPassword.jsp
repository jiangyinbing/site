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
		
		<title>支付密码</title>
	</head>
	<body>
		
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">业务办理</a> >>
						<a href="#">支付密码</a>
					</div>
					<!--列表内容 -->
					<table class="table_style table_font_center" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td height="30" colspan="2">
									<h2>
										支付密码
									</h2>
								</td>
							</tr>
							<tr style="display: none">
								<td height="30" width="20%">
									<div align="right" >
										用户编码：
									</div>
								</td>
								<td>
									<div align="left"  style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="CUSTOMERBASIC_ID" id="CUSTOMERBASIC_ID" data-validator-group="customValidatorGroupName" data-validator-required="请输入用户编码." 
											type="text" onchange="cleanMsg()" disabled="disabled" value="${userSession.userId}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" >
										业务系统类型：
									</div>
								</td>
								<td>
									<div align="left"  style="padding-left: 10px;">
										<select id="SOURCE_BIZ_TYPE">
											<option value="SPPS" selected="true">设置支付密码</option>
										<!--<option value="FPPS">忘记支付密码</option>-->
											<option value="MPPS">修改支付密码</option>
											<option value="CPPS">验证支付密码</option>
										</select>	
									</div>
								</td>
							</tr>
							<tr id="ID_display" style="display: none">
								<td height="30" width="20%">
									<div align="right" >
										身份证号：
									</div>
								</td>
								<td>
									<div align="left"  style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="ID_NO" id="ID_NO" data-validator-group="customValidatorGroupName" data-validator-required="请输入您的身份证号." 
											type="text" onchange="cleanMsg()"/>
									</div>
								</td>
							</tr>
							<tr id="PC_display" style="display: none">
								<td height="30" width="20%">
									<div align="right" >
										手机验证码：
									</div>
								</td>
								<td>
									<div align="left"  style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="MOBILE_CODE" id="MOBILE_CODE" data-validator-group="customValidatorGroupName" data-validator-required="请输入角色手机验证码." 
											type="text" onchange="cleanMsg()"/>
									</div>
								</td>
							</tr>
							<tr id="PB_display" style="display: none">
								<td height="30" width="20%">
									<div align="right" >
										原支付密码：
									</div>
								</td>
								<td>
									<div align="left"  style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="PIN_BLOCK" id="PIN_BLOCK" maxlength="6" data-validator-group="customValidatorGroupName" data-validator-required="请输入原支付密码." 
											type="text" onchange="cleanMsg()" />
									</div>
								</td>
							</tr>
							<tr id="NP_display" style="display: true">
								<td height="30" width="20%">
									<div align="right" >
										最新支付密码：
									</div>
								</td>
								<td>
									<div align="left"  style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="NEW_PIN_BLOCK" id="NEW_PIN_BLOCK" maxlength="6" data-validator-group="customValidatorGroupName" data-validator-required="请输入新支付密码." 
											type="text" onchange="cleanMsg()"/>
									</div>
								</td>
							</tr>
							
						
							<tr>
								<td colspan="2" style="padding: 10px">
									<div align="center">
										<input type="button" value="　保　存　" class="btn" onclick="submitResult()"/>
										<input id="backBt" type="button" value="　返　回　" class="btn"
											onclick="javascript:window.location.href='javascript:history.go(-1)'" />
									</div>
								</td>
							</tr>
						</tbody>
						
					</table>
					<div align="center"><b id="msg"></b></div>
				</div>
			</div>
	</body>
	
	<script type="text/javascript">
	
		$(function(){
			
			$("#SOURCE_BIZ_TYPE").change(function(){
				
				var source_biz_type = $("#SOURCE_BIZ_TYPE").val();
				$("#ID_display").css("display","none")
				$("#PC_display").css("display","none")
				$("#PB_display").css("display","none")
				$("#NP_display").css("display","true")
				if(source_biz_type=="SPPS"){
					$("#ID_display").css("display","none")
					$("#PC_display").css("display","none")
					$("#PB_display").css("display","none")
					$("#NP_display").css("display","true")
				}else if(source_biz_type=="FPPS"){
				console.log(source_biz_type)
					$("#ID_display").css("display","true")
					$("#PC_display").css("display","true")
					$("#PB_display").css("display","none")
					$("#NP_display").css("display","true")
				}else if(source_biz_type=="MPPS"){
					$("#ID_display").css("display","none")
					$("#PC_display").css("display","none")
					$("#PB_display").css("display","true")
					$("#NP_display").css("display","true")
				}else {
					$("#ID_display").css("display","none")
					$("#PC_display").css("display","none")
					$("#PB_display").css("display","true")
					$("#NP_display").css("display","none")
				}
			})
		
		})
		
		function cleanMsg(){
			$("#msg").html("");
		}
		
		function validataCommon(){
			var customerbasic_id = $("#CUSTOMERBASIC_ID").val();
			var source_biz_type = $("#SOURCE_BIZ_TYPE").val();
			var new_pin_block = $("#NEW_PIN_BLOCK").val();
			if(customerbasic_id==""){
				$("#msg").html("请输入用户编码");
				return false; 
			}
			if(source_biz_type==""){
				$("#msg").html("请选择业务系统类型");
				return false; 
			}
			if(new_pin_block==""){
				$("#msg").html("请输入新的支付密码");
				return false; 
			}
			return true;
		}
		
		function submitResult(){
			var customerbasic_id = $("#CUSTOMERBASIC_ID").val();
			var source_biz_type = $("#SOURCE_BIZ_TYPE").val();
			var id_no = $("#ID_NO").val();
			var mobile_code = $("#MOBILE_CODE").val();
			var pin_block = $("#PIN_BLOCK").val();
			var new_pin_block = $("#NEW_PIN_BLOCK").val();
			console.log(source_biz_type)
			if(source_biz_type=="SPPS"){
				var flag = validataCommon();
				if(!flag){
					return;
				}
				$.ajax({
					type:'post',
					url:'${pageContext.servletContext.contextPath }/background/system/paypassword/setPassword.html',
					dataType:'json',
					data:{customerbasic_id:customerbasic_id,source_biz_type:source_biz_type,new_pin_block:new_pin_block},
					success:function(data){
// 						data = eval('(' + data + ')');
// 						$("#msg").html(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
						$("#msg").html(data);
					}
				
				})
			
			}else if(source_biz_type=="MPPS"){
				var flag = validataCommon();
				if(!flag){
					return;
				}
				if(pin_block==""){
					$("#msg").html("请输入原支付密码");
					return; 
				}
				$.ajax({
						type:'post',
						url:'${pageContext.servletContext.contextPath }/background/system/paypassword/modifyPassword.html',
						dataType:'json',
						data:{customerbasic_id:customerbasic_id,source_biz_type:source_biz_type,new_pin_block:new_pin_block,pin_block:pin_block},
						success:function(data){
// 							data = eval('(' + data + ')');
// 							$("#msg").html(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
							$("#msg").html(data);
						}
					
					})
			}else if(source_biz_type=="FPPS"){
				var flag = validataCommon();
				if(!flag){
					return;
				}
				if(id_no==""){
					$("#msg").html("请输入身份证号");
					return; 
				}
				if(mobile_code==""){
					$("#msg").html("请输入手机验证码");
					return; 
				}
				$.ajax({
					type:'post',
					url:'${pageContext.servletContext.contextPath }/background/system/paypassword/forgetPassword.html',
					dataType:'json',
					data:{customerbasic_id:customerbasic_id,source_biz_type:source_biz_type,new_pin_block:new_pin_block,id_no:id_no,mobile_code:mobile_code},
					success:function(data){
// 						data = eval('(' + data + ')');
// 						$("#msg").html(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
						$("#msg").html(data);
					}
				
				})
			}else{
				if(customerbasic_id==""){
					$("#msg").html("请输入用户编码");
					return false; 
				}
				if(pin_block==""){
					$("#msg").html("请输入原支付密码");
					return; 
				}
				$.ajax({
					type:'post',
					url:'${pageContext.servletContext.contextPath }/background/system/paypassword/checkPassword.html',
					dataType:'json',
					data:{customerbasic_id:customerbasic_id,pin_block:pin_block},
					success:function(data){
// 						data = eval('(' + data + ')');
// 						$("#msg").html(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
						$("#msg").html(data);
					}
				
				})			
			}
			
		
		}
	
	</script>
	
</html>







