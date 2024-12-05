package com.ys.skywingracing.user.application.dto.response;

import com.ys.skywingracing.user.domain.enums.Role;
import com.ys.skywingracing.user.domain.objectValue.Email;
import com.ys.skywingracing.user.domain.objectValue.FullName;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String email,
        FullName name,
        String username,
        Role role
) {
}
