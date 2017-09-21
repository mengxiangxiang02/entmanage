<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>
       	学员信息录入系统
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="shortcut icon" href="sft.ico"> 
    <link rel="stylesheet" href="./css/Skins/default/style.css" type="text/css" media="all" />
    <script type="text/javascript" src="./js/angular.min.js"></script>
    <script type="text/javascript" src="./js/jquery.min.js"></script>
    <script type="text/javascript" src="./js/jquery.md5.js"></script>
</head>

<body>
<script type="text/javascript">
    $(document).ready(function () {
        $(".input220").focus(function () {
            $(this).select();
        });
    });
</script>
<div id="head"><h3>
    <span>	企业信息录入平台</span>
</h3></div>
<div id="login">
    <form id="fm1" name="fm1"  action="${pageContext.request.contextPath}/login/validate.htm" method="post" class="fm-v clearfix" ng-app="myApp"  ng-controller="validateCtrl" novalidate>
        <table cellpadding="3" cellspacing="0">
            <tr>
                <th>用户名</th>
                <td>
                    <input id="userName" name="userName" ng-model="userName" tabindex="1" class="input220"  type="text" size="25" value="请输入用户名"  autocomplete="false" required/>
                    <span style="color:red" ng-show="fm1.UserName.$invalid">
                    <span ng-show="fm1.UserName.$error.required">*</span>
                    </span>
                </td>
            </tr>
            <tr>
                <th>密码</th>
                <td>
                    <input id="shawpassWord" name="shawpassWord" ng-model="shawpassWord"  tabindex="2" class="input220" type="password" value="" size="25" autocomplete="off"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" style=" text-align:center;">
                    <input type="button" id="btnLogin"  value="登录" class="login_btn" />
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    var app = angular.module('myApp', []);
    app.controller('validateCtrl', function($scope) {
     
    });
    var go = document.getElementById('btnLogin');
    go.onclick = function(){
    	var result=isValidUserName($("#userName").val());
    	if(result==false)
   		{
    		$("#userName").val("输入无效");
    		return;
   		}
    	encryptionPassword();
    	$("#fm1").submit();
    }
    /**
    	校验用户名
    */
    function isValidUserName(s)   
    {   
    	var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){3,50}$/;   
    	if (!patrn.exec(s)) 
    		return false 
    	return true 
    }
    
    function encryptionPassword(){
    	var shawpassWord=$("#shawpassWord").val();
        var md5password = $.md5(shawpassWord);
        $("#shawpassWord").val(md5password);
     }
    
    
</script>

</body>
</html>

