package com.project.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Credential;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth")
	public ResponseEntity<Object> login(@Valid @RequestBody Credential credential) {
		  try {
			  Authentication auth =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getUsername(), credential.getPassword()));  
			  return new ResponseEntity<>(auth.getPrincipal(), HttpStatus.OK);
		  } catch (BadCredentialsException e) {
			  return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		  }catch (Exception e) {
			  return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		  }
	}
 
}
