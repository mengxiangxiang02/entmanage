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
			<h4 class="modal-title">班级录入</h4>
		</div>
		<form class="form-horizontal" id="sysUserForm">
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<label class="col-sm-2 control-label">班级名称：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="班级名称" class="form-control"
									name="classname">
							</div>
							<label class="col-sm-2 control-label">班级学年：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="班级学年" class="form-control"
									name="classyear">
							</div>
						</div>



						<div class="form-group">
							<label class="col-sm-2 control-label">序列号：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="序列号" class="form-control"
									   name="id">
							</div>
							<label class="col-sm-2 control-label">备注：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="备注" class="form-control"
									   name="remark">
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
		var classInfo = ${classInfo};
        $("input[name=classname]").attr("value", classInfo.classname);
        $("input[name=classyear]").attr("value", classInfo.classyear);
        $("input[name=remark]").attr("value", classInfo.remark);
        $("input[name=id]").attr("value", classInfo.id).attr("readOnly", "true");

	} else {
		$("input[name=id]").attr("value", -1).attr("readOnly", "true");
		$("input[name=gmtModified]").attr("value",FormatDate(new Date())).attr("readOnly", "true");
		$("input[name=gmtCreate]").attr("value",FormatDate(new Date())).attr("readOnly", "true");
	}
	
	function saveUserFun(){
		if (editFlag == "true") { // 编辑页面数据初始化)
			//$("input[name=gmtCreate]").attr("value", new Date(entInfo.gmtCreate.time));
			$("input[name=gmtModified]").attr("value",new Date(classInfo.gmtModified.time));
		}else
		{
			$("input[name=gmtModified]").attr("value",new Date());
			$("input[name=gmtCreate]").attr("value",new Date());
		}
		var sysUser_options = {
			url : path + '/classinfo/save.htm',
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