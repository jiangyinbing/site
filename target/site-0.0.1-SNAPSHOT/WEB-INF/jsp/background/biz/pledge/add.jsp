<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="../../../common/common-js.jsp"%>
	<%@include file="../../../common/validator.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
	<title>添加抵/质押信息</title>
	<style type="text/css">.redClass{color:red;}</style>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery-1.4.min.js"></script>
  </head>
  
  <body>
    <form name="addLinkForm" action="${pageContext.servletContext.contextPath }/biz/pledge/addPledge.html" method="post" enctype="multipart/form-data">
		<div class="main_page">
			<div class="main_con">
				<div class="position">
					现在的位置:
					<a href="#">业务列表</a> 
					>>
					<a href="#">订单列表</a>
					>>
					<a href="#">查询担保人和抵押信息</a>
					>>
					<a href="#">添加抵/质押信息</a>
				</div>
				<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td height="60" colspan="2">
								<input value="${id}" name="xj_order_id" type="hidden" />
								<h2>添加抵/质押信息</h2>
							</td>
						</tr>
						<tr>
							<td height="30" width="40%">
								<div align="right" >物品类型：</div>
							</td>
							<td>
								<div align="left"  style="padding-left: 10px;">
									<select name="good_type" id="GOOD_TYPE" style="height: 20px; width: 200px" data-validator-group="customValidatorGroupName" >
										<option value="H">房子</option>
										<option value="C">车子</option>
										<option value="O">其他</option>
									</select> 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >产权人：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="owner_name" style="height: 20px; width: 200px" name="owner_name" type="text" 
									data-validator-group="customValidatorGroupName" data-validator-required="请输入产权人." /> (必填) 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >产权人身份证号：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="cert_user_id_no" style="height: 20px; width: 200px" name="cert_user_id_no" type="text" 
									data-validator-group="customValidatorGroupName" data-validator-required="请输入产权人身份证号." /> (必填) 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >产权证号：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="CERT_NO" style="height: 20px; width: 200px" name="cert_no" type="text"
									data-validator-group="customValidatorGroupName" data-validator-required="请输入产权证号." /> (必填) 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >资产金额：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="oth_imp_amt" style="height: 20px; width: 200px" name="oth_imp_amt" type="text"
									data-validator-group="customValidatorGroupName" data-validator-required="请输入资产金额." /> (必填) 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >资产位置：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="mortgage_addres" style="height: 20px; width: 200px" name="mortgage_addres" type="text"
									data-validator-group="customValidatorGroupName" data-validator-required="请输入资产位置." /> (必填) 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >抵质押物名称：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="pledge_name" style="height: 20px; width: 200px" name="pledge_name" type="text" 
									data-validator-group="customValidatorGroupName" data-validator-required="请输入抵质押物名称." /> (必填) 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >数量：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="AREA_AMOUNT" style="height: 20px; width: 200px" name="area_amount" type="text" 
									data-validator-group="customValidatorGroupName" data-validator-required="请输入数量." /> (必填) 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >抵质押类型：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<select name="pledge_flag" id="PLEDGE_FLAG" style="height: 20px; width: 200px" data-validator-group="customValidatorGroupName" >
										<option value="P">质押</option>
										<option value="M">抵押</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >备注：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="remark" style="height: 20px; width: 200px" name="remark" type="text" 
									data-validator-group="customValidatorGroupName" data-validator-required="请输入备注." /> 
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >附件信息：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input name='upload' type='file' >
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2" style="padding: 10px">
								<div align="center">
									<input type="submit" value="　保　存　" class="btn" />
									<input id="backBt" type="button" value="　返　回　" class="btn"
										onclick="javascript:window.location.href='javascript:history.go(-1)'" />
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
  </body>
</html>
