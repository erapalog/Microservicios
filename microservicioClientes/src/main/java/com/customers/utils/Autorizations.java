package com.customers.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Autorizations {


	public static ResponseEntity<?> getResponseDenied(String message) {
		return new ResponseEntity<GeneralResponse>(new GeneralResponse(null, Params.CODE_BAD_REQUEST, message),
				HttpStatus.UNAUTHORIZED);
	}

	public static ResponseEntity<?> getResponseServerError(String message) {

		return new ResponseEntity<GeneralResponse>(
				new GeneralResponse(null, Params.CODE_BAD_REQUEST, message),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity<?> getResponseSuccess(Object obj, String message) {

		return new ResponseEntity<GeneralResponse>(new GeneralResponse(obj, Params.CODE_OK, message), HttpStatus.OK);
	}



	public static ResponseEntity<?> getResponseBadRequest(Object obj, String message) {

		return new ResponseEntity<GeneralResponse>(new GeneralResponse(obj, Params.CODE_BAD_REQUEST, message),
				HttpStatus.BAD_REQUEST);
	}

	// General Response for a manual validator
	public static ResponseEntity<?> getGeneralResponseCustomValidate(int status, String message) {
		return new ResponseEntity<>(new GeneralResponse(null, status, message), HttpStatus.CONFLICT);
	}

	public static Boolean authRest(String username) {
		return username == null ? true : false;
	}


}
