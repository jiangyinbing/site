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
	 var url = "${pageContext.servletContext.contextPath }/background/system/resources/permissioRole.html?roleId="+id;
	 var h_sp1 = 400;
	 var w_sp1 = 350;
	//兼容IE，firefox,google.模态窗口居中问题
	 var iTop2 = (window.screen.availHeight - 20 - h_sp1) / 2;
	 var iLeft2 = (window.screen.availWidth - 10 - w_sp1) / 2;
	 var params = 'menubar:no;dialogHeight=' + h_sp1 + 'px;dialogWidth=' + w_sp1 + 'px;dialogLeft=' + iLeft2 + 'px;dialogTop=' + iTop2 + 'px;resizable=yes;scrollbars=0;resizeable=0;center=yes;location:no;status:no;scroll:no'
	
	 if(navigator.userAgent.indexOf("Chrome") >0 ){
		  window.open(url,window, params);//谷歌浏览器不支持showModalDialog事件
    }else{
    	 window.showModalDialog(url, window, params);
    	
    }
	 
	 
	 //location.href=url;
}
</script>
<body>
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/system/role/query.html" method="post">
<div class="main_page">
<div class="main_con">
<div class="position">
现在的位置:
<a href="#">角色管理</a>
>>
<a href="#">角色列表</a>
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
	  <sec:authorize ifAnyGranted="ROLE_sys_role_add">
	  	<a class="btn" href="${pageContext.servletContext.contextPath }/background/system/role/addUI.html">新增</a>
	  </sec:authorize>
</div>
<!--列表内容 -->
<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr>
	<td width="3%" class="tit_top_bg"><input id="choseAll" type="checkbox" name="checkbox" onclick="selectAllCheckBox()" /></td>
	<td width="15%"class="tit_top_bg">角色名</td>
	<td width="15%" class="tit_top_bg">角色KEY</td>
	<td width="5%"class="tit_top_bg" >是否禁用</td>
	<td width="15%" class="tit_top_bg">描述</td>
	<td width="20%" class="tit_top_bg">操作</td>
</tr>
<c:forEach var="role" items="${pageView.records}">
<tr>
  <td height="20" ><input type="checkbox" name="check" value="${role.id}" /></td>
  <td height="20" >${role.name}</td>
  <td height="20" >${role.roleKey}</td>
  <td height="20" >
  <c:if test="${role.enable eq '0'}">
  <font color="red">禁用</font>
  </c:if>
  <c:if test="${role.enable eq '1'}">
  <font color="blue">正常</font>
  </c:if>
  </td>
  <td height="20" >${role.description}</td>
  <td height="20" ><span class="STYLE4">
  <sec:authorize ifAnyGranted="ROLE_sys_role_permissions">
   <img src="${pageContext.servletContext.contextPath }/images/resc.png" width="16" height="16" />
 	<a href="javascript:void(0);" onclick="permissio('${role.id}')">分配权限</a>&nbsp;&nbsp;&nbsp;&nbsp;
  </sec:authorize>
  <sec:authorize ifAnyGranted="ROLE_sys_role_show">
   <img src="${pageContext.servletContext.contextPath }/images/search_btn.gif" width="16" height="16" />
 	<a href="${pageContext.servletContext.contextPath }/background/system/role/getById.html?roleId=${role.id}&typeKey=0">显示详细信息</a>
 	&nbsp;&nbsp;
 </sec:authorize>
 <sec:authorize ifAnyGranted="ROLE_sys_role_edit">
  <img src="${pageContext.servletContext.contextPath }/images/edt.gif" width="16" height="16" />
  <a href="${pageContext.servletContext.contextPath }/background/system/role/getById.html?roleId=${role.id}&typeKey=1">编辑</a>
 &nbsp; &nbsp;
 </sec:authorize>
 <sec:authorize ifAnyGranted="ROLE_sys_role_delete">
 <img src="${pageContext.servletContext.contextPath }/images/del.gif" width="16" height="16" />
 	<a href="javascript:void(0);" onclick="deleteId('${pageContext.servletContext.contextPath }/background/system/role/deleteById.html?roleId=${role.id}')">删除</a>
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
