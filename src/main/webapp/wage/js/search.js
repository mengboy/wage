/**
 * Created by vector on 2017/2/27.
 */
$("#submit").click(function(){
    var eId = $("#e_id").val();
    var pass = $("#e_pass").val();
    var time = $("#time").val();
    if(eId != null && pass!=null)
    {
        $.ajax({
            url:getBaseUrl() + "/getAllPayByEIdAndTime",
            data:{
                eId: eId,
                pass: pass,
                time: time
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
                    var giveTime = formatTime(pay.pTime);
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
                    setContent("deductionSum", pay.pFinesum);
                    setContent("realWage", pay.pRealsum);
                    setContent("giveTime", giveTime);

                }else if(results.status == 9)
                {
                    alert("用户名／密码错误");
                }else if(results.status == 7)
                {
                    alert("所查工资表不存在");
                }else {
                    alert("未知错误");
                }
            }
        });

    }else {
        alert("请填写用户名和密码");
    }
});