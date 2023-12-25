package com.example.EventManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.EventManagement.dto.UserRequest;
import com.example.EventManagement.entities.User;
import com.example.EventManagement.services.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users/register")
    public User createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("/api/users/{userID}/update")
    public void updateUser(@PathVariable long userID, @RequestBody UserRequest request) {
       userService.updateUser(userID, request);
    }

    @DeleteMapping("/api/users/{userID}/delete")
    public void deleteUserById(@PathVariable long userID) {
       userService.deleteUserById(userID);
    }

    @GetMapping("/api/users")
    public Iterable<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("api/user/login/{email}")
  public User getUserByEmail(@PathVariable String email) {
    return userService.getUserByEmail(email);
  }
}
