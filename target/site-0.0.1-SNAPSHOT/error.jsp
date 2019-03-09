<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.Exception"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />

<title>错误页面</title>
</head>
<body>
<div class="main_page">
<div class="main_con" align="center">
<h1>出错了!<a href="javascript:window.location.href='javascript:history.go(-1)'">点击返回</a></h1>
<%
Exception e = (Exception)request.getAttribute("exception");
out.print(e.getMessage());
%>
</div>
</div>
</body>
</html>





