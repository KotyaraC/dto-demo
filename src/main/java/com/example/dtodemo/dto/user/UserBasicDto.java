package com.example.dtodemo.dto.user;

import java.util.UUID;

public record UserBasicDto(
        UUID id,
        String firstName,
        String lastName
) {
}
