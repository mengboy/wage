package com.white.ssm.controller;

import com.white.ssm.mail.SendEmailService;
import com.white.ssm.model.Mail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * 发送邮件
 * Created by vector on 2017/3/20.
 */
@RestController
public class SendMailController {
    @Resource(name = "mailService")
    SendEmailService sendEmailService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public int sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text, @RequestParam(required = false) String fileName, @RequestParam(value = "file", required = false)CommonsMultipartFile file){
        Mail mail = new Mail(to, subject, text);
        if(fileName != null && file != null){
            String filepath = "/Users/vector/IdeaProjects/wage/wage/src/uploadfile/" + file.getOriginalFilename();
            File uploadFile = new File(filepath);
            try {
                file.transferTo(uploadFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            mail.setFile(uploadFile);
            mail.setFileName(file.getOriginalFilename());
            return sendEmailService.sendMimeMessage(mail);
        }
        return sendEmailService.sendSimpleMail(mail);
    }
}
