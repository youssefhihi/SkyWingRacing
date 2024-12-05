package com.ys.skywingracing.user.application.dto.request.create;

import com.ys.skywingracing.user.domain.objectValue.Email;
import com.ys.skywingracing.user.domain.objectValue.FullName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateUserRequestDto(

        @NotNull(message = "Email is required")
        Email email
) {
}
