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
    <script src="../wage/js/baseUrl.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="addEmployee.jsp"> 添加内容</a> </li>
        <%--<li>搜索：</li>--%>
        <%--<li>首页--%>
          <%--<select name="s_ishome" class="input" onchange="changesearch()" style="width:60px; line-height:17px; display:inline-block">--%>
            <%--<option value="">选择</option>--%>
            <%--<option value="1">是</option>--%>
            <%--<option value="0">否</option>--%>
          <%--</select>--%>
          <%--&nbsp;&nbsp;--%>
          <%--推荐--%>
          <%--<select name="s_isvouch" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">--%>
            <%--<option value="">选择</option>--%>
            <%--<option value="1">是</option>--%>
            <%--<option value="0">否</option>--%>
          <%--</select>--%>
          <%--&nbsp;&nbsp;--%>
          <%--置顶--%>
          <%--<select name="s_istop" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">--%>
            <%--<option value="">选择</option>--%>
            <%--<option value="1">是</option>--%>
            <%--<option value="0">否</option>--%>
          <%--</select>--%>
        <%--</li>--%>
        <if condition="$iscid eq 1">
          <li>
            <select name="cid" class="input" style="width:200px; line-height:17px;" id="select">
              <option value="">请选择分类</option>
              <option value="">按部门查询</option>
              <option value="">按工号查询</option>
              <option value="">按时间查询</option>
            </select>
          </li>
        </if>
          <li style="display: none" id="year">
          年份：
          <select class="input" id="selectYear" style="width:60px; line-height:17px;display:inline-block">
              <option value="">选择</option>
              <option value="2016">2016</option>
              <option value="2015">2015</option>
              <option value="2014">2014</option>
              <option value="2013">2013</option>
              <option value="2012">2012</option>
              <option value="2011">2011</option>
          </select>
          </li>
          <li style="display: none" id="mounth" >
              月份：
              <select class="input" id="selectMounth" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
                  <option value="">选择</option>
                  <option value="1">01</option>
                  <option value="2">02</option>
                  <option value="3">03</option>
                  <option value="4">04</option>
                  <option value="5">05</option>
                  <option value="6">06</option>
                  <option value="7">07</option>
                  <option value="8">08</option>
                  <option value="9">09</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
              </select>
          </li>
        <li>
          <input id="keywords" type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" id="search" > 搜索</a>
        </li>

      </ul>
    </div>
    <table id="table" class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">序号</th>
        <th width="10%">工号</th>
        <th>部门</th>
        <th>发放时间</th>
        <th width="310">操作</th>
      </tr>

    </table>
      <tr>
          <td colspan="8"><div class="pagelist"> <a href="javascript:void(0)" id="lastPage">上一页</a> <span class="current" id="currentPage">1</span><a href="javascript:void(0)" id="nextPage">下一页</a></div></td>
      </tr>
  </div>
</form>
<script src="../wage/js/formatTime.js"></script>
<script type="text/javascript">

//搜索
function changesearch(){

}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){

	}
}

//全选
$("#checkall").click(function(){
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {
		Checkbox=true;
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;
		$("#listform").submit();
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {
		Checkbox=true;
	  }
	});
	if (Checkbox){

		$("#listform").submit();
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {
		Checkbox=true;
	  }
	});
	if (Checkbox){

		$("#listform").submit();
	}
	else{
		alert("请选择要操作的内容!");

		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {
		Checkbox=true;
	  }
	});
	if (Checkbox){


		$("#listform").submit();
	}
	else{
		alert("请选择要操作的内容!");

		return false;
	}
}

//批量置顶
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {
		Checkbox=true;
	  }
	});
	if (Checkbox){

		$("#listform").submit();
	}
	else{
		alert("请选择要操作的内容!");

		return false;
	}
}


//批量移动
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {
		Checkbox=true;
	  }
	});
	if (Checkbox){

		$("#listform").submit();
	}
	else{
		alert("请选择要操作的内容!");

		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {
		Checkbox=true;
	  }
	});
	if (Checkbox){
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}
	    });
		if(i>1){
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{

			$("#listform").submit();
		}
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}


/**
 * select 选中事件
 **/
$('#select').change(function(){
//    alert($(this).find("option:selected").text());
    var selectValue = $(this).find("option:selected").text();//这就是selected的值
    if(selectValue == "按部门查询")
    {
//        alert("show" + selectValue);
        $("#year").show();
        $("#mounth").show();
        $("#keywords").show();
    }else if(selectValue == "按时间查询"){
        $("#year").show();
        $("#mounth").show();
        $("#keywords").hide();
    }
    else {
//        alert("hide" + selectValue);
        $("#year").hide();
        $("#mounth").hide();
        $("#keywords").show();
    }
});



/**
 * 获取数据
 * @type {number}
 */
