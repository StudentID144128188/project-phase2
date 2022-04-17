package com.project.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import  org.springframework.security.core.userdetails.User;


public class UserModelDetails extends User {
    private String lastName;
    private String firstName;
    private String userName;
    private String email;

    public UserModelDetails(String username, String password,
            Collection<? extends GrantedAuthority> authorities) {            
           super(username, password, authorities);
       }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}
