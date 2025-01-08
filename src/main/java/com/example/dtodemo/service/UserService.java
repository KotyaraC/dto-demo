// UserService.java
package com.example.dtodemo.service;

//import com.example.dtodemo.dto.UserDto;

import com.example.dtodemo.dto.user.UserBasicDto;
import com.example.dtodemo.dto.user.UserDetailedDto;
import com.example.dtodemo.dto.user.UserRegistrationDto;
import com.example.dtodemo.exception.RegistrationException;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserBasicDto> getAllUsers();
    UserDetailedDto getUserById(UUID id);

    UserDetailedDto register(UserRegistrationDto userDto) throws RegistrationException;
}
