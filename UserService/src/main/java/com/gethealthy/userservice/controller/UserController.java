package com.gethealthy.userservice.controller;

import com.gethealthy.userservice.exception.NoMatchingUserFoundException;
import com.gethealthy.userservice.exception.UserNotFoundException;
import com.gethealthy.userservice.model.User;
import com.gethealthy.userservice.model.UserDTO;
import com.gethealthy.userservice.model.UserRequest;
import com.gethealthy.userservice.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get-with-id")
    public ResponseEntity<UserDTO> getUserById(@RequestParam Long id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/get-with-username")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) throws NoMatchingUserFoundException {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserRequest user) throws ExecutionControl.UserException {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) throws UserNotFoundException{
        return ResponseEntity.ok(userService.updatedUser(userDTO));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Boolean> removeUser(@RequestParam Long id) {
        return ResponseEntity.ok(userService.removeUser(id));
    }

}
