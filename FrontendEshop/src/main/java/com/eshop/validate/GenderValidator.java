package com.eshop.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.eshop.model.User;


@Component
public class GenderValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
	
		return User.class.isAssignableFrom(obj);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.gender","gender is required");
		
		User uObj=(User)target;
		String gender=uObj.getGender();
		if((gender.equals("Male"))||(gender.equals("Female"))||(gender.equals("male"))||(gender.equals("female")))
		{
			System.out.println("correct");
		}
		else
		{
			errors.rejectValue("gender","gender.code","Only Male and Female allowed for Gender");
		}
	}

	
	
}
