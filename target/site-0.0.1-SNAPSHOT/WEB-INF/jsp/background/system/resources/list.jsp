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
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/system/resources/query.html" method="post">
<div class="main_page">
<div class="main_con">
<div class="position">
现在的位置:
<a href="#">资源管理</a>
>>
<a href="#">资料列表</a>
</div>
<table class="table_style" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr align="left">
<td align="left">
名称：<input type="text" name="name" value="${param.name}" />
<input type="submit" value="开始查询" class="btn" />&nbsp;&nbsp;
<input type="button" value="重置" class="btn" onclick="clearText()"/>
</td>
</tr>
</tbody>
</table>
<!-- 按钮内容 -->
<div style="height: 30px">
	  <sec:authorize ifAnyGranted="ROLE_sys_resc_addUI">
	  	<a class="btn" href="${pageContext.servletContext.contextPath }/background/system/resources/addUI.html">新增</a>
	  </sec:authorize>
</div>
<!--列表内容 -->
<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr>
	<td width="3%" class="tit_top_bg"><input id="choseAll" type="checkbox" name="checkbox" onclick="selectAllCheckBox()" /></td>
	<td width="8%"class="tit_top_bg">资源名</td>
	<td width="10%" class="tit_top_bg">资源KEY</td>
	<td width="20%"class="tit_top_bg" >资源URL</td>
	<td width="8%" class="tit_top_bg">资源类型</td>
	<td width="5%" class="tit_top_bg">优先级</td>
	<td width="10%" class="tit_top_bg">上级资源</td>
	<td width="23%" class="tit_top_bg">操作</td>
</tr>
<c:forEach var="resources" items="${pageView.records}">
<tr>
  <td height="20" >
    <input type="checkbox" name="check" value="${resources.id}" />
  </td>
  
  <td height="20" >${resources.name}</td>
  <td height="20" >${resources.resKey}</td>
  <td height="20" >${resources.resUrl}</td>
  <td height="20" >
	  <c:if test="${resources.type eq '0'}">
	  <font color="red">目录</font>
	  </c:if>
	  <c:if test="${resources.type eq '1'}">
	  <font color="blue">菜单</font>
	  </c:if>
	  <c:if test="${resources.type eq '2'}">
	        按扭
	  </c:if>
  </td>
  <td height="20" >${resources.level}</td>
  <td height="20" >${resources.parentName}</td>
  <td height="20" >
     <sec:authorize ifAnyGranted="ROLE_sys_res_show">
	  <img src="${pageContext.servletContext.contextPath }/images/search_btn.gif" width="16" height="16" />
	  	<a href="${pageContext.servletContext.contextPath }/background/system/resources/getById.html?resourcesId=${resources.id}&typeKey=0">显示详细信息</a>
	  	&nbsp;&nbsp;
	  </sec:authorize>
	  <sec:authorize ifAnyGranted="ROLE_sys_res_edit">
	  <img src="${pageContext.servletContext.contextPath }/images/edt.gif" width="16" height="16" />
	  <a href="${pageContext.servletContext.contextPath }/background/system/resources/getById.html?resourcesId=${resources.id}&typeKey=1">编辑</a>
	  &nbsp; &nbsp;
	  </sec:authorize>
	  <sec:authorize ifAnyGranted="ROLE_sys_res_delete">
	  <img src="${pageContext.servletContext.contextPath }/images/del.gif" width="16" height="16" />
	  	<a href="javascript:void(0);" onclick="deleteId('${pageContext.servletContext.contextPath }/background/system/resources/deleteById.html?resourcesId=${resources.id}')">删除</a>
	  </sec:authorize>
  </td>
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
