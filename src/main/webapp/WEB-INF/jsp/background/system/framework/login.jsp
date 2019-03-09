<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<LINK href="${pageContext.servletContext.contextPath }/css/login.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery-1.4.min.js"></script>
	<title>hb应用后台管理系统</title>
	</head>
<script type="text/javascript">
$(document).ready(function() {	
	$("#name").focus();
});
function keyDownSunmit(event){
	if(event.keyCode == 13){
	    checkLogin();
	}
}
function checkLogin(){
   var name = $("#name").val();
   var password = $("#password").val();
   var authCode = $("#authCode").val();
   if(name==""){
      $("#showDiv").html("<font color='black'>请输入用户名！</font>");
      document.getElementById("showDiv").style.display='block';
      $("#name").focus();
      return;
   }
   if(password==""){
      $("#showDiv").html("<font color='black'>请输入密码！</font>");
       document.getElementById("showDiv").style.display='block';
      $("#password").focus();
      return;
   }
   if(authCode==""){
      $("#showDiv").html("<font color='black'>请输入验证码！</font>");
       document.getElementById("showDiv").style.display='block';
      $("#authCode").focus();
      return;
   }
   document.loginForm.submit();
}
function cleanDiv(div){
  $("#"+div).html("");
  if(div=='showerrorDiv'){
	  $("#showDiv").html("");  
  }
}      
function doRegister(){
	location.href="register.jsp";
}
</script>
<body onkeydown="keyDownSunmit(event);">
<div id="div_logo">
	<p style="width:500px; height:80px;position:absolute;">
		<img src="${pageContext.servletContext.contextPath }/images/logo.png" style="width: auto;height: auto;max-width: 100%;max-height: 100%;">
	</p>
</div>
<div class="form_login">
    <form name="loginForm" method="post" action="${pageContext.servletContext.contextPath }/background/system/loginCheck.html">
       <ul>
           <li><label><strong>用户名</strong>
           <input class="form_input" type="text"  id="name" name="username" onchange="cleanDiv('showDiv')"/></label>&nbsp;&nbsp;&nbsp;
           <a href="${pageContext.servletContext.contextPath }/background/system/register.html" style="text-decoration: none;" target="_blank">立即注册</a></li>
           <li><label><strong>密&nbsp;&nbsp;&nbsp;码</strong>
           <input class="form_input mg_dty" type="password" name="password" id="password" onchange="cleanDiv('showDiv')"/></label></li>
           <li>
            <label>
            <strong>验证码</strong>
            <input type="text" name="authCode" id="authCode" class="form_input_yzm" onchange="cleanDiv('showerrorDiv')" />
            <img src="<%=basePath%>authCode.jsp" width="66" height="20" onclick="this.src='<%=basePath%>authCode.jsp?'+Math.random();" />
            </label>
           </li>
           <li><input class="form_dl" type="button" value="登录"  onclick="checkLogin();" /></li>
           <li>
			<div id="showDiv" style="display: none;margin-left: 70px; font-weight:bold;"></div> 
			<div id="showerrorDiv" style="margin-left: 70px; font-weight:bold;">${error}</div>
		   </li>
       </ul>
       
<!--		<a href="${pageContext.servletContext.contextPath }/makeOrder.jsp">创建订单</a>-->
				
   </form>
</div>
<div><a></a></div>
</body>
</html>