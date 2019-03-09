<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="../../common/common-js.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link id="cssMiddle" type="text/css" rel="stylesheet"
			href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css"
			media="all" />
		<title>实名验证</title>
	</head>
	<style>
input
</style>

	<body>

		<div class="main_page">
			<div class="main_con">
				<div class="position">
					现在的位置:
					<a href="#">业务办理</a> >>
					<a href="#">实名验证</a>
				</div>

				<div style="height:200px">
					<b id="msg">您已经进行过实名验证。</b>
				</div>
			</div>
		</div>
	</body>

</html>







