<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>企业信息维护</title>
    <jsp:include page="/common/default.jsp"></jsp:include>
</head>

<body  onLoad="checkCookie()" class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
                     <div class="col-sm-8">
                         <div class="form-inline">
                           <label>产品名称:</label>
							 <input type="text" placeholder="商户号"  id="merchant_params">
                           <label>商户号:</label>
                           <input type="text" placeholder="商户号"  id="merchant_params">
                           <label>商户名:</label>
                           <input type="text" placeholder="商户名"  id="merchantName_params">
                       	</div>
					<div class="col-sm-12">
                    	<div class="btn-group">
                           <button class="btn btn-success" type="button" onclick="queryUser()" data-toggle="modal">
                            	<i class="fa fa-plus"></i> 搜索
                            </button>
                            <button class="btn btn-primary" type="button" onclick="editSysUser('add');" data-toggle="modal">
                            	<i class="fa fa-plus"></i> 新增
                            </button>
                            <button class="btn btn-danger" type="button" onclick="editSysUser('edit');" data-toggle="modal">
                            	<i class="fa fa-edit"></i> 编辑
                            </button>
                        </div>
                     </div>
                   	</div>
				</div>
				<!-- 查询列表（表格） -->
                <table id="sysUserList" class="table table-striped table-bordered table-hover customer-default-table">	
                	<thead>
	                	<tr class="head">
	                        <th>序号</th>
				            <th>产品名称</th>
	                        <th>商户号</th>
				          	<th>商户名称</th>
				            <th>商户状态</th>
				            <th>是否为掌臻商户</th>
				            <th>创建时间</th>
				            <th>更新时间</th>
						</tr>
			        </thead>
				    <tbody>
					</tbody>
     			</table>                               
			</div><!-- end col-sm-12-->
		</div><!-- end row -->
		
		<!-- 弹出窗口 -->
		<div id="newSysUserWin" class="modal fade"></div>
	</div>
	<script>
		var $bizTypeCode_name="";
		var $merchantNo_name="";
		var $merchantName_name="";
		//初始化商户tab页数据
		function initSysUsersData(){
			var userList= $('#sysUserList').dataTable({
				"sAjaxSource" : path+"/merchant/query.htm",
				"fnServerParams": function(aoData){
		        	aoData.push({"name":'bizTypeCode',"value":$bizTypeCode_name});
		        	aoData.push({"name":'merchantNo',"value":$merchantNo_name});
		        	aoData.push({"name":'merchantName',"value":$merchantName_name});
		        },
				 "bLengthChange": false, //改变每页显示数据数量
		            "bFilter": false, //过滤功能
		            "bProcessing": true, //开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
		            "bServerSide": true, //开启服务器模式，使用服务器端处理配置datatable。注意：sAjaxSource参数也必须被给予为了给datatable源代码来获取所需的数据对于每个画。 这个翻译有点别扭。
		            "iDisplayLength": 10,//每页显示10条数据
			        "fnInitComplete": sysUserdrawCompleteFun,
		        aoColumns:[
					{mData:"id",sWidth:"20px"},
					{mData:'bizcode',"sWidth":"100px"},
					{mData:'merchantno',"sWidth":"100px"},
					{mData:'merchantname',"sWidth":"100px"},
					{mData:'status',sWidth:'160px',
						 mRender:function( data, type, row){
							 if(data == 'Y'){
								return '<span class="label label-primary">有效';
							 }else if(data == 'N'){
								 return '<span class="label label-danger">无效';
							 }
							 else
							 {
								 return '<span class="label label-default">'+data;
							 }
					 	}
					 },
					 {mData:'exts',sWidth:'160px',
						 mRender:function( data, type, row){
							 if(data == 'Y'){
								return '<span class="label label-primary">是';
							 }else if(data == 'N'){
								 return '<span class="label label-danger">否';
							 }
							 else
							 {
								 return '<span class="label label-default">'+data;
							 }
					 	}
					 },
					 {mData:'gmtCreate',"sWidth":"50px",
							mRender:function( data, type, row){
								 if(data !=null){
									var createdate=new Date(data.time);
									return FormatDate(createdate);
								 }
								 else
								 {
									 return data;
								 }
						 	}	
						},
						{mData:'gmtModified',"sWidth":"50px",
							mRender:function( data, type, row){
								 if(data !=null){
									var createdate=new Date(data.time);
									return FormatDate(createdate);
								 }
								 else
								 {
									 return data;
								 }
						 	}		
						},
				]
			});
		}
		
		function sysUserdrawCompleteFun(){
			//表格行被点击的事件  --->写法1，推荐使用：将click事件定义在tbody上，如果调用fnReloadAjax()方法，click事件仍然生效
			$("#sysUserList tbody").click(function(e){
				var index=$(e.target.parentNode).prevAll().length;
				$("table tbody").each(function(key,val){
					$(this).children().removeClass('info');
					$($(this).children().get(index)).addClass('info');
					//清空所有的checkbox
					//$("#sysUserList :checkbox").attr("checked", false);
					//默认选中当前行...
					//$($(this).children().get(index)).children().find("input[type='checkbox']").attr("checked",true);
					if(key==0){
						$user_id=$('#sysUserList').dataTable().fnGetData($(this).children().get(index)).id;
					}
				});
			});
		}
		function queryUser(){
			$bizTypeCode_name=$('#bizTypeCode_params').val();
			$merchantNo_name=$('#merchant_params').val();
			$merchantName_name=$('#merchantName_params').val();
			$('#sysUserList').dataTable().fnReloadAjax();
		}
		//编辑商户
		function editSysUser(type){
			if('add'==type){ // 新增
				$user_id ="0";
				if($(".info").length>0){ // 是否有选中项
					$(".info").removeClass("info");
				}
				$.yf.openWin("#newSysUserWin",'/merchant/edit.htm',{'id':$user_id});
			}else if('edit'==type){  // 编辑
				if($(".info").length>0){
					$.yf.openWin('#newSysUserWin','/merchant/edit.htm',{'id':$user_id});
				}else{
					notyMsg('请选择一条记录...');
				}
			}
		}
		function FormatDate (date) {
		    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds() ;
		}
		//初始化
		initSysUsersData();
	</script>
</body>

</html>