package com.nilgun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // Bir entity içine gömülebilir olduğunu belirtir
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    // Value Object olduğu için Setter koymuyoruz (Immutable/Değişmez yapı)
}