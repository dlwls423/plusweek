package com.sparta.plusweek.infra.mail;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final AuthEmailRepository authEmailRepository;

    public Optional<AuthEmail> findById(String email) {
        return authEmailRepository.findById(email);
    }

    public Boolean hasMail(String email) {
        return authEmailRepository.existsById(email);
    }

    public AuthEmail save(AuthEmail emailAuth) {
        return authEmailRepository.save(emailAuth);
    }

    public void delete(String email) {
        authEmailRepository.deleteById(email);
    }
}

