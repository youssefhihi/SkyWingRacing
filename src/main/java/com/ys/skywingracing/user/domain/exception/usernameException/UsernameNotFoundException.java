package com.ys.skywingracing.user.domain.exception.usernameException;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String username) {
        super("Username " + username + " not found");
    }
}
