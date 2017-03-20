package com.white.ssm.controller;

import com.white.ssm.mail.SendEmailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 发送邮件
 * Created by vector on 2017/3/20.
 */
@RestController
public class SendMailController {
    @Resource(name = "mailService")
    SendEmailService sendEmailService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public int sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text){
        return sendEmailService.sendMail(to, subject, text);
    }
}
