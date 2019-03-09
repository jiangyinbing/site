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
		action="${pageContext.servletContext.contextPath }/background/biz/userLimit/list.html"
		method="post">                                
		<div class="main_page">                          
			<div class="main_con">
				<div class="position">
				
					现在的位置: <a href="#">客户授信jyb额度信息</a> 
					<!-- >> <a href="#">订单列表</a> -->
				</div>
				<div style="height: 30px">
				客户名称 ：
					<input type="text" id="customer_name" style="height: 20px; width: 200px"
						name="customer_name" />	&nbsp; &nbsp;
				<button>查询</button>     &nbsp; &nbsp;
				
				 <button>重置</button> 
               <a href="javascript:void(0)" class="BtnClear" onclick="javascript:document.getElementById('text').value='重置'"></a>  
				</div>
				<div style="height: 30px">
					<a class="btn"
						href="${pageContext.servletContext.contextPath }/background/biz/userLimit/gotoUserLimitMake.html">新增</a>
					<%-- <a class="btn"
						href="${pageContext.servletContext.contextPath }/background/system/order/gotoUserLimitMake.html">新增</a>
					 <a class="btn"  class="edit"
						href="${pageContext.servletContext.contextPath }/background/biz/userLimit/gotoUserLimitMod.html">修改</a>
				--%>
				
				</div>
								<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<%--<td width="8%" class="tit_top_bg">客户ID</td>
							 --%>
							<td width="8%" class="tit_top_bg">手机号</td>
							<td width="10%" class="tit_top_bg">客户已用额度</td>
							<td width="8%" class="tit_top_bg">剩余额度</td>
							<td width="10%" class="tit_top_bg">客户授信额度</td>
							<!-- <td width="8%" class="tit_top_bg">客户类型</td> -->
							<td width="8%" class="tit_top_bg"><c:if
								test="${userSession.customerType=='1'}">法人名称</c:if> <c:if
								test="${userSession.customerType=='2'}">客户姓名</c:if></td> 
							<td width="8%" class="tit_top_bg">生效时间</td>
							<td width="8%" class="tit_top_bg">失效时间</td>
							<td width="8%" class="tit_top_bg">状态</td>
							<td width="20%" class="tit_top_bg">备注</td>
							<td width="20%" class="tit_top_bg">操作</td>
						</tr>
					</thead>
					<tbody id="table">
						<c:forEach var="resources" items="${pageView.records}">
							<tr>
								<td><input type="text" value="${resources.mobile_no}"  id="MOBILE_NO"  style="height: 30px; width: 80px"></td>
								<td><input type="text" value="${resources.use_limit}"  id="USE_LIMIT"  style="height: 30px; width: 80px"></td>
								<td><input type="text" value="${resources.remain_limt}"  id="REMAIN_LIMIT"  style="height: 30px; width: 80px"></td>
	             				<td><input type="text" value="${resources.customer_limit}"  id="CUSTOMER_LIMIT"  style="height: 30px; width: 80px"></td>
	             				<td><input type="text" value="${resources.customer_name}"  id="CUSTOMER_NAME"  style="height: 30px; width: 80px"></td>
	             				<td><input type="date" value="${resources.effect_date}"  id="EFFECT_DATE"  style="height: 30px; width:120px"></td>
	             				<td >
	<input type="date" value="${resources.invalid_date}"  id="INVALID_DATE" style="height: 30px; width: 120px">							
								</td>
	             				<td>	
									<div align="left" >
									<select  style="height: 30px; width: 80px" id="STATUS" name="status">
										<option value="0">有效</option>
										<option value="1">无效</option>
										
									</select>
								</div>
								</td> alert(${resources.remark},${resources.limitId},${resources.customer_Id})
								<td><input type="text" value="${resources.remark}"  id="REMARK"  style="height: 30px; width: 170px"></td>
							
							<td>	
								 <%-- id='${resources.limitId}confirm' --%>
