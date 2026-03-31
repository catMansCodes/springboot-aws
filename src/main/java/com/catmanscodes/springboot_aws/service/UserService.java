package com.catmanscodes.springboot_aws.service;

import com.catmanscodes.springboot_aws.model.User;
import com.catmanscodes.springboot_aws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get user by id
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with id: " + id));

    }

    //create user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //update user
    public User updateUser(int id, User user) {

        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    //delete user
    public String deleteUser(int id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(existingUser);
        return "User with id: " + id + " has been deleted.";
    }

}
