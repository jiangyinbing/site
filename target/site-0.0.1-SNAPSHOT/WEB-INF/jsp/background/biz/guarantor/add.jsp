<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="../../../common/common-js.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
	<title>新增担保人</title>
  </head>
  
  <body>
    <form name="addLinkForm" action="${pageContext.servletContext.contextPath }/biz/guarantor/addGuarantor.html" method="post">
		<!--存订单id，传到后台-->
		<input style="height: 20px; width: 200px;" id="id" name="id" type="hidden" value="${id}"/>
		<div class="main_page">
			<div class="main_con">
				<div class="position">
					现在的位置:
					<a href="#">业务列表</a> 
					>>
					<a href="#">订单列表</a>
					>>
					<a href="#">查询担保人和抵押信息</a>
					>>
					<a href="#">新增担保人</a>
				</div>
				<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr><td height="60" colspan="2"><h2>添加担保人</h2></td>
						<tr>
							<td height="30" width="40%">
								<div align="right" >担保人姓名：</div>
							</td>
							<td>
								<div align="left"  style="padding-left: 10px;">
									<input style="height: 20px; width: 200px;" id="guarantName" name="guarantName" 
										type="text" /> (必填) <span id="nameTip" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="40%">
								<div align="right" >身 份 证 号：</div>
							</td>
							<td>
								<div align="left"  style="padding-left: 10px;">
									<input style="height: 20px; width: 200px;" id="idNo" name="idNo" 
										type="text" /> (必填) <span id="id_noTip" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="40%">
								<div align="right" >手 机 号 码：</div>
							</td>
							<td>
								<div align="left"  style="padding-left: 10px;">
									<input style="height: 20px; width: 200px;" id="mobileNumber" name="mobileNumber" 
										type="text" /> (必填) <span id="mobile_noTip" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="40%">
								<div align="right" >与被担保人关系：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<select name="relationship" id="relationship" style="height: 20px; width: 200px" data-validator-group="customValidatorGroupName" >
										<option value="0">请选择</option>
										<option value="C">配偶</option>
										<option value="F">父亲</option>
										<option value="M">母亲</option>
										<option value="B">兄弟</option>
										<option value="S">姐妹</option>
										<option value="L">亲属</option>
										<option value="W">同事</option>
										<option value="I">本人</option>
										<option value="H">子女</option>
										<option value="T">同学</option>
										<option value="Y">朋友</option>
										<option value="O">其他</option>
									</select> (必选) <span id="relationshipTip" class="redClass"></span>
								</div>
							</td>
						</tr>
						<c:if test="${tip!=null}">
							<tr>
								<td colspan="2" style="padding: 10px">
									<div align="center" style="color: red;">
										<span>${tip }</span>
									</div>
								</td>
							</tr>
						</c:if>
						<tr>
							<td colspan="2" style="padding: 10px">
								<div align="center">
									<input type="submit" value="　保　存　" class="btn" onclick="check();"/>
									<input id="backBt" type="button" value="　返　回　" class="btn"
										onclick="javascript:window.location.href='javascript:history.go(-1)'" />
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
  </body>
</html>
