package com.myfuture.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myfuture.login.model.UserCredentials;
import com.myfuture.login.service.AddNewUser;
import com.myfuture.login.service.ValidateUserLoginData;




@RestController
@RequestMapping(path="/ms1")
public class RegisterController {
	
	
	@Autowired
	private ValidateUserLoginData validateUserLoginData;
	
	@Autowired
	private AddNewUser addNewUser;
	
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void showRegistrationForm(HttpServletRequest request,
			@RequestBody @Valid UserCredentials userCredentials) throws Exception
	{
		
		if(validateUserLoginData.isValidData(userCredentials.getPhoneNumber()))
		{
			addNewUser.addUser(userCredentials);
		}else{
			//TODO: be handle to custom exception 
			throw new Exception("user already exist");
		}
		
		
	    
		// return oauth2 JWT  token 
		System.out.println("true");
	    
	}
	
	

}
