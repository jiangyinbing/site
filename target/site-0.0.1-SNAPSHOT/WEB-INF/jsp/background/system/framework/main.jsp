<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
<%@include file="../../../common/common-js.jsp" %>
<meta charset="utf-8" />
<title>hb应用后台管理系统</title>
<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
<style>
*{margin:0; padding:0}
body, html{ height:100%; width:100%; overflow:hidden;} /*这个高度很重要*/
body {
	margin: 0px;
	font-size:12px;
}
.clear{ 
	clear:both;
	}
#select{ 
	text-align:right;
	}
#select p{ 
	float:right; 
	line-height:36px; 
	color:#fff;
	}
#select a{ 
	display:inline;
	width:12px;
	height:12px; 
	border:1px solid #666; 
	float:right;
	margin:10px 10px;
	 }
#select a.green{ 
	background:#5FC876;
	}
#select a.blue{ 
	background:#29A3CA;
	}
.change_skin{
	position:absolute;
	top:10px;
	right:10px;
}
</style>
<script>
	function styleChange(n) {
	    var cssPath = "${pageContext.servletContext.contextPath }/css/public_index"+n+".css";
			    itop.document.getElementById("cssTop").href = cssPath;
			    ileft.document.getElementById("cssLeft").href = cssPath;
			    main.document.getElementById("cssMiddle").href = cssPath;
		$.ajax({
			url : "${pageContext.servletContext.contextPath}/background/system/styleChange.html",
			type : 'POST',
			dataType : 'html',
			data: {"style":n},  
			timeout : 10000,
			error : function(rs) {
			},
			success : function(){
		    }
	    });
	    
	}
</script>

</head>
<body style="position:relative;">
<!--<div class="change_skin">-->
<!--            	<div id="select" class="select">-->
<!--                    <a href="javascript:void(0);" onclick="styleChange(1)" class="green"></a>-->
<!--                    <a href="javascript:void(0);" onclick="styleChange(2)" class="blue"></a>-->
<!--                    <p>请挑选我的颜色：</p>-->
<!--                    <div class="clear"></div>-->
<!--                  </div>-->
<!--            </div>-->
            <!--End_change_skin-->
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" height="90">
			<iframe id="itop" name="itop" src="${pageContext.servletContext.contextPath }/background/system/top.html" frameborder="0" width="100%" height="90"  scrolling="no"></iframe>
		</td>
	</tr>
	<tr>
		<td valign="top" width="200" height="100%"> <!--这个高度很重要-->
			<iframe id="ileft" name="ileft" src="${pageContext.servletContext.contextPath }/background/system/left.html" frameborder="0" width="200"  height="100%" scrolling="auto"></iframe>
		</td>
		<td valign="top" width="auto" height="100%"> <!--这个高度很重要-->
			<iframe id="main" name="main"  src="${pageContext.servletContext.contextPath }/background/system/center.html" width="100%" allowtransparency="true" height="100%" frameborder="0" scrolling="auto" style="overflow:visible;"></iframe>
		</td>
	</tr>
</table>
</body>


</html>
