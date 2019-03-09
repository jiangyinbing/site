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
		<title>实名验证</title>
	</head>

	<body>

		<div class="main_page">
			<div class="main_con">
				<div class="position">
					现在的位置:
					<a href="#">业务办理</a> >>
					<a href="#">实名验证</a>
				</div>
				<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td height="30" colspan="2">
								<h2>
									实名验证
								</h2>
							</td>
						</tr>
						<tr>
							<td height="30" width="20%">
								<div align="right">
									用户编码：
								</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<div style="height: 20px; width: 200px" name="CUSTOMERBASIC_ID"
										id="CUSTOMERBASIC_ID">
										${userSession.userId}
									</div>
								</div>
							</td>
						</tr>

						<tr id="ID_display">
							<td height="30" width="20%">
								<div align="right">
									姓名：
								</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input style="height: 20px; width: 200px" name="NAME" id="NAME"
										data-validator-group="customValidatorGroupName"
										data-validator-required="请输入您的真实姓名." type="text"
										onchange="cleanMsg()" />
								</div>
							</td>
						</tr>
						<tr id="ID_display">
							<td height="30" width="20%">
								<div align="right">
									身份证号：
								</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input style="height: 20px; width: 200px" name="ID_NO"
										id="ID_NO" data-validator-group="customValidatorGroupName"
										data-validator-required="请输入您的身份证号." type="text"
										onchange="cleanMsg()" />
								</div>
							</td>
						</tr>
						<tr id="ID_display">
							<td height="30" width="20%">
								<div align="right">
									银行卡号：
								</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input style="height: 20px; width: 200px" name="CARD_NO"
										id="CARD_NO" data-validator-group="customValidatorGroupName"
										data-validator-required="请输入您的银行卡号." type="text"
										onchange="cleanMsg()" />
								</div>
							</td>
						</tr>
						<tr id="ID_display">
							<td height="30" width="20%">
								<div align="right">
									开户行：
								</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input style="height: 20px; width: 200px" name="OPEN_BANK_ID"
										id="OPEN_BANK_ID"
										data-validator-group="customValidatorGroupName"
										data-validator-required="请输入您的银行卡号的开户行." type="text"
										onchange="cleanMsg()" />
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2" style="padding: 10px">
								<div align="center">
									<input type="button" value="　验　证　" class="btn"
										onclick=
	submitResult();
/>
									<input id="backBt" type="button" value="　返　回　" class="btn"
										onclick=
	javascript: window.location.href = 'javascript:history.go(-1)';
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
	function cleanMsg() {
		$("#msg").html("");
	}

	function validataCommon() {
		var customerbasic_id = $("#CUSTOMERBASIC_ID").val();
		var name = $("#NAME").val();
		var id_no = $("#ID_NO").val();
		var card_no = $("#CARD_NO").val();
		var open_bank_id = $("#OPEN_BANK_ID").val();
		if (name == "") {
			$("#msg").html("请输入您的真实姓名");
			return false;
		}
		if (id_no == "") {
			$("#msg").html("请输入您的身份证号");
			return false;
		}
		if (card_no == "") {
			$("#msg").html("请输入您的银行卡号");
			return false;
		}
		if (open_bank_id == "") {
			$("#msg").html("请输入您银行卡号的开户行");
			return false;
		}
		return true;
	}

	function submitResult() {
		var customerbasic_id = $("#CUSTOMERBASIC_ID").val();
		var name = $("#NAME").val();
		var id_no = $("#ID_NO").val();
		var card_no = $("#CARD_NO").val();
		var open_bank_id = $("#OPEN_BANK_ID").val();
		var flag = validataCommon();
		if (!flag) {
			return;
		}
		$
				.ajax( {
					type : 'post',
					url : '${pageContext.servletContext.contextPath }/background/business/authentication/realNameAuthentication.html',
					dataType : 'json',
					data : {
						customerbasic_id : customerbasic_id,
						name : name,
						id_no : id_no,
						card_no : card_no,
						open_bank_id : open_bank_id
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







