package com.ys.skywingracing.user.domain.objectValue;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
public record Email(
        @NotBlank(message = "Email is mandatory")
        @Pattern(
                regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
                message = "Invalid email format"
        )
        String email
) implements Serializable {


}

