package com.ums.university.management.system.Service.Impl;

import com.ums.university.management.system.Service.DAO.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${email.from}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void simpleEmail(String to, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
    }

    @Override
    public void emailWithSingleAttachment(String to, String body, String subject, String attachment){

    }

    @Override
    public void emailWithMultipleAttachments(String to, String body, String subject, String[] attachment){

    }
}
