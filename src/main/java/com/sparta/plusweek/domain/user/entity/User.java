package com.sparta.plusweek.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false)
    private String username; // 닉네임

    @Column(nullable = false)
    private String password;

    private String email;

    private Role role;

    @Builder
    private User(Long id, String username, String password, String email, Role role) {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
