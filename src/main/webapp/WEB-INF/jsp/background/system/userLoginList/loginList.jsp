<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../../../common/common-js.jsp" %>
<%@include file="../../../common/validator.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
<title>资源管理</title>
</head>
<body>
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/system/userLoginList/query.html" method="post" enctype="multipart/form-data">
<div class="main_page">
<div class="main_con">
<div class="position">
现在的位置:
<a href="#">登陆信息管理</a>
>>
<a href="#">登陆信息列表</a>
</div>
<table class="table_style" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr align="left">
<td align="left">
用户名：<input type="text" name="userName" value="${param.userName}" />
登录时间：<input value="${param.loginTime}" name="loginTime"  type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />　　
<input type="submit" value="开始查询" class="btn"/>&nbsp;&nbsp;
<input type="reset" value="重置" class="btn"/>
</td>
</tr>
</tbody>
</table>
<!-- 按钮内容 -->
<div style="height: 30px">
	  <sec:authorize ifAnyGranted="ROLE_sys_login_export">
	  	<a class="btn" href="javascript:void(0);" onclick="replaceURL('exportExcel.html')"><!-- 调用commont-js.jsp -->
	  	导出</a><input type="text" name="expPageSize"  size="5"/>条
	  </sec:authorize>
	  <sec:authorize ifAnyGranted="ROLE_sys_login_import">
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       <a class="btn" href="javascript:void(0);" onclick="if(validate('customValidatorGroupName')){replaceURL('readExcel.html')};">导入</a> 
	       <input id="file" type="file" name="file" data-validator-group="customValidatorGroupName" data-validator-required="请选择正确的文件."  data-validator-excel="请选择正确格式的文件."/>  
      </sec:authorize>
</div>
<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr>
<td width="5%" class="tit_top_bg" >登陆ID</td>
<td width="5%" class="tit_top_bg" >用户ID</td>
<td width="12%" class="tit_top_bg" >用户名</td>
<td width="12%" class="tit_top_bg" >登陆时间</td>
<td width="15%" class="tit_top_bg" >登陆IP</td>
</tr>
<c:forEach var="loginList" items="${pageView.records}">
<tr>
<td height="20" >${loginList.loginId}</td>
<td height="20" >${loginList.userId}</td>
<td height="20" >${loginList.userName}</td>
<td height="20" ><fmt:formatDate value="${loginList.loginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<td height="20" >${loginList.loginIp}</td>
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







