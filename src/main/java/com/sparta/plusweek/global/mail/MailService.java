package com.sparta.plusweek.global.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    private final RedisUtil redisUtil;

    private static final int DURATION = 3;

    @Value("${spring.mail.username}")
    private String email;

    @Override
    public String createAuthCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    @Override
    public void sendMessage(String to, String subject) {
        try {
            String code = createAuthCode();
            MimeMessage message = createMessage(to, subject, code);

            if (redisUtil.hasMail(to)) {
                redisUtil.deleteMail(to);
            }
            redisUtil.addMailList(to, code, DURATION);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.warn(e.getMessage());
        }
    }

    public boolean checkCode(String to, String code) {
        try {
            Object authCode = redisUtil.getCode(to);
            return authCode.equals(code);
        } catch (Exception e) {
            throw new IllegalArgumentException(); // 임시...
        }
    }

    private MimeMessage createMessage(String to, String subject, String code)
        throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(email);
        message.addRecipients(RecipientType.TO, to);
        message.setSubject(subject);

        return message;
    }

}

