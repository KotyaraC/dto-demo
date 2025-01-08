package com.example.dtodemo.service.impl;

import com.example.dtodemo.dto.user.UserBasicDto;
import com.example.dtodemo.dto.user.UserDetailedDto;
import com.example.dtodemo.dto.user.UserRegistrationDto;
import com.example.dtodemo.exception.RegistrationException;
import com.example.dtodemo.mapper.UserMapper;
import com.example.dtodemo.model.Role;
import com.example.dtodemo.model.User;
import com.example.dtodemo.repository.RoleRepository;
import com.example.dtodemo.repository.UserRepository;
import com.example.dtodemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserBasicDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDetailedDto getUserById(UUID id) {
        User user = userRepository.findById(id).get();
        return userMapper.toDetailedDto(user);
    }

    @Override
    public UserDetailedDto register(UserRegistrationDto userDto) throws RegistrationException {
        String email = userDto.email();
        if (userRepository.existsByEmail(email)) {
            throw new RegistrationException("Email is already registered");
        }
        User user = userMapper.toModel(userDto);

        user.setPassword(passwordEncoder.encode(userDto.password()));
        Role userRole = roleRepository.findByRole(Role.RoleName.ROLE_USER);
        user.setRoles(Set.of(userRole));

        User savedUser = userRepository.save(user);
        return userMapper.toDetailedDto(savedUser);
    }
}
