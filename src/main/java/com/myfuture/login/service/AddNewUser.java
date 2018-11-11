package com.myfuture.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfuture.login.Repo.UserCredintialsRepo;
import com.myfuture.login.Repo.UserProfileRepo;
import com.myfuture.login.model.UserCredentials;
import com.myfuture.login.model.UserProfile;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;


@Service
public class AddNewUser {
	
	@Autowired
	private UserCredintialsRepo userCredintialsRepo;
	
	@Autowired
	private UserProfileRepo userProfileRepo;
	
	private static CharSequence secret = "HashSecret";	
	
	public void addUser(UserCredentials userCredentials){	
		
		Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder(secret);
		
		String encodedPass = encoder.encode(userCredentials.getPassword());
		userCredentials.setPassword(encodedPass);
		try{
			userCredintialsRepo.save(userCredentials);
			UserProfile user = new UserProfile();
			user.setPhoneNumber(userCredentials.getPhoneNumber());
			user.setUserName(userCredentials.getUserName());
			userProfileRepo.save(user);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
