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

<title>资源管理</title>
</head>
<body>
	<form id="fenye" name="fenye"
		action="${pageContext.servletContext.contextPath }/background/system/order/query.html"
		method="post">                                
		<div class="main_page">                          
			<div class="main_con">
				<div class="position">
					现在的位置: <a href="#">业务列表</a> >> <a href="#">订单列表</a>
				</div>
				<div style="height: 30px">
				订单编号：
					<input type="text" id="ORDER_ID" style="height: 20px; width: 200px"
						name="orderId" />	&nbsp; &nbsp;
				<button>查询</button>&nbsp; &nbsp;
				
				 <button>重置</button>
               <a href="javascript:void(0)" class="BtnClear" onclick="javascript:document.getElementById('text').value='重置'"></a>  
				</div>
				<div style="height: 30px">
					<a class="btn"
						href="${pageContext.servletContext.contextPath }/background/system/order/gotoOrderMake.html">新增</a>
				</div>
				<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td width="8%" class="tit_top_bg">订单编号</td>
							<td width="8%" class="tit_top_bg"><c:if
									test="${userSession.customerType=='1'}">法人名称</c:if> <c:if
									test="${userSession.customerType=='2'}">客户姓名</c:if></td>
							<td width="8%" class="tit_top_bg">手机号码</td>
							<td width="8%" class="tit_top_bg">借款期数</td>
							<td width="8%" class="tit_top_bg">贷款金额</td>
							<td width="8%" class="tit_top_bg">订单状态</td>
							<td width="11%" class="tit_top_bg">产品名称</td>
							<td width="40%" class="tit_top_bg">操作</td>
						</tr>
					</thead>
					<tbody id="table">
						<c:forEach var="resources" items="${pageView.records}">
							<tr>
								<td>${resources.orderId}</td>
								<td>${userSession.userRealname}</td>
								<td>${userSession.userPhone}</td>
								<td>${resources.term}</td>
								<td>${resources.oriOrderAmt}</td>
	             				<td>	
									<c:choose>
										<c:when test="${resources.orderStatu=='N'}">放款已成功</c:when>
										<c:when test="${resources.orderStatu=='S'}">订单征审中</c:when>
										<c:when test="${resources.orderStatu=='L'}">订单已确认</c:when>
										<c:when test="${resources.orderStatu=='T'}">订单已终止</c:when>
										<c:when test="${resources.orderStatu=='U'}">撤销订单</c:when>
										<c:when test="${resources.orderStatu=='E'}">征审失败</c:when>
										<c:when test="${resources.orderStatu=='X'}">订单已过期</c:when>
										<c:when test="${resources.orderStatu=='B'}">添加信息</c:when>
										<c:when test="${resources.orderStatu=='C'}">合同审核中</c:when>
										<c:when test="${resources.orderStatu=='R'}">合同不通过</c:when>
										<c:when test="${resources.orderStatu=='G'}">合同已审核</c:when>
										<c:when test="${resources.orderStatu=='P'}">结清未入账</c:when>
										<c:when test="${resources.orderStatu=='D'}">结清已入账</c:when>
										<c:when test="${resources.orderStatu=='W'}">担保签署中</c:when>
										<c:when test="${resources.orderStatu=='H'}">待签划扣书</c:when>
										<c:when test="${resources.orderStatu=='K'}">合同已审核(银行)</c:when>
										<c:when test="${resources.orderStatu=='F'}">银行已放款</c:when>
										<c:when test="${resources.orderStatu=='I'}">待签委托担保协议</c:when>
										<c:otherwise>其他</c:otherwise>
									
									</c:choose>
								</td>
								<td>${resources.productName}</td>
								
								<td>	
								 
								     <input id='${resources.orderId}confirm'  type='button' value='确认订单' onclick=confirm(${resources.orderId},${resources.coreEntId},${resources.productCd},${resources.productName},${resources.oriOrderAmt},${resources.term},${resources.interestRate})>&nbsp; &nbsp;
<%-- 								     <input id='${resources.orderId}dizhiya'   type='button' value='抵质押信息' onclick=dizhiya(${resources.orderId})>&nbsp; &nbsp;
 --%>								     <input id='${resources.orderId}cancel'  type='button' value='撤销订单' onclick=cancel(${resources.orderId})>&nbsp; &nbsp;
								
								</td>
								 <c:if test="${resources.orderStatu=='S'}">
								 <script type="text/javascript">
							        $("#${resources.orderId}confirm").attr('disabled','disabled');
							        $("#${resources.orderId}cancel").attr('disabled','disabled');
