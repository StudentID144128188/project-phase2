package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.UserModel;
import com.project.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> getAllUsers(){
		try {
			List<UserModel> userModels = userService.getAllUsers();
		    if (userModels.isEmpty()) {
		    	return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		    } else {
		    	return new ResponseEntity<>(userModels, HttpStatus.OK);
		    }
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserModel> getUserById(@PathVariable String userId){
		try {
			UserModel userModel = userService.getUserById(userId);
		    if (null == userModel) {
		      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		    } else {
		    	return new ResponseEntity<>(userModel, HttpStatus.OK);
		    }
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		  }
	}
	
	@PostMapping(value = "/users", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel userModel) {
		  try {
			  UserModel new_user = userService.createUser(userModel);
		    return new ResponseEntity<>(new_user, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		  }
	}
	

	@PutMapping("/users/{userId}")
	public ResponseEntity<UserModel> updateUser(@PathVariable String userId, @Valid @RequestBody UserModel userModel) {
		 try {
			UserModel temp = userService.getUserById(userId);
		 	UserModel new_user = userService.updateUser(userId, userModel);	 
		 	if(null == temp){
		 		return new ResponseEntity<>(new_user, HttpStatus.CREATED);	
		 	} else {
		 		return new ResponseEntity<>(new_user, HttpStatus.OK);	 
		 	}
		 } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		 }
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
	  try {
		  UserModel temp = userService.getUserById(userId);
		  if( null != temp ){
			  userService.deleteUser(userId);	
			  return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
		  } else {
			  return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		  }
	  } catch (Exception e) {
	    return new ResponseEntity<>("Something went wrong",  HttpStatus.BAD_REQUEST);
	  }
	}
	
	@GetMapping("users/information")
	public ResponseEntity<UserModel> getUserInforByUsername(@RequestParam(name = "username", required = true) String username){
		try {
			UserModel userModel = userService.getUserByUsername(username);
		    if (null == userModel) {
		      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		    } else {
		    	return new ResponseEntity<>(userModel, HttpStatus.OK);
		    }
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		  }
	}
	
	
}
