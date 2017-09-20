//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"
});

//重构提交的URL,加入时间,确保每次都能进Controller
function wrapUrl(url) {
	var result = url;
	var index = url.indexOf("?");
	if (index > 0) {
		result = result + "&date=" + new Date();
	} else {
		result = result + "?date=" + new Date();
	}
	return result;
}

// url 提交地址
// onSuccess 处理完跳转的方法
// paras 提交参数
// method (post,get)
// isAsync (异步调用true,同步处理false)
function ajaxRequest(url, onSuccess, paras, method, isAsync) {
	$.ajax({
		type : method,
		url : url,
		cache:false, // 禁止使用jquery缓存（Jquery1.2++）
		async : isAsync,
		data : paras,
		// beforeSend:showLoading(),
		success : function(request) {
			onSuccess(request);
		},
		error : function(xhr, ts, et) {
			//alert("服务调用失败!");
			layer.msg('服务调用失败!', {icon: 2});
		},
		timeout : 120000
	});
}

function formatTime(javaTimeLongValue,mask){
    var d = new Date(javaTimeLongValue);
    var zeroize = function (value, length){
        if (!length) length = 2;
        value = String(value);
        for (var i = 0, zeros = ''; i < (length - value.length); i++){
            zeros += '0';
        }
        return zeros + value;
    };
 
    return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0){
        switch ($0){
            case 'd': return d.getDate();
            case 'dd': return zeroize(d.getDate());
            case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
            case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
            case 'M': return d.getMonth() + 1;
            case 'MM': return zeroize(d.getMonth() + 1);
            case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
            case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
            case 'yy': return String(d.getFullYear()).substr(2);
            case 'yyyy': return d.getFullYear();
            case 'h': return d.getHours() % 12 || 12;
            case 'hh': return zeroize(d.getHours() % 12 || 12);
            case 'H': return d.getHours();
            case 'HH': return zeroize(d.getHours());
            case 'm': return d.getMinutes();
            case 'mm': return zeroize(d.getMinutes());
            case 's': return d.getSeconds();
            case 'ss': return zeroize(d.getSeconds());
            case 'l': return zeroize(d.getMilliseconds(), 3);
            case 'L': var m = d.getMilliseconds();
                if (m > 99) m = Math.round(m / 10);
                return zeroize(m);
            case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
            case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
            case 'Z': return d.toUTCString().match(/[A-Z]+$/);
            // Return quoted strings with the surrounding quotes removed
            default: return $0.substr(1, $0.length - 2);
        }
    });
};

//表格第一列序号绘制
function drawDataTableIndexRowLine(oSettings){
	var api = this.api();
	var startIndex= 0;//获取到本页开始的条数
	api.column(0).nodes().each(function(cell, i) {
		cell.innerHTML = "<center>"+(startIndex + i + 1)+"</center>";
	});
}

$(function () {
	notyMsg=function(text){
		noty({text: text,type: "information",dismissQueue: true,layout: 'topRight',theme: 'defaultTheme',timeout:3000});
	},
	//封装常用操作 		--add by lish
    jQuery.yf={
		openWin:function(id,url,params){
			//$(id).parent().showLoading();
			$(id).load(path+url,params,function(data){
				//$(this).parent().hideLoading();
				$(this).fadeIn('fast');
			});
			$(id).modal();
		},
		link:function(linkName){
			$.each(links,function(){
				if(linkName==this['name']){
					if(linkName=='注销')
						window.location.href=path+this['url'];
					else{
						$('#content').showLoading();
						$('#homepage').hide();
						$('#content').fadeOut().load(path+this['url'],function(){
							$('#content').hideLoading();
							$(this).fadeIn('fast');
						});
					}
				}
				return ;
			})
		},
		linkToUrl:function(url,params){
			$('#content').showLoading();
			$('#homepage').hide();
			$('#content').fadeOut().load(path+url,params,function(){
                //History.pushState(null, null, path+url);
				$('#content').hideLoading();
				$(this).fadeIn('fast');
			});
			return ;
			
		},
		initDataTable:function(newopts){
			//ITS datatable 默认配置
			var defaults={
				"bProcessing": true,
		        "bServerSide": true,
		        "bInfo":true,
		        "bFilter": false,
		        "bSort" : false,
		        "bAutoWidth": false,
		        "bLengthChange": false,
		        "iDisplayLength":20,
		        "sServerMethod": "POST",
		        "sZeroRecords": "没有找到符合条件的数据aaa"	,
		        "oLanguage": {
		        	"sLengthMenu": "每页显示 _MENU_条",
		        	"sZeroRecords": sZeroRecords,
		        	//"sProcessing": "&lt;img src=’./loading.gif’ /&gt;",
		        	"sProcessing": "数据加载中...",
		        	"sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",
		        	"sInfoEmpty": "没有记录",
		        	"sInfoFiltered": "",
		        	"sSearch": "",
		        	"oPaginate": {
			        	"sFirst": "首页",
			        	"sPrevious": "前一页",
			        	"sNext": "后一页",
			        	"sLast": "尾页"
		        	}
	        	}
			};
			var opts = $.extend(true,defaults,newopts);
			return opts;
		},
		//获得当前选中的行并返回数据
		fnGetSelected:function( oTableLocal ){
			var aReturn = new Array();
			var aTrs = oTableLocal.fnGetNodes();
			for ( var i=0 ; i<aTrs.length ; i++ ){
				if ( $(aTrs[i]).hasClass('rowSelected') ){
					aReturn.push( aTrs[i] );
				}
			}
			return aReturn;
		},
		//删除数据
		deleData:function(url,params,oTable){
			$.ajax({
			    type: "post",
			    cache:false,
			    dataType: "json",
			    url: path+url,
			    data:params,
			    success: function(data){
			    	if(data.message){
			    		oTable.fnDraw();
			    		layer.msg('的确很重要', {icon: 1});
			    	}else{
			    		alter("error");
			    	}
			    },
			    error: function(e) { 
			    	layer.msg('服务端异常！', {icon: 3});
		    	} 
			});
		}
	}
});