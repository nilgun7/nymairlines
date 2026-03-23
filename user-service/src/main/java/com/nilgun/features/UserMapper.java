package com.nilgun.features;


import com.nilgun.entity.UserEntity;
import com.nilgun.dto.UserRegistrationRequestDto;
import com.nilgun.dto.UserRegistrationResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true) // Şifreyi manuel set ettiğimiz için ignore ediyoruz
    UserEntity toEntity(UserRegistrationRequestDto dto);

    UserRegistrationResponseDto toResponseDto(UserEntity entity);
}