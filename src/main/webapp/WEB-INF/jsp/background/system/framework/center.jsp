<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
<title>hb应用后台管理系统</title>
  <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery-1.4.min.js"></script>
	<script type="text/javascript">
        $(document).ready(function () {
            var aMenuOneLi = $(".menu-one > li");
            var aMenuTwo = $(".menu-two");
            $(".menu-one > li > .header").each(function (i) {
                $(this).click(function () {
                    if ($(aMenuTwo[i]).css("display") == "block") {
                        $(aMenuTwo[i]).slideUp(300);
                        $(aMenuOneLi[i]).removeClass("menu-show")
                    } else {
                        /*for (var j = 0; j < aMenuTwo.length; j++) {
                            $(aMenuTwo[j]).slideUp(300);
                            $(aMenuOneLi[j]).removeClass("menu-show");
                        }*/
                        $(aMenuTwo[i]).slideDown(300);
                        $(aMenuOneLi[i]).addClass("menu-show")
                    }
                });
            });
        });
	);
		
		
    </script>
</head>

<body>
<div class="m_c" style="margin-left:10px;">
<!--内容导航指示一-->
  <div class="middle_img">
       <div class="middle_bg"></div>
       <p>您现在的位置: <a href="#">我的桌面</a></p>
  </div>
  <!--内容-->
  <div class="middle_con">
     <div class="content">
		<ul class="menu-one">
<!--			<li class="firstChild">-->
<!--				<div class="header" id="showID1">-->
<!--				</div>-->
<!--				<ul class="menu-two" id="showYujing">-->
<!--				</ul>-->
<!--			</li>-->
		</ul>
	</div>
</div> 
</body>
</html>

