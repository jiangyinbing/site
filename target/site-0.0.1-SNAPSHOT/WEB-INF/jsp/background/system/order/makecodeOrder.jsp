<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="../../../common/common-js.jsp"%>
		<%@include file="../../../common/validator.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link id="cssMiddle" type="text/css" rel="stylesheet"
			href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css"
			media="all" />

		<title>信息授权</title>
	</head>
	<body>
		<form action="" method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">业务列表</a> >>
						<a href="#">订单列表</a> >>
						<a href="#">信息授权</a>
					</div>
					<input type="hidden" value="${id}" id="id"/>
					<table class="table_style table_font_center" width="100%"
									border="0" cellspacing="0" cellpadding="0">
						<tbody id="table">
							<tr align="center" height="100px"><td>
								<div align="center"><b id="msg"></b></div>
							</td></tr>
							<tr align="center"><td>
								<input type="hidden" value="" id="hid"/>
								<input type="button" value='确认' onclick="sumbit()" class="btn"/>&nbsp; &nbsp;
								<input type="button" value='返回' class="btn"
														onclick="javascript:window.location.href='${pageContext.servletContext.contextPath }/background/system/order/gotoOrderList.html'"/>
							</td></tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</body>
	
	<script type="text/javascript">
		$(function(){
			$("#hid").val("ENC_01");
			var a = $("#hid").val();
			var id = $("#id").val();
			$("#msg").html("是否对订单"+id+"进行个人信息授权！");
		});
		
		function sumbit(){
			var code = $("#hid").val();
			var id = $("#id").val();
			
			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath }/background/system/order/codeOrder.html',
				dataType:'json',
				data:{code:code,id:id},
				success:function(data){
					data = eval('(' + data + ')');
					if(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC == "交易成功"){
						if(code == "ENC_01"){
							$("#msg").html("个人信息授权授权成功，请确认授权借款合同！");
							//alert("缓存码="+JSON.stringify(data.SERVICE.SERVICE_BODY.RESPONSE));
							$("#hid").val("ENC_03");
						}else if(code == "ENC_03"){
							$("#msg").html("借款合同授权成功，请确认签署划扣书！");
							$("#hid").val("ENC_04");
						}else if(code == "ENC_04"){
							$("#msg").html("签署划扣书完成，请确认合同！");
							$("#hid").val("all");
						}else if(code == "all"){
							alert("完成确认合同");
							window.location.href='${pageContext.servletContext.contextPath }/background/system/order/gotoOrderList.html';
						}
					}else{
						$("#msg").html("授权失败，请重新授权！");
					}
				}
			})
		}
		
	</script>
</html>






