package com.nilgun.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity<UUID> {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Setter(AccessLevel.PRIVATE) // Şifre sadece içeriden yönetilmeli
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role; // ROLE_USER, ROLE_ADMIN

    private boolean enabled = true;

    // Opsiyonel: Meysam'ın yaptığı gibi @Embedded kullanımı
    @Embedded
    private PersonalInfo personalInfo;

    public void updatePassword(String encodedPassword) {
        if (encodedPassword == null || encodedPassword.isBlank()) {
            throw new IllegalArgumentException("Şifre boş olamaz!");
        }
        this.password = encodedPassword;
    }
}