/* 							        $("#${resources.orderId}dizhiya").attr('disabled','disabled');
 */							    </script>
							       </c:if> 
							       <c:if test="${resources.orderStatu=='U'}">
								 <script type="text/javascript">
								    $("#${resources.orderId}confirm").attr('disabled','disabled');
							        $("#${resources.orderId}cancel").attr('disabled','disabled');
							    </script>
							       </c:if> 
						</c:forEach>
					</tbody>
					        
					<div align="center">
						<b id="msg"></b>
					</div>

				</table>
				<!-- 分页 -->
				<%@include file="/WEB-INF/jsp/common/webfenye.jsp"%>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	/* $(function(){
		
	});

	function getorderStatu(orderStatu) {
		if (orderStatu == "N") {
			return "未审核";
		} else if (orderStatu == "A") {
			return "放款已成功";
		} else if (orderStatu == "S") {
			
			return "订单征审中";
		} else if (orderStatu == "L") {
			return "订单已确认";
		} else if (orderStatu == "T") {
			return "订单已终止";
		} else if (orderStatu == "U") {
			return "撤销订单";
		} else if (orderStatu == "E") {
			return "征审失败";
		} else if (orderStatu == "X") {
			return "订单已过期";
		} else if (orderStatu == "B") {
			return "添加信息"; //添加担保人
		} else if (orderStatu == "C") {
			return "合同审核中";
		} else if (orderStatu == "R") {
			return "合同不通过";
		} else if (orderStatu == "G") {
			return "合同已审核";
		} else if (orderStatu == "P") {
			return "结清未入账";
		} else if (orderStatu == "D") {
			return "结清已入账";
		} else if (orderStatu == "W") {
			return "担保签署中";
		} else if (orderStatu == "H") {
			return "待签划扣书";
		} else if (orderStatu == "K") {
			return "合同已审核(银行)";
		} else if (orderStatu == "F") {
			return "银行已放款";
		} else if (orderStatu == "I") {
			return "待签委托担保协议";
		} else {
			return "其他";
		}
	} */
	
	 function findone(){
		
		 var order d = $("#ORDER_ID").val();
		 $("#msg").html("");
		 window.location.reload();
		 $.ajax({
				type : 'get',
				url : '${pageContext.servletContext.contextPath }/background/system/order/query.html',
				dataType : 'json',
				data : {orderId : orderId},
				success : function(data) {
					
					$("#table").html("");
					console.log(data);
					for(var i=0;i<data.length;i++){
						$("#msg").html("<font color='black'>"+data+"</font>");
						document.getElementById("msg").style.display = 'block';
					}
				}
			});

	 }

	/* function up() {
		$("#msg").html("");
		if (i < 1) {
			$("#msg").html("当前已是第一页");
			return;
		}
		i--;
		$("#up").css("display", "true");
		$("#down").css("display", "true");
		$.ajax({
					type : 'post',
					url : '${pageContext.servletContext.contextPath }/background/system/order/query.html',
					dataType : 'json',
					data : {
						pageNow : i
					},
					success : function(data) {
						$("#table").html("");
						process(data);
					}
				});
	}

	function down() {
		$("#msg").html("");
		i++;

		$("#down").css("display", "true");
		$("#up").css("display", "true");
		$.ajax({
					type : 'post',
					url : '${pageContext.servletContext.contextPath }/background/system/order/query.html',
					dataType : 'json',
					data : {
						pageNow : i
					},
					success : function(data) {
						$("#table").html("");
						process(data);
					}
				});

	} */

	function confirm(orderId, coreEntId, productCd, productName, oriOrderAmt,term, interestRate) {
		   $.ajax({
					type : 'post',
					url : '${pageContext.servletContext.contextPath }/background/system/order/confirmOrder.html',
					dataType : 'json',
					data : {
						orderId : orderId,
						coreEntId : coreEntId,
						productCd : productCd,
						productName : productName,
						oriOrderAmt : oriOrderAmt,
						term : term,
						interestRate : interestRate
					},
					success : function(data) {
						  alert("#" + orderId + "confirm");
						$("#" + orderId+ "confirm").attr('disabled','disabled');
						$("#" + orderId+ "cancel").attr('disabled','disabled');
						$("#" + orderId + "dizhiya").attr('disabled', 'disabled');
					}
				});
	}

	function cancel(id) {
		$.ajax({
					type : 'post',
					url : '${pageContext.servletContext.contextPath }/background/system/order/cancelOrder.html',
					dataType : 'json',
					data : {
						orderId : id
					},
					success : function(data) {
						 					
						$("#" + id + "cancel").attr('disabled','disabled');
						$("#" + id + "confirm").attr('disabled', 'disabled');
						$("#" + id + "dizhiya").attr('disabled', 'disabled');

					}
				});
	}

	function code(id) {
		window.location.href = '${pageContext.servletContext.contextPath }/background/system/order/gotocodeOrderMake.html?id='
				+ id;
	}

	function acctSetup(id, merId, acctSetup, loanCode, oriOrderAmt, term) {
		$.ajax({
					type : 'post',
					url : '${pageContext.servletContext.contextPath }/background/system/order/acctSetup.html',
					dataType : 'json',
					data : {
						Mechan_id : merId,
						orderId : hb_orderId,
						Loan_code : loanCode,
						Loan_amount : oriOrderAmt,
						Term : term
					},
					success : function(data) {
						/* data = eval('(' + data + ')');
						$("#msg").html(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
						if(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC=="交易成功"){ */
						$("#" + id + "acctSetup").attr('disabled', 'disabled');
					}
				});
	}

	function AP4(id) {//担保
		window.location.href = '${pageContext.servletContext.contextPath }/biz/guarantor/queryGuarantor.html?id='
				+ id;
	}
	function dizhiya(id) {//抵质押，订单未确认之前，都可以增进抵质押
		window.location.href = '${pageContext.servletContext.contextPath }/biz/pledge/queryPledge.html?id='
				+ id;
	}
	function AP6(id) {
		window.location.href = '${pageContext.servletContext.contextPath }/background/system/order/gotouploadfileimg.html?id='
				+ id;
	}
	function AP7(id) {
		window.location.href = '${pageContext.servletContext.contextPath }/background/system/order/gotouploadfile.html?id='
				+ id;
	}
</script>
</html>


