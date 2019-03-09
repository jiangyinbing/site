<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>hb应用后台管理系统金融系统</title>
<link id="cssLeft" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery-1.4.min.js"></script>
<style>
*{font-size:0px;}
</style>
</head>

<body style="position:relative; ">
<div class="left_menu" id="L_main">
<c:forEach items="${resources}" var="key" varStatus="stut_1">
 <c:if test="${key.type eq 0 && key.parentId eq 1010}">
       <div class="tree_box">
        <h3><img src="${pageContext.servletContext.contextPath }/images/icon-${key.level}.png" width="25" height="20"  alt="" />${key.name}</h3>
        <ul class="tree_one" style="display:none">
            <c:forEach items="${resources}" var="two" varStatus="stut_2">
            <c:if test="${two.parentId eq key.id && two.type eq 0}">
            <li>
              
                <h4>${two.name}</h4>
                <ul class="tree_two">
                  <c:forEach items="${resources}" var="three" varStatus="stut_3">
                   <c:if test="${three.parentId eq two.id && three.type eq 1}">
                     <li><a href="${pageContext.servletContext.contextPath }${three.resUrl}" target="main">${three.name}</a></li>
                   </c:if>
                  </c:forEach>
                </ul>
              
            </li>
            </c:if>
            </c:forEach>
	     </ul>
      </div>
 </c:if>
</c:forEach>
</div><!--End_left_menu-->
    <script type="text/javascript">
    $(function(){
        var h3 = $(".tree_box").find("h3");
        var tree_one = $(".tree_box").find(".tree_one");
        var h4 = $(".tree_one").find("h4");
        var tree_two = $(".tree_one").find(".tree_two");
        h3.each(function(i){
            $(this).click(function(){
                tree_one.eq(i).slideToggle();
                tree_one.eq(i).parent().siblings().find(".tree_one").slideUp();
            })
        })
        h4.each(function(i){
            $(this).click(function(){
                tree_two.eq(i).slideToggle();
                tree_two.eq(i).parent().siblings().find(".tree_two").slideUp();
            })
        })
    })
</script>

<script type="text/javascript">
//满窗口显示
var winHeight = 0;
function findDimensions() //函数：获取尺寸
{
//获取窗口高度
if (window.innerHeight){
winHeight = window.innerHeight;

}else if ((document.body) && (document.body.clientHeight)){
winHeight = document.body.clientHeight;
}

//通过深入Document内部对body进行检测，获取窗口大小
if (document.documentElement && document.documentElement.clientHeight )
{
winHeight = document.documentElement.clientHeight;

}
//结果输出至两个文本框
document.getElementById('L_main').style.height=(winHeight-167+'px');

if(navigator.userAgent.indexOf("Firefox")>0||navigator.userAgent.indexOf("Chrome")>0){  
  winHeight = document.body.clientHeight;
      document.getElementById('L_main').style.height=(winHeight+167+'px');
   }  
}
findDimensions();
//调用函数，获取数值
window.onresize=findDimensions;
</script>
</body>
</html>

