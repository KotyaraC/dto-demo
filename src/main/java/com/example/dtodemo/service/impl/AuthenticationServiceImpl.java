package com.example.dtodemo.service.impl;

import com.example.dtodemo.dto.user.LoginRequestDto;
import com.example.dtodemo.dto.user.LoginResponseDto;
import com.example.dtodemo.security.JwtUtil;
import com.example.dtodemo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtUtil;

  @Override
  public LoginResponseDto authenticate(LoginRequestDto loginRequestDto) {
    Authentication authentication =
        new UsernamePasswordAuthenticationToken(loginRequestDto.email(), loginRequestDto.password());
    Authentication authenticate = authenticationManager.authenticate(authentication);
    String token = jwtUtil.generateToken(authenticate.getName());
    return new LoginResponseDto(token);
  }
}
