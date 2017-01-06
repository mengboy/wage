<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <script src="../wage/js/laydate/laydate.js"></script>
    <script src="../wage/js/jquery.js"></script>
    <style type="text/css">
        #payrall{
            /*margin-left:20px;*/
            /*margin-top:30px;*/
            margin: 0 auto;
            border:1px solid black;
            border-collapse: collapse;
            width:650px;
        }
        td{
            border:1px solid black;
            line-height:2em;
            text-align:center;
        }
        caption{
            font-size:24px;
            font-weight:bold;
        }

        input{
            width:90%;
            background:no-repeat 0 0 scroll;
            border:none;
            outline:medium;
            font-size: 1ch;
        }
        #giveTime{
            width: 80%;
        }
        #submit{
            width: 30%;
            height: 100%;
            font-size: 2ch;
            font-family: "simsun", "Helvetica Neue", Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>
<table id="payrall">
    <caption>工资明细</caption>
    <tbody>
    <tr>
        <td>姓名</td>
        <td><input type="text" id="name"/></td>
        <td>工号</td>
        <td><input type="number" id="number"/></td>
        <td>部门</td>
        <td><input type="text" id="department"/></td>
    </tr>
    <tr>
        <td colspan="3">发放项目</td>
        <td colspan="3">扣减项目</td>
    </tr>
    <tr>
        <td>基本工资</td>
        <td colspan="2"><input type="number" id="base"/></td>
        <td>社会保险</td>
        <td colspan="2"><input type="number" id="social"/></td>
    </tr>
    <tr>
        <td>岗位工资</td>
        <td colspan="2"><input type="number" id="title"/></td>
        <td>养老保险</td>
        <td colspan="2"><input type="number" id="pension"/></td>
    </tr>
    <tr>
        <td>职务工资</td>
        <td colspan="2"><input type="number" id="duties"/></td>
        <td>医疗保险</td>
        <td colspan="2"><input type="number" id="medical"/></td>
    </tr>
    <tr>
        <td>技能工资</td>
        <td colspan="2"><input type="number" id="skill"/></td>
        <td>失业保险</td>
        <td colspan="2"><input type="number" id="unemployment"/></td>
    </tr>
    <tr>
        <td>学历工资</td>
        <td colspan="2"><input type="number" id="education"/></td>
        <td>住房公积金</td>
        <td colspan="2"><input type="number" id="houseFound"/></td>
    </tr>
    <tr>
        <td>加班费</td>
        <td colspan="2"><input type="number" id="overtime"/></td>
        <td>缺勤扣除</td>
        <td colspan="2"><input type="number" id="absence"/></td>
    </tr>
    <tr>
        <td>奖金</td>
        <td colspan="2"><input type="number" id="bonus"/></td>
        <td>其他扣除</td>
        <td colspan="2"><input type="number" id="other"/></td>
    </tr>
    <tr>
        <td>福利</td>
        <td colspan="2"><input type="number" id="wage"/></td>
        <td>个人所得税</td>
        <td colspan="2"><input type="number" id="tax"/></td>
    </tr>
    <tr>
        <td colspan="6">&nbsp</td>
    </tr>
    <tr>
        <td>应发合计</td>
        <td colspan="2"><input type="number" id="shouldSum"/></td>
        <td>扣除合计</td>
        <td colspan="2"><input type="number" id="deductionSum"/></td>
    </tr>
    <tr>
        <td colspan="6">&nbsp</td>
    </tr>
    <tr>
        <td>实发合计</td>
        <td colspan="2"><input type="number" id="realWage"/></td>
        <td>发放时间</td>
        <td colspan="2"><input class="laydate-icon" onclick="laydate()" id="giveTime"/></td>
    </tr>
    <tr>
        <td colspan="6"><input type="button" id="submit" value="提交修改"></td>
    </tr>
    <tr>
        <td colspan="6">备注：若工资明细有误，请联系相关部门，并将工资报错表提交给管理员</td>
    </tr>
    </tbody>
</table>
</body>
<script src="../wage/js/baseUrl.js"></script>
<script src="../wage/js/formatTime.js"></script>
<script src="../wage/js/addContent.js"></script>
<script>
    var pId = window.location.search.split("=")[1];
    $("#submit").click(function(){
        var e_id = $("#number").val().toString();
        var p_base = $("#base").val();
        var p_social = $("#social").val();
        var p_title = $("#title").val();
        var p_pension = $("#pension").val();
        var p_duties = $("#duties").val();
        var p_medical = $("#medical").val();
        var p_skill = $("#skill").val();
        var p_unemployment = $("#unemployment").val();
        var p_education = $("#education").val();
        var p_houseFound = $("#houseFound").val();
        var p_overtime = $("#overtime").val();
        var p_absence = $("#absence").val();
        var p_bonus = $("#bonus").val();
        var p_other = $("#other").val();
        var p_wage = $("#wage").val();
        var p_tax = $("#tax").val();
        var p_shouldSum = $("#shouldSum").val();
        var p_deductionSum = $("#deductionSum").val();
        var p_realWage = $("#realWage").val();
        var p_giveTime = $("#giveTime").val();

        $.ajax({
            url:getBaseUrl() + "/updateBypId",
            data:{
                pId: pId,
                e_id: e_id,
                p_base: p_base,
                p_social: p_social,
                p_title: p_title,
                p_pension: p_pension,
                p_duties: p_duties,
                p_medical: p_medical,
                p_skill: p_skill,
                p_unemployment: p_unemployment,
                p_education: p_education,
                p_houseFound: p_houseFound,
                p_overtime: p_overtime,
                p_absence: p_absence,
                p_bonus: p_bonus,
                p_other: p_other,
                p_wage: p_wage,
                p_tax: p_tax,
                p_shouldSum: p_shouldSum,
                p_deductionSum: p_deductionSum,
                p_realWage: p_realWage,
                p_giveTime: p_giveTime
            },
            type: "POST",
            dataType: "json",
            async: false,
            cache: false,
            success:function(results){
                if(results == 0)
                {
                    alert("修改成功");
                }
            }
        });
    });


    function getPayInfo(){
        $.ajax({
            url:getBaseUrl() + "/getPayBypId",
            data:{
                pId: pId
            },
            type: "POST",
            dataType: "json",
            async: false,
            cache: false,
            success:function(results){
                if(results.status == 0)
                {
                    var employee = results.employee;
                    var pay = results.pay;
                    var time = formatTime(pay.pTime);
                    setContent("name", employee.eName);
                    setContent("number", employee.eId);
                    setContent("department", employee.eDepart);
                    setContent("base", pay.pBasic);
                    setContent("social", pay.iSocial);
                    setContent("title", pay.pTitle);
                    setContent("pension", pay.iPension);
                    setContent("duties", pay.pDuties);
                    setContent("medical", pay.iMedical);
                    setContent("skill", pay.pSkill);
                    setContent("unemployment", pay.iUnemploy);
                    setContent("education", pay.pEducation);
                    setContent("houseFound", pay.pHousing);
                    setContent("overtime", pay.pOvertime);
                    setContent("absence", pay.pAbsence);
                    setContent("bonus", pay.pBonus);
                    setContent("other", pay.pFineother);
                    setContent("wage", pay.pWalfare);
                    setContent("tax", pay.pTax);
                    setContent("shouldSum", pay.pShouldsum);
                    setContent("realWage", pay.pRealsum);
                    setContent("deductionSum", pay.pFinesum);
                    setContent("giveTime", time);

                }else {
                    alert("获取员工信息失败");
                }
            }
        });
    }
    var pId = window.location.search.split("=")[1];
    getPayInfo(pId);
</script>
</html>