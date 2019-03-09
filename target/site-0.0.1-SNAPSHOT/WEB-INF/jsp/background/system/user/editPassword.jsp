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
		<title>修改密码</title>
	</head>
	<body>
		<form action="${pageContext.servletContext.contextPath }/background/system/editPassword.html" method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">修改密码</a> 
					</div>
					<!--列表内容 -->
					<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody>
			<tr>
				<td height="30"
					 colspan="2">
					<h2>修改密码 </h2>
				</td>
			</tr>
				<tr>	
					<td height="30"width="20%" >
						<div align="right"  >
								请输入旧密码：
						</div>
					</td>
					<td >
						<div align="left"   style="padding-left:10px;">
							 <input style="height: 20px;width: 200px" id="oldpassword" name="oldpassword" type="password" data-validator-group="customValidatorGroupName" data-validator-required="请输入旧密码."/>
							 <span style="color: red">${msg}</span>
						</div>
					</td>
				</tr>
				<tr>	
					<td height="30"width="20%" >
						<div align="right"  >
								请输入新密码：
						</div>
					</td>
					<td >
						<div align="left"   style="padding-left:10px;">
							 <input style="height: 20px;width: 200px" id="onePass" name="newPassword" type="password" data-validator-group="customValidatorGroupName" data-validator-required="请输入新密码." data-validator-regular="密码长度必须大于或等于六位." data-validator-validexpress=".{6,}"/>
						</div>
					</td>
				</tr>
				<tr>	
					<td height="30"width="20%" >
						<div align="right"  >
								请确认新密码：
						</div>
					</td>
					<td >
						<div align="left"   style="padding-left:10px;">
						<input style="height: 20px;width: 200px" id="twoPass"  type="password" data-validator-group="customValidatorGroupName" data-validator-required="请确认您要修改的密码." data-validator-compare="两次密码不一致." data-validator-compareto="onePass" />
						</div>
					</td>
				</tr>

				<tr>
					<td colspan="2" style="padding: 10px">
						<div align="center">
			 				<input type="submit" value="　保　存　" class="btn" onclick="return validate('customValidatorGroupName');"/>　　　　
			 				<input id="backBt" type="button" value="　返　回　" class="btn" onclick="javascript:window.location.href='javascript:history.go(-1)'"/>
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







