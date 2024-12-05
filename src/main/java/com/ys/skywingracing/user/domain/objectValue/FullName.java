package com.ys.skywingracing.user.domain.objectValue;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public record FullName(
        @NotBlank(message = "First name is mandatory")
        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
        String firstName,

        @NotBlank(message = "Last name is mandatory")
        @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
        String lastName
) {}

