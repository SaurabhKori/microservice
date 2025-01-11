package com.humanitics.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humanitics.userservice.dto.User;
import com.humanitics.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserControler {
	@Autowired
	private UserService userservice;
	@PostMapping("/saveuser")
	 public ResponseEntity<User> creatUser(@RequestBody  User user){
		 User user1=userservice.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	@GetMapping("/singleUser/{userId}")
	 public ResponseEntity<User> singleUser(@PathVariable("userId") String userId){
		 User user1=userservice.getUser(userId);
		return ResponseEntity.ok(user1);
	}
	@GetMapping("/getAllUser")
	 public ResponseEntity<List<User>> getAllUser( ){
		List<User> user=userservice.getAllUser();
		return ResponseEntity.ok(user);
	}
}
