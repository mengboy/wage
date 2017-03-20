import com.white.ssm.controller.SendMailController;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by vector on 2017/3/20.
 */
public class SendMailTest {
    @Test
    public void sendMail(){
        String to = "2424396726@qq.com";
        String subject = "test";
        String text = "text";
        boolean isSSL = true;
        boolean isAuth = true;
        String host = "smtp.163.com";
        int port = 465;
        String from = "xxxxxx";
        final String username = "xxxxx";
        final String pass = "pass";

        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.enable", isSSL);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", isAuth);

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, pass);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("主题");
            message.setText("内容");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("发送完毕");
    }
}
