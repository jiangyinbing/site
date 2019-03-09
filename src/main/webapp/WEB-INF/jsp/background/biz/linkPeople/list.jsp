<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<%@include file="../../../common/common-js.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
	<title>联系人信息列表</title>
	</head>

	<body>
		<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/system/resources/query.html" method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">联系人信息</a>
						>>
						<a href="#">联系人列表</a>
					</div>
					<!-- 按条件查询部分 -->
					<!--
					<table class="table_style" width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr align="left">
								<td align="left">
								联系人名字：<input type="text" name="link" value="${param.userName}" />　　
								关系：<input type="text" name="linkrelation" value="${param.userNickname}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								手机：<input type="text" name="linkmobile" value="${param.userNickname}" />
								<input type="submit" value="开始查询" class="btn" />&nbsp;&nbsp;
								<input type="button" value="重置" class="btn" onclick="clearText()"/>
								</td>
							</tr>
						</tbody>
					</table>
					-->
					<!-- 按钮内容 -->
					<div style="height: 30px">	
						<a class="btn" href="${pageContext.servletContext.contextPath }/biz/bussiness/linkpeople/addLinkpeople.html">新增</a>
					</div>
					<!-- 列表内容 -->
					<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td width="3%" class="tit_top_bg"><input id="choseAll" type="checkbox" name="checkbox" onclick="selectAllCheckBox()" /></td>
								<td width="30%" class="tit_top_bg">联系人姓名</td>
								<td width="27%" class="tit_top_bg">

								     <c:if test="${customerType=='1'}">职位</c:if>
								     <c:if test="${customerType=='2'}">关系</c:if>    
								</td>
								<td width="40%" class="tit_top_bg">联系人电话</td>
							</tr>
							<c:forEach var="res" items="${lst}">
								<tr>
								  <td height="20" >
								    <input type="checkbox" name="check" value="${res.linkmanId}" />
								  </td>
								  <td height="20" >${res.name}</td>
								  <td height="20" >
									     <c:choose>
										  	<c:when test="${res.relationship=='C'}">配偶</c:when> 
										  	<c:when test="${res.relationship=='F'}">父亲</c:when> 
										  	<c:when test="${res.relationship=='M'}">母亲</c:when> 
										  	<c:when test="${res.relationship=='B'}">兄弟</c:when> 
										  	<c:when test="${res.relationship=='S'}">姐妹</c:when> 
										  	<c:when test="${res.relationship=='L'}">亲属</c:when> 
										  	<c:when test="${res.relationship=='W'}">同事</c:when> 
										  	<c:when test="${res.relationship=='H'}">子女</c:when> 
											<c:when test="${res.relationship=='T'}">同学</c:when> 
										  	<c:when test="${res.relationship=='Y'}">朋友</c:when> 
										  	<c:when test="${res.relationship=='I'}">本人</c:when> 
										  	<c:when test="${res.relationship=='O'}">其他</c:when> 
											<c:otherwise>
													${res.relationship}
											</c:otherwise>	
										</c:choose>
								  </td>
								  <td height="20" >${res.mobileNo}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- 分页 -->
				</div>
			</div>	
		</form>
		<p>${tip}</p>
	</body>
</html>
