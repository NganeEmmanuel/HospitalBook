package com.gethealthy.userservice.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("user not found with ID: " + userId);

    }
}
