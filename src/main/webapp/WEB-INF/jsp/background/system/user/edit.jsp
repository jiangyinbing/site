<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../../../common/common-js.jsp" %>
<%@include file="../../../common/validator.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />

<title>资源管理</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath }/background/system/user/update.html" method="post">
<div class="main_page">
<div class="main_con">
<div class="position">
现在的位置:
<a href="#">用户管理</a>
>>
<a href="#">修改用户</a>
</div>
<!--列表内容 -->
<input type="hidden" name="userId" value="${user.userId}">
<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" colspan="4">
			<h2>用户信息</h2>
			</td>
		</tr>
		<tr>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">用户名：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 100px" name="userName" data-validator-group="customValidatorGroupName" data-validator-required="请输入用户名." value="${user.userName}"/>
					　　　所属角色：<select name="roleId">
					<option value="">选择角色</option>
					<c:forEach var="key" items="${roles}">
						<option value="${key.id}" <c:if test="${key.name eq user.roleName}">selected="selected"</c:if>>${key.name}</option>
					</c:forEach>
				</select>
				</div>
			</td>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">QQ：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userQQ" value="${user.userQQ}"/>
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">昵称：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userNickname" value="${user.userNickname}"/>
				</div>
			</td>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">真实姓名：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px;display: none" name="userRealname"  data-validator-group="customValidatorGroupName" data-validator-required="请输入真实名字." value="${user.userRealname}"/>
				     ${user.userRealname}
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">年龄：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userAge" value="${user.userAge}"/>
				</div>
			</td>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">性别：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userSex" value="${user.userSex}"/>
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">地址：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userAddress" value="${user.userAddress}"/>
				</div>
			</td>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">电话：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userPhone" value="${user.userPhone}"/>
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">邮箱：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userMail" value="${user.userMail}" data-validator-group="customValidatorGroupName" data-validator-required="请输入email." data-validator-email="email格式不对." />
				</div>
			</td>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">备注：</div></td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="mark"  value="${user.mark}"/>
				</div>
			</td>
		</tr><!-- 
		<tr>
			<td height="30" width="10%">
				<div align="right" class="STYLE1">QQ：</div>
			</td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userQQ" value="${user.userQQ}"/>
				</div>
			</td>
			<!--  
			<td height="30" width="10%">
				<div align="right" class="STYLE1">用户状态：</div></td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input type="radio" name="status" value="待审核" <c:if test="${user.status eq '待审核'}">checked="checked"</c:if>/>：待审核
					<input type="radio" name="status" value="审核通过" <c:if test="${user.status eq '审核通过'}">checked="checked"</c:if>/>：审核通过
				</div>
			</td>
		</tr>-->
		<!--  
		<tr>
		<td height="30" width="10%">
				<div align="right" class="STYLE1">级别：</div></td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="level" readonly="readonly" value="${user.level}"/>
				</div>
			</td>
					<td height="30" width="13%">
						<div align="right" class="STYLE1">上级代理用户名编号：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="parentNumber"
								readonly="readonly" value="${user.parentNumber}"/>
						</div>
					</td>
		</tr>
		-->
		<tr>
			<td colspan="4" style="padding: 10px">
				<div align="center">
					<input type="submit" value="　保　存　" class="btn" onclick="return validate('customValidatorGroupName');"/> 
					<input id="backBt" type="button" value="　返　回　" class="btn" onclick="javascript:window.location.href='javascript:history.go(-1)'" />
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







