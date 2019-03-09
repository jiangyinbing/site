<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <%@include file="../../../common/common-js.jsp"%>
	<%@include file="../../../common/validator.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link id="cssMiddle" type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
	<title>联系人信息</title>
	<style type="text/css">.redClass{color:red;}</style>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery-1.4.min.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/linkpeople/add.js"></script>
  </head>
  
  <body>
    <form name="addLinkForm" action="${pageContext.servletContext.contextPath }/biz/bussiness/linkpeople/doAddLinkpeople.html" method="post">
		<div class="main_page">
			<div class="main_con">
				<div class="position">
					现在的位置:
					<a href="#">联系人信息</a> >>
					<a href="#">添加联系人</a>
				</div>
				<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr><td height="60" colspan="2"><h2>添加联系人</h2></td>
						<tr><td height="40" width="20%" colspan="2"><div align="center" >联系人1</div></td></tr>
						<tr>
							<td height="30" width="40%">
								<div align="right" >联系人姓名：</div>
							</td>
							<td>
								<div align="left"  style="padding-left: 10px;">
									<input style="height: 20px; width: 200px;" id="link1" name="link1" 
										type="text" /> (必填) <span id="linkTip1" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >
								    <c:if test="${customerType=='1'}">职位</c:if>
								     <c:if test="${customerType=='2'}">关系</c:if>
								：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
								    <c:if test="${customerType=='1'}">
								          <input style="height: 20px; width: 200px;" id="linkrelation1" name="linkrelation1" type="text" />
								    </c:if>
									<c:if test="${customerType=='2'}">
										<select name="linkrelation1" id="linkrelation1" style="height: 20px; width: 200px" data-validator-group="customValidatorGroupName" >
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
										</select> 
									 </c:if>
									(必填) <span id="linkrelationTip1" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >移动手机号：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="linkmobile1" style="height: 20px; width: 200px" name="linkmobile1" 
										type="text" /> (必填) <span id="linkmobileTip1" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >身份证号码：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="idNo1" style="height: 20px; width: 200px" name="idNo1" 
										type="text" /> (必填) <span id="idNoTip1" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >单&nbsp;位&nbsp;名&nbsp;称：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="unitName1" style="height: 20px; width: 200px" name="unitName1" 
										type="text" /> (选填) <span id="unitNameTip1" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >单&nbsp;位&nbsp;电&nbsp;话：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="unitPhone1" style="height: 20px; width: 200px" name="unitPhone1" 
										type="text" /> (选填) <span id="unitPhoneTip1" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%" colspan="2">
								<div align="center" ></div>
							</td>
						</tr>
						<tr>
							<td height="40" width="20%" colspan="2">
								<div align="center" >联系人2
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >联系人姓名：</div>
							</td>
							<td>
								<div align="left"  style="padding-left: 10px;">
									<input id="link2" style="height: 20px; width: 200px" name="link2"
										type="text" /> (选填) <span id="linkTip2" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >
								      <c:if test="${customerType=='1'}">职位</c:if>
								     <c:if test="${customerType=='2'}">关系</c:if>：
								 </div>
							</td>
							<td>
								<div align="left"  style="padding-left: 10px;">
									 <c:if test="${customerType=='1'}">
								          <input style="height: 20px; width: 200px;" id="linkrelation2" name="linkrelation2" type="text" />
								    </c:if>
									<c:if test="${customerType=='2'}">
										<select name="linkrelation2" id="linkrelation2" style="height: 20px; width: 200px" data-validator-group="customValidatorGroupName" >
											<option value="0">请选择</option>
											<option value="C">配偶</option>
											<option value="F">父亲</option>
											<option value="M">母亲</option>
											<option value="B">兄弟</option>
											<option value="S">姐妹</option>
											<option value="L">亲属</option>
											<option value="W">同事</option>
											<option value="D">父母</option>
											<option value="H">子女</option>
											<option value="T">同学</option>
											<option value="Y">朋友</option>
											<option value="O">其他</option>
										</select> 
									 </c:if>
									</select> (选填) <span id="linkrelationTip2" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >移动手机号：</div>
							</td>
							<td>
								<div align="left"  style="padding-left: 10px;">
									<input id="linkmobile2" style="height: 20px; width: 200px" name="linkmobile2"
										type="text" /> (选填) <span id="linkmobileTip2" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >身份证号码：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="idNo2" style="height: 20px; width: 200px" name="idNo2" 
										type="text" /> (选填) <span id="idNoTip2" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >单&nbsp;位&nbsp;名&nbsp;称：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="unitName2" style="height: 20px; width: 200px" name="unitName2" 
										type="text" /> (选填) <span id="unitNameTip2" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right" >单&nbsp;位&nbsp;电&nbsp;话：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input id="unitPhone2" style="height: 20px; width: 200px" name="unitPhone2" 
										type="text" /> (选填) <span id="unitPhoneTip2" class="redClass"></span>
								</div>
							</td>
						</tr>
						<tr><td height="30" width="20%" colspan="2"><div align="center" style="color:red">${tip}</div></td></tr>
						<tr>
							<td colspan="2" style="padding: 10px">
								<div align="center">
									<input type="button" value="　保　存　" class="btn" onclick="check();"/>
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
