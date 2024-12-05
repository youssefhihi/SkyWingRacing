package com.ys.skywingracing.user.domain.service.impl;

import com.ys.skywingracing.common.domain.exception.EntityNotFoundException;
import com.ys.skywingracing.user.application.dto.request.create.CreateUserRequestDto;
import com.ys.skywingracing.user.application.dto.request.update.UpdateRoleRequestDto;
import com.ys.skywingracing.user.application.dto.response.UserResponseDto;
import com.ys.skywingracing.user.application.mapper.UserMapper;
import com.ys.skywingracing.user.domain.enums.Role;
import com.ys.skywingracing.user.domain.exception.emailException.EmailAlreadyExistsException;
import com.ys.skywingracing.user.domain.exception.usernameException.UsernameAlreadyExistsException;
import com.ys.skywingracing.user.domain.model.User;
import com.ys.skywingracing.user.domain.service.UserService;
import com.ys.skywingracing.user.infrastructure.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDomainService implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public UserResponseDto saveUser(CreateUserRequestDto request) {
       if (repository.existsByUsername(request.username())){
           throw new UsernameAlreadyExistsException(request.username());
       }

       if (repository.existsByEmail(request.email())){
           throw new EmailAlreadyExistsException(request.email());
       }

        User newUser = User.builder()
                .name(request.name())
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.ROLE_USER)
                .build();
        return mapper.toResponseDto(repository.save(newUser));
    }

    @Override
    public UserResponseDto updateRole(UpdateRoleRequestDto request) {
        User user = repository.findById(request.id()).orElseThrow(() -> new EntityNotFoundException("User", request.id()));
        user.setRole(request.role());
        return mapper.toResponseDto(repository.save(user));
    }

}
