<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>企业信息录入平台	</title>
    <meta name="keywords" content="AUC">
    <meta name="description" content="AUC">
    
    <link rel="shortcut icon" href="sft.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.0.0" rel="stylesheet">
 	<!-- cookie操作 -->
    <script src="js/cookieoperate.js"></script>
</head>

<body onLoad="checkCookie()"  class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
  <header >
		 	<div class="navbar-inner" >	
		 	    <div class="nav-no-collapse pull-left" id="header-nav">

                 </div>
                      <div class="nav-no-collapse pull-right" id="header-nav">
                        <ul class="nav navbar-nav pull-right">
                            <li class="dropdown profile-dropdown" style="">
                                <a href="#" class="dropdown" data-toggle="dropdown">
                                    <i class="fa fa-user"></i>
                                    <span class="hidden-xs">${userName}</span>
                                </a>
                                <ul class="dropdown-menu pull-right">

                                    <li><a class="button button-primary button-circle button-small"  datavalue="${userName}" data-toggle="modal" data-target="#myModal" rel="${userName}"><i class="fa fa-user"></i>密码修改</a><li>
                                    <li><a href="login.jsp"><i class="ace-icon fa fa-power-off"></i>安全退出</a></li>
                                </ul>
                            </li>
                            
                        </ul>
                      </div>
		 		</div>
		 </header>

  <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content animated bounceInRight">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
              </div>
              <div class="modal-body">
                  <input name="cid" id="cid" type="hidden" value="">
                  <div class="form-group"><label>用户名</label> <input name="userName" id="userName"  value="${userName}" class="form-control"></div>
                  <div class="form-group"><label>旧密码</label> <input name="oldpass" id="oldpass" type="password" class="form-control"></div>
                  <div class="form-group"><label>新密码</label> <input name="pass" id="pass" type="password" class="form-control"></div>
                  <div class="form-group"><label>重复新密码</label> <input name="repass" id="repass" type="password" class="form-control"></div>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                  <button type="button" class="btn btn-primary baocun" onclick="saveUserFun();">保存</button>
              </div>
          </div>
      </div>
  </div>
    <div id="wrapper">
		<!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">功能列表</span>
                        </a>
                    </li>
                    <li>
	                        <a href="#">
	                            <i class="fa  fa-folder"></i>
	                            <span class="nav-label">企业管理</span>
	                            <span class="fa arrow"></span>
	                        </a>
	                         <ul class="nav nav-second-level">
	                            <li>
	                                <a class="J_menuItem" href="pages/entinfo/entquery.jsp" data-index="0">
	                                	<i class="fa fa-soundcloud"></i>
	                                	企业信息维护
	                                </a>
	                            </li>
                                 <li>
                                     <a class="J_menuItem" href="pages/studententinfo/studententquery.jsp" data-index="0">
                                         <i class="fa fa-soundcloud"></i>
                                         老学员公司查询
                                     </a>
                                 </li>
	                        </ul>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa  fa-folder"></i>
                            <span class="nav-label">班级管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="pages/classinfo/classquery.jsp" data-index="0">
                                    <i class="fa fa-soundcloud"></i>
                                    班级信息维护
                                </a>
                            </li>

                        </ul>
                    </li>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
		<!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
	        <div class="row border-bottom">
	          
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="graph_echarts.html">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                
            </div>
            <div class="row J_mainContent fixed-nav" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="graph_echarts.html" 
                	frameborder="0" data-id="graph_echarts.html" seamless></iframe>
            </div>

        </div>
        <!--右侧部分结束-->
    </div>
    <!-- wrapper结束  -->


    <script>
        //改密
        function saveUserFun(){
            var userName = $("#userName").val();
            var pass = $("#pass").val();
            var oldpass = $("#oldpass").val();
            var repass = $("#repass").val();

            if (userName=="") {parent.layer.msg('未选择用户！');return false;}
            if (pass=="" || repass=="") {parent.layer.msg('密码不能留空！');return false;}
            if (pass!=repass) {parent.layer.msg('两次输入的密码不相同！');return false;}
            $.ajax({
                url : path + '/login/updatepassword.htm',
                type : 'post',
                dataType : 'json',
                data:{'userName':userName,'pass':pass,'oldpass':oldpass},
                success  : userUpdateSuss
            });
        };
        function userUpdateSuss(data) {
            if (data.msg == true) {
                alert(data.message);
                $('#myModal').modal('hide');
            } else {
                alert(data.message);
            }
        }

    </script>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.5"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="js/hplus.js?v=4.0.0"></script>
    <script type="text/javascript" src="js/contabs.js"></script>
  	
    <!-- 第三方插件 -->
    <script src="js/plugins/pace/pace.min.js"></script>
</body>

</html>