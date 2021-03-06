<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="../../../common/common-js.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
	<title>担保人信息列表</title>
  </head>
  
  <body>
  	<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/system/resources/query.html" method="post">
		<div class="main_page">
			<div class="main_con">
				<div class="position">
					现在的位置:
					<a href="#">业务列表</a> 
					>>
					<a href="#">订单列表</a>
					>>
					<a href="#">查询担保人信息</a>
				</div>
				<!-- 担保人新增,确认按钮内容 -->
				<div style="height: 30px">	
					<a class="btn" href="${pageContext.servletContext.contextPath }/biz/guarantor/showAddGuarantor.html?id=${id }">新增担保人</a>
					<a class="btn" href="${pageContext.servletContext.contextPath }/biz/guarantor/comfortGuarantor.html?id=${id }">确认担保人</a>
				</div>
				
				<!-- 担保人信息列表内容 -->
				<h3>担保人信息内容：</h3>
				<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td width="10%" class="tit_top_bg">担保人姓名</td>
							<td width="20%" class="tit_top_bg">担保人身份证</td>
							<td width="20%" class="tit_top_bg">担保人手机</td>
							<td width="10%" class="tit_top_bg">订单id</td>
							<td width="10%" class="tit_top_bg">关系</td>
							<td width="20%" class="tit_top_bg">担保状态</td>
							<td width="10%" class="tit_top_bg">操作</td>
						</tr>
					</thead>
					<tbody id="main">
						<c:forEach items="${glst}" var="g">
							<tr>
								<td>${g.guarantName }</td>
								<td>${g.idNo }</td>
								<td>${g.mobileNumber }</td>
								<td>${g.orderId }</td>
								<td><c:if test="${g.relationship=='C'}">配偶</c:if>
									<c:if test="${g.relationship=='F'}">父亲</c:if>
									<c:if test="${g.relationship=='M'}">母亲</c:if>
									<c:if test="${g.relationship=='B'}">兄弟</c:if>
									<c:if test="${g.relationship=='S'}">姐妹</c:if>
									<c:if test="${g.relationship=='L'}">亲属</c:if>
									<c:if test="${g.relationship=='W'}">同事</c:if>
									<c:if test="${g.relationship=='D'}">父母</c:if>
									<c:if test="${g.relationship=='H'}">子女</c:if>
									<c:if test="${g.relationship=='X'}">兄弟姐妹</c:if>
									<c:if test="${g.relationship=='T'}">同学</c:if>
									<c:if test="${g.relationship=='Y'}">朋友</c:if>
									<c:if test="${g.relationship=='O'}">其他</c:if></td>
								<td><c:if test="${g.guaranteeStatus=='A'}">担保已建立</c:if>
									<c:if test="${g.guaranteeStatus=='B'}">担保已确认</c:if>
									<c:if test="${g.guaranteeStatus=='C'}">合同已签署</c:if>
									<c:if test="${g.guaranteeStatus=='D'}">审批已通过</c:if>
									<c:if test="${g.guaranteeStatus=='E'}">担保已作废</c:if>
									<c:if test="${g.guaranteeStatus=='F'}">担保已结束</c:if>
									<c:if test="${g.guaranteeStatus=='G'}">担保已生效</c:if></td>
								<td><input type="button" value="删除" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br/>
			</div>
		</div>	
	</form>
	<p style="text-align: center;">${tip}</p>
  </body>
</html>
