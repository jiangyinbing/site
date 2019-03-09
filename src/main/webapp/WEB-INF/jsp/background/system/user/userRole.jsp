<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="../../../common/common-js.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link id="cssMiddle" type="text/css" rel="stylesheet"
			href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css"
			media="all" />
		<title>分配角色</title>
	</head>
<script type="text/javascript">
function allocation() {
		$.ajax( {
					async : false, //请勿改成异步，下面有些程序依赖此请数据
					type : "POST",
					data : {
						userId : "${user.userId}",
						roleId : $('input[name="roleId"]:checked').val()
					},
					url : "${pageContext.servletContext.contextPath }/background/system/user/allocation.html",
					dataType : 'json',
					success : function(json) {
						if (json == "1000") {
							window.dialogArguments.location.reload();
							alert("分配成功！！");
							window.close();
						} else if (json == "1001") {
							alert("分配失败！！");
						}
						;
					}
				});
	}
</script>
	<body>
		<form action="${pageContext.servletContext.contextPath }/background/system/user/add.html" method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">用户管理</a> >>
						<a href="#">分配角色</a>
					</div>
					<!--列表内容 -->
					<table class="table_style table_font_center" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td height="30" colspan="2">
									<h2>
										分配角色
									</h2>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" >
										用户名：
									</div>
								</td>
								<td>
									<div align="left"  style="padding-left: 10px;">
										${user.userName}
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="20%">
									<div align="right" >
										所属角色
									</div>
								</td>
								<td>
									<div align="left"  style="padding-left: 10px;">
										<c:if test="${empty user.roleName}">
											<font color="red">没有分配角色</font>
										</c:if>
										<c:if test="${not empty user.roleName}">
											<font color="blue">${user.roleName}</font>
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<table class="listtable" width="100%">
										<tr>
											<td width="8"
												background="${pageContext.servletContext.contextPath }/images/tab_12.gif">
												&nbsp;
											</td>
											<td>
												<table class="ttab" width="100%" cellspacing="1"
													onmouseover=changeto(); onmouseout=changeback();>
													<tr>
														<td width="3%" height="22"
															background="${pageContext.servletContext.contextPath }/images/bg.gif">
														</td>
														<td width="15%" height="22"
															background="${pageContext.servletContext.contextPath }/images/bg.gif"
															>
															角色名
														</td>
														<td width="5%" height="22"
															background="${pageContext.servletContext.contextPath }/images/bg.gif">
															<span >是否禁用</span>
														</td>
														<td width="12%" height="22"
															background="${pageContext.servletContext.contextPath }/images/bg.gif">
															<span >描述</span>
														</td>
													</tr>

													<c:forEach var="role" items="${roles}">
														<tr>
															<td height="20">
																<input type="radio" name="roleId" value="${role.id}" />
															</td>
															<td height="20">
																<span >${role.name}</span>
															</td>
															<td height="20">
																<span > <c:if
																		test="${role.enable eq '0'}">
																		<font color="red">禁用</font>
																	</c:if> <c:if test="${role.enable eq '1'}">
																		<font color="blue">正常</font>
																	</c:if> </span>
															</td>
															<td height="20">
																<span >${role.description}</span>
															</td>
														</tr>
													</c:forEach>
												</table>
											</td>
											<td width="8"
												background="${pageContext.servletContext.contextPath }/images/tab_15.gif">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td colspan="2" style="padding: 10px">
									<div align="center">
										<input type="button" value="　保　存　" class="btn"
											onclick="allocation();" />
										<input id="backBt" type="button" value="　关　闭　" class="btn"
											onclick="javascript:window.close();" />
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







