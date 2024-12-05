package com.ys.skywingracing.user.domain.exception.emailException;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String email) {
      super("Email " + email + " not found");
    }
}
