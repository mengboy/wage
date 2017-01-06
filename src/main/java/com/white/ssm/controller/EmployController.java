package com.white.ssm.controller;

import com.white.ssm.common.QueryBase;
import com.white.ssm.common.Response;
import com.white.ssm.common.Status;
import com.white.ssm.model.Employee;
import com.white.ssm.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vector on 16/12/10.
 */
@Controller
public class EmployController {
    @Resource
    IEmployeeService iEmployeeService;

    /**
     * 添加员工
     * @param img
     * @param e_name
     * @param e_number
     * @param e_sex
     * @param e_info
     * @param e_depart
     * @param e_pass
     * @param e_title
     * @return
     */
    @RequestMapping(value = "/addEmploy")
    public @ResponseBody int addEmploy(@RequestParam("img") CommonsMultipartFile img, @RequestParam String e_name, @RequestParam String e_number, @RequestParam String e_sex, @RequestParam String e_info, @RequestParam String e_depart, @RequestParam String e_pass, @RequestParam String e_title)
    {
        try {
            String imgName = iEmployeeService.saveImg(img, e_number);
            System.out.println(imgName);
            Employee employee = new Employee();
            employee.seteId(Integer.parseInt(e_number));
            employee.seteDepart(e_depart);
            employee.seteImg(imgName);
            employee.seteName(e_name);
            employee.seteIntro(e_info);
            employee.seteSex(e_sex);
            employee.setePass(e_pass);
            employee.seteTitle(e_title);
            iEmployeeService.saveEmploye(employee);
        }catch (Exception e)
        {
            return Status.ERROR;
        }
        return Status.SUCCESS;
    }

    /**
     * 获取全部员工
     * @param pageSize
     * @param requestPage
     * @return
     */
    @RequestMapping(value = "/getAllEmployee")
    public @ResponseBody Object getAllEmployee(@RequestParam long pageSize, @RequestParam long requestPage, @RequestParam String depart){
        QueryBase queryBase = new QueryBase(requestPage, pageSize);
        Map<String, Object> parameters = new HashMap<String, Object>();
        queryBase.setParameters(parameters);
        if(depart.length() == 0)
        {
            int status = this.iEmployeeService.getAllEmploy(queryBase);
            System.out.println("status" + status);
            System.out.println(queryBase.getResults().size());
            return new Response(status, queryBase);
        }
        else {
            queryBase.setDepart("'" + depart + "'");
            int status = this.iEmployeeService.getAllByDepart(queryBase);
            System.out.println("status" + status);
            System.out.println(queryBase.getResults().size());
            return new Response(status, queryBase);
        }
    }


    /**
     * 根据eId获取员工信息
     * @param eId
     * @return
     */
    @RequestMapping(value = "/getById")
    public @ResponseBody Object getById(@RequestParam String eId)
    {
        Employee employee = iEmployeeService.getById(Integer.parseInt(eId));
        System.out.println(employee);
        if(employee != null)
        {
            return new Response(Status.SUCCESS, employee);
        }else {
            return new Response(Status.ERROR);
        }
    }

    /**
     * 根据部门查询
     * @param pageSize
     * @param requestPage
     * @param depart
     * @return
     */
    @RequestMapping(value = "/getAllByDepart")
    public @ResponseBody Object getAllEmployeeByDepart(@RequestParam long pageSize, @RequestParam long requestPage, @RequestParam String depart){
        QueryBase queryBase = new QueryBase(requestPage, pageSize);
        Map<String, Object> parameters = new HashMap<String, Object>();
        queryBase.setParameters(parameters);
        queryBase.setDepart("'" + depart + "'");
        int status = this.iEmployeeService.getAllByDepart(queryBase);
        System.out.println("status" + status);
        System.out.println(queryBase.getResults().size());
        return new Response(status, queryBase);
    }

    /**
     * 根据员工id获取部门
     * @param eId
     * @return
     */
    @RequestMapping(value = "/getDepartById")
    public @ResponseBody String getDepartById(@RequestParam String eId)
    {
        int eid = Integer.parseInt(eId);
        System.out.println(iEmployeeService.getEmployeeDepartById(eid));
        return iEmployeeService.getEmployeeDepartById(eid);
    }

    @RequestMapping(value = "/updateEmploy")
    public @ResponseBody int updateEmploy(@RequestParam("img") CommonsMultipartFile img, @RequestParam String e_name, @RequestParam String e_number, @RequestParam String e_sex, @RequestParam String e_info, @RequestParam String e_depart, @RequestParam String e_pass, @RequestParam String e_title)
    {
        try {
            String imgName = iEmployeeService.saveImg(img, e_number);
            System.out.println(imgName);
            Employee employee = new Employee();
            employee.seteId(Integer.parseInt(e_number));
            employee.seteDepart(e_depart);
            employee.seteImg(imgName);
            employee.seteName(e_name);
            employee.seteIntro(e_info);
            employee.seteSex(e_sex);
            employee.setePass(e_pass);
            employee.seteTitle(e_title);
            return iEmployeeService.updateEmployee(employee);
        }catch (Exception e)
        {
            return Status.ERROR;
        }
    }

    @RequestMapping(value = "/delByeId")
    public @ResponseBody int delByeId(@RequestParam String eId){
        return iEmployeeService.deleteEmployById(Integer.parseInt(eId));
    }
}
