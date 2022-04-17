package com.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

@Document(collection = "users")
public class UserModel {
	@Id
	private String id;
	
	@NotEmpty(message = "The email address is required.")
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	private String email;
	
	@NotEmpty(message = "The password is required.")
	@Size(min = 8, max = 25, message = "The length of password must be between 8 and 25 characters.")
	private String password;
	
	@NotEmpty(message = "The first name is required.")
	private String firstName;
	
	@NotEmpty(message = "The last name is required.")
	private String lastName;
	
	@NotEmpty(message = "The username is required.")
	private String username;
	
	private boolean keepSignIn;
	
	private boolean emailMe;
	
	private String role;
	
	public UserModel() {
		super();
	}

	public UserModel(String id,
			@NotEmpty(message = "The email address is required.") @Email(message = "The email address is invalid.", flags = Flag.CASE_INSENSITIVE) String email,
			@NotEmpty(message = "The password is required.") @Size(min = 8, max = 25, message = "The length of password must be between 8 and 25 characters.") String password,
			@NotEmpty(message = "The first name is required.") String firstName,
			@NotEmpty(message = "The last name is required.") String lastName,
			@NotEmpty(message = "The username is required.") String username, boolean keepSignIn, boolean emailMe,
			String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.keepSignIn = keepSignIn;
		this.emailMe = emailMe;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isKeepSignIn() {
		return keepSignIn;
	}

	public void setKeepSignIn(boolean keepSignIn) {
		this.keepSignIn = keepSignIn;
	}

	public boolean isEmailMe() {
		return emailMe;
	}

	public void setEmailMe(boolean emailMe) {
		this.emailMe = emailMe;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isEmpty() {
		return (this.email.isBlank() || this.email == null);
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", keepSignIn=" + keepSignIn + ", emailMe=" + emailMe + ", role=" + role
				+ "]";
	}

}
