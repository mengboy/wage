package com.white.ssm.controller;

import com.white.ssm.common.QueryBase;
import com.white.ssm.common.Response;
import com.white.ssm.common.Status;
import com.white.ssm.model.Employee;
import com.white.ssm.model.Pay;
import com.white.ssm.service.IEmployeeService;
import com.white.ssm.service.IpayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 查询工资
 * 根据RequestMapping匹配URL
 * Created by vector on 16/12/2.
 */
@RestController
public class PayController {
    private static Logger log= LoggerFactory.getLogger(UserController.class);
    @Resource(name = "payService")
    private IpayService ipayService;

    @Resource(name = "employService")
    private IEmployeeService iEmployeeService;


    /**
     * 查询全部
     * @param request
     * @param pageSize
     * @param requestPage
     * @return
     */

    @RequestMapping(value = "/getallPay", method = RequestMethod.POST)
    public @ResponseBody Object getAllPay(HttpServletRequest request, @RequestParam long pageSize, @RequestParam long requestPage)
    {
        QueryBase queryBase = new QueryBase(requestPage, pageSize);
        Map<String, Object> parameters = new HashMap<String, Object>();
        queryBase.setParameters(parameters);
        List<String> depart_list = new LinkedList<String>();
        int status = this.ipayService.getAll(queryBase, depart_list);
        System.out.println("status" + status);
        System.out.println(queryBase.getResults().size());
        return new Response(status, queryBase);
    }

    /**
     * 根据员工id查询
     * @param request
     * @param eId
     * @return
     */
    @RequestMapping(value = "/getAllPayByEIdAndTime", method = RequestMethod.POST)
    public @ResponseBody Object getAllPayByEIdAndTime(HttpServletRequest request,@RequestParam String eId, @RequestParam String pass, @RequestParam String time){
        System.out.println("ByID");
        Employee employee = iEmployeeService.getById(Integer.parseInt(eId));
        QueryBase queryBase = new QueryBase();
        if(time.length() == 0)
        {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            queryBase.setYearAndMounth("'" + format.format(date) + "'");
        }else {
            queryBase.setYearAndMounth("'" + time + "'");
        }
        queryBase.seteId(Integer.parseInt(eId));
        if(employee != null)
        {
            if(employee.getePass().equals(pass))
            {
                try {
                    Pay pay = this.ipayService.getByIdAndTime(queryBase);
                    System.out.println("pay" + pay);
                    System.out.println("id" + pay.geteId());

                    return new Response(Status.SUCCESS, pay, employee);
                }catch (Exception e)
                {
                    return new Response(Status.NOT_EXISTS);
                }
            }else {
                System.out.print("pass" + employee.getePass());
                return Status.ERROR;
            }

        }
        return Status.PASSWORD_NOT_MATCH;
    }

