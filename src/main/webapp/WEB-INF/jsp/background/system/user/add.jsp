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
						现在的位置:
						<a href="#">用户管理</a> >>
						<a href="#">添加用户</a>
					</div>
					<!--列表内容 -->
					<table class="table_style table_font_center" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td height="30" colspan="4">
									<h2>
										用户信息
									</h2>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right">
										用户名：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input data-validator-group="customValidatorGroupName" data-validator-required="请输入用户名."  style="height: 20px; width: 200px" name="userName" />
										*用户登录的名称 默认密码 666666
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right">
										QQ：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="userQQ" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right">
										昵称：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="userNickname" />
									</div>
								</td>
<!--								<td height="30" width="10%">-->
<!--									<div align="right">-->
<!--										真实姓名：-->
<!--									</div>-->
<!--								</td>-->
<!--								<td>-->
<!--									<div align="left" style="padding-left: 10px;">-->
<!--										<input style="height: 20px; width: 200px" name="userRealname" data-validator-group="customValidatorGroupName" data-validator-required="请输入真实名字."/>-->
<!--									</div>-->
<!--								</td>-->
									<td height="30" width="10%">
									<div align="right">
										邮箱：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="userMail" data-validator-group="customValidatorGroupName" data-validator-required="请输入email." data-validator-email="email格式不对." />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right">
										年龄：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="userAge" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right">
										性别：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="userSex" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right">
										地址：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="userAddress" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right">
										电话：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="userPhone" />
									</div>
								</td>
							</tr>
							<tr>
							
								<td height="30" width="10%">
									<div align="right">
										备注：
									</div>
								</td>
								<td colspan="3">
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="mark" />
									</div>
								</td>
							</tr><!-- 
							<tr>
								<td height="30" width="10%">
									<div align="right">
										QQ：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="userQQ" />
									</div>
								</td>
								
								<td height="30" width="10%">
									<div align="right">
										用户状态：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input type="radio" name="status" value="待审核"
											checked="checked" />
										：待审核
										<input type="radio" name="status" value="审核通过" />
										：审核通过
									</div>
								</td>
							</tr> --><!-- 
							<tr>
								<td height="30" width="10%">
									<div align="right">
										级别：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="level"
											readonly="readonly" value="1" />
									</div>
								</td>
								<td height="30" width="13%">
									<div align="right">
										上级代理用户名编号：
									</div>
								</td>
								<td>
									<div align="left" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="parentNumber"
											readonly="readonly" value="${userSession.userId }" />
									</div>
								</td>
							</tr>-->
							<tr>
								<td colspan="4" style="padding: 10px">
									<div align="center">
										<input type="submit" value="　保　存　" class="btn" onclick="return validate('customValidatorGroupName');"/>
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






