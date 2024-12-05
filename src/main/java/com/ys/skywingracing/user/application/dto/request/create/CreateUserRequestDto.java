package com.ys.skywingracing.user.application.dto.request.create;

import com.ys.skywingracing.user.domain.objectValue.FullName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserRequestDto(
        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
        String username,
        @NotNull(message = "Email is required")
        String email,
        @NotNull(message = "full Name is required")
        FullName name,
        @NotBlank(message = "Password is required")
        @Size(min = 4, message = "Password must be at least 4 characters long")
        String password
) {
}
