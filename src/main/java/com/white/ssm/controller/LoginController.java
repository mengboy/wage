package com.white.ssm.controller;

import com.google.code.kaptcha.Constants;
import com.white.ssm.common.Status;
import com.white.ssm.model.Admin;
import com.white.ssm.service.IAdminService;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by vector on 16/11/9.
 */
@RestController
public class LoginController extends HandlerInterceptorAdapter{
    private static Logger logger = Logger.getLogger(LoginController.class);
    @Resource
    private HttpSession session;

    @Resource(name = "adminService")
    private IAdminService adminService;
    /**
     * 管理员登录
     * @param request
     * @param userId
     * @param password
     * @param VCode
     * @return
     */
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public @ResponseBody int loginCheck(HttpSession session,HttpServletRequest request, @RequestParam int userId, @RequestParam String password, @RequestParam String VCode)
    {
        Admin admin = adminService.getAdminByID(userId);
        boolean check = false;
//        HttpSession session = request.getSession();
        String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println(code);
        System.out.println(VCode);
        if(admin != null) {
            if (VCode.equals(code)) {
                if (admin.getaPass().equals(password)) {
                    check = true;
                }
                if (check) {
                    System.out.println(check);
                    session.setAttribute("admin", admin);
                    return Status.SUCCESS;
                } else {
                    System.out.println(check);
                    return Status.ERROR;
                }
            } else {
                return Status.CODE_NOT_MATCH;
            }
        }else {
            return Status.NOT_EXISTS;
        }

    }


    /**
     * 首页
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/")
    public ModelAndView welcome(HttpServletRequest request, ModelMap map){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping("/loginOut")
    public ModelAndView loginOut(HttpServletRequest request, ModelMap modelMap){
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if(session != null)
        {
            session.invalidate();
            mv.setViewName("welcome");
            return mv;
        }else {
            mv.setViewName("welcome");
            return mv;
        }
    }

}
