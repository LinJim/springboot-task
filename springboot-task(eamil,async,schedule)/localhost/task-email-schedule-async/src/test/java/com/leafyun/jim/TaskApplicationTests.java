package com.leafyun.jim;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
    }


    @Test
    public void test1() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");

        message.setTo("806812616@qq.com");
        message.setFrom("lzhabc2016@163.com");

        javaMailSender.send(message);
    }

    @Test
    public void test2() throws MessagingException {
        // 创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // 邮件设置
        helper.setSubject("通知-今晚开会");
        // HTML 为 true ，是说明此 text 为 HTML 显示格式
        helper.setText("<b style='color:red'> 今天7:30开会</b>", true);

        helper.setTo("806812616@qq.com");
        helper.setFrom("lzhabc2016@163.com");

        // 上传文件
        helper.addAttachment("1-150RZUT2352.jpg", new File("F:\\images\\1-150RZUT2352.jpg"));
        // helper.addAttachment("2.jpg",new File(""));
        javaMailSender.send(mimeMessage);
    }


}
