package com.ys.skywingracing.pigeon.domain.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, String id ) {
        super(entity + " Not Found with  " + id);
    }
}
