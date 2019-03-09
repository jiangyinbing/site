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
				
					现在的位置: <a href="#">客户授信额度信息</a> 
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
				
								<!--列表内容 -->
				<table class="table_style table_font_center" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<thead>
						<c:forEach var="resources" items="${pageView.records}">
						<tr>
							<td height="30" colspan="4">
								<h2>创建额度</h2>
							</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">手机号码：</div>
							</td>
							<td><div align="left" style="padding-left: 10px;">
									<input type="text" value="${resources.mobile_no}" id="MOBILE_NO" style="height: 20px; width: 200px"
									name="mobile_No"  />
								</div>
							</td> 
							<td height="30" width="10%">
								<div align="right">剩余额度 ：</div>
							</td>
							<td><div align="left" style="padding-left: 10px;">
								<input type="text" value="${resources.remain_limt}" id="REMAIN_LIMIT" style="height: 20px; width: 200px"
									name="remainLimt"  />
							</div></td>
						</tr>

						<td height="30" width="10%">
							<div align="right">客户授信额度：</div>
						</td>
						<td>
							<div align="left" style="padding-left: 10px;">
								<input type="text" value="${resources.customer_limit}"  id="CUSTOMER_LIMIT" style="height: 20px; width: 200px"
									name="customerLimit"  />
							</div>
						</td>

						<td height="30" width="10%">
							<div align="right">客户已用额度：</div>
						</td>
						<td>
							<div align="left" style="padding-left: 10px;">
								<input type="text" value="${resources.use_limit}" id="USE_LIMIT" style="height: 20px; width: 200px"
									name="useLimit"  />
							</div>
						</td>
						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">客户类型：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
									<input type="text" value="${resources.customer_name}" id="CUSTOMER_NAME" style="height: 20px; width: 200px"
										name="customerName" />
								</div>
							</td>
							<td height="30" width="10%">
								<div align="right">生效时间：</div>
							</td>
							<td>
								<div align="left" style="padding-left: 10px;">
								<input type="text" value="${resources.effect_date}" type="text" id="EFFECT_DATE"  name="effectDate"  class="date" value="2005-3-22" style="height: 20px; width: 200px"/> 
								<!-- <button onclick="time();">当前值</button> -->
							

							</div>
							</td>

						</tr>
						<tr>
							<td height="30" width="10%">
								<div align="right">失效时间：</div>
							</td>
							<td>
								
								<div align="left" style="padding-left: 10px;">
								<input type="text" value="${resources.invalid_date}"  type="text" id="INVALID_DATE" name="invalidDate" class="date" value="2005-3-22" style="height: 20px; width: 200px"/> 
								<!-- <button onclick="time();">当前值</button> -->
							</div>
							</td>
							
							<td height="30" width="10%">
								<div align="right">状态 ：</div>
							</td>
							<td><div align="left" style="padding-left: 10px;">
								<select type="text" value="${resources.status}"  id="STATUS" style="height: 20px; width: 200px"
									name="status" >
										
										<option value="1">无效</option>
										<option value="0">有效</option>
									</select>
							    </div>
							</td>
						</tr>
						<tr>
							<td height="30" colspan="4">
								<div class="choose" >
									<!-- <p>备注：&nbsp;(选填)</p> -->
	<input type="text" value="${resources.remark}"   onfocus="if(value=='备注：') {value=''}" id="REMARK" name="remark" 
	onblur="if (value=='') {value='请输入用户名'}"  style="height: 50px; width: 1000px">							
								</div>
								
							</td>
						</tr>
						
						<tr>
							<tr>
								<td colspan="4" style="padding: 10px">
									<div align="center">
										<input type="button" value="　保　存　" class="btn"
											onclick="checksubmit();javascript:window.location.href='javascript:history.go(-1)'" /> <input id="backBt" type="button"
											value="　返　回　" class="btn"
											onclick="javascript:window.location.href='javascript:history.go(-1)'" />
									</div>
								</td>
							</tr>
							</c:forEach>
					</thead>
					<%-- <tbody id="table">
						<c:forEach var="resources" items="${pageView.records}">
							<tr>
								<td>${resources.mobile_no}</td>
								<td>${resources.use_limit}</td>
								<td>${resources.remain_limt}</td>
	             				<td>${resources.customer_limit}</td>
	             				<td>${resources.customer_name}</td>
	             				<td>${resources.effect_date}</td>
	             		       <td>${resources.invalid_date}</td>
	             				<td>${resources.invalid_date}</td>
	             				<td>	
									<c:choose>
										<c:when test="${resources.status=='1'}">有效</c:when>
										<c:when test="${resources.status=='0'}">无效</c:when>
									</c:choose>
								</td>
								<td>${resources.remark}</td> 
							
						</c:forEach>
					</tbody> --%>
					        
					<div align="center">
						<b id="msg"></b>
					</div>

				</table>
				<!-- 分页 -->
