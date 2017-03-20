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
  <div class="panel-head"><strong class="icon-reorder"> 邮件列表</strong></div>
  <div class="padding border-bottom">
  <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 全部标记为已读</button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="10%">序号</th>
      <th width="20%">邮箱</th>
      <th width="15%">主题</th>
      <th width="20%">内容</th>
      <th width="10%">标识</th>
      <th width="15%">操作</th>
    </tr>

    <tr>
      <td>1</td>
      <td>zhangsan@163.com</td>
      <td>工资报错</td>
      <td>描述文字....</td>
      <td>未读</td>
      <td><div class="button-group">
      <a class="button border-main" href="#add"><span class="icon-edit"></span> 查看</a>
      <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1)"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
    </tr>
    <tr>
      <td>2</td>
      <td>lisi@163.com</td>
      <td>工资报错</td>
      <td>描述文字....</td>
      <td>未读</td>
      <td><div class="button-group">
      <a class="button border-main" href="#add"><span class="icon-edit"></span> 查看</a>
      <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1)"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
    </tr>
    <tr>
      <td>3</td>
      <td>wangwu@163.com</td>
      <td>工资报错</td>
      <td>描述文字....</td>
      <td>已读</td>
      <td><div class="button-group">
      <a class="button border-main" href="#add"><span class="icon-edit"></span> 查看</a>
      <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1)"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
    </tr>

  </table>
</div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){

	}
}
</script>
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 写邮件</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="title" id="subject" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>邮箱地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="url" id="address" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>添加附件：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="img" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
          <div class="tipss">附件大小：100M以内</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" name="note" style="height:120px;" id="context" value=""></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>抄送地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sort" value="zhaoliu@163.com"  data-validate="required:,number:必须为有效地址" />
          <div class="tips"></div>
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
<script src="../wage/js/baseUrl.js"></script>
<script>
    $("#submit").click(function(){
        var subject = $("#subject").val();
        var address = $("#address").val();
        var context = $("#context").val();

        $.ajax({
            url:getBaseUrl() + "/sendEmail",
            data:{
                subject: subject,
                to: address,
                text: context
            },
            type: "POST",
            dataType: "json",
            async: false,
            cache: false,
            success:function(results){
                if(results == 0)
                {
                    alert("发送成功");
                }else {
                    alert("发送失败");
                }
            }
        });
    });
</script>

</html>