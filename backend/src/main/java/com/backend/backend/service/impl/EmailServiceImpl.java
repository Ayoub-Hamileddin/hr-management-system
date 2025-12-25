package com.backend.backend.service.impl;

import com.backend.backend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Value("${mail.service.from}")
    private String emailFrom;


    @Override
    public String send(String email, String subject, String body) {
        SimpleMailMessage message=new SimpleMailMessage();

        message.setFrom(emailFrom);
        message.setTo(email);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);

        return "Email sent successfuly";
    }
}
