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
    <script src="../wage/js/baseUrl.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <%--<script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>--%>
    <script type='text/javascript' src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="../wage/js/pintuer.js"></script>
</head>
<style>
    .container{
        margin:0px;
    }
    .image-preview-input {
        position: relative;
        overflow: hidden;
        margin: 0px;
        color: #333;
        background-color: #fff;
        border-color: #ccc;
    }
    .image-preview-input input[type=file] {
        position: absolute;
        top: 0;
        right: 0;
        margin: 0;
        padding: 0;
        font-size: 20px;
        cursor: pointer;
        opacity: 0;
        filter: alpha(opacity=0);
    }
    .image-preview-input-title {
        margin-left:2px;
    }
</style>
<script>
    $(document).on('click', '#close-preview', function(){
        $('.image-preview').popover('hide');
        // Hover befor close the preview
        $('.image-preview').hover(
            function () {
                $('.image-preview').popover('show');
            },
            function () {
                $('.image-preview').popover('hide');
            }
        );
    });

    $(function() {
        // Create the close button
        var closebtn = $('<button/>', {
            type:"button",
            text: 'x',
            id: 'close-preview',
            style: 'font-size: initial;',
        });
        closebtn.attr("class","close pull-right");
        // Set the popover default content
        $('.image-preview').popover({
            trigger:'manual',
            html:true,
            title: "<strong>Preview</strong>"+$(closebtn)[0].outerHTML,
            content: "There's no image",
            placement:'bottom'
        });
        // Clear event
        $('.image-preview-clear').click(function(){
            $('.image-preview').attr("data-content","").popover('hide');
            $('.image-preview-filename').val("");
            $('.image-preview-clear').hide();
            $('.image-preview-input input:file').val("");
            $(".image-preview-input-title").text("Browse");
        });
        // Create the preview image
        $(".image-preview-input input:file").change(function (){
            var img = $('<img/>', {
                id: 'dynamic',
                width:250,
                height:200
            });
            var file = this.files[0];
            var reader = new FileReader();
            // Set preview image into the popover data-content
            reader.onload = function (e) {
                $(".image-preview-input-title").text("Change");
                $(".image-preview-clear").show();
                $(".image-preview-filename").val(file.name);
                img.attr('src', e.target.result);
                $(".image-preview").attr("data-content",$(img)[0].outerHTML).popover("show");
            }
            reader.readAsDataURL(file);
        });
    });
</script>
<style>
    .img{
        width: 200px;
        height: 250px;
        position: absolute;
        right: 30%;
        top: 20%;
        background: #FFF;
        z-index: 3;
        text-align: center;
    }
