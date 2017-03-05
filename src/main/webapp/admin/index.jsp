<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="../wage/css/pintuer.css">
    <link rel="stylesheet" href="../wage/css/admin.css">
    <script src="../wage/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="../wage/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="../wage/welcome.html" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="http://localhost:8080/loginOut"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>


  <h2><span class="icon-pencil-square-o"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="info.jsp" target="right"><span class="icon-caret-right"></span>个人主页</a></li>
    <li><a href="pass.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    <li><a href="page.jsp" target="right"><span class="icon-caret-right"></span>公告发布</a></li>
    <li><a href="email.jsp" target="right"><span class="icon-caret-right"></span>我的邮箱</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>工资管理</h2>
  <ul>
      <li><a href="wage_entry.jsp" target="right"><span class="icon-caret-right"></span>工资录入</a></li>
    <li><a href="list.jsp" target="right"><span class="icon-caret-right"></span>工资查看</a></li>
    <li><a href="table.jsp" target="right"><span class="icon-caret-right"></span>报表查看</a></li>
  </ul>

    <h2><span class="icon-pencil-square-o"></span>员工管理</h2>
    <ul>
        <li><a href="showEmployee.jsp" target="right"><span class="icon-caret-right"></span>员工查看</a></li>
        <li><a href="addEmployee.jsp" target="right"><span class="icon-caret-right"></span>添加员工</a></li>
    </ul>


</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);
	  $(this).toggleClass("on");
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="info.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>