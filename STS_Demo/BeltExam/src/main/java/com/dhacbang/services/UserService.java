package com.dhacbang.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dhacbang.models.LoginUser;
import com.dhacbang.models.User;
import com.dhacbang.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public User register(User newUser, BindingResult result) {
		
		//*****Check EMail in DB and rejects it if its already in use reject value
		if (repo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email","Unique","This emil is already in use!");
		}
		
		
		//*****Check password matches with confirm password if not reject value
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches","The Confirm Password must match the Password!");
		}
		
		
		//*****Check for error if there is, it is not registered
		if (result.hasErrors()) {
			return null;
		}else {
		//*****Hashes the password for protection
			String hash_browns = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hash_browns);
			return repo.save(newUser);
		}
		
		
	}
	public User login(LoginUser newLogin, BindingResult result) {
		//***********If email invalid it returns null 
		if (result.hasErrors()) {
			return null;
		}
		
		
		//***********trys to get user with email if not present then email is invalid and returns error
		Optional<User> potentialUser = repo.findByEmail(newLogin.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Invalid Cridentials!");
			return null;
		}
		
		
		//*********User is recived and pass word is verified if not matched then returns error
		User user = potentialUser.get();
				if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
					result.rejectValue("password", "Matches", "Invalid Credentials!");
		}
				
		if(result.hasErrors()) {
			return null;
		}else {
			return user;
		}		
	}
	
	public User getOne(Long id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
}
