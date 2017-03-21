package com.white.ssm.mail;

import com.white.ssm.common.Status;
import com.white.ssm.model.Mail;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 发送电子邮件
 * Created by vector on 2017/3/20.
 */
@Service("mailService")
public class SendEmailService {
    @Resource
    JavaMailSenderImpl mailSender;

    public int sendSimpleMail(Mail mail){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        try{
            simpleMailMessage.setFrom(mailSender.getUsername());
            simpleMailMessage.setTo(mail.getTo());
            simpleMailMessage.setSubject(mail.getSubject());
            simpleMailMessage.setText(mail.getContext());
            mailSender.send(simpleMailMessage);
        }catch (Exception e){
            return Status.ERROR;
        }
        return Status.SUCCESS;
    }

    public int sendMimeMessage(Mail mail){
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
            helper.setFrom(mailSender.getUsername());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContext());
            FileSystemResource fileSystemResource = new FileSystemResource(mail.getFile());
            helper.addAttachment(mail.getFileName(), fileSystemResource);
            mailSender.send(mimeMailMessage);
        } catch (MessagingException e) {
            return Status.ERROR;
        }
        return Status.SUCCESS;
    }

}
