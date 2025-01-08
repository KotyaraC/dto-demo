package com.example.dtodemo.service;

import com.example.dtodemo.dto.user.LoginRequestDto;
import com.example.dtodemo.dto.user.LoginResponseDto;

public interface AuthenticationService {

  LoginResponseDto authenticate(LoginRequestDto loginRequestDto);
}
