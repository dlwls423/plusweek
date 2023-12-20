package com.sparta.plusweek.domain.mail;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Mail {

    @Id
    private String mail;

    private String code;

}
