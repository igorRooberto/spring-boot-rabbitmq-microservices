package com.igor.user_service.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",nullable = false,unique = true)
    private UUID id;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    public User(String email) {
        this.email = email;
    }
}
