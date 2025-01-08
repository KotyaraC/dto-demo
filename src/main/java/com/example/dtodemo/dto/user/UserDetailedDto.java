package com.example.dtodemo.dto.user;


import java.util.List;
import java.util.UUID;

public record UserDetailedDto(
        UUID id,
        String email
) {
}
