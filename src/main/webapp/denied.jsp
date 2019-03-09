<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
<title>没权限</title> 
<style type="text/css"> 
/* 注意、警告框 */
.attention {
	background: #FFFBCC;
	border: 1px #E6DB55 solid;
	color: #333;
	margin: 10px;
	padding: 8px 8px 8px 35px;
	line-height: 22px;
	font-size: 12px;
}
/* 圆角，CSS3支持 */
</style>
</head>
<body>
<div class="main_page">
<div class="main_con" align="center">
<DIV class="attention">
			你没权限操作此功能，请联系管理员！！
</div>
</div>
</div>
</body>
</html>