</style>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>员工信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="">
            <div class="main">
                <div class="img">
                    <img id="eImg" src="../wage/images/2014.jpg" alt="未找到图像" width="100%" height="100%"/>
                    <span>照片</span>
                </div>
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" id="e_name" class="input w50" value="" name="title" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>工号：</label>
                </div>
                <div class="field">
                    <input type="number" id="e_number" class="input w50" value="" name="id_number" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>密码：</label>
                </div>
                <div class="field">
                    <input type="text" id="e_pass" class="input w50" value="" name="id_number" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>职位：</label>
                </div>
                <div class="field">
                    <input type="text" id="e_title" class="input w50" value="" name="id_number" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>照片：</label>
                </div>
                <div class="field">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2" style="margin: 0px;padding: 0px; width: 300px">
                                <!-- image-preview-filename input [CUT FROM HERE]-->
                                <div class="input-group image-preview">
                                    <input type="text" class="form-control image-preview-filename" disabled="disabled" style="width: 225px"> <!-- don't give a name === doesn't send on POST/GET -->
                                    <span class="input-group-btn">
                    <!-- image-preview-clear button -->
                                        <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                        <%--<span class="glyphicon glyphicon-remove"></span> --%>
                                         Clear
                                        </button>
                                        <!-- image-preview-input -->
                                        <div class="btn btn-default image-preview-input">
                        <%--<span class="glyphicon glyphicon-folder-open"></span>--%>
                                        <span class="image-preview-input-title">Browse</span>
                                        <input type="file" accept="image/png, image/jpeg, image/gif" name="input-file-preview"/> <!-- rename it -->
                                    </div>
                                    </span>
                                </div><!-- /input-group image-preview [TO HERE]-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>

            <if condition="$iscid eq 1">
                <div class="form-group">
                    <div class="label">
                        <label>部门：</label>
                    </div>
                    <div class="field">
                        <select id="e_depart" name="cid" class="input w50">
                            <option value="0">请选择部门</option>
                            <option value="1">销售部</option>
                            <option value="2">广告部</option>
                            <option value="3">公关部</option>
                            <option value="4">财务部</option>
                            <option value="5">技术部</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>性别：</label>
                    </div>
                    <div class="field" style="padding-top:8px;">
                        男 <input id="male" name="sex" type="radio" value="男"/>
                        女 <input id="female" name="sex" type="radio"  value="女"/>
                    </div>
                </div>
            </if>
            <!--<div class="form-group">-->
            <!--<div class="label">-->
            <!--<label>家庭住址：</label>-->
            <!--</div>-->
            <!--<div class="field">-->
            <!--<textarea class="input" name="note" style=" height:90px;"></textarea>-->
            <!--<div class="tips"></div>-->
            <!--</div>-->
            <!--</div>-->
            <div class="form-group">
                <div class="label">
                    <label>详细信息：</label>
                </div>
                <div class="field">
                    <textarea id="e_info" name="content" class="input" style="height:450px; border:1px solid #ddd;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="clear"></div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="button" id="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="../wage/js/addContent.js"></script>
<script>

    //myData.append("", );
    $("#submit").click(function(){
        var myData = new FormData();
        myData.append('img', $('input[type=file]')[0].files[0]);
        myData.append('e_name', $("#e_name").val());
        var e_depart = $("#e_depart").find("option:selected").text();
//      alert(e_depart);
        myData.append('e_depart', e_depart);
        myData.append('e_number', $("#e_number").val());
        var sex = $('input:radio[name="sex"]:checked').val();
//      alert(sex);
        myData.append('e_sex', sex);
        myData.append('e_info', $("#e_info").val());
        myData.append('e_pass', $("#e_pass").val());
        myData.append('e_title', $("#e_title").val());
        $.ajax({
            url:getBaseUrl() + "/updateEmploy",
            data:myData,
            type: "POST",
            dataType: "json",
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            success:function(results){
                if(results == 0)
                {
                    alert("修改成功");
                }
            }
        });
    });

    function getInfo(){
        $.ajax({
            url:getBaseUrl() + "/getById",
            data:{
                eId: eId
            },
            type: "POST",
            dataType: "json",
            async: false,
            cache: false,
            success:function(results){
                if(results.status == 0)
                {
                    var employee = results.body;
                    setContent("e_name", employee.eName);
                    setContent("e_number", employee.eId);
                    setContent("e_info", employee.eIntro);
                    setContent("e_pass", employee.ePass);
                    setContent("e_title", employee.eTitle);
                    if(employee.eDepart == "销售部")
                    {
                        $("#e_depart").find("option[value='1']").attr("selected",true);
                    }
                    else if(employee.eDepart == "广告部")
                    {
                        $("#e_depart").find("option[value='2']").attr("selected",true);
                    }
                    else if(employee.eDepart == "公关部")
                    {
                        $("#e_depart").find("option[value='3']").attr("selected",true);
                    }
                    else if(employee.eDepart == "财务部")
                    {
                        $("#e_depart").find("option[value='4']").attr("selected",true);
                    }
                    else if(employee.eDepart == "技术部")
                    {
                        $("#e_depart").find("option[value='5']").attr("selected",true);
                    }
                    if(employee.eSex == "男")
                    {
                        $("#male").attr("checked",true);
                    }else if(employee.eSex == "女"){
                        $("#female").attr("checked",true);
                    }
                    $("#eImg").attr("src", "../wage/images/" + employee.eImg);
                }else {
                    alert("获取员工信息失败");
                }
            }
        });
    }
    var eId = window.location.search.split("=")[1];
    getInfo(eId);
</script>
</html>