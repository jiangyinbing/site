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
						<a href="#">角色管理</a> >>
						<a href="#">查看角色</a>
					</div>
					<!--列表内容 -->
					<table class="table_style table_font_center" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tbody>
			<tr>
				<td height="30"
					 colspan="2">
					<h2>角色信息</h2>
				</td>
			</tr>
				<tr>	
					<td height="30"width="20%" >
						<div align="right"  >
								角色名：
						</div>
					</td>
					<td >
					    <div align="left"  >
						 ${role.name}
						 </div>
					</td>
				</tr>
				<tr>	
					<td height="30"width="20%" >
						<div align="right"  >
								角色roleKey：
						</div>
					</td>
					<td align="left">
						<div align="left"  >${role.roleKey}</div>
					</td>
				</tr>
				<tr>	
					<td height="30"width="20%" >
						<div align="right"  >
								是否禁用：
						</div>
					</td>
					<td >
					   <div  align="left">
						<c:if test="${role.enable eq '0'}">禁用</c:if>　　
						<c:if test="${role.enable eq '1'}">正常</c:if>
						</div>
					</td>
				</tr>
<tr>	
	<td height="30"width="20%" >
		<div align="right"  >
				描述：
		</div>
	</td>
	<td >
		<div align="left"  >${role.description}</div>
	</td>
</tr>
				<tr>
					<td colspan="2" style="padding: 10px">
						<div align="center">　　　
			 				<input id="backBt" type="button" value="　返　回　" class="btn" onclick="javascript:window.location.href='javascript:history.go(-1)'"/>
		 				</div>
					</td>
				</tr>
				</tbody>
		</table>
				</div>
			</div>
	</body>
</html>







