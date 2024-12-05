package com.ys.skywingracing.user.domain.service;


import com.ys.skywingracing.user.application.dto.request.create.CreateUserRequestDto;
import com.ys.skywingracing.user.application.dto.request.update.UpdateRoleRequestDto;
import com.ys.skywingracing.user.application.dto.response.UserResponseDto;
import com.ys.skywingracing.user.domain.enums.Role;

import java.util.UUID;

public interface UserService {
    UserResponseDto saveUser(CreateUserRequestDto createUserRequest);
    UserResponseDto updateRole(UpdateRoleRequestDto updateRoleRequestDto);
}
