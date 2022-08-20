package com.wipro.velocity.grow.controller;


import com.wipro.velocity.grow.exception.ResourceNotFoundException;
import com.wipro.velocity.grow.model.User;
import com.wipro.velocity.grow.repository.UserRepository;
import com.wipro.velocity.grow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepository urepo;

	@Autowired
	private UserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
	  return userService.saveUser(user);
	}
	
	@GetMapping("/findAllUser")
	public List<User> getUser(){
		return userService.findAll();
	}
	
	 @GetMapping("/User/{email}")
     public ResponseEntity<User> getUserByEmail(@PathVariable(value="email")String email)throws ResourceNotFoundException{
         return userService.getUserByEmail(email);
     }

	@PostMapping("/loginUser")
	public Boolean loginUser(@Validated @RequestBody User user) throws ResourceNotFoundException {
          return userService.loginUser(user);
	}

//
//	 @GetMapping("/getuserby/{email}")
//	 	public List<User> getProductsByaccountNo(@PathVariable(value="email")String email) {
//	 		return (List<User>)urepo.findByEmail(email).get();
//	 	}
}
