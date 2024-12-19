package com.ys.skywingracing.common.api;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime date,
        String error,
        HttpStatus status
) {
}
