package com.ys.skywingracing.pigeon.application.dto.request;

import com.ys.skywingracing.pigeon.domain.enums.Gender;
import com.ys.skywingracing.pigeon.domain.valueObject.BandNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PigeonRequestDTO(
        @NotNull BandNumber bandNumber,

        @NotNull Gender gender,

        @Positive double age,

        @NotBlank String color

) {
}
