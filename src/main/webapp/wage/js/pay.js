var grequestPage = 1;//请求页
var gpageSize = 10;//一次页面显示数量--默认十不修改
//查找类型，0,1,2,若为3，则查找全部
var gtype = 3;
var gcondition = '';var tt;
var btn_status;
function read()
{
//    	alert();
    $.getJSON(getbaseurl()+"/api/light/getlightbyadmin?requestPage=" + grequestPage + "&pageSize=" + gpageSize + "&type=" + gtype + "&condition=" + gcondition,
        function(json)
        {
            if (!json.status) {
                $("tr").remove(".one");
                totalPage = json.body.totalPage == null ? 0 : json.body.totalPage;
                if(totalPage != 0)
                {
                    $("#currentPage").html(json.body.currentPage);
                    $("#totalPage").html(totalPage);
                }else{
                    $("#currentPage").html("");
                    $("#totalPage").html("");
                }
                var light_color;
                var status;
                var img_off = "images/off.png";
                var img_on = "images/on.png";
                var num = 1;
                for (var i = 0; i < json.body.results.length; i++) {
                    var rowspan = json.body.results[i].lights.length;
                    //alert(rowspan);
                    var classroom =  json.body.results[i].classname;
                    for (var j = 0; j < json.body.results[i].lights.length; j++) {
                        var result = json.body.results[i].lights[j];
                        //  alert(result.id);
                        var light_mode_off = "off" + result.id;
                        var light_mode_on = "on" + result.id;
                        var button_content = result.status == 0 ? "开启" : "关闭";
                        var control;
                        var btn_content;
                        if (result.mode == 1) {
                            control = "<td rowspan=" + rowspan + ">" + "<img id=" + light_mode_on  + " src=" + img_on + " onmousedown='mousedown()' onmouseup='mouseup()'/>"
                                + "<img style='display:none' id=" + light_mode_off  + " src=" + img_off + " />" + "</td>";
                            btn_content = "<td>" + "<button onmousedown='mousedown()' onmouseup='mouseup()' id = " + result.id + " name=" + result.mode + ">"
                                + button_content + "</button></td>";

                        }
                        if (result.mode == 0) {
                            control = "<td rowspan=" + rowspan + ">" + "<img id=" + light_mode_off + " src=" + img_off + " onmousedown='mousedown()' onmouseup='mouseup()' />"
                                + "<img style='display:none' id=" + light_mode_on  + " src=" + img_on + " />" + "</td>";
                            btn_content = "<td>" + "<button id = " + result.id + " disabled='disabled' onmousedown='mousedown()' onmouseup='mouseup()'>"
                                + button_content + "</button></td>";
                        }

                        if(result.status == 0)
                        {
                            light_color = "#f0ad4e";
                            status = "关闭";
                        }
                        else {
                            light_color = "#26b99a";
                            status = "开启";
                        }
                        //var time = result.time;
                        //alert(time);
                        if(result.time != null)
                        {
                            var date = getalltime(result.time.toString());
                        }
                        if(j == 0)
                        {
                            var newRow = "<tr class=" + "one>"
                                + "<td rowspan = " + rowspan + ">" + classroom + "</td>"
                                + "<td>" + num + "</td>"
                                + "<td>" + result.id+"</td>"
                                + "<td>" + result.id.toString().substring(0,1) +"教"+ result.id.toString().substring(1,2) +"楼" + result.id +"号"+ "</td>"
                                + "<td>" + "<font color=" + light_color+ ">" + status + "</font>" + "</td>"
                                + "<td>" + date + "</td>"
                                + control
                                //+"<td>" + "<img id=" + img_off_id  + " src=" + img_src_off + " />"
                                //+ "<img style='display:none' id=" + img_on_id  + " src=" + img_on + " />" + "</td>"
                                + btn_content
                                + "</tr>";
                            $("#table").append(newRow);
                            $("#"+ result.id +"").addClass(result.status == 0 ? "btn btn-primary" : "btn btn-warning");
                            num++;
                        }
                        else {
                            var newRow = "<tr style='height:41px' class=" + "one>"
                                + "<td>" + num + "</td>"
                                + "<td>" + result.id+"</td>"
                                + "<td>" + result.id.toString().substring(0,1) +"教"+ result.id.toString().substring(1,2) +"楼" + result.id +"号"+ "</td>"
                                + "<td>" + "<font color=" + light_color+ ">" + status + "</font>" + "</td>"
                                + "<td>" + date + "</td>"
                                //  + control
                                //+"<td>" + "<img id=" + img_off_id  + " src=" + img_src_off + " />"
                                //+ "<img style='display:none' id=" + img_on_id  + " src=" + img_on + " />" + "</td>"
                                + btn_content
                                + "</tr>";
                            $("#table").append(newRow);
                            $("#"+ result.id +"").addClass(result.status == 0 ? "btn btn-primary" : "btn btn-warning");
                            num++;
                        }
                        // num++;
                    }
                }
                //  result.status == 0 ? button_success : button_waring;
                if(totalPage != 0)
                {
                    if (json.body.currentPage == 1) {
                        $("#last_page").hide();
                        if (json.body.totalPage == 1) {
                            $("#next_page").hide();
                        }
                    } else {
                        $("#last_page").show();
                        if (json.body.currentPage != json.body.totalPage) {
                            $("#next_page").show();
                        }
                    }
                    if ((json.body.currentPage == json.body.totalPage) && (json.body.currentPage != 1)) {
                        $("#next_page").hide();
                        $("#last_page").show();
                    }
                    if (json.body.currentPage < json.body.totalPage) {
                        $("#next_page").show();
                    }
                }else{
                    $("#last_page").hide();
                    $("#next_page").hide();
                }
            }
        });
}
$(document).ready(function() {
    read(grequestPage, gpageSize, gtype, gcondition);
    $.getJSON(getbaseurl() + "/manage/classroom/getbuildings",
        function(json)
        {
            if(json.status == 0)
            {
                for(var i = 0; i < json.body.length; i++)
                {
                    if(json.body[i] != null)
                    {
                        var option = "<option value="+ json.body[i].building +">" +json.body[i].building+"教</option>"

                        $("#building").append(option);
                    }
                }
            }
        }
    );
});

