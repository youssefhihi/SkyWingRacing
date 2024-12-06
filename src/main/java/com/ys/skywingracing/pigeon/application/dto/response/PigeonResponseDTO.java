package com.ys.skywingracing.pigeon.application.dto.response;



import com.ys.skywingracing.pigeon.domain.enums.Gender;
import com.ys.skywingracing.pigeon.domain.valueObject.BandNumber;

import java.time.LocalDateTime;
import java.util.UUID;

public record PigeonResponseDTO(
        UUID id,
        BandNumber bandNumber,
        Gender gender,
        double age,
        String color,
        LocalDateTime createdDate
) {
}
