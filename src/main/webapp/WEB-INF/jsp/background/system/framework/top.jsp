<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link id="cssTop" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
<title>hb应用后台管理系统</title>
</head>

<body>
<div id="div_logo">
	<p style="width:500px; height:80px;position:absolute;">
		<img src="${pageContext.servletContext.contextPath }/images/logo.png" style="width: auto;height: auto;max-width: 100%;max-height: 100%;">
	</p>
</div>
<div class="top_bj">
    <div class="txt_right">
       <span>您好，<a href="${pageContext.servletContext.contextPath }/background/business/customerinfo/query.html" target="main" title="个人信息"> [${userSession.userName}]</a>，欢迎您登录！&nbsp;&nbsp;&nbsp;&nbsp;
             <a href="${pageContext.servletContext.contextPath }/background/system/center.html" target="main">[首页]</a>&nbsp;&nbsp;&nbsp;&nbsp;
             <a href="${pageContext.servletContext.contextPath }/background/system/toEditPassword.html"  target="main">[登录密码]</a>&nbsp;&nbsp;&nbsp;&nbsp;
             <a href="${pageContext.servletContext.contextPath }/background/system/login.html"  target="_parent">[退出]</a>
       </span>
    </div>
</div>
</body>
</html>