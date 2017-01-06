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
                <li> <a class="button border-main icon-plus-square-o" href="add.jsp"> 添加员工</a> </li>
                <if condition="$iscid eq 1">
                    <li>
                        <select id="select" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                            <option value="">请选择分类</option>
                            <option value="">按部门查询</option>
                            <option value="">按工号查询</option>
                        </select>
                    </li>
                </if>
                <li>
                    <input type="text" placeholder="请输入搜索关键字" id="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <a href="javascript:void(0)" class="button border-main icon-search"  id="search" > 搜索</a></li>
            </ul>
        </div>
        <table id="table" class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">序号</th>
                <th width="10%">工号</th>
                <th>照片</th>
                <th>姓名</th>
                <th>性别</th>
                <th>职称</th>
                <th>部门</th>
                <th width="310">操作</th>
            </tr>
        </table>
        <tr>
            <td colspan="8">
                <div class="pagelist"> <a href="">上一页</a> <span id="currentPage">1</span><a href="">下一页</a>
            </div>
            </td>
        </tr>
    </div>
</form>
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
     * 获取员工数据
     * @type {number}
     */
    var pageSize = 10;
    var requestPage = 1;
    var eId = "";
    var depart = "";
    function read()
    {
        $.ajax({
            url:getBaseUrl() + "/getAllEmployee",
            data:{
                pageSize: pageSize,
                requestPage: requestPage,
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

//                    alert(depart);
                        var employee = results.body.results[i].employee;
                        var imgUrl = "showEmployInfo.jsp?eId=" + employee.eId;
                        var newRow = "<tr class=" + "one>"
                            + "<td>" + (i + 1) + "</td>"
                            + "<td>" + employee.eId + "</td>"
                            + "<td width='10%'><img src='../wage/images/" + employee.eImg + "' width='70' height='50'" + "/> "
                            + "</td>"
                            + "<td>" + employee.eName + "</td>"
                            + "<td>" + employee.eSex + "</td>"
                            + "<td>" + employee.eTitle + "</td>"
                            + "<td>" + employee.eDepart + "</td>"
                            + "<td> <div class=button-group>"
                            + "<a class='button border-main' href='" + imgUrl + "'>"
                            + "<span class='icon-edit'></span>"
                            + "查看</a>"
                            + "<a class='button border-red del' id='" + employee.eId + "'>"
                            + "<span class='icon-trash-o'></span>"
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
    read(pageSize, requestPage, depart);

    $("#lastPage").click(function(){
       --requestPage;
       read(pageSize, requestPage, depart);
    });

    $("#nextPage").click(function(){
       ++requestPage;
       read(pageSize, requestPage, depart);
    });


    $("#search").click(function(){
        var type = $("#select").find("option:selected").text();
        if(type == "按部门查询"){
            depart = $("#keywords").val();
//            alert(depart);
            read(pageSize, requestPage, depart);
        }else if(type == "按工号查询"){
            eId = $("#keywords").val();
            $.ajax({
                url:getBaseUrl() + "/getById",
                data:{
                    eId:eId
                },
                type: "POST",
                dataType: "json",
                async: false,
                cache: false,
                success:function(results){
                    if(results.status == 0)
                    {
                        $("tr").remove(".one");
                        currentPage = results.body.currentPage == null ? 0 : results.body.currentPage;
                            var employee = results.body;
                            var newRow = "<tr class=" + "one>"
                                + "<td>" + 1 + "</td>"
                                + "<td>" + employee.eId + "</td>"
                                + "<td width='10%'><img src='../wage/images/" + employee.eImg + "' width='70' height='50'" + "/> "
                                + "</td>"
                                + "<td>" + employee.eName + "</td>"
                                + "<td>" + employee.eSex + "</td>"
                                + "<td>" + employee.eTitle + "</td>"
                                + "<td>" + employee.eDepart + "</td>"
                                + "<td> <div class=button-group>"
                                + "<a class='button border-main' href='showEmployInfo.jsp?eId=" + employee.eId + "'>"
                                + "<span class='icon-edit'></span>"
                                + "查看</a>"
                                + "<a class='button border-red del' id='" + employee.eId + "'>"
                                + "<span class='icon-trash-o'></span>"
                                + "删除</a>"
                                + "</div>"
                                + "<td>"
                                + "</tr>";

                            $("#table").append(newRow);
                        }
                        else {
                        alert("查询失败");
                    }
                }
            });
        }

    });


    $(".del").click(function() {
        var eId = $(this).attr("id");
        $.ajax({
            url: getBaseUrl() + "/delByeId",
            data: {
                eId: eId
            },
            type: "POST",
            dataType: "json",
            async: false,
            cache: false,
            success: function (results) {
                if (results == 0) {
                    alert("删除成功")
                }else {
                    alert("删除失败");
                }
            }
        });
    });
</script>
</body>
</html>