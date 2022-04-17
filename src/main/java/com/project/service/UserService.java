package com.project.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.config.UserModelDetails;
import com.project.entity.UserModel;
import com.project.repository.UserDao;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<UserModel> getAllUsers(){
		List<UserModel> userModels = new ArrayList<UserModel>();
		userModels = userDao.findAll();
		return userModels;
	}
	
	public UserModel getUserById(String userId){
		Optional<UserModel> userModel = userDao.findById(userId);
		if(userModel.isPresent()) {
			return userModel.get();
		}else {
			return null;
		}
	}
	
	public UserModel createUser(UserModel userModel) {
		List<UserModel> userModels = new ArrayList<UserModel>();
		userModels = userDao.findAll();
		UserModel find_user_email = userModels.stream()
				  .filter(e -> userModel.getEmail().equals(e.getEmail()))
				  .findAny()
				  .orElse(null);
		UserModel find_user_username = userModels.stream()
				  .filter(e -> userModel.getUsername().equals(e.getUsername()))
				  .findAny()
				  .orElse(null);
		if(null == find_user_email && null == find_user_username) {
			String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
			userModel.setPassword(encodedPassword);
			userModel.setRole("user");
			UserModel new_user = userDao.insert(userModel);
		//	userDao.save(new_user);
			return new_user;
		} else {
			return new UserModel();
		}
	}
	
	public void deleteUser(String userId){
		userDao.deleteById(userId);
	}
	
	public UserModel updateUser(String userId, UserModel userModel) {
		String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
		userModel.setPassword(encodedPassword);
		userModel.setId(userId);
		userModel.setRole("user");
		userDao.save(userModel);
		return userModel;
	}

	
	public UserModel getUserByUsername(String username) {
		List<UserModel> userModels = new ArrayList<UserModel>();
		userModels = userDao.findAll();
		UserModel userModel = userModels.stream()
				  .filter(e -> e.getUsername().equals(username))
				  .findAny()
				  .orElse(null);
		return userModel;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel foundUser = userDao.findByUsername(username);
			String username_ = foundUser.getUsername();
			String password_ = foundUser.getPassword();
			Set<GrantedAuthority> authorities = new HashSet<>();
	        UserModelDetails userDetails = new UserModelDetails(username_, password_, authorities); 
	        userDetails.setLastName(foundUser.getLastName());
	        userDetails.setFirstName(foundUser.getFirstName());
	        userDetails.setUserName(foundUser.getUsername());
	        userDetails.setEmail(foundUser.getEmail());
	        return userDetails;
	}
}
