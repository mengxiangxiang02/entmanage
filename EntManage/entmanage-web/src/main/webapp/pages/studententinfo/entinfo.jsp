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
			<h4 class="modal-title">老学员公司维护</h4>
		</div>
		<form class="form-horizontal" id="sysUserForm">
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<label class="col-sm-2 control-label">企业名称：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="企业名称" class="form-control"
									name="entname">
							</div>
							<label class="col-sm-2 control-label">企业地点：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="企业地点" class="form-control"
									name="entlocation">
							</div>
						</div>

						<div class="form-group">

							<label class="col-sm-2 control-label">企业性质：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="企业性质" class="form-control"
									   name="enttype">
							</div>
						</div>





						<div class="form-group">
							<label class="col-sm-2 control-label">在职学员：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="学员" class="form-control"
									   name="interviewstudent">
							</div>
							<label class="col-sm-2 control-label">学员班级：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="学员班级" class="form-control"
									   name="studentclass">
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-2 control-label">序列号：</label>
							<div class="col-sm-4">
								<input type="text" placeholder="序列号" class="form-control"
									   name="id">
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
		var entInfo = ${entInfo};
        $("input[name=entname]").attr("value", entInfo.entname);
        $("input[name=entlocation]").attr("value", entInfo.entlocation);
        $("input[name=enttype]").attr("value", entInfo.enttype);
        $("input[name=interviewstudent]").attr("value", entInfo.interviewstudent);
        $("input[name=studentclass]").attr("value", entInfo.studentclass);

		var createdate=new Date(entInfo.gmtCreate.time);
		$("input[name=gmtCreate]").attr("value",FormatDate(createdate)).attr("readOnly", "true");
		var gmtModified=new Date(entInfo.gmtModified.time);
		$("input[name=gmtModified]").attr("value",FormatDate(gmtModified)).attr("readOnly", "true");
		$("input[name=id]").attr("value", entInfo.id).attr("readOnly", "true");
		
	} else {
		$("input[name=id]").attr("value", -1).attr("readOnly", "true");
		$("input[name=gmtModified]").attr("value",FormatDate(new Date())).attr("readOnly", "true");
		$("input[name=gmtCreate]").attr("value",FormatDate(new Date())).attr("readOnly", "true");
	}
	
	function saveUserFun(){
		if (editFlag == "true") { // 编辑页面数据初始化)
			//$("input[name=gmtCreate]").attr("value", new Date(entInfo.gmtCreate.time));
			$("input[name=gmtModified]").attr("value",new Date(entInfo.gmtModified.time));
		}else
		{
			$("input[name=gmtModified]").attr("value",new Date());
			$("input[name=gmtCreate]").attr("value",new Date());
		}
		var sysUser_options = {
			url : path + '/studentent/save.htm',
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