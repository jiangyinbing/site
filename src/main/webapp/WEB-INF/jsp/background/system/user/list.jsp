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
<script type="text/javascript">
function permissio(id){
	 var url = "${pageContext.servletContext.contextPath }/background/system/resources/permissioUser.html?userId="+id;
	 var h_sp1 = 400;
	 var w_sp1 = 350;
	//兼容IE，firefox,google.模态窗口居中问题
	 var iTop2 = (window.screen.availHeight - 20 - h_sp1) / 2;
	 var iLeft2 = (window.screen.availWidth - 10 - w_sp1) / 2;
	 var params = 'menubar:no;dialogHeight=' + h_sp1 + 'px;dialogWidth=' + w_sp1 + 'px;dialogLeft=' + iLeft2 + 'px;dialogTop=' + iTop2 + 'px;resizable=yes;scrollbars=0;resizeable=0;center=yes;location:no;status:no;scroll:no'
	 window.showModalDialog(url, window, params);
	 //location.href=url;
}
function userRole(id){
	 var url = "${pageContext.servletContext.contextPath }/background/system/user/userRole.html?userId="+id;
	 var h_sp1 = 420;
	 var w_sp1 = 600;
	//兼容IE，firefox,google.模态窗口居中问题
	 var iTop2 = (window.screen.availHeight - 20 - h_sp1) / 2;
	 var iLeft2 = (window.screen.availWidth - 10 - w_sp1) / 2;
	 var params = 'menubar:no;dialogHeight=' + h_sp1 + 'px;dialogWidth=' + w_sp1 + 'px;dialogLeft=' + iLeft2 + 'px;dialogTop=' + iTop2 + 'px;resizable=yes;scrollbars=0;resizeable=0;center=yes;location:no;status:no;scroll:no'
	 window.showModalDialog(url, window, params);
	 //location.href=url;
}
</script>
<body>
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/system/user/query.html" method="post">
<div class="main_page">
<div class="main_con">
<div class="position">
现在的位置:
<a href="#">用户管理</a>
>>
<a href="#">用户列表</a>
</div>
<table class="table_style" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr align="left">
<td align="left">
用户名：<input type="text" name="userName" value="${param.userName}" />　　
昵称：<input type="text" name="userNickname" value="${param.userNickname}" />
<input type="submit" value="开始查询" class="btn" />&nbsp;&nbsp;
<input type="button" value="重置" class="btn" onclick="clearText()"/>
</td>
</tr>
</tbody>
</table>
<!-- 按钮内容 -->
<div style="height: 30px">
	  <sec:authorize ifAnyGranted="ROLE_sys_user_addUI">
	  	<a class="btn" href="${pageContext.servletContext.contextPath }/background/system/user/addUI.html">新增</a>
	  </sec:authorize>
</div>
<!--列表内容 -->
<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr>
	<td width="3%" class="tit_top_bg"><input id="choseAll" type="checkbox" name="checkbox" onclick="selectAllCheckBox()" /></td>
    <td width="10%" height="22" class="tit_top_bg" >用户名</td>
    <td width="10%" height="22" class="tit_top_bg" >所属角色</td>
    <td width="10%" height="22" class="tit_top_bg" >昵称</td>
    <td width="10%" height="22" class="tit_top_bg" >注册时间</td>
    <td width="10%" height="22" class="tit_top_bg" >最后登录时间</td>
    <td width="3%" height="22" class="tit_top_bg" >等级</td>
	<td width="35%" class="tit_top_bg">操作</td>
</tr>
<c:forEach var="key" items="${pageView.records}">
<tr>
<td height="20" ><input type="checkbox" name="check" value="${key.userId}" /></td>
<td height="20" ><a href="${pageContext.servletContext.contextPath }/background/system/user/getById.html?userId=${key.userId}&type=0">${key.userName}</a></td>
<td height="15" ><span  style="color: blue;">${key.roleName}</td>
<td height="15" >${key.userNickname}</td>
<td height="15" >
<fmt:parseDate value="${key.regTime}" var="date" pattern="yyyy-MM-dd" />
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
</td>
<td height="12" >
<fmt:parseDate value="${key.lastLogintime}" var="date" pattern="yyyy-MM-dd" />
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
</td>
<td height="20" >${key.level}</td>
<td height="30" >
	<sec:authorize ifAnyGranted="ROLE_sys_user_fenpeirole">
	<img src="${pageContext.servletContext.contextPath }/images/role.png" width="16" height="16" />
	<a href="javascript:void(0);" onclick="userRole('${key.userId}')">分配角色</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</sec:authorize>
<!--	<sec:authorize ifAnyGranted="ROLE_sys_user_permissions">-->
<!--	<img src="${pageContext.servletContext.contextPath }/images/resc.png" width="16" height="16" />-->
<!--	<a href="javascript:void(0);" onclick="permissio('${key.userId}')">分配权限</a>&nbsp;&nbsp;&nbsp;&nbsp;-->
<!--	</sec:authorize>-->
	<sec:authorize ifAnyGranted="ROLE_sys_user_edit">
	<img src="${pageContext.servletContext.contextPath }/images/edt.gif" width="16" height="16" />
	<a href="${pageContext.servletContext.contextPath }/background/system/user/getById.html?userId=${key.userId}&type=1">编辑</a>
	&nbsp; &nbsp;
	</sec:authorize>
	<sec:authorize ifAnyGranted="ROLE_sys_user_reset">
	<img src="${pageContext.servletContext.contextPath }/images/edt.gif" width="16" height="16" />
	<a href="javascript:void(0);" onclick="deleteId('${pageContext.servletContext.contextPath }/background/system/user/reset.html?userId=${key.userId}','确定要初始化密码？初始化后密码666666');">初始化密码</a>
	</sec:authorize>
	<sec:authorize ifAnyGranted="ROLE_sys_user_delete">
	<img src="${pageContext.servletContext.contextPath }/images/del.gif" width="16" height="16" />
	<a href="javascript:void(0);" onclick="deleteId('${pageContext.servletContext.contextPath }/background/system/user/deleteById.html?userId=${key.userId}');">删除</a>
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
