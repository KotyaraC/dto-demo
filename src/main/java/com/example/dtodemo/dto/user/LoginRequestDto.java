package com.example.dtodemo.dto.user;

import com.example.dtodemo.validation.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDto(
    @NotBlank(message = "Username cannot be blank")
    String email,
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 50, message = "Password is too short or long")
    String password) {
}