    /**
     * 按日期分页查询
     * 默认当前年月
     * @param request
     * @param pageSize
     * @param requestPage
     * @return
     */
    @RequestMapping(value = "/getAllPayByTime", method = RequestMethod.POST)
    public @ResponseBody Object getAllByYearAndMounth(HttpServletRequest request, @RequestParam long pageSize, @RequestParam long requestPage, @RequestParam String year, @RequestParam String mounth){
        QueryBase queryBase = new QueryBase(requestPage, pageSize);
        Map<String, Object> parameters = new HashMap<String, Object>();
        queryBase.setParameters(parameters);
        Date date = new Date();
        if(year.length() == 0 && mounth.length() == 0)
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            queryBase.setYearAndMounth("'" + format.format(date) + "'");
        }else {
            if(year.length() == 0)
            {
                SimpleDateFormat format = new SimpleDateFormat("yyyy");
                queryBase.setYearAndMounth("'" + format.format(date) + "-" + mounth + "'");
            }
            else {
                String yearAndMounth = "'" + year + "-" + mounth + "'";
                queryBase.setYearAndMounth(yearAndMounth);
                System.out.println(yearAndMounth);
            }
        }
        List<String> depart_list = new LinkedList<String>();
        int status = this.ipayService.getByYearAndMounth(queryBase, depart_list);
        System.out.println("status" + status);
        System.out.println(queryBase.getResults().size());
        return new Response(status, queryBase, depart_list);
    }


    /**
     * 根据pId查询
     * @param pId
     * @return
     */
    @RequestMapping(value = "/getPayBypId")
    public @ResponseBody Object getPayBypId(@RequestParam String pId)
    {
        Pay pay = ipayService.getPayById(Integer.parseInt(pId));
        if(pay != null)
        {
            Employee employee = iEmployeeService.getById(pay.geteId());
            return new Response(Status.SUCCESS, pay, employee);
        }
        else {
            return new Response(Status.ERROR);
        }
    }


    /**
     * 通过pId删除
     * @param pId
     * @return
     */
    @RequestMapping(value = "/deleteBypId")
    public @ResponseBody int delBypId(@RequestParam String pId)
    {
        return ipayService.delBypId(Integer.parseInt(pId));
    }


    /**
     * 更新pay记录
     * @param e_id
     * @param p_base
     * @param p_social
     * @param p_title
     * @param p_pension
     * @param p_duties
     * @param p_medical
     * @param p_skill
     * @param p_unemployment
     * @param p_education
     * @param p_houseFound
     * @param p_overtime
     * @param p_absence
     * @param p_bonus
     * @param p_other
     * @param p_wage
     * @param p_tax
     * @param p_shouldSum
     * @param p_deductionSum
     * @param p_realWage
     * @param p_giveTime
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/updateBypId")
    public @ResponseBody int updateBypId(@RequestParam String pId, @RequestParam String e_id, @RequestParam String p_base, @RequestParam String p_social, @RequestParam String p_title, @RequestParam String p_pension, @RequestParam String p_duties,
                                         @RequestParam String p_medical, @RequestParam String p_skill, @RequestParam String p_unemployment, @RequestParam String p_education, @RequestParam String p_houseFound, @RequestParam String p_overtime,
                                         @RequestParam String p_absence, @RequestParam String p_bonus, @RequestParam String p_other, @RequestParam String p_wage, @RequestParam String p_tax, @RequestParam String p_shouldSum, @RequestParam String p_deductionSum,
                                         @RequestParam String p_realWage, @RequestParam String p_giveTime) throws ParseException {
        Date date = new Date();
        if(p_giveTime.length() != 0)
        {

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.parse(p_giveTime);
        }
        Pay pay = new Pay(Integer.parseInt(pId), Integer.parseInt(e_id), s2d(p_bonus), date,s2d(p_base), s2d(p_title), s2d(p_duties), s2d(p_skill), s2d(p_education), s2d(p_overtime), s2d(p_wage), s2d(p_social), s2d(p_pension), s2d(p_medical), s2d(p_unemployment), s2d(p_houseFound), s2d(p_absence), s2d(p_other), s2d(p_deductionSum), s2d(p_shouldSum), s2d(p_realWage), s2d(p_tax));
        System.out.println(date);
        return ipayService.updateBypId(pay);
    }
    /**
     * 根据时间，部门查询
     * 默认当前年月
     * @param request
     * @param pageSize
     * @param requestPage
     * @param year
     * @param mounth
     * @param depart
     * @return
     */
    @RequestMapping(value = "/getAllPayByDepart", method = RequestMethod.POST)
    public @ResponseBody Object getByDepart(HttpServletRequest request, @RequestParam long pageSize, @RequestParam long requestPage, @RequestParam String year, @RequestParam String mounth, @RequestParam String depart){
        QueryBase queryBase = new QueryBase(requestPage, pageSize);
        Map<String, Object> parameters = new HashMap<String, Object>();
        queryBase.setParameters(parameters);
        queryBase.setDepart("'" + depart + "'");
        if(year.length() != 0 && mounth.length() != 0)
        {
            String yearAndMounth = "'" + year + "-" + mounth + "'";
            queryBase.setYearAndMounth(yearAndMounth);

        }else {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            queryBase.setYearAndMounth("'" + format.format(date) + "'");
        }
        List<String> depart_list = new LinkedList<String>();
        int status;
        if(depart.length() == 0)
        {
            status = this.ipayService.getByYearAndMounth(queryBase, depart_list);
        }else {
            status = this.ipayService.getByDepartAndTime(queryBase, depart_list);
        }
        System.out.println("status" + status);
        System.out.println(queryBase.getResults().size());
        return new Response(status, queryBase, depart_list);
    }


    @RequestMapping(value = "/getAllPayByEIdAndAdmin", method = RequestMethod.POST)
    public @ResponseBody Object getAllPayByEIdAndAdmin(HttpServletRequest request,@RequestParam String eId, @RequestParam long pageSize, @RequestParam long requestPage){
        System.out.println("ByID");
        Employee employee = iEmployeeService.getById(Integer.parseInt(eId));
        QueryBase queryBase = new QueryBase(requestPage, pageSize);
        queryBase.seteId(Integer.parseInt(eId));
        List<String> depart_list = new LinkedList<String>();
        int status = this.ipayService.getById(queryBase, depart_list);
        return new Response(status, queryBase, depart_list);
    }


    /**
     * 添加工资记录
     * @param e_id
     * @param p_base
     * @param p_social
     * @param p_title
     * @param p_pension
     * @param p_duties
     * @param p_medical
     * @param p_skill
     * @param p_unemployment
     * @param p_education
     * @param p_houseFound
     * @param p_overtime
     * @param p_absence
     * @param p_bonus
     * @param p_other
     * @param p_wage
     * @param p_tax
     * @param p_shouldSum
     * @param p_deductionSum
     * @param p_realWage
     * @param p_giveTime
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/addPay")
    public @ResponseBody int addPay(@RequestParam String e_id, @RequestParam String p_base, @RequestParam String p_social, @RequestParam String p_title, @RequestParam String p_pension, @RequestParam String p_duties,
                                    @RequestParam String p_medical, @RequestParam String p_skill, @RequestParam String p_unemployment, @RequestParam String p_education, @RequestParam String p_houseFound, @RequestParam String p_overtime,
                                    @RequestParam String p_absence, @RequestParam String p_bonus, @RequestParam String p_other, @RequestParam String p_wage, @RequestParam String p_tax, @RequestParam String p_shouldSum, @RequestParam String p_deductionSum,
                                    @RequestParam String p_realWage, @RequestParam String p_giveTime) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(p_giveTime);
//        System.out.println(Double.parseDouble((p_medical.length() == 0) ? "0" : p_medical));
//        Integer eId, Double pBonus, Date pTime, Double pBasic, Double pTitle, Double pDuties, Double pSkill, Double pEducation, Double pOvertime, Double pWalfare, Double iSocial, Double iPension, Double iMedical, Double iUnemploy, Double pHousing, Double pAbsence, Double pFineother, Double pFinesum, Double pShouldsum, Double pRealsum, Double pTax
        Pay pay = new Pay(Integer.parseInt(e_id), s2d(p_bonus), date,s2d(p_base), s2d(p_title), s2d(p_duties), s2d(p_skill), s2d(p_education), s2d(p_overtime), s2d(p_wage), s2d(p_social), s2d(p_pension), s2d(p_medical), s2d(p_unemployment), s2d(p_houseFound), s2d(p_absence), s2d(p_other), s2d(p_deductionSum), s2d(p_shouldSum), s2d(p_realWage), s2d(p_tax));
        return ipayService.addPay(pay);
    }

    /**
     *  String to Double
     * @param str
     * @return
     */
    private Double s2d(String str){
        return Double.parseDouble((str.length() == 0) ? "0" : str);
    }

}
