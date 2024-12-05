package com.ys.skywingracing.user.application.dto.request.update;

import com.ys.skywingracing.user.domain.enums.Role;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateRoleRequestDto(
        @NotNull(message = "User id is required")
        UUID id,
        @NotNull(message = "Role is required")
        Role role
) {
}
