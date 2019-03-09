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

		<title>征审件管理</title>
	</head>
	<body>
		<form id="fenye" name="fenye"
			action="${pageContext.servletContext.contextPath }/background/system/resources/query.html"
			method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">业务列表</a> >>
						<a href="#">征审件列表</a>
					</div>
					<div style="height: 30px">
	  					<%-- <a class="btn" href="${pageContext.servletContext.contextPath }/background/system/order/gotoOrderMake.html">新增</a> --%>
					</div>
					<!--列表内容 -->
					<table class="table_style table_font_center" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						
						<thead>
							<tr>
								<td width="8%" class="tit_top_bg">
									订单编号
								</td>
								<td width="8%" class="tit_top_bg">
									申请编号
								</td>
								<td width="8%" class="tit_top_bg">
									申请状态
								</td>
								<td width="8%" class="tit_top_bg">
									审批利率
								</td>
								<td width="8%" class="tit_top_bg">
									审批金额
								</td>
								<td width="8%" class="tit_top_bg">
									审批期数
								</td>
								<td width="11%" class="tit_top_bg">
									手续费
								</td>
								<td width="11%" class="tit_top_bg">
									原因描述
								</td>
								<td width="8%" class="tit_top_bg">
									流程标志
								</td>
								
								<td width="40%"  class="tit_top_bg">
									操作
								</td>
							</tr>
						</thead>
						<tbody id="table"></tbody>
						<div align="center"><b id="msg"></b></div>
					</table>
				</div>
			</div>
		</form>
		<div style="float: right">
		<input  id="up" type="button" value="上一页" onclick="up()" />
			<span id="span">
				<input id="down" type="button" value="下一页" onclick="down()"/>
			</span>
		</div>
	</body>
	<script type="text/javascript">
		var i=1;
		$(function(){
			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath }/background/biz/signOn/query.html',
				dataType:'json',
				success:function(data){
					data = eval('(' + data + ')');
				
					if(data.SERVICE.SERVICE_BODY.RESPONSE.ORDER_LIST.length==0){
						i=i-2;
						console.log(i);
						return;
					}
					process(data);
				}
			});
			
		
		});
		
		function process(data){
			
				var data = data.SERVICE.SERVICE_BODY.RESPONSE.ORDER_LIST;
				
					for(var i =0;i<data.length;i++){
					var status = data[i].ORDER_STATUS;
					var str = "<tr>"+
								 "<td id='"+data[i].ORDER_ID+"orderid' width='8%' >"+data[i].ORDER_ID+"</td>"+
								 "<td id='"+data[i].ORDER_ID+"dp' width='8%' >"+data[i].APP_NO+"</td>"+
								 "<td id='"+data[i].ORDER_ID+"term' width='8%' >"+data[i].STATUS+"</td>"+
								 "<td id='"+data[i].ORDER_ID+"la' width='8%' >";
								 if(data[i].AUDIT_LOAN_RATE!=null){
									 str += data[i].AUDIT_LOAN_RATE+"</td>";
								 }else{
									 str += data[i].LOAN_RATE+"</td>";
								 }
								 str += "<td id='"+data[i].ORDER_ID+"ostatus' width='8%' >";
								 if(data[i].ORDER_LMT_AMT!=null){
									 str += data[i].ORDER_LMT_AMT+"</td>";
								 }else{
									 str += data[i].APP_LMT+"</td>";
								 }
								 str += "<td id='"+data[i].ORDER_ID+"psd' width='8%' >";
								 if(data[i].FINAL_LOAN_TERM!=null){
									 str += data[i].FINAL_LOAN_TERM+"</td>";
								 }else{
									 str += data[i].LOAN_TERM+"</td>";
								 }
								 str += "<td id='"+data[i].ORDER_ID+"psc' width='8%' >"+data[i].AUDIT_LOAN_SERV_FEE+"</td>"+
								 "<td id='"+data[i].ORDER_ID+"ooa' width='8%' >"+data[i].REFUSE_DESC+"</td>"+
								 "<td id='"+data[i].ORDER_ID+"ooa' width='8%' >"+data[i].NODE_NAME+"</td>"+
								 "<td  width='20%' >";
								 
								 if(getstatus(status)=="添加信息"){
								 	var st = data[i].REFUSE_CODE;
								 	if(st!=null){
								 	    var strs = new Array(); //定义一数组 
										strs = st.split(";"); //字符分割 
										/* AP1:信用额度不足;
										AP2:疑似中介;
										AP3:疑似非法套现;
										AP4:担保人信息;
										AP5其它原因（需注明）;
										AP6:影像信息;
										AP7:基础信息; */
										//str+="<input id='"+data[i].XJ_ORDER_ID+"confirm' disabled='disabled' type='button' value='确认订单'  >&nbsp; &nbsp;<br>";
										for(var k = 0;k<strs.length;k++){
											if(strs[k] == "AP4"){
												str+="<input  id='addAP4' type='button' value='担保信息' onclick='AP4("+data[i].ORDER_ID+")' />&nbsp; &nbsp;<br>";
											}
											if(strs[k] == "AP6"){
												str+="<input  id='addAP6' type='button' value='订单影像附件' onclick='AP6("+data[i].ORDER_ID+")' />&nbsp; &nbsp;<br>";
											}
										}
										//str+="<input id='"+data[i].XJ_ORDER_ID+"acctSetup' disabled='disabled' type='button' value='确认放款' onclick='acctSetup("+data[i].XJ_ORDER_ID+","+data[i].MERCHANT_ID+","+data[i].XJ_ORDER_ID+","+data[i].LOAN_CODE+","+data[i].LOAN_AMOUNT+","+data[i].TERM+")' >&nbsp; &nbsp;</td></tr>";
								 	}
								 }else{
									str+="<input  id='addAP4' type='button' value='担保信息' onclick='AP4("+data[i].ORDER_ID+")' />&nbsp; &nbsp;<br>";
									str+="<input  id='addAP6' type='button' value='订单影像附件' onclick='AP6("+data[i].ORDER_ID+")' />&nbsp; &nbsp;<br>";
								 }
								 
								 
								 
					$("#table").append(str);
					}
					
				
			}

			function getstatus(status){
					if(status=="N"){
						return "未审核";
					}else if(status=="A"){
						return "放款已成功";
					}else if(status=="S"){
						return "订单征审中";
					}else if(status=="L"){
						return "订单已确认";
					}else if(status=="T"){
						return "订单已终止";
					}else if(status=="U"){
						return "撤销订单";
					}else if(status=="E"){
						return "征审失败";
					}else if(status=="X"){
						return "订单已过期";
					}else if(status=="B"){
						return "添加信息";  //添加担保人
					}else if(status=="C"){
						return "合同审核中";
					}else if(status=="R"){
						return "合同不通过";
					}else if(status=="G"){
						return "合同已审核";
					}else if(status=="P"){
						return "结清未入账";
					}else if(status=="D"){
						return "结清已入账";
					}else if(status=="W"){
						return "担保签署中";
					}else if(status=="H"){
						return "待签划扣书";
					}else if(status=="K"){
						return "合同已审核(银行)";
					}else if(status=="F"){
						return "银行已放款";
					}else if(status=="I"){
						return "待签委托担保协议";
					}else{
						return "其他";
					}
			}		
		
		function up(){
			$("#msg").html("");
			if(i<1){
			$("#msg").html("当前已是第一页");
				return;
			}
			i--;
			$("#up").css("display","true");
			$("#down").css("display","true");
			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath }/background/biz/signOn/query.html',
				dataType:'json',
				data:{pageNow:i},
				success:function(data){
				
					$("#table").html("");
					data = eval('(' + data + ')');
					
					 process(data);
					
				}
			});
			
			
		}
		function down(){
			$("#msg").html("");
			i++;
			$("#down").css("display","true");
			$("#up").css("display","true");
			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath }/background/biz/signOn/query.html',
				dataType:'json',
				data:{pageNow:i},
				success:function(data){
				
					data = eval('(' + data + ')');
					if(data.SERVICE.SERVICE_BODY.RESPONSE.ORDER_LIST.length==0){
					$("#msg").html("当前已是最后一页");
					i=i-2;
					console.log(i);
					return;
					}
					$("#table").html("");
					process(data);
				}
			});
			
			
		}
			
			
		function confirm(id,product_id,product_name,la,term,dp){
			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath }/background/system/order/confirmOrder.html',
				dataType:'json',
				data:{xj_order_id:id,product_id:product_id,product_name:product_name,loan_amount:la,term:term,down_payment:dp},
				success:function(data){
					data = eval('(' + data + ')');
					$("#msg").html(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
					if(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC=="交易成功"){
					$("#"+id+"confirm").attr('disabled','disabled');
					$("#"+id+"cancel").attr('disabled','disabled');
					$("#"+id+"dizhiya").attr('disabled','disabled');
					}
				}
			});
		}
		
		function cancel(id){
			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath }/background/system/order/cancelOrder.html',
				dataType:'json',
				data:{xj_order_id:id},
				success:function(data){
					data = eval('(' + data + ')');
					$("#msg").html(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
					if(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC=="交易成功"){
					$("#"+id+"cancel").attr('disabled','disabled');
					$("#"+id+"confirm").attr('disabled','disabled');
					$("#"+id+"dizhiya").attr('disabled','disabled');
					}
				}
			});
		}
	
		function code(id){
			window.location.href='${pageContext.servletContext.contextPath }/background/system/order/gotocodeOrderMake.html?id='+id;
		}
		
		function acctSetup(id,Mechan_id,Xj_order_id,Loan_code,Loan_amount,Term){
			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath }/background/system/order/acctSetup.html',
				dataType:'json',
				data:{Mechan_id:Mechan_id,Xj_order_id:Xj_order_id,Loan_code:Loan_code,Loan_amount:Loan_amount,Term:Term},
				success:function(data){
					data = eval('(' + data + ')');
					$("#msg").html(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC);
					if(data.SERVICE.SERVICE_HEADER.SERV_RESPONSE.DESC=="交易成功"){
						$("#"+id+"acctSetup").attr('disabled','disabled');
					}
				}
			});
		}
		
		function AP4(id){//担保
			window.location.href='${pageContext.servletContext.contextPath }/biz/guarantor/queryGuarantor.html?id='+id;
		}
		function dizhiya(id){//抵质押，订单未确认之前，都可以增进抵质押
			window.location.href='${pageContext.servletContext.contextPath }/biz/pledge/queryPledge.html?id='+id;
		}
		function AP6(id){
			window.location.href='${pageContext.servletContext.contextPath }/background/system/order/gotouploadfileimg.html?id='+id;
		}
		function AP7(id){
			window.location.href='${pageContext.servletContext.contextPath }/background/system/order/gotouploadfile.html?id='+id;
		}
	</script>
</html>


