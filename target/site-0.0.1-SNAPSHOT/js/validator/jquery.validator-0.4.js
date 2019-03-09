/*
    jQuery Form Validators v0.4
    Website: http://validator.codeplex.com/
    License: http://validator.codeplex.com/license
    Examples:
    <input type='text' data-validator-group="groupName" data-validator-required="please enter a value" />
    <input type='text' data-validator-group="groupName" data-validator-email="invalid email" />
    <input type='text' data-validator-group="groupName" data-validator-regular="must be less than 6 chars long" data-validator-validexpress=".{6,}" />
    <input type='text' data-validator-group="groupName" data-validator-regular="must be less than 6 chars long" data-validator-invalidexpress=".{,6}" />
    <input type='text' data-validator-group="groupName" data-validator-compare="password mismatch" compareTo="button1" />
    <input type='text' data-validator-group="groupName" data-validator-custom="must be less than 6 chars long" data-validator-customfn="this.length < 6" />
    <input type='text' data-validator-group="groupName" data-validator-invalid="username cannot be used" data-validator-invalidVal="username" />
*/

var validate;

(function ($) {

    validate = function (group) {
        var marker = true;
        $("*[data-validator-group=" + group + "]").each(function (i, elm) {
            if (check(elm)) {
                $(elm).highlight();
                if (marker)
                    $(elm).find(":input").andSelf().focus();
                marker = false;
            }
            else
                $(elm).unhighlight();
        });
        return marker;
    }

    function revalidate() {
        if (!check(this))
            $(this).unhighlight();
        else
            $(this).highlight();
    }

    function check(elm) {
        var jelm = $(elm);

        var listsize = jelm.find("input:radio, input:checkbox").size();
        if (jelm.attr("disabled") || listsize > 0 && listsize == jelm.find("input:radio:disabled, input:checkbox:disabled").size())
            return "";

        //if empty value only perform required validation
        if ((jelm.val() == "" || jelm.val() == null || jelm.is("input:checkbox:not(':checked')")) && jelm.find("input:radio:checked, input:checkbox:checked").size() == 0)
            return jelm.data("validator-required") ? "validator-required" : "";

        if (jelm.data("validator-regular") && jelm.data("validator-validexpress") && !new RegExp(jelm.data("validator-validexpress"), "m").test(jelm.val()))
            return "validator-regular";

        if (jelm.data("validator-regular") && jelm.data("validator-invalidexpress") && new RegExp(jelm.data("validator-invalidexpress"), "m").test(jelm.val()))
            return "validator-regular";

        if (jelm.data("validator-compare") && $("#" + jelm.data("validator-compareto")).val() != jelm.val())
            return "validator-compare";
        
        if (jelm.data("validator-custom") && !new Function(jelm.data("validator-customfn")).call(elm))
            return "validator-custom";
        
        if (jelm.data("validator-ajaxmsg") && !callAjax(jelm.data("validator-ajax"),elm))
            return "validator-ajaxmsg";
        
        if (jelm.data("validator-invalid") && jelm.val() == jelm.data("validator-invalidval"))
            return "validator-invalid";

        if (validators != undefined) {
            for (var name in validators)
                if (jelm.data("validator-" + name) && !callReg(validators[name],elm))
                    return "validator-" + name;
        }
    }
    function callAjax(tourl,elm){
     var flag=false;
     $.ajax({
    	 url:tourl,async:false,data:{'alias':elm.value},
    	 success:function(data)
    	 {if(0 ==data){flag=true;}}
    	 });
     return flag;
   	}
    function callReg(regexp,elm){
	 return new RegExp(regexp, "mi").test(elm.value); 
	}
    function showAlert() {
        var ctrl = $(this);
        var top = ctrl.offset().top + ctrl.height() + 4;
        var left = ctrl.offset().left + Math.max(ctrl.width() - 260, 0);
        ctrl.parents().each(function () {
            if ($(this).css("position") != "static" && (!$.browser.mozilla || $(this).css("display") != "table")) {
                var offset = $(this).offset();
                top -= offset.top;
                left -= offset.left;
                return false;
            }
        });
        ctrl.parent().children(".alertbox").remove();
        ctrl.parent().append("<div class='alertbox' style='top:" + top + "px; left:" + left + "px;'><div>" + ctrl.data(check(this)) + "</div></div>");
    }

    function hideAlert() {
        $(this).parent().children(".alertbox").remove();
    }

    $.fn.highlight = function () { this.addClass("highlight").focus(showAlert).blur(hideAlert).change(revalidate); return this; }
    $.fn.unhighlight = function () { this.removeClass("highlight").unbind("focus", showAlert).unbind("blur", hideAlert).parent().children(".alertbox").remove(); return this; }

})(jQuery);

