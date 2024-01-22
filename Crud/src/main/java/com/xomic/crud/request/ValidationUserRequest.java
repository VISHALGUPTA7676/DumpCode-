package com.xomic.crud.request;

import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidationUserRequest implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserRequest userRequest  = (UserRequest) target;
		
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "empty", "Email ID is required");
		/*
		 * if (!EmailValidator.getInstance().isValid(userRequest.getEmailId())) {
		 * errors.rejectValue("emailId", "invalid", "Invalid email format"); }
		 */

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty", "Password is required");
		if (userRequest.getPassword().length() < 6) {
			errors.rejectValue("password", "length", "Password must be at least 6 characters long");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "empty", "First name is required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "empty", "Last name is required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNuber", "empty", "Mobile number is required");
		if (!userRequest.getMobileNuber().matches("\\d{10}")) {
			errors.rejectValue("mobileNuber", "invalid", "Invalid mobile number format");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cityName", "empty", "City name is required");

		if (userRequest.getStateId() <= 0) {
			errors.rejectValue("stateId", "positive", "State ID must be greater than 0");
		}

		if (userRequest.getCountryId() <= 0) {
			errors.rejectValue("countryId", "positive", "Country ID must be greater than 0");
		}

		if (userRequest.getUserTypeId() <= 0) {
			errors.rejectValue("userTypeId", "positive", "User type ID must be greater than 0");
		}

		if (userRequest.getLanguageId() == null || userRequest.getLanguageId().length == 0) {
			errors.rejectValue("languageId", "empty", "Language ID cannot be empty");
		}

		List<UserExperiences> userExperiences = userRequest.getUserExperiences();
		if (userExperiences == null || userExperiences.isEmpty()) {
			errors.rejectValue("userExperiences", "empty", "User experiences cannot be empty");
		} else {
			for (int i = 0; i < userExperiences.size(); i++) {
				UserExperiences userExperience = userExperiences.get(i);
				if (StringUtils.isEmpty(userExperience.getCompanyName())) {
					errors.rejectValue("userExperiences["+i+"].companyName", "empty",
							"Company name cannot be empty");
				}
				// Add more validation logic for fields in UserExperience...
			}
		}

	}

}
