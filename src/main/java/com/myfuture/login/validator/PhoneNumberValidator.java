package com.myfuture.login.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String PHONE_PATTERN = "\\d++";
	@Override
	public boolean isValid(String PhoneNumber, ConstraintValidatorContext context) {
		
		if (PhoneNumber!=null && PhoneNumber.length()==11 && isValidNumber(PhoneNumber) ){
			return true;
		}
		else
		return false;
	}
	private boolean isValidNumber(String phoneNumber) {
	       pattern = Pattern.compile(PHONE_PATTERN);
	       matcher = pattern.matcher(phoneNumber);
	       return matcher.matches();
	   }
	

}
