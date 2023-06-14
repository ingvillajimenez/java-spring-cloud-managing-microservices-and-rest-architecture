package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	UserService userService;
	
	// -------------------- Update a User ----------------------------------
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		//logger.info("Updating User with id {}", id);
		
		User currentUser = userService.findById(id);
		
		if (currentUser == null ) {
			//logger.error("Unable to update. User with id {} not found.", id);
			//return new ResponseEntity(new CustomErrorType("Unable to update. User with id " + id + " not found."),
				//	HttpStatus.NOT_FOUND);
		}
		
		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());
		
		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
}
