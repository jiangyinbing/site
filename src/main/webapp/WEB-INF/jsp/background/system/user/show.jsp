<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="../../../common/common-js.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link id="cssMiddle" type="text/css" rel="stylesheet"
			href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css"
			media="all" />

		<title>资源管理</title>
	</head>
	<body>
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">用户管理</a> >>
						<a href="#">查看用户</a>
					</div>
					<!--列表内容 -->
		<table class="table_style table_font_center" width="100%"
						border="0" cellspacing="0" cellpadding="0">
		<tbody>
				<tr>
					<td height="30" colspan="4">
						<h2>用户信息</h2>
					</td>
				</tr>
				<tr>
					<td height="30" width="20%">
						<div align="right" >用户名：</div></td>
					<td width="30%">
						<div align="left" >
							${user.userName}
						</div>
					</td>
					<td height="30" width="20%">
						<div align="right" >所属角色：</div></td>
					<td>
						<div align="left" >
							${user.roleName}
						</div></td>
				</tr>
				<tr>
					<td height="30" width="20%">
						<div align="right" >昵称：</div></td>
					<td>
						<div align="left" >
							${user.userNickname}
						</div></td>
					<td height="30" width="20%">
						<div align="right" >真实姓名：</div></td>
					<td>
						<div align="left" >
							${user.userRealname}
						</div></td>
				</tr>
				<tr>
					<td height="30" width="20%">
						<div align="right" >年龄：</div></td>
					<td>
						<div align="left" >
							${user.userAge}
						</div></td>
					<td height="30" width="20%">
						<div align="right" >性别：</div></td>
					<td>
						<div align="left" >
							${user.userSex}
						</div></td>
				</tr>
				<tr>
					<td height="30" width="20%">
						<div align="right" >地址：</div></td>
					<td>
						<div align="left" >
							${user.userAddress}
						</div></td>
					<td height="30" width="20%">
						<div align="right" >电话：</div></td>
					<td>
						<div align="left" >
							${user.userPhone}
						</div></td>
				</tr>
				<tr>
					<td height="30" width="20%">
						<div align="right" >邮箱：</div></td>
					<td>
						<div align="left" >
							${user.userMail}
						</div></td>
					<td height="30" width="20%">
						<div align="right" >备注：</div></td>
					<td>
						<div align="left" >
							${user.mark}
						</div></td>
				</tr>
				<tr>
					<td height="30" width="20%">
						<div align="right" >QQ：</div></td>
					<td>
						<div align="left" >
							${user.userQQ}
						</div></td>
					<td height="30" width="20%">
						<div align="right" >用户状态：</div></td>
					<td>
						<div align="left" >
							${user.status}
						</div></td>
				</tr>
				<tr>
				<td height="30" width="20%">
						<div align="right" >级别：</div></td>
					<td>
						<div align="left" >
							${user.level}
						</div></td>
					<td height="30" width="13%">
						<div align="right" >上级代理用户名编号：</div></td>
					<td>
						<div align="left" >
							${user.parentNumber}
						</div></td>
				</tr>
				<tr>
					<td colspan="4" style="padding: 10px">
						<div align="center">
							<input
								id="backBt" type="button" value="　返　回　" class="btn"
								onclick="javascript:window.location.href='javascript:history.go(-1)'" />
						</div></td>
				</tr>
				</tbody>
			</table>
				</div>
			</div>
	</body>
</html>







