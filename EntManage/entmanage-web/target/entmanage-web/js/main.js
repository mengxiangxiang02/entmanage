$().ready(function() {
	$("#login_form").validate({
		rules: {
			usernamelogin: "required",
			passwordlogin: {
				required: true,
				minlength: 1
			},
		},
		messages: {
			usernamelogin: "请输入姓名",
			passwordlogin: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符")
			},
		}
	});
	$("#register_form").validate(
	{
		rules: {
			register_username: "required",
			register_password: {
				required: true,
				minlength: 5
			},
			register_rpassword: {
				equalTo: "#register_password"
			},
			register_email: {
				required: true,
				email: true
			}
		},
		messages: {
			register_username: "请输入姓名",
			register_password: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符")
			},
			register_rpassword: {
				equalTo: "两次密码不一样"
			},
			register_email: {
				required: "请输入邮箱",
				email: "请输入有效邮箱"
			}
		}
	});
});
$(function() {
	$("#register_btn").click(function() {
		$("#register_form").css("display", "block");
		$("#login_form").css("display", "none");
	});
	$("#back_btn").click(function() {
		$("#register_form").css("display", "none");
		$("#login_form").css("display", "block");
	});
});