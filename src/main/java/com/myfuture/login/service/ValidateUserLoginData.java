package com.myfuture.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfuture.login.Repo.UserCredintialsRepo;
import com.myfuture.login.model.UserCredentials;

@Service
public class ValidateUserLoginData {
	
	@Autowired
	private UserCredintialsRepo userCredintialsRepo;
	
	public boolean isValidData(String phoneNumber){
		
//		check if user exist in DB;
//		if exist not valid data return false else return true;
		
		UserCredentials user = userCredintialsRepo.findByPhoneNumber(phoneNumber);
		if(user!=null && user.getPassword()!=null)
			return false;
		else
			return true;
	}

}