package com.project.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Credential {
	
	@NotEmpty(message = "The username is required.")
	private String username;
	
	@NotEmpty(message = "The password is required.")
	@Size(min = 8, max = 25, message = "The length of password must be between 8 and 25 characters.")
	private String password;

	public Credential() {
		super();
	}

	public Credential(@NotEmpty(message = "The username is required.") String username,
			@NotEmpty(message = "The password is required.") @Size(min = 8, max = 25, message = "The length of password must be between 8 and 25 characters.") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credential [username=" + username + ", password=" + password + "]";
	}
	
}
