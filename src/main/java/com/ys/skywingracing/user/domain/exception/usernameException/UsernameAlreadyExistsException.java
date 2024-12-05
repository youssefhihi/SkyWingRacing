package com.ys.skywingracing.user.domain.exception.usernameException;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
      super("Username " + username + " already exists");
    }
}
