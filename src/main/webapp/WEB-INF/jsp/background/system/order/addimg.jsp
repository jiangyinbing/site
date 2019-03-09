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
		<title>增加影像信息</title>
	</head>
	<body>
		<form action="" method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<a href="#">业务列表</a> >>
						<a href="#">订单列表</a> >>
						<a href="#">增加影像信息</a>
					</div>
					
					<table class="table_style table_font_center" width="100%"
									border="0" cellspacing="0" cellpadding="0">
						<tbody id="table">
							<tr align="center"><td>
								<div align="center">
								<img id="loading" src="${pageContext.servletContext.contextPath }/images/loading.gif" hidden/>
									<div id="preview_wrapper">
										
								        <div id="preview_fake">
								            <img id="preview" onload="onPreviewLoad(this)"/>
								            
								        </div>
									</div>
								    <br/>
								    <input id="upload_img" name="upload_img" type="file" onchange="onUploadImgChange(this)"/>
								    <br/>
								    <img id="preview_size_fake"/>
								    
								</div>
							</td></tr>
							<tr align="center"><td>
								<input type="button" value='确认上传' onclick="sub(${id})" class="btn"/>&nbsp; &nbsp;
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
		function sub(id){ 
		     //加载图标   
		     $("#loading").ajaxStart(function(){
		        $(this).show();
		     }).ajaxComplete(function(){
		        $(this).hide();
		     });
		      //上传文件
		    $.ajaxFileUpload({
		        url:'${pageContext.servletContext.contextPath }/background/system/order/addimg.html?id='+id,//处理图片
		        secureuri :false,
		        fileElementId :'upload_img',//file控件id
		        dataType : 'text',
		        success : function (data){
			        data = data.replace("<PRE>", '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre>text</pre>前后缀
					data = data.replace("</PRE>", '');
					data = data.replace("<pre>", '');
					data = data.replace("</pre>", ''); 
					data = eval('(' + data + ')');
			        alert("上传完成");
			        
		        }

			});
			return false;
		}
        
		
		
		function onUploadImgChange(sender){
			var objPreview = document.getElementById( 'preview' );
		    var objPreviewFake = document.getElementById( 'preview_fake' );
		    var objPreviewSizeFake = document.getElementById( 'preview_size_fake' );
		    if( !sender.value.match( /.jpg|.jpeg|.gif|.png|.bmp|.zip|.rar|.pdf|.txt|.doc|.xls|.ppt|.html|.docx|.xlsx|.pptx/i ) ){
		        alert('图片格式无效！');
		        objPreview.src = "";
		    }
			
		    if( sender.files && sender.files[0] ){
		        objPreview.style.display = 'block';
		        objPreview.style.width = 'auto';
		        objPreview.style.height = 'auto';
		        objPreview.src = window.URL.createObjectURL(document.getElementById("upload_img").files.item(0));
		    }else if( objPreviewFake.filters ){
		        // IE7,IE8 在设置本地图片地址为 img.src 时出现莫名其妙的后果
		        //（相同环境有时能显示，有时不显示），因此只能用滤镜来解决
		        sender.select();
		        var imgSrc = document.selection.createRange().text;
		        objPreviewFake.filters.item(
		            'DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;
		        objPreviewSizeFake.filters.item(
		            'DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;
		        autoSizePreview( objPreviewFake,
		            objPreviewSizeFake.offsetWidth, objPreviewSizeFake.offsetHeight );
		        objPreview.style.display = 'none';
		    }
		}
		function onPreviewLoad(sender){
		    autoSizePreview( sender, sender.offsetWidth, sender.offsetHeight );
		}
		function autoSizePreview( objPre, originalWidth, originalHeight ){
		    var zoomParam = clacImgZoomParam( 300, 300, originalWidth, originalHeight );
		    objPre.style.width = zoomParam.width + 'px';
		    objPre.style.height = zoomParam.height + 'px';
		    objPre.style.marginTop = zoomParam.top + 'px';
		    objPre.style.marginLeft = zoomParam.left + 'px';
		}
		//设置图片大小
		function clacImgZoomParam( maxWidth, maxHeight, width, height ){
		    var param = { width:width, height:height, top:0, left:0 };
		    if( width>maxWidth || height>maxHeight ){
		        rateWidth = width / maxWidth;
		        rateHeight = height / maxHeight;
		        if( rateWidth > rateHeight ){
		            param.width = maxWidth;
		            param.height = height / rateWidth;
		            param.left = (maxWidth - param.width) / 2;
		    		param.top = (maxHeight - param.height) / 2;
		        }else{
		            param.width = width / rateHeight;
		            param.height = maxHeight;
		            param.left = 0;
		    		param.top = 0;
		        }
		    }
		    
		    return param;
		}
	</script>
</html>