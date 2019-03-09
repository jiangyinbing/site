<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="../../common/common-js.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link id="cssMiddle" type="text/css" rel="stylesheet"
			href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css"
			media="all" />
		<title>业务办理</title>
	</head>
	<body>
		<div class="main_page">
			<div class="main_con">
				<div class="position">
					现在的位置:
					<a href="#">业务办理</a> >>
					<a href="#">确认订单</a>
				</div>
				<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td height="30" colspan="2">
								<h2>
									订单信息
								</h2>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									订单编号：
								</div>
							</td>
							<td>
								<div align="left">
									${order.name}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									产品ID：
								</div>
							</td>
							<td align="left">
								<div align="left">
									${order.orderKey}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									产品名称：
								</div>
							</td>
							<td>
								<div align="left">
									${order.description}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									需要贷款金额：
								</div>
							</td>
							<td>
								<div align="left">
									${order.name}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									贷款期数：
								</div>
							</td>
							<td align="left">
								<div align="left">
									${order.orderKey}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									订单状态：
								</div>
							</td>
							<td>
								<div align="left">
									${order.description}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									申请日期：
								</div>
							</td>
							<td>
								<div align="left">
									${order.name}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									首付金额：
								</div>
							</td>
							<td align="left">
								<div align="left">
									${order.orderKey}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									姓名：
								</div>
							</td>
							<td>
								<div align="left">
									${order.description}
								</div>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									手机：
								</div>
							</td>
							<td>
								<div align="left">
									${order.name}
								</div>
							</td>
						</tr>
						
						<tr>
							<td colspan="2" style="padding: 10px">
								<div align="center">
									<input type="button" value="　确认订单　" class="btn"
										onclick=submit(); />
									<input id="backBt" type="button" value="　返　回　" class="btn"
										onclick=javascript:
										window.location.href='javascript:history.go(-1)' ;
/>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div align="center">
					<b id="msg"></b>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	function submit() {

		$
				.ajax( {
					type : 'post',
					url : '${pageContext.servletContext.contextPath }/background/system/order/confirmOrder.html',
					dataType : 'json',
					data : {
						
					},
					success : function(data) {
						data = eval('(' + data + ')');
						$("#msg").html(
								data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
					}

				})
	}
	
	</script>
</html>







