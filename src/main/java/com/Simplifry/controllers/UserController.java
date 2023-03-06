package com.Simplifry.controllers;

import com.Simplifry.entities.Users;
import com.Simplifry.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.Simplifry.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/{id}")
    public Users getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createUser(@RequestBody Users user) {
        try {
            // Check if the user already exists in the database
            if (userService.existsByUsername(user.getUsername())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Conflict response if the user already exists
            }
            userService.save(user);
            return ResponseEntity.ok(HttpStatus.CREATED); // Success response if the user was created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Internal server error response if something goes wrong
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
