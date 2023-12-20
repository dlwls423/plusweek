package com.sparta.plusweek.global.mail;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/email")
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/{email_addr}/authcode")
    public ResponseEntity<String> sendEmailPath(
        @PathVariable(name = "email_addr") String email_addr)
        throws MessagingException {
        emailService.sendEmail(email_addr);
        return ResponseEntity.ok("이메일을 확인하세요");
    }

    @PostMapping("/{email_addr}/authcode")
    public ResponseEntity<String> sendEmailAndCode(
        @PathVariable(name = "email_addr") String email_addr,
        @RequestBody EmailRequestDto dto) {
        emailService.verifyEmailCode(email_addr, dto.getCode());
        return ResponseEntity.ok("인증이 완료되었습니다.");
    }
}
