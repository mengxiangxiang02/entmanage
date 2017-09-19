<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script type="text/javascript">
</script>
<div class="modal-dialog" style="width: 800px; height: 500px;">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title">商户配置</h4>
		</div>
		<form class="form-horizontal" id="sysUserForm">
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<label class="col-sm-2 control-label">商户号：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="商户号" class="form-control"
									name="merchantno">
							</div>
							<label class="col-sm-2 control-label">商户名：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="商户名" class="form-control"
									name="merchantname">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label">支付渠道：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="支付渠道" class="form-control"
									name="bizcode">
							</div>
							<label class="col-sm-2 control-label">合同状态：</label>
							 <div class="col-sm-4">
								 <select id ="status"  name ="status" class="imput-md form-control">
	                           			<option value="Y">有效</option>
	                           			<option value="N">无效</option>
	                           		</select>
	                          </div> 			
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">创建时间：</label>
							<div class="col-sm-4">
							   <input type="text"  name="gmtCreate"  placeholder="创建时间"  class="form-control">
							</div>
							<label class="col-sm-2 control-label">是否为掌臻商户：</label>
							 <div class="col-sm-4">
								 <select id ="exts"  name ="exts" class="imput-md form-control">
	                           			<option value="Y">是</option>
	                           			<option value="N">否</option>
	                           		</select>
                           	</div>	
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label">序列号：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="序列号" class="form-control"
									name="id">
							</div>
							<label class="col-sm-2 control-label">修改时间：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="修改时间" class="form-control"
									name="gmtModified">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" onclick="$('#newSysUserWin').modal('hide')">关闭</a>
				<button class="btn btn-primary" onclick= "saveUserFun();" id="saveUser">提交</button>
			</div>
		</form>
	</div>
	
</div>



<script type="text/javascript">
	var editFlag = "${isEdit}"; // 是否为编辑的标示符
	if (editFlag == "true") { // 编辑页面数据初始化
		var MerchantInfoDO = ${MerchantInfoDO};
		$("input[name=merchantno]").attr("value", MerchantInfoDO.merchantno).attr("readOnly", "true");
		$("input[name=merchantname]").attr("value", MerchantInfoDO.merchantname);
		$("input[name=bizcode]").attr("value", MerchantInfoDO.bizcode);
		//$("input[name=status]").attr("value", MerchantInfoDO.status);
		$("#status").val(MerchantInfoDO.status);
		$("#exts").val(MerchantInfoDO.exts);
		var createdate=new Date(MerchantInfoDO.gmtCreate.time);
		$("input[name=gmtCreate]").attr("value",FormatDate(createdate)).attr("readOnly", "true");
		var gmtModified=new Date(MerchantInfoDO.gmtModified.time);
		$("input[name=gmtModified]").attr("value",FormatDate(gmtModified)).attr("readOnly", "true");
		$("input[name=id]").attr("value", MerchantInfoDO.id).attr("readOnly", "true");
		
	} else {
		$("input[name=id]").attr("value", -1).attr("readOnly", "true");
		$("input[name=gmtModified]").attr("value",FormatDate(new Date())).attr("readOnly", "true");
		$("input[name=gmtCreate]").attr("value",FormatDate(new Date())).attr("readOnly", "true");
	}
	
	function saveUserFun(){
		if (editFlag == "true") { // 编辑页面数据初始化)
			$("input[name=gmtCreate]").attr("value", new Date(MerchantInfoDO.gmtCreate.time));
			$("input[name=gmtModified]").attr("value",new Date(MerchantInfoDO.gmtModified.time));
		}else
		{
			$("input[name=gmtModified]").attr("value",new Date());
			$("input[name=gmtCreate]").attr("value",new Date());
		}
		var sysUser_options = {
			url : path + '/merchant/save.htm',
			type : 'post',
			dataType : 'json',
			//data:{'roles':$("#roles").val()},  //额外的参数...
			success  : userUpdateSuss
		};
		$('#sysUserForm').ajaxSubmit(sysUser_options);
	};
	//ajaxForm提交成功的回调函数...
	function userUpdateSuss(data) {
		if (data.msg == true) {
			notyMsg("操作成功");
			$('#newSysUserWin').modal('hide');
			$('#sysUserList').dataTable().fnReloadAjax();
		} else {
			notyMsg(data.message);
		}
	}
	function FormatDate (date) {
	    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds() ;
	}
</script>