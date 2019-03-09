<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../../../common/common-js.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />

<title>资源管理</title>
</head>
<body>
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/system/log/query.html" method="post">
<div class="main_page">
<div class="main_con">
<div class="position">
现在的位置:
<a href="#">操作日志管理</a>
>>
<a href="#">操作日志记录</a>
</div>
<table class="table_style" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr align="left">
<td align="left">
用户名：<input type="text" name="username" value="${param.username}" />　　
模块：<input type="text" name="module" value="${param.module}" />　
<input type="submit" value="开始查询" class="btn"/>&nbsp;&nbsp;
<input type="reset" value="重置" class="btn"/>
</td>
</tr>
</tbody>
</table>
<!--列表内容 -->
<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr>
<td width="5%" class="tit_top_bg" >用户名</td>
<td width="5%" class="tit_top_bg" >模块</td>
<td width="12%" class="tit_top_bg" >执行操作</td>
<td width="12%" class="tit_top_bg" >花费时间</td>
<td width="15%" class="tit_top_bg" >执行时间</td>
<td width="15%" class="tit_top_bg" >用户ＩＰ</td>
</tr>
<c:forEach var="log" items="${pageView.records}">
<tr>
<td height="20" >${log.username}</td>
<td height="20" >${log.module}</td>
<td height="20" >${log.action}</td>
<td height="20" >${log.actionTime}</td>
<td height="20" ><fmt:formatDate value="${log.operTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<td height="20" >${log.userIP}</td>
</tr>
</c:forEach>
</tbody>
</table>
<!-- 分页 -->
<%@include file="/WEB-INF/jsp/common/webfenye.jsp" %>
</div>
</div>
</form>
</body>
</html>





