package com.catmanscodes.springboot_aws.controller;

import com.catmanscodes.springboot_aws.model.User;
import com.catmanscodes.springboot_aws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    //get user by id

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }

    //create user

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return ResponseEntity.ok(userService.createUser(user));
    }

    //update user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    //delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
