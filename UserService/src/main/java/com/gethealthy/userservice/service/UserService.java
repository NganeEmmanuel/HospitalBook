package com.gethealthy.userservice.service;

import com.gethealthy.userservice.exception.NoMatchingUserFoundException;
import com.gethealthy.userservice.exception.UserNotFoundException;
import com.gethealthy.userservice.model.User;
import com.gethealthy.userservice.model.UserDTO;
import com.gethealthy.userservice.model.UserRequest;
import jdk.jshell.spi.ExecutionControl;

public interface UserService {
    /**
     *
     * @param id Data type of lONG
     * @return a new user object if found
     * @throws UserNotFoundException if user is not found in the database
     */
    UserDTO getUserById(Long id) throws UserNotFoundException;

    /**
     *
     * @param user userRequest object to be saved
     * @return user of saved user
     * @throws  ExecutionControl.UserException if user was unable to be added to the database
     */
    UserDTO addUser(UserRequest user) throws ExecutionControl.UserException;

    /**
     *
     * @param username string by which you want to filter by
     * @return user of saved user
     * @throws  NoMatchingUserFoundException when user was not found in the database
     */
    User getUserByUsername(String username) throws NoMatchingUserFoundException;

    /**
     *
     * @param userDTO user DTO object to update the user with
     * @return userDTO object of the updated user
     * @throws UserNotFoundException is user is not found by ID
     */
    UserDTO updatedUser(UserDTO userDTO) throws UserNotFoundException;

    /**
     *
     * @param id Long data type for user id
     * @return true if successful and false if not
     */
    Boolean removeUser(Long id);

}
