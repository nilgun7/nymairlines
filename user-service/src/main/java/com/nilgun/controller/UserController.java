package com.nilgun.controller;

import com.nilgun.dto.UserRegistrationRequestDto;
import com.nilgun.dto.UserRegistrationResponseDto;
import com.nilgun.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponseDto> register(
            @Valid @RequestBody UserRegistrationRequestDto requestDto
    ) {
        UserRegistrationResponseDto response = userService.registerUser(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // İleride eklenecek profil getirme, güncelleme vb. buraya gelecek.
}