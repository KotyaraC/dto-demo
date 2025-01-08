package com.example.dtodemo.mapper;

import com.example.dtodemo.config.MapperConfig;
import com.example.dtodemo.dto.user.UserBasicDto;
import com.example.dtodemo.dto.user.UserDetailedDto;
import com.example.dtodemo.dto.user.UserRegistrationDto;
import com.example.dtodemo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserBasicDto toDto(User user);

    UserDetailedDto toDetailedDto(User user);

//    @Mapping(target = "devices", source = "deviceIds", qualifiedByName = "deviceById")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    User toModel(UserRegistrationDto registrationDto);
}
