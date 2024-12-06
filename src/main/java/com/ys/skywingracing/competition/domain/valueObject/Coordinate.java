package com.ys.skywingracing.competition.domain.valueObject;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record Coordinate(@NotNull Double latitude, @NotNull Double longitude) implements Serializable {
    public Coordinate {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90 degrees.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180 degrees.");
        }
    }

}