var pageSize = 10;
var requestPage = 1;
var year = "";
var mounth = "";
var depart = "";
var eId = "";
function read()
{
    $.ajax({
        url:getBaseUrl() + "/getAllPayByDepart",
        data:{
            pageSize: pageSize,
            requestPage: requestPage,
            year: year,
            mounth: mounth,
            depart: depart
        },
        type: "POST",
        dataType: "json",
        async: false,
        cache: false,
        success:function(results){
//            alert(results.status);
            if(results.status == 0)
            {
//                window.location.href = "../admin/index";
                $("tr").remove(".one");
                currentPage = results.body.currentPage == null ? 0 : results.body.currentPage;
                $("#currentPage").html(currentPage);
                for(var i = 0; i < results.body.results.length; i++)
                {
//                    alert(results.body.results.length);
                    var depart = results.listMessage[i];
//                    alert(depart);
                    var pay = results.body.results[i].pay;
                    var eId = pay.eId;
//                    alert(eId);
//                    alert(pay.pTime);
                    var time = formatTime(pay.pTime);
//                    alert(time);
                    var newRow = "<tr class=" + "one>"
                        + "<td>" + (i + 1) + "</td>"
                        + "<td>" + eId + "</td>"
                        + "<td>" + depart + "</td>"
                        + "<td>" + time + "</td>"
                        + "<td> <div class=button-group>"
                        + "<a class='button border-main' href='payrall.jsp?pId=" + pay.pId + "'>"
                        + "<span class='icon-edit'></span>"
                        + "查看</a>"
                        + "<a class='button border-red del' id='" + pay.pId + "'>"
                        + "<span class='icon-trash-o'></span> "
                        + "删除</a>"
                        + "</div>"
                        + "<td>"
                        + "</tr>";
                     $("#table").append(newRow);
                }
            }
        }
    });
}


function readById()
{
    $.ajax({
        url:getBaseUrl() + "/getAllPayByEIdAndAdmin",
        data:{
            pageSize: pageSize,
            requestPage: requestPage,
            eId: eId
        },
        type: "POST",
        dataType: "json",
        async: false,
        cache: false,
        success:function(results){
//            alert(results.status);
            if(results.status == 0)
            {
//                window.location.href = "../admin/index";
                $("tr").remove(".one");
                currentPage = results.body.currentPage == null ? 0 : results.body.currentPage;
                $("#currentPage").html(currentPage);
                for(var i = 0; i < results.body.results.length; i++)
                {
//                    alert(results.body.results.length);
                    var depart = results.listMessage[i];
//                    alert(depart);
                    var pay = results.body.results[i].pay;
                    var eId = pay.eId;
//                    alert(eId);
//                    alert(pay.pTime);
                    var time = formatTime(pay.pTime);
//                    alert(time);
                    var newRow = "<tr class=" + "one>"
                        + "<td>" + (i + 1) + "</td>"
                        + "<td>" + eId + "</td>"
                        + "<td>" + depart + "</td>"
                        + "<td>" + time + "</td>"
                        + "<td> <div class=button-group>"
                        + "<a class='button border-main' href='payrall.jsp?pId=" + pay.pId + "'>"
                        + "<span class='icon-edit'></span>"
                        + "查看</a>"
                        + "<a class='button border-red del' id='" + pay.pId + "'>"
                        + "<span class='icon-trash-o'></span> "
                        + "删除</a>"
                        + "</div>"
                        + "<td>"
                        + "</tr>";
                    $("#table").append(newRow);
                }
            }
        }
    });
}

read(pageSize, requestPage, year, mounth, depart);


$("#lastPage").click(function(){
    var type = $("#select").find("option:selected").text();
    if(type == "按工号查询")
    {
        --requestPage;
        eId = $("#keywords").val();
        readById(pageSize, requestPage, eId);
    }else {
        --requestPage;
        //year = $("#year").val();
        //mounth = $("#mounth").val();
        if(requestPage >= 0)
        {
            read(pageSize, requestPage, year, mounth, depart);
        }
    }
});

$("#nextPage").click(function(){
    var type = $("#select").find("option:selected").text();
    ++requestPage;
    if(type == "按工号查询")
    {
        eId = $("#keywords").val();
        readById(pageSize, requestPage, eId);
    }else {
        if(requestPage >= 0)
        {
            read(pageSize, requestPage, year, mounth, depart);
        }
    }
});


$("#search").click(function(){
   var type = $("#select").find("option:selected").text();
   if(type == "按部门查询"){
       requestPage = 1;
       year = $("#selectYear").find("option:selected").text();
       mounth = $("#selectMounth").find("option:selected").text();
       depart = $("#keywords").val();
       read(pageSize, requestPage, year, mounth, depart);
   }else if(type == "按时间查询"){
       requestPage = 1;
       year = $("#selectYear").find("option:selected").text();
       mounth = $("#selectMounth").find("option:selected").text();
       depart = "";
       read(pageSize, requestPage, year, mounth, depart);
   }else if(type == "按工号查询")
   {
       eId = $("#keywords").val();
       readById(pageSize, requestPage, eId);
   }
});

$(".del").click(function () {
   var pId = $(this).attr("id");
   alert(pId);
   $.ajax({
       url:getBaseUrl() + "/deleteBypId",
       data:{
           pId: pId
       },
       type: "POST",
       dataType: "json",
       async: false,
       cache: false,
       success:function(results){
           if(results == 0){
               alert("删除成功");
           }else {
               alert("删除失败");
           }
       }
   });
});

</script>
</body>
</html>