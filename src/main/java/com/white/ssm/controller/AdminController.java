package com.white.ssm.controller;

import com.google.code.kaptcha.Constants;
import com.white.ssm.common.Status;
import com.white.ssm.model.Admin;
import com.white.ssm.service.IAdminService;
import com.white.ssm.service.impl.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by vector on 16/12/6.
 */
@Controller
public class AdminController {
    @Resource(name = "adminService")
    IAdminService iAdminService;
    /**
     * 首页跳转
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/admin/index")
    public ModelAndView adminIndex(HttpServletRequest request, ModelMap map){
        HttpSession session = request.getSession();
        String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println(code);
        Admin admin = (Admin) session.getAttribute("admin");
        ModelAndView mv = new ModelAndView();
        if(admin != null)
        {
            mv.setViewName("index");
            return mv;
        }else {
            mv.setViewName("welcome");
            return mv;
        }
    }

    /**
     * 管理员修改密码
     * @param oldPass
     * @param newPass
     * @return
     */
    @RequestMapping(value = "/changePass")
    public @ResponseBody int changePass(HttpServletRequest request, @RequestParam String oldPass, @RequestParam String newPass)
    {
       HttpSession session =  request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin != null)
        {
             if(admin.getaPass().equals(oldPass))
            {
                admin.setaPass(newPass);
                iAdminService.updateAdmin(admin);
                return Status.SUCCESS;
            }else {
                 return Status.ERROR;
             }

        }else {
            return Status.ERROR;
        }
    }
}
