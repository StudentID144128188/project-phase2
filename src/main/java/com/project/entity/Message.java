package com.project.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message {
	@Id
	private String id;
	
	@NotEmpty(message = "The email address is required.")
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	private String email;
	
	@NotEmpty(message = "The name is required.")
	private String name;
	
	@NotEmpty(message = "The message is required.")
	private String message;
	
	public Message() {
		super();
	}

	public Message(String id,
			@NotEmpty(message = "The email address is required.") @Email(message = "The email address is invalid.", flags = Flag.CASE_INSENSITIVE) String email,
			@NotEmpty(message = "The name is required.") String name,
			@NotEmpty(message = "The message is required.") String message) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isEmpty() {
		return (this.email.isBlank() || this.email == null);
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", email=" + email + ", name=" + name + ", message=" + message + "]";
	}

}
