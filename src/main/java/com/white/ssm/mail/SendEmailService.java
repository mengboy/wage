package com.white.ssm.mail;

import com.white.ssm.common.Status;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 发送电子邮件
 * Created by vector on 2017/3/20.
 */
@Service("mailService")
public class SendEmailService {
    @Resource
    JavaMailSender mailSender;

    public int sendMail(String to, String subject, String text){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage.setFrom(mailSender.getUsername());
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(text);
            mailSender.send(simpleMailMessage);
        }catch (Exception e){
            return Status.ERROR;
        }
        return Status.SUCCESS;
    }

}
