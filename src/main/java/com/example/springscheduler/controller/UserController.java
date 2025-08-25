package com.example.springscheduler.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springscheduler.entity.User;
import com.example.springscheduler.repository.UserRepository;

@RestController
@RequestMapping("/spring-scheduler-api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
	    Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
	    if (existingUser.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
	    }
	    userRepository.save(user);
	    return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
	}

}
