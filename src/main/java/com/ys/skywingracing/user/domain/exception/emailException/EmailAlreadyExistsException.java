package com.ys.skywingracing.user.domain.exception.emailException;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
      super("Email " + email + " already exists");
    }
}
