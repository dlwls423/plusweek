package com.sparta.plusweek.global.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailUtil {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    private final EmailService emailService;


    @Value("${spring.mail.username}")
    private String email;

    public String createAuthCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public void sendMessage(String to, String subject) {
        try {
            String code = createAuthCode();
            MimeMessage message = createMessage(to, subject, code);

            if (emailService.hasMail(to)) {
                emailService.delete(to);
            }
            AuthEmail emailAuth = AuthEmail.builder()
                .email(to)
                .code(code)
                .build();

            emailService.save(emailAuth);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.warn(e.getMessage());
        }
    }

    public void checkCode(String email, String code) {
        AuthEmail emailAuth = emailService.findById(email)
            .orElseThrow(() -> new IllegalArgumentException("해당 이메일을 찾을 수 없습니다."));

        if (!emailAuth.getCode().equals(code)) {
            throw new IllegalArgumentException("인증코드가 일치하지 않습니다.");
        }
    }

    private MimeMessage createMessage(String to, String subject, String code)
        throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(email);
        message.addRecipients(RecipientType.TO, to);
        message.setSubject(subject);
        message.setText(createMailHtml(code), "UTF-8", "html");

        return message;
    }

    private String createMailHtml(String code) {
        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process("mail", context);
    }

}