<!-- 								 <input class="edit"  type='button' value='修改' onclick=confirm(${resources.mobile_no},${resources.use_limit},${resources.remain_limt},${resources.customer_limit},${resources.customer_name},${resources.effect_date},${resources.invalid_date},${resources.status},${resources.remark})>&nbsp; &nbsp;
 -->						
 <input type='button' value='保　存' <%-- id='${resources.limitId}save' --%> onclick=checksubmittt("${resources.limitId}","${resources.customer_Id}");javascript:window.location.href="javascript:history.go(-1)" /> 
 
                           <input  type='button' value='删除' onclick=del(${resources.mobile_no});javascript:window.location.href='javascript:history.go(-1)'>&nbsp; &nbsp;
								</td> 
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

/* function confirm(mobile_no, use_limit, remain_limt, customer_limit, customer_name,effect_date, invalid_date,status,remark) {
	  alert(mobile_no);
	$.ajax({
				type : 'post',
				url : '${pageContext.servletContext.contextPath }/background/biz/userLimit/list.html',
				dataType : 'json',
				data : {
					mobile_no : mobile_no,
					use_limit : use_limit,
					remain_limt : remain_limt,
					customer_limit : customer_limit,
					customer_name : customer_name,
					effect_date : effect_date,
					invalid_date : invalid_date,
					status:status,
					remark:remark
				},
				success : function(data) {
					  alert("#" + limitId + "confirm");
					  var t_this = $(this);
		                var list = $(t_this).parent().parent().find("td:lt(7)");
		                var html = encodeURIComponent($(t_this).parent().parent().html());
		                $.each(list, function (i, obj) {
		                    $(obj).html("<input type='text' value='" + $(obj).text() + "'/>");
		                });
		                $(t_this).parent().html("<input type='button' value='保存' class='checksubmit' /><input type='button' html='" + html + "' value='取消' class='cancel'/>");
		            });
				}
			}); */
 
			function del(id) {
				$.ajax({
							type : 'post',
							url : '${pageContext.servletContext.contextPath }/background/biz/userLimit/deleteById.html',
							dataType : 'json',
							data : {
								mobile_no : id
							},
							success : function(data) {
								 					
						 	return "/background/biz/userLimit/userLimit";
							}
						});
			}
 /* $(document).ready(function () {
	$(".edit").live("click", function () {
	                var t_this = $(this);
	                var list = $(t_this).parent().parent().find("td:lt(7)");
	                var html = encodeURIComponent($(t_this).parent().parent().html());
	                $.each(list, function (i, obj) {
	                    $(obj).html("<input type='text' style='height: 20px; width: 100px' value='" + $(obj).text() + "'/>");
	                });
	                $(t_this).parent().html("<input type='button' value='保存' class='checksubmit' /><input type='button' html='" + html + "' value='取消' class='cancel'/>");
	            });
	            $(".checksubmit").live("click", function () { */
	            	 /* function checksubmit(){
	            	//cleanDiv('msg');
	        		var mobile_no=$("#MOBILE_NO").val();
	        		var use_limit = $("#USE_LIMIT").val();
	        		var remain_limt = $("#REMAIN_LIMIT").val();
	        		var customer_limit=$("#CUSTOMER_LIMIT").val();
	        		var customer_name=$("#CUSTOMER_NAME").val();
	        		var effect_date=$("#EFFECT_DATE").val();
	        		var invalid_date=$("#INVALID_DATE").val();
	        		var status=$("#STATUS option:selected").val();
	        		var remark=$("#REMARK").val();
	        		alert(remark);
	                var t_this = $(this);
	                var list = $(t_this).parent().parent().find("td :input[type='text']");
	                $.each(list, function (i, obj) {
	                     $(obj).parent().html($(obj).val()); 
	                     $.ajax({
	            			type:'post',
	            			url:'${pageContext.servletContext.contextPath }/background/biz/userLimit/mkorder.html',
	            			data:{mobile_no:mobile_no,remain_limt:remain_limt,customer_limit:customer_limit,use_limit:use_limit,
	            				customer_name:customer_name,effect_date:effect_date,invalid_date:invalid_date,status:status,remark:remark},
	            			dataType:'json',
	            			success:function(data){
	            				$("#msg").html("<font color='black'>"+data+"</font>");
	            				document.getElementById("msg").style.display = 'block';
	            				alert(use_limit);
	            			} 
	            			
	            		});
	                });
	                 $(t_this).parent().html("<input type='button' value='编辑' class='edit'/>");  
	            });
	            $(".cancel").live("click", function () {
	                $(this).parent().parent().html(decodeURIComponent($(this).attr("html")));
	            });
	 }); */   
 /* var i=1;
$(function(){
	$.ajax({
		type:'post',
		url:'${pageContext.servletContext.contextPath }/background/biz/userLimit/list.html',
		dataType:'json',
		success:function(data){
			process(data);
		}
	});
	

});

function process(data){
	for(var i =0;i<data.length;i++){
		//var orderStatu = data[i].orderStatu;
		var str = "<tr>"+
				  "<td id='"+data[i].customer_Id+"customerid' width='8%' >"+data[i].customer_Id+"</td>"+  
					 "<td id='"+data[i].customer_Id+"mobileno' width='8%' >"+data[i].mobile_no+"</td>"+
					 "<td id='"+data[i].customerId+"uselimit' width='8%' >"+data[i].use_limit+"</td>"+
					 "<td id='"+data[i].customerId+"remainlimt' width='8%' >"+data[i].remain_limt+"</td>"+
					 "<td id='"+data[i].customerId+"customerlimit' width='8%' >"+data[i].customer_limit+"</td>"+
					 "<td id='"+data[i].customerId+"customertype' width='8%' >"+data[i].customer_type+"</td>"+
					 "<td id='"+data[i].customerId+"effectdate' width='8%' >"+data[i].effect_date+"</td>"+
					 "<td id='"+data[i].customerId+"invaliddate' width='8%' >"+data[i].invalid_date+"</td>"+
					 "<td id='"+data[i].customerId+"status' width='8%' >"+data[i].status+"</td>"+
					 "<td id='"+data[i].customerId+"remark' width='8%' >"+data[i].remark+"</td></tr>";
		$("#table").append(str);
	}
}  */
function checksubmittt(customer_Id,limitId){
	//cleanDiv('msg');
	//alert(mobile_no);
	var mobile_no=$("#MOBILE_NO").val();
	var use_limit = $("#USE_LIMIT").val();
	var remain_limt = $("#REMAIN_LIMIT").val();
	var customer_limit=$("#CUSTOMER_LIMIT").val();
	var customer_name=$("#CUSTOMER_NAME").val();
	var effect_date=$("#EFFECT_DATE").val();
	var invalid_date=$("#INVALID_DATE").val();
	var status=$("#STATUS option:selected").val();
	var remark=$("#REMARK").val();
	alert(customer_name+" "+invalid_date);
$.ajax({
	type:'post',
	url:'${pageContext.servletContext.contextPath }/background/biz/userLimit/modUserLimit.html',
	data:{mobile_no:mobile_no,remain_limt:remain_limt,customer_limit:customer_limit,use_limit:use_limit,limitId:limitId,customer_Id:customer_Id,
		customer_name:customer_name,effect_date:effect_date,invalid_date:invalid_date,status:status,remark:remark},
	dataType:'json',
	success:function(data){
		/* $("#msg").html("<font color='black'>"+data+"</font>");
		document.getElementById("msg").style.display = 'block'; */
		alert("修改成功");
		return "/background/biz/userLimit/userLimit";
	}
}); 
	
}
	 function findone(){
		
		 var order_id = $("#ORDER_ID").val();
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

	

	/* function confirm(orderId, coreEntId, productCd, productName, oriOrderAmt,term, interestRate) {
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
	} */

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


