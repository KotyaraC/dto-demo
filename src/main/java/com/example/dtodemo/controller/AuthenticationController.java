package com.example.dtodemo.controller;

import com.example.dtodemo.dto.user.LoginRequestDto;
import com.example.dtodemo.dto.user.LoginResponseDto;
import com.example.dtodemo.dto.user.UserDetailedDto;
import com.example.dtodemo.dto.user.UserRegistrationDto;
import com.example.dtodemo.service.AuthenticationService;
import com.example.dtodemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthenticationController {

  private final UserService userService;
  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public UserDetailedDto register(@RequestBody @Valid UserRegistrationDto UserDto) {
    return userService.register(UserDto);
  }

  @PostMapping("/login")
  public LoginResponseDto login(@RequestBody @Valid LoginRequestDto loginRequestDto) {
    return authenticationService.authenticate(loginRequestDto);
  }
}
