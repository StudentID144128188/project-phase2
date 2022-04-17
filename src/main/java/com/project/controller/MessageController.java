package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Message;
import com.project.service.MessageService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	
	@GetMapping("/messages")
	public ResponseEntity<List<Message>> getAllUsers(){
		try {
			List<Message> messages = messageService.getAllMessages();
		    if (messages.isEmpty()) {
		      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(messages, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@GetMapping("/messages/{messageId}")
	public ResponseEntity<Message> getMessageById(@PathVariable String messageId){
		try {
			Message msg = messageService.getMessageById(messageId);
		    if (null == msg) {
		      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		    } else {
		    	return new ResponseEntity<>(msg, HttpStatus.OK);
		    }
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		  }
	}
	
	@PostMapping("/messages")
	public ResponseEntity<Message> createMessage(@Valid @RequestBody Message message) {
		  try {
			  Message new_message = messageService.createMessage(message);
		    return new ResponseEntity<>(new_message, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		  }
	}
	
	@PutMapping("/messages/{messageId}")
	public ResponseEntity<Message> updateMessage(@PathVariable String messageId, @Valid @RequestBody Message message) {
		  try {
			 Message msg = messageService.getMessageById(messageId);
			 Message new_message = messageService.updateMessage(messageId, message);	 
			 if (null == msg) {
				 return new ResponseEntity<>(new_message, HttpStatus.CREATED);	
			 } else {
				 return new ResponseEntity<>(new_message, HttpStatus.OK);	
			 }
		  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			  }
	}
	
	@DeleteMapping("/messages/{messageId}")
	public ResponseEntity<String> deleteMessage(@PathVariable String messageId) {
	  try {
		  Message msg = messageService.getMessageById(messageId);
		  if (null != msg) {
			  messageService.deleteMessage(messageId);	
			  return new ResponseEntity<>("Message has been deleted", HttpStatus.OK);
		  } else {
			  return new ResponseEntity<>("Message not found", HttpStatus.NOT_FOUND);
		  }
	  } catch (Exception e) {
	    return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
}
