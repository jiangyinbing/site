$(function(){
	// 联系人指针聚焦验证
	$("#link1").focus(function(){$("#linkTip1").html("");});
	$("#link2").focus(function(){$("#linkTip2").html("");});
	// 关系指针聚焦验证
	$("#linkrelation1").focus(function(){$("#linkrealtionTip1").html("");});
	$("#linkrelation2").focus(function(){$("#linkrealtionTip2").html("");});
	// 移动电话指针聚焦验证
	$("#linkmobile1").focus(function(){$("#mobileTip1").html("");});
	$("#linkmobile2").focus(function(){$("#mobileTip2").html("");});
	// 证 件 类 型指针聚焦验证
	$("#idNo1").focus(function(){$("#idNoTip1").html("");});
	$("#idNo2").focus(function(){$("#idNoTip2").html("");});
	// 单 位 名 称指针聚焦验证
	$("#unitName1").focus(function(){$("#unitNameTip1").html("");});
	$("#unitName2").focus(function(){$("#unitNameTip2").html("");});
	// 单 位 电 话指针聚焦验证
	$("#unitPhone1").focus(function(){$("#unitPhoneTip1").html("");});
	$("#unitPhone2").focus(function(){$("#unitPhoneTip2").html("");});
	
	// 联系人失焦验证
	$("#link1").blur(function(){
		var linkValidate = /^[\u4E00-\u9FA5]{1,6}$/;
		var lk = $("#link1").val();
		if(lk.trim().length==0){
		   	$("#linkTip1").html("请输入联系人姓名!");
		}else if(!linkValidate.test(lk)){
		   	$("#linkTip1").html("请输入真实姓名!");
		}else{
		   	$("#linkTip1").html("");
		}
	});
	$("#link2").blur(function(){
		var linkValidate = /^[\u4E00-\u9FA5]{1,6}$/;
		var lk = $("#link2").val();
		if(lk.trim().length==0){
		   	$("#linkTip2").html("请输入联系人姓名!");
		}else if(!linkValidate.test(lk)){
		   	$("#linkTip2").html("请输入真实姓名!");
		}else{
		   	$("#linkTip2").html("");
		}
	});
	
	// 关系选择改变验证事件
	$("#linkrelation1").blur(function(){
		var linkrelation = $("#linkrelation1").val();
		if(linkrelation.trim().length==0){
			$("#linkrelationTip1").html("请输入职位!");
		}else{
			$("#linkrelationTip1").html("");
		}
	});
	// 关系选择改变验证事件
	$("#linkrelation1").change(function(){
		var linkrelation = $("#linkrelation1").val();
		if(linkrelation=="0"){
			$("#linkrelationTip1").html("请选择关系!");
		}else if(linkrelation.trim().length==0){
			$("#linkrelationTip1").html("请输入职位!");
		}else{
			$("#linkrelationTip1").html("");
		}
	});
	$("#linkrelation2").blur(function(){
		var linkrelation = $("#linkrelation2").val();
		if(linkrelation=="0"){
			$("#linkrelationTip2").html("请选择关系!");
		}else if(linkrelation.trim().length==0){
			$("#linkrelationTip2").html("请输入职位!");
		}else{
			$("#linkrelationTip2").html("");
		}
	});
	$("#linkrelation2").change(function(){
		var linkrelation = $("#linkrelation2").val();
		if(linkrelation=="0"){
			$("#linkrelationTip2").html("请选择关系!");
		}else if(linkrelation.trim().length==0){
			$("#linkrelationTip2").html("请输入职位!");
		}else{
			$("#linkrelationTip2").html("");
		}
	});
	// 移动手机验证
	$("#linkmobile1").blur(function(){
		var linkmobile = $("#linkmobile1").val();
		var mobileValidate = new RegExp("^1[3|4|5|7|8]\\d{9}$");
		if(linkmobile.trim().length == 0){
   			$("#linkmobileTip1").html("请输入手机号!");
		}else if(!mobileValidate.test(linkmobile)){
   			$("#linkmobileTip1").html("请输入正确的手机号!");
	   	}else{
   			$("#linkmobileTip1").html("");
   		}
	});
	$("#linkmobile2").blur(function(){
		var linkmobile = $("#linkmobile2").val();
		var mobileValidate = new RegExp("^1[3|4|5|7|8]\\d{9}$");
		if(linkmobile.trim().length == 0){
   			$("#linkmobileTip2").html("请输入手机号!");
		}else if(!mobileValidate.test(linkmobile)){
   			$("#linkmobileTip2").html("请输入正确的手机号!");
	   	}else{
   			$("#linkmobileTip2").html("");
	   	}
	});
	// 身份证号码失焦验证
	$("#idNo1").blur(function(){
		var ino = $("#idNo1").val();
		var inoValidate = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
		if(ino.trim().length==0){
		   	$("#idNoTip1").html("请输入身份证号!");
		}else if(!inoValidate.test(ino)){
			$("#idNoTip1").html("请输入正确的身份证!");
		}else{
		   	$("#idNoTip1").html("");
		}
	});
	$("#idNo2").blur(function(){
		var ino = $("#idNo2").val();
		var inoValidate = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
		if(ino.trim().length==0){
		   	$("#idNoTip2").html("请输入身份证号!");
		}else if(!inoValidate.test(ino)){
			$("#idNoTip2").html("请输入正确的身份证!");
		}else{
		   	$("#idNoTip2").html("");
		}
	});
//	// 单位名称失焦验证
//	$("#unitName1").blur(function(){
//		var ino = $("#unitName1").val();
//		var inoValidate = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
//		if(ino.trim().length==0){
//			$("#unitNameTip1").html("请输入单位名称!");
//		}else{
//			$("#unitNameTip1").html("");
//		}
//	});
//	$("#unitName2").blur(function(){
//		var ino = $("#unitName2").val();
//		if(ino.trim().length==0){
//			$("#unitNameTip2").html("请输入单位名称!");
//		}else{
//			$("#unitNameTip2").html("");
//		}
//	});
	// 单位电话失焦验证
	$("#unitPhone1").blur(function(){
		var linkValidate = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
		var ino = $("#unitPhone1").val();
//		if(ino.trim().length==0){
//			$("#unitPhoneTip1").html("请输入单位电话!");
//		}else if(!linkValidate.test(ino)){
		if(!(ino.trim().length==0)){
			if(!linkValidate.test(ino)){
				$("#unitPhoneTip1").html("请输入正确的单位电话!");
			}else{
				$("#unitPhoneTip1").html("");
			}
		}else{
			$("#unitPhoneTip1").html("");
		}
	});
	$("#unitPhone2").blur(function(){
		var linkValidate = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
		var ino = $("#unitPhone2").val();
//		if(ino.trim().length==0){
//			$("#unitPhoneTip2").html("请输入单位电话!");
//		}else if(!linkValidate.test(ino)){
		if(!linkValidate.test(ino)){
			$("#unitPhoneTip2").html("请输入正确的单位电话!");
		}else{
			$("#unitPhoneTip2").html("");
		}
	});
});

