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
		<script src="${pageContext.servletContext.contextPath }/js/jquery-1.4.min.js" type="text/javascript"></script>  
		<script src="${pageContext.servletContext.contextPath }/js/ajaxfileupload.js" type="text/javascript"></script>  
		<title>增加影像附件</title>
	</head>
	<body>
		<form action="" method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">业务列表</a> >>
						<a href="#">影像信息</a>
					</div>
					
					<table class="table_style table_font_center" width="100%"
									border="0" cellspacing="0" cellpadding="0">
						<tbody id="table1">
							<tr align="center">已上传影像信息</tr>
							<tr align="center">
								<td>文件标题</td>
								<td>上传日期</td>
								<td>下载</td>
							</tr>
						</tbody>
					</table>
					<div hight="30px"></div>
					<table class="table_style table_font_center" width="100%"
									border="0" cellspacing="0" cellpadding="0">
						<tbody id="table2">
							<tr align="center">添加影像附件</tr>
							<tr align="center">
								<td>标题</td>
								<td>选择文件</td>
								<td>按钮</td>
							</tr>
							<tr align="center">
								<input type="button" value='增加' onclick="sub()" class="btn"/>&nbsp; &nbsp;
								<input type="hidden" value='${id}' id="orderid"/>&nbsp; &nbsp;
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
		
	</body>
	
	<script type="text/javascript">
		var table=0;
		function sub(){ 
			table++;
		     $("#table2").append("<tr><td><input id='"+table+"t' type='text' size='50'></td><td><input id='upload"+table+"' name='upload' type='file' onchange='gettitle(this)' class='"+table+"t'></td><td><input id='uploadsub"+table+"t' type='button' value='确认上传' disabled='disabled' onclick='uploadfile("+table+")' class='btn'/>&nbsp; &nbsp;</td></tr>");
		}
        function uploadfile(fid){
        	//加载图标   
		     $("#uploadsub"+fid+"t").ajaxStart(function(){
		        $(this).attr('disabled','disabled');
		        $(this).val("正在上传");
		     }).ajaxComplete(function(){
		        $(this).val("上传完成");
		     });
		     
			var title = $("#"+fid+"t").val();
			var id = $("#orderid").val();
        	$.ajaxFileUpload({
		        url:'${pageContext.servletContext.contextPath }/background/system/order/addimg.html?id='+id+'&title='+encodeURI(encodeURI(title)),//处理图片
		        secureuri :false,
		        fileElementId : 'upload'+fid,//file控件id
		        dataType : 'text',
		        success : function (data){
			        list();
			        
		        }

			});
			return false;
		}
        
        function gettitle(uploadid){
        	var i = uploadid.value;
        	i = i.split("\\");
        	i = i[i.length-1];
        	i = i.split(".");
        	$("#"+uploadid.className).val(i[0]);
        	$("#uploadsub"+uploadid.className).attr('disabled','');
        	$("#uploadsub"+uploadid.className).val("确认上传");
        }
		
		
		//查询附件信息
		$(function(){
			list();
		});

		function list(){
			var orderId = $("#orderid").val();

			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath }/background/system/order/filelist.html?orderId='+orderId,
				dataType:'json',
				success:function(data){
					process(data);
				}
			});
		}
		
		function process(data){
				$("#table1").empty();
				var th = "<tr align='center'>已上传附件信息</tr>"+
							"<tr align='center'>"+
								"<td>文件标题</td>"+
								"<td>上传日期</td>"+
								"<td>下载</td></tr>";
				$("#table1").append(th);
				
					for(var i =0;i<data.length;i++){
						var str = "<tr>"+
								 "<td  width='8%' ><input type='hidden' id='"+data[i].upload_file+"title' value='"+data[i].title+"'>"+data[i].title+"</div></td>"+
								 "<td  width='8%' ><input type='hidden' id='"+data[i].upload_file+"id' value='"+data[i].upload_file+"'><input type='hidden' id='"+data[i].upload_file+"type' value='"+data[i].upload_time+"'>"+data[i].upload_time+"</div></td>"+
								 "<td id='"+data[i].upload_file+"xz' width='8%' ><input id='"+data[i].upload_file+"xz' type='button' value='下载' onclick='down("+data[i].upload_file+")' >&nbsp; &nbsp;</td></tr>";
						$("#table1").append(str);
					
					}
					
			}
			
			function down(id){
				var name = $("#"+id+"title").val();
				var dir = $("#"+id+"type").val();
				var fileid = $("#"+id+"id").val();
				window.location.href='${pageContext.servletContext.contextPath }/background/system/order/filedown.html?filename='+name+'&filedir='+dir+'&id='+fileid;
			}
			
			
	</script>
</html>