//create your own custom validators below
//validator name is mapped to attribute name on form field (must be all lower case can use '-' to separate words) e.g. "email" => <input data-validator-email="error message" />
//validator function should return true if valid and false if not
var validators ={
		intege:"^-?[1-9]\\d*$",					//整数
		intege1:"^[1-9]\\d*$",					//正整数
		intege2:"^-[1-9]\\d*$",					//负整数
		num:"^([+-]?)\\d*\\.?\\d+$",			//数字
		num1:"^[1-9]\\d*|0$",					//正数（正整数 + 0）
		num2:"^-[1-9]\\d*|0$",					//负数（负整数 + 0）
		decmal:"^([+-]?)\\d*\\.\\d+$",			//浮点数
		decmal1:"^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$",　　	//正浮点数
		decmal2:"^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$",　 //负浮点数
		decmal3:"^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$",　 //浮点数
		decmal4:"^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$",　　 //非负浮点数（正浮点数 + 0）
		decmal5:"^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$",　　//非正浮点数（负浮点数 + 0）
		email:"^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$", //邮件
		color:"^[a-fA-F0-9]{6}$",				//颜色
		url:"^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$",	//url
		chinese:"^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$",					//仅中文
		ascii:"^[\\x00-\\xFF]+$",				//仅ACSII字符
		zipcode:"^\\d{6}$",						//邮编
		mobile:"^(13|15)[0-9]{9}$",				//手机
		ip4:"^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$",	//ip地址
		notempty:"^\\S+$",						//非空
		picture:"(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$",	//图片
		rar:"(.*)\\.(rar|zip|7zip|tgz)$",								//压缩文件
		excel:"(.*)\.(xls|xlsx)$",								//excel文件
		date:"^\\d{4}(\\-|\\/|\.)\\d{1,2}\\1\\d{1,2}$",					//日期
		qq:"^[1-9]*[1-9][0-9]*$",				//QQ号码
		tel:"^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$",	//电话号码的函数(包括验证国内区号,国际区号,分机号)
		username:"^\\w+$",						//用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
		letter:"^[A-Za-z]+$",					//字母
		letter_u:"^[A-Z]+$",					//大写字母
		letter_l:"^[a-z]+$",					//小写字母
		idcard:"^[1-9]([0-9]{14}|[0-9]{17})$"	//身份证
};

var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"} 

function isCardID(sId){ 
	var iSum=0 ;
	var info="" ;
	if(!/^\d{17}(\d|x)$/i.test(sId)) return "你输入的身份证长度或格式错误"; 
	sId=sId.replace(/x$/i,"a"); 
	if(aCity[parseInt(sId.substr(0,2))]==null) return "你的身份证地区非法"; 
	sBirthday=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2)); 
	var d=new Date(sBirthday.replace(/-/g,"/")) ;
	if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))return "身份证上的出生日期非法"; 
	for(var i = 17;i>=0;i --) iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;
	if(iSum%11!=1) return "你输入的身份证号非法"; 
	return true;//aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女") 
} 




//短时间，形如 (13:04:06)
function isTime(str)
{
	var a = str.match(/^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/);
	if (a == null) {return false}
	if (a[1]>24 || a[3]>60 || a[4]>60)
	{
		return false;
	}
	return true;
}

//短日期，形如 (2003-12-05)
function isDate(str)
{
	var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
	if(r==null)return false; 
	var d= new Date(r[1], r[3]-1, r[4]); 
	return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
}

//长时间，形如 (2003-12-05 13:04:06)
function isDateTime(str)
{
	var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/; 
	var r = str.match(reg); 
	if(r==null) return false; 
	var d= new Date(r[1], r[3]-1,r[4],r[5],r[6],r[7]); 
	return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]&&d.getHours()==r[5]&&d.getMinutes()==r[6]&&d.getSeconds()==r[7]);
}