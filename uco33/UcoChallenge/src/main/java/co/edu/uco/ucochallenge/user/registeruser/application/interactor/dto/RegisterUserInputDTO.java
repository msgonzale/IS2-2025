package co.edu.uco.ucochallenge.user.registeruser.application.interactor.dto;

import java.util.UUID;

import co.edu.uco.ucochallenge.crosscuting.helper.TextHelper;
import co.edu.uco.ucochallenge.crosscuting.helper.UUIDHelper;

public record RegisterUserInputDTO(UUID idType, String idNumber, String firstName, String secondName, String firstSurname,
		String secondSurname, UUID homeCity, String email, String mobileNumber) {
	
	public static RegisterUserInputDTO normalize(final UUID idType, final String idNumber,final String firstName,final String secondName,final String firstSurname,
			final String secondSurname,final UUID homeCity,final String email,final String mobileNumber) {
		 var idTypeNormalized = UUIDHelper.getDefault(idType);
		 var idNumberNormalized = TextHelper.getDefaultWithTrim(idNumber);
		 var firstNameNormalized = TextHelper.getDefaultWithTrim(firstName);
		 var secondNameNormalized = TextHelper.getDefaultWithTrim(secondName);
		 var firstSurnameNormalized = TextHelper.getDefaultWithTrim(firstSurname);
		 var secondSurnameNormalized = TextHelper.getDefaultWithTrim(secondSurname);
		 var homeCityNormalized = UUIDHelper.getDefault(homeCity);
		 var emailNormalized = TextHelper.getDefaultWithTrim(email);
		 var mobileNumberNormalized = TextHelper.getDefaultWithTrim(mobileNumber);
		 
		 return new RegisterUserInputDTO(idTypeNormalized, idNumberNormalized, firstNameNormalized, secondNameNormalized, firstSurnameNormalized, secondSurnameNormalized, homeCityNormalized, emailNormalized, mobileNumberNormalized);
	}
}