//翻页
$("#next_page").click(function(){
    grequestPage++;
    read(grequestPage, gpageSize, gtype, gcondition);
});
$("#last_page").click(function(){
    grequestPage--;
    read(grequestPage, gpageSize, gtype, gcondition);
});

$("#search").click(function(){
    var building = $("#building").find("option:selected").val();
    var floor = $("#floor").find("option:selected").val();
    gcondition = building + floor;
    gtype = 1;
    grequestPage = 1;
    read(grequestPage, gpageSize, gtype, gcondition);
});
$("#search_accurate").click(function(){
    var num = $("#number").val();
    gcondition = num;
    gtype = 2;
    grequestPage = 1;
    read(grequestPage, gpageSize, gtype, gcondition);
});

//改变照片
$("body").on('click','img',function(){
    var id = $(this).attr("id");
    if (id.substring(0,2) == "on")
    {
        /*$(this).hide();*/
        //alert(id.substring(2));
        /* $("#off" + id.substring(2) + "").show();*/
        var mode = 0;
        $.getJSON(getbaseurl()+"/api/light/updatemode?classroom_id=" + id.substring(2,6) + "&mode=" + mode,
            function(json)
            {
                //alert(json.status);
            });
        //read(grequestPage, gpageSize, gtype, gcondition);
    }
    if(id.substring(0,3) == "off")
    {
        /* $(this).hide();
         $("#on" + id.substring(3) + "").show();*/
        var mode = 1;
        $.getJSON(getbaseurl()+"/api/light/updatemode?classroom_id=" + id.substring(3,7) + "&mode=" + mode,
            function(json)
            {
                //alert(json.status);
            });
        //read(grequestPage, gpageSize, gtype, gcondition);
    }
    tt = window.setInterval("read()",2000);
});
$("body").on('click', 'button', function(){
    var id = $(this).attr("id");
    //alert($(this).text());
    var name = $(this).attr("name");
    var text = $(this).text();
    if (text == "关闭") {
        /*          $(this).text("开启");
         $(this).removeClass();
         $(this).addClass("btn btn-success");*/
        var status = 0;
        $.getJSON(getbaseurl()+"/api/light/updatestatus?id=" + id + "&status=" + status,
            function(json)
            {
//              alert(json.status);
            });
        //read(grequestPage, gpageSize, gtype, gcondition);
    }
    if (text == "开启") {
//          $(this).text("关闭");
//          $(this).removeClass();
//          $(this).addClass("btn btn-warning");
        var status = 1;
        $.getJSON(getbaseurl()+"/api/light/updatestatus?id=" + id + "&status=" + status,
            function(json)
            {
//              alert(json.status);
            });
        //read(grequestPage, gpageSize, gtype, gcondition);
    }
    tt = window.setInterval("read()",2000);
});
NProgress.done();

tt = window.setInterval("read()",2000);

function mousedown(){
    console.log('mousedown');
    window.clearInterval(tt);
};
function mouseup(){
    console.log('mouseup');
};