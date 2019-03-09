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
			action="${pageContext.servletContext.contextPath }/background/system/resources/add.html"
			method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">资源管理</a> >>
						<a href="#">添加资源</a>
					</div>
					<!--列表内容 -->
					<table class="table_style table_font_center" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td height="30" colspan="2">
									<h2>
										添加资源
									</h2>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" class="STYLE1">
										上级资源：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<select name="parentId">
											<option value="1010">
												顶级菜单
											</option>
											<c:forEach var="key" items="${resources}">
												<option value="${key.id}">
													${key.name}
												</option>
											</c:forEach>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" class="STYLE1">
										资源名称：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 400px" name="name" data-validator-group="customValidatorGroupName" data-validator-required="请输入资源名称." />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" class="STYLE1">
										资源KEY：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 400px" name="resKey" data-validator-group="customValidatorGroupName" data-validator-required="请输入key,以便系统识别"  />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" class="STYLE1">
										资源URL：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 400px" name="resUrl" data-validator-group="customValidatorGroupName" data-validator-required="请输入url." />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" class="STYLE1">
										资源类型：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input name="type" type="radio" value="0" />
										:目录
										<input name="type" type="radio" value="1" />
										:菜单
										<input name="type" type="radio" value="2" />
										:按扭
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" class="STYLE1">
										优先级：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 400px" name="level" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" class="STYLE1">
										资源描述：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 400px" name="description" />
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2" style="padding: 10px">
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







