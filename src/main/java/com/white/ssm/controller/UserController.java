package com.white.ssm.controller;

/**
 * Created by admin on 2016/11/3.
 */
import com.white.ssm.common.QueryBase;
import com.white.ssm.common.Response;
import com.white.ssm.model.User;
import com.white.ssm.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
// /user/**
public class UserController {
    private static Logger log=LoggerFactory.getLogger(UserController.class);
    @Resource(name = "userService")
    private IUserService iUserService;
    // /user/test?id=1
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String test(HttpServletRequest request,Model model){
        System.out.print("iagulbdc");
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
            user = new User();
            user.setAge(11);
            user.setId(1);
            user.setPassword("123");
            user.setUserName("javen");
        }

        log.debug(user.toString());
        model.addAttribute("user", user);
        return "index";
    }



    @RequestMapping(value = "/getall", method = RequestMethod.POST)
    public @ResponseBody Object getAll(HttpServletRequest request, @RequestParam long pageSize, @RequestParam long requestPage)
    {
        QueryBase queryBase = new QueryBase(requestPage, pageSize);
        Map<String, Object> parameters = new HashMap<String, Object>();
        queryBase.setParameters(parameters);
        int status = this.iUserService.getAll(queryBase);
        System.out.println("status" + status);
        System.out.println(queryBase.getResults().size());
        return new Response(status, queryBase);
    }

    @RequestMapping(value = "/getallByPass", method = RequestMethod.POST)
    public @ResponseBody Object getAllByPass(HttpServletRequest request, @RequestParam long pageSize, @RequestParam long requestPage, @RequestParam String password)
    {
        QueryBase queryBase = new QueryBase(requestPage, pageSize, password);
        Map<String, Object> parameters = new HashMap<String, Object>();
        queryBase.setParameters(parameters);
        int status = this.iUserService.getAllByPass(queryBase);
        System.out.println(queryBase.getResults().size());
        return new Response(status, queryBase);
    }


}
