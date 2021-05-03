package com.yu.springboot_jdbc_mybatis.tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Component
public class MailTool {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderMailAddress;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendSimpleMail(Map<String, Object> valueMap) {
        MimeMessage mimeMessage = null;
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            //设置发件人邮箱
            helper.setFrom(senderMailAddress);

            //设置收件人邮箱
            helper.setTo((String[]) valueMap.get("to"));

            //设置邮件标题
            helper.setSubject(valueMap.get("title").toString());

            //添加正文（使用thymeleaf模板）
            Context context = new Context();
            context.setVariables(valueMap);
          //  context.setVariable("number", "00000");
            String content = templateEngine.process("index", context);
            helper.setText(content, true);

            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}