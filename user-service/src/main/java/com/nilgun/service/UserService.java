package com.nilgun.service;

import com.nilgun.entity.UserEntity;
import com.nilgun.entity.UserRole;
import com.nilgun.dto.UserRegistrationRequestDto;
import com.nilgun.dto.UserRegistrationResponseDto;
import com.nilgun.features.UserMapper;
import com.nilgun.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // Final olan alanlar için constructor oluşturur (Dependency Injection)
@Slf4j // Loglama için
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper; // MapStruct mapper
    private final PasswordEncoder passwordEncoder;

    @Transactional // İşlem yarıda kalırsa veritabanını geri alır (Rollback)
    public UserRegistrationResponseDto registerUser(UserRegistrationRequestDto registrationDto) {

        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            log.error("Kayıt başarısız: Email zaten kullanımda {}", registrationDto.getEmail());
            throw new RuntimeException("Bu email adresi ile daha önce kayıt olunmuş.");
        }
        if (userRepository.existsByUsername(registrationDto.getUsername())) {
            throw new RuntimeException("Bu kullanıcı adı zaten alınmış.");
        }

        UserEntity userEntity = userMapper.toEntity(registrationDto);

        // 4. Güvenlik: Şifreyi hashle
        String encodedPassword = passwordEncoder.encode(registrationDto.getPassword());
        userEntity.updatePassword(encodedPassword);

        // 5. Varsayılan değerleri ata
        userEntity.setRole(UserRole.ROLE_USER);

        // 6. Kaydet ve DTO olarak geri dön
        UserEntity savedUser = userRepository.save(userEntity);
        log.info("Yeni kullanıcı başarıyla kaydedildi: {}", savedUser.getUsername());

        return userMapper.toResponseDto(savedUser);
    }
}