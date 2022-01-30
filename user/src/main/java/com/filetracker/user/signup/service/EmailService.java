package com.filetracker.user.signup.service;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    private JavaMailSender javaMailSender;

    synchronized void sendMailToUser(String sendFrom, String sendTo, String mailBody, String mailSubject){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(sendFrom);
        message.setTo(sendTo);
        message.setText(mailBody);
        message.setSubject(mailSubject);
        javaMailSender.send(message);
        log.info("Mail sent from "+sendFrom+" to"+sendTo+"........................");
    }
}
