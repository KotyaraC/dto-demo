package com.example.dtodemo.controller;

import com.example.dtodemo.dto.user.UserBasicDto;
import com.example.dtodemo.dto.user.UserDetailedDto;
import com.example.dtodemo.dto.user.UserRegistrationDto;
import com.example.dtodemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserBasicDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('USER')")
    public UserDetailedDto getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping("/check")
    public String checkRoles(Authentication authentication) {
        return authentication.getAuthorities().toString();
    }

}