// 点击保存按钮时的验证操作
function check(){
	// 联系人1  
   	var link1 = $("#link1").val();
   	var linkrelation1 = $("#linkrelation1").val();
   	var linkmobile1 = $("#linkmobile1").val();
   	var idNo1 = $("#idNo1").val();
   	var unitName1 = $("#unitName1").val();
   	var unitPhone1 = $("#unitPhone1").val();
   	
   	var linkValidate = /^[\u4E00-\u9FA5]{1,6}$/;						// 姓名纯中文的验证
   	var mobileValidate = new RegExp("^1[3|4|5|7|8][0-9]\\d{8}$");		// 手机号验证
   	var inoValidate = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
   	var telValidate = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;			// 固定号码验证
   	// 最终返回验证结果
   	var flag = true;
   
   	// 联系人姓名验证1
	if(link1.trim().length==0){
	   	$("#linkTip1").html("请输入联系人姓名!");
    	flag = false;
	}else if(!linkValidate.test(link1)){
	   	$("#linkTip1").html("请输入真实姓名!");
    	flag = false;
	}
	// 关系验证1
	if(linkrelation1=='0'){
	   	$("#linkrelationTip1").html("请选择关系!");
    	flag = false;
    }
	if(linkrelation1.trim().length==0){
	   	$("#linkrelationTip1").html("请输入联系人关系!");
    	flag = false;
	}
	// 联系人手机号验证1
	if(linkmobile1.trim().length==0){
	   	$("#linkmobileTip1").html("请填写手机号!");
    	flag = false;
    }else if(!mobileValidate.test(linkmobile1)){
	   	$("#linkmobileTip1").html("请填写正确的手机号!");
    	flag = false;
    }
	// 联系人姓名验证1
	if(link1.trim().length==0){
	   	$("#linkTip1").html("请输入联系人姓名!");
    	flag = false;
	}else if(!linkValidate.test(link1)){
	   	$("#linkTip1").html("请输入真实姓名!");
    	flag = false;
	}
	// 身份证号码验证1
	if(idNo1.trim().length==0){
		$("#idNoTip1").html("请输入身份证号码!");
		flag = false;
	}else if(!inoValidate.test(idNo1)){
		$("#idNoTip1").html("请输入正确的身份证!");
		flag = false;
	}
//	// 单位名称验证1
//	if(unitName1.trim().length==0){
//		$("#unitNameTip1").html("请输入单位名称!");
//		flag = false;
//	}
//	// 单位电话验证1
//	if(unitPhone1.trim().length==0){
//		$("#unitPhoneTip1").html("请输入单位电话!");
//		flag = false;
//	}else if(!telValidate.test(unitPhone1.trim())){
//		$("#unitPhoneTip1").html("请输入正确的单位电话!");
//		flag = false;
//	}
	if(unitPhone1.trim().length!=0 && !telValidate.test(unitPhone1.trim())){
		$("#unitPhoneTip1").html("请输入正确的单位电话!");
		flag = false;
	}
    
//    // 联系人2
//   	var link2 = $("#link2").val();
//  	var linkrelation2 = $("#linkrelation2").val();
//   	var linkmobile2 = $("#linkmobile2").val();
//	var idNo2 = $("#idNo2").val();
//   	var unitName2 = $("#unitName2").val();
//   	var unitPhone2 = $("#unitPhone2").val();
//   	
//	// 联系人2验证
//    if(!(link2.trim().length==0)){
//    	alert("555");
//    	// 姓名验证
//    	if(link2.trim().length==0){
//		   	$("#linkTip2").html("请输入联系人姓名!");
//	    	flag = false;
//		}else if(!linkValidate.test(link2)){
//		   	$("#linkTip2").html("请输入真实姓名!");
//	    	flag = false;
//		}else if(link2.trim()==link1.trim()){
//			$("#linkTip2").html("请不要输入同一联系人!");
//			flag = false;
//		}
//		// 关系验证
//	   	if(linkrelation2=="0"){
//	   		$("#linkrelationTip2").html("请选择关系!");
//	    	flag = false;
//	   	}
//	   	// 移动手机号验证
//		if(linkmobile2.trim().length==0){
//		   	$("#linkmobileTip2").html("请填写手机号!");
//	    	flag = false;
//	    }else if(!mobileValidate.test(linkmobile2)){
//		   	$("#linkmobileTip2").html("请填写正确的手机号!");
//	    	flag = false;
//	    }else if(linkmobile2.trim()==linkmobile1.trim()){
//		   	$("#linkmobileTip2").html("请不要输入相同的手机号!");
//	    	flag = false;
//	    }
//		// 证件类型验证2
//		if(idNo2.trim().length==0){
//			$("#idNoTip2").html("请输入证件类型!");
//			flag = false;
//		}else if(!inoValidate.test(idNo2)){
//			$("#idNoTip1").html("请输入正确的身份证!");
//			flag = false;
//		}
////		// 单位名称验证2
////		if(unitName2.trim().length==0){
////			$("#unitNameTip2").html("请输入单位名称!");
////			flag = false;
////		}
////		// 单位电话验证2
////		if(unitPhone2.trim().length==0){
////			$("#unitPhoneTip2").html("请输入单位电话!");
////			flag = false;
////		}else if(!telValidate.test(unitPhone2.trim())){
////			$("#unitPhoneTip2").html("请输入正确的单位电话!");
////			flag = false;
////		}
//		if(!telValidate.test(unitPhone2.trim())){
//			$("#unitPhoneTip2").html("请输入正确的单位电话!");
//			flag = false;
//		}
//   	}
    
   	if(flag){
   		document.addLinkForm.submit();
   	}
}