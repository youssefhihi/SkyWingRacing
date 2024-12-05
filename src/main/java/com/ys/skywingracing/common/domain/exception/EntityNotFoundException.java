package com.ys.skywingracing.common.domain.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entity,UUID id) {
        super(entity + " not found with id " + id);
    }
}
