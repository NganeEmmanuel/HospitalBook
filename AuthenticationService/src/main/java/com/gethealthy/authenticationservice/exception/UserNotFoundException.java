package com.gethealthy.authenticationservice.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("user not found with ID: " + userId);

    }
}
