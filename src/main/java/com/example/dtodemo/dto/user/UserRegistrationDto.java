package com.example.dtodemo.dto.user;

import com.example.dtodemo.validation.Email;
import com.example.dtodemo.validation.FieldsMatch;

import java.util.List;
import java.util.UUID;

@FieldsMatch(field = "password", fieldMatch = "repeatPassword", message = "Passwords do not match!")
public record UserRegistrationDto(
        String email,
        String password,
        String repeatPassword
) {
}
