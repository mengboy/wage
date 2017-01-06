<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="../wage/css/pintuer.css">
<link rel="stylesheet" href="../wage/css/admin.css">
<script src="../wage/js/jquery.js"></script>
<script src="../wage/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改会员密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
           admin
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="oldPass" name="mpass" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="newPass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="reNewPass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" id="submit"> 提交</button>
        </div>
      </div>      
    </form>
  </div>
</div>
</body>
<script src="../wage/js/baseUrl.js">
</script>
<script>
  $("#submit").click(function(){
      var oldPass = $("#oldPass").val();
      var newPass = $("#newPass").val();
      var rePass = $("#reNewPass").val();
      if(newPass == rePass && oldPass != null){

          $.ajax({
              url:getBaseUrl() + "/changePass",
              data:{
                  oldPass: oldPass,
                  newPass: newPass
              },
              type: "POST",
              dataType: "json",
              async: false,
              cache: false,
              success:function(results){
//                alert(results);
                  if(results == 0)
                  {
                      alert("修改成功");
                  }else {
                      alert("修改失败");
                  }
              }

          });
      }
  });

</script>
</html>