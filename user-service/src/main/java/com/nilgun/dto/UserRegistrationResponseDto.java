package com.nilgun.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Testlerde ve Mapper'da kolaylık sağlar
public class UserRegistrationResponseDto {

    private UUID id;
    private String username;
    private String email;

    // PersonalInfo içindeki alanları düzleştirerek dönebiliriz
    private String firstName;
    private String lastName;

    // Audit (Denetleme) bilgileri eklenebilir
    private LocalDateTime createdAt;
}