<%-- 				<%@include file="/WEB-INF/jsp/common/webfenye.jsp"%>
 --%>			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
function checksubmit(){
	cleanDiv('msg');
	var mobile_no=$("#MOBILE_NO").val();
	var use_limit = $("#USE_LIMIT").val();
	var remain_limt = $("#REMAIN_LIMIT").val();
	var customer_limit=$("#CUSTOMER_LIMIT").val();
	var customer_name=$("#CUSTOMER_NAME").val();
	var effect_date=$("#EFFECT_DATE").val();
	var invalid_date=$("#INVALID_DATE").val();
	var status=$("#STATUS option:selected").val();
	var remark=$("#REMARK").val();
	$.ajax({
		type:'post',
		url:'${pageContext.servletContext.contextPath }/background/biz/userLimit/mkorder.html',
		data:{mobile_no:mobile_no,remain_limt:remain_limt,customer_limit:customer_limit,use_limit:use_limit,
			customer_name:customer_name,effect_date:effect_date,invalid_date:invalid_date,status:status,remark:remark},
		dataType:'json',
		success:function(data){
			$("#msg").html("<font color='black'>"+data+"</font>");
			document.getElementById("msg").style.display = 'block';
		}
	});
}
 /* $(document).ready(function () {
	$(".edit").live("click", function () {
	                var t_this = $(this);
	                var list = $(t_this).parent().parent().find("td:lt(4)");
	                var html = encodeURIComponent($(t_this).parent().parent().html());
	                $.each(list, function (i, obj) {
	                    $(obj).html("<input type='text' value='" + $(obj).text() + "'/>");
	                });
	                $(t_this).parent().html("<input type='button' value='保存' class='checksubmit'/><input type='button' html='" + html + "' value='取消' class='cancel'/>");
	            });
	            $(".checksubmit").live("click", function () {
	            	cleanDiv('msg');
	        		var mobile_no=$("#MOBILE_NO").val();
	        		var use_limit = $("#USE_LIMIT").val();
	        		var remain_limt = $("#REMAIN_LIMIT").val();
	        		var customer_limit=$("#CUSTOMER_LIMIT").val();
	        		var customer_name=$("#CUSTOMER_NAME").val();
	        		var effect_date=$("#EFFECT_DATE").val();
	        		var invalid_date=$("#INVALID_DATE").val();
	        		var status=$("#STATUS option:selected").val();
	        		var remark=$("#REMARK").val();
	        		
	                var t_this = $(this);
	                var list = $(t_this).parent().parent().find("td :input[type='text']");
	                $.each(list, function (i, obj) {
	                    /* $(obj).parent().html($(obj).val()); */
	                	/* $.ajax({
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
	                /* $(t_this).parent().html("<input type='button' value='编辑' class='edit'/>"); */
	            });
	            $(".cancel").live("click", function () {
	                $(this).parent().parent().html(decodeURIComponent($(this).attr("html")));
	            });
	 });  */
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

</script>
</html>


