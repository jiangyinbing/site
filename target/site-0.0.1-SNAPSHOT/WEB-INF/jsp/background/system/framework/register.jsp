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
	<style type="text/css">
		.form_login2 form{ font:normal 16px/24px "Microsoft YaHei";*font-family:"Microsoft YaHei","宋体"; }
		.form_login2 form ul{ height:auto;width:auto; overflow:hidden; padding:0; clear:both;}
		.form_login2 form input{ vertical-align:middle; height:20px ;border:1px solid #0082c4; margin-bottom:10px;}
		.form_pwd{ background:#e0e0e0;}
		.form_input{ background:#fff; width:154px;}
		.form_input_yzm{  width:80px; background:#fff; }
		.form_login2 form .form_dl{ display:block; width:221px; height:32px; border:none; text-indent:-999px;}
	
		.form_login2 form{ width:350px; height:100px; margin:160px auto; border:1px solid #000; padding: 50px 50px 80px;}
		.btn{padding: 2px 10px; heigth: 15px;}
		#registerTiltel{position: relative; top: -18px;}
		.rdo_1{margin-left: 16px;}
	</style>
	<title>hb应用后台管理系统</title>
	</head>
<script type="text/javascript">
$(document).ready(function() {	
	$("#mobileNo").focus();
});
function keyDownSunmit(event){
	if(event.keyCode == 13){
	    checkRegister();
	}
}
function checkRegister(){
   var name = $("#mobileNo").val();
   var password = $("#password").val();
   var authCode = $("#verification").val();
   if(name==""){
      $("#showDiv").html("<font color='black'>请输入手机号码！</font>");
      $("#showerrorDiv").html("");
      document.getElementById("showDiv").style.display='block';
      $("#mobileNo").focus();
      return;
   }
   if(password==""){
      $("#showDiv").html("<font color='black'>请输入密码！</font>");
      $("#showerrorDiv").html("");
       document.getElementById("showDiv").style.display='block';
      $("#password").focus();
      return;
   }
   if(authCode==""){
      $("#showDiv").html("<font color='black'>请输入验证码！</font>");
      $("#showerrorDiv").html("");
       document.getElementById("showDiv").style.display='block';
      $("#verification").focus();
      return;
   }
   document.registerForm.submit();
}
function cleanDiv(div){
  $("#"+div).html("");
  if(div=='showerrorDiv'){
	  $("#showDiv").html("");  
  }
}      
</script>
<body>
<div class="form_login2">
    <form name="registerForm" method="post" action="${pageContext.servletContext.contextPath }/background/system/registerCheck.html">
    	<h2 align="center" id="registerTiltel">注册</h2>
       <ul>
           <li><label><strong>手机号码</strong></label>
           <input class="form_input" type="text"  id="mobileNo" name="mobileNo" onchange="cleanDiv('showDiv')"/></li>
           <li><label><strong>登入密码</strong></label>
           <input class="form_input mg_dty" type="password" name="password" id="password" onchange="cleanDiv('showDiv')"/></li>
           <li><label><strong>用户类型</strong>
           		<input type="radio" name="customerType" id="customerType" value="1" class="rdo_1"/>企业&nbsp;&nbsp;<input type="radio" name="customerType" id="customerType" value="2" checked="checked"/>个人</label>
           </li>
           <li><label><strong>验&nbsp;&nbsp;证&nbsp;&nbsp;码</strong>
           <input class="form_input" type="text"  id="verification" name="verification" value="" onchange="cleanDiv('showDiv')"/></label>
           <input type="button" value="获取验证码" class="btn" /> </li>
<!--           <li><input class="form_dl" type="button" value="注册" onclick="checkRegister();" /></li>-->
           <li align="center"><input class="btn" type="button" value="注册" onclick="checkRegister();" /></li>
           <li>
			<div id="showDiv" style="display: none; margin-left: 70px; font-weight:bold;"></div> 
			<div id="showerrorDiv" style="margin-left: 70px; color:red;">${error}</div>
		   </li>
       </ul>
   </form>
</div>
</body>